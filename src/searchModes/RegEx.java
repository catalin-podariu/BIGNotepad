package searchModes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import gui.BIGNotepad;

/**
 *
 * @author catalin.podariu[at]gmail.com
 */
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
			String temp = document.getText(index, index + toFind.length());
//			if (compileAndMatch(toFind, regexPattern)) {
//				Feedback.valueOf(notepad).selectString(index, toFind.length());
//			}
		}
	}

	public void findPrevious(String toFind, String regexPattern) throws BadLocationException {
		for (int index = notepad.currentSearchLocation; index - toFind.length() >= 0; index--) {
//			if (compileAndMatch(toFind, regexPattern)) {
//				Feedback.valueOf(notepad).selectString(index, toFind.length());
//			}
		}
	}

	public boolean compileAndMatch(final String toFind, String regexPattern) {
		serverPattern = Pattern.compile(regexPattern);
		matchServer = serverPattern.matcher(toFind);
		return matchServer.matches();
	}

}
