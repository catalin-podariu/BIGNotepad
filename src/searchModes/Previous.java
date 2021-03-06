package searchModes;

import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import gui.BIGNotepad;
import searchEngine.Type;

/**
 *
 * @author catalin.podariu[at]gmail.com
 */
public class Previous {

	private BIGNotepad notepad;
	private StyledDocument document;

	private Previous(BIGNotepad notepad) {
		this.notepad = notepad;
		document = this.notepad.bigEdit.getStyledDocument();
		this.notepad.currentSearchLocation = this.notepad.bigEdit.getCaretPosition();
	}

	public static Previous valueOf(BIGNotepad notepad) {
		return new Previous(notepad);
	}

	public void find(String toFind, int searchMode) throws BadLocationException {
		for (int index = notepad.currentSearchLocation; index - toFind.length() >= 0; index--) {
			int endIndex = index + toFind.length();
			String temp = document.getText(index, endIndex);

			if (searchMode == Type.IGNORE_CASE_WHOLE_WORD.getValue()) {
				Type.IGNORE_CASE_WHOLE_WORD.find(notepad, toFind, index, temp);

			} else if (searchMode == Type.IGNORE_CASE_WORD_START.getValue()) {
				Type.IGNORE_CASE_WORD_START.find(notepad, toFind, index, temp);

			} else if (searchMode == Type.IGNORE_CASE.getValue()) {
				Type.IGNORE_CASE.find(notepad, toFind, index, temp);
			}

			if (searchMode == Type.MATCH_CASE_WHOLE_WORD.getValue()) {
				Type.MATCH_CASE_WHOLE_WORD.find(notepad, toFind, index, temp);

			} else if (searchMode == Type.MATCH_CASE_WORD_START.getValue()) {
				Type.MATCH_CASE_WORD_START.find(notepad, toFind, index, temp);

			} else if (searchMode == Type.MATCH_CASE.getValue()) {
				Type.MATCH_CASE.find(notepad, toFind, index, temp);
			}

			if (notepad.currentSearchLocation == 0) {
				// if BEGINING of document is reached ask for wrap around
				Feedback.valueOf(notepad).determineWrapAround();
			}
		}
	}
}
