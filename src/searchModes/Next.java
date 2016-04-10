package searchModes;

import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import gui.BIGNotepad;
import searchEngine.Type;

/**
 *
 * @author catalin.podariu[at]gmail.com
 */
public class Next {

	private BIGNotepad notepad;
	private StyledDocument document;

	private Next(BIGNotepad notepad) {
		this.notepad = notepad;
		document = this.notepad.bigEdit.getStyledDocument();
		this.notepad.currentSearchLocation = this.notepad.bigEdit.getCaretPosition();
	}

	public static Next valueOf(BIGNotepad notepad) {
		return new Next(notepad);
	}

	public void find(String toFind, int searchMode) throws BadLocationException {
		for (int index = notepad.currentSearchLocation; index < document.getLength(); index++) {
			int endIndex = index + toFind.length();
			String temp = document.getText(index, endIndex);

			if (searchMode == Type.get().IGNORE_CASE_WHOLE_WORD) {
				WholeWord.get(notepad).find(toFind, index, temp);

			} else if (searchMode == Type.get().IGNORE_CASE_WORD_START) {
				WordStart.get(notepad).find(toFind, index, temp);

			} else if (searchMode == Type.get().IGNORE_CASE) {
				IgnoreCase.get(notepad).find(toFind, endIndex, temp);
			}

			if (notepad.currentSearchLocation == document.getLength()) {
				// if EOF ask for wrap around
				Feedback.valueOf(notepad).determineWrapAround();
			}
		}
	}
}
