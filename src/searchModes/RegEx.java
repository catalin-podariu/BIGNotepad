package searchModes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import gui.BIGNotepad;

public class RegEx {

	private BIGNotepad notepad;
	private StyledDocument document;
	private Pattern serverPattern;
	private Matcher matchServer;

	private RegEx(BIGNotepad notepad) {
		this.notepad = notepad;
		document = notepad.bigEdit.getStyledDocument();
	}

	public static RegEx valueOf(BIGNotepad notepad) {
		return new RegEx(notepad);
	}

	public void findNext(String toFind, String regexPattern) throws BadLocationException {
		for (int index = notepad.currentSearchLocation; index < document.getLength(); index++) {
			if (matchFound(toFind)) {
				Feedback.valueOf(notepad).selectString(index, toFind.length());
			}
		}
	}

	public void findPrevious(String toFind) throws BadLocationException {
		for (int index = notepad.currentSearchLocation; index - toFind.length() >= 0; index--) {
			if (matchFound(toFind)) {
				Feedback.valueOf(notepad).selectString(index, toFind.length());
			}
		}
	}

	public boolean matchFound(final String toFind) {
		serverPattern = Pattern.compile(toFind);
		matchServer = serverPattern.matcher(toFind);
		return matchServer.matches();
	}

}
