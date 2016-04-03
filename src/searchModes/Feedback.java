package searchModes;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

import gui.BIGNotepad;

public class Feedback {

	private BIGNotepad notepad;
	private JTextPane bigEdit;
	private StyledDocument document;

	private Feedback(BIGNotepad notepad) {
		this.bigEdit = notepad.bigEdit;
		document = this.bigEdit.getStyledDocument();
		notepad.currentSearchLocation = this.bigEdit.getCaretPosition();
	}

	public static Feedback valueOf(BIGNotepad notepad) {
		return new Feedback(notepad);
	}

	public void determineWrapAround() {
		if (notepad.searchWrapAround) {
			int status = JOptionPane.showConfirmDialog(null, // ?!
					"Start search from the begining of document?", //
					"No String found..", //
					JOptionPane.YES_NO_OPTION);
			if (status == 0) {
				notepad.currentSearchLocation = 0;
			} else if (status == 1) {
				notepad.currentSearchLocation = document.getLength();
			}
		}
	}

	public void selectString(int selStart, int selEnd) {
		bigEdit.requestFocus();
		bigEdit.setCaretPosition(selStart);
		bigEdit.moveCaretPosition(selStart + selEnd);
	}

	public void displayCustomMessage(String messageToDisplay) {
		JOptionPane.showConfirmDialog(null, // ?!
				messageToDisplay, //
				"BIG Notepad says..", //
				JOptionPane.OK_OPTION);
	}
}
