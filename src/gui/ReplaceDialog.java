package gui;

import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

public class ReplaceDialog {
	
	private BIGNotepad notepad;
	private StyledDocument document;
	private JTextPane bigEdit;
	
	JDialog replaceDialog;

	private ReplaceDialog(BIGNotepad notepad) {
		this.notepad = notepad;
		document = bigEdit.getStyledDocument();
		bigEdit = notepad.bigEdit;
		
		replaceDialog = new javax.swing.JDialog();
	}

	public static ReplaceDialog create(BIGNotepad notepad) {
		return new ReplaceDialog(notepad);
	}
	
	public void setVisible(boolean status){
		replaceDialog.setVisible(status);
	}
	
	void replaceDialogComponentShown(java.awt.event.ComponentEvent evt) {
		findDialog.dispose();
		replaceDialog.setLocationRelativeTo(this);
		String noStringSelected = "";
		addSelectedStringAsFindItem(replaceDSearchCombo, noStringSelected);
	}
}
