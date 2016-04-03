package searchModes;

import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import gui.BIGNotepad;

public class RegEx {

	private BIGNotepad notepad;
	private StyledDocument document;

	private RegEx(BIGNotepad notepad) {
		this.notepad = notepad;
		document = notepad.bigEdit.getStyledDocument();
	}

	public static RegEx valueOf(BIGNotepad notepad) {
		return new RegEx(notepad);
	}

	public void find(String toFind, int searchMode) throws BadLocationException {
		// TODO catalin.podariu REGEX Functionality
	}

}
