package gui;

import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

public class ReplaceDialog {
	
	private BIGNotepad notepad;
	private StyledDocument document;
	private JTextPane bigEdit;
	
	JDialog replaceDialog;
	private JDialog findDialog;

	private ReplaceDialog(BIGNotepad notepad, JDialog findDialog) {
		this.notepad = notepad;
		this.findDialog = findDialog;
		document = bigEdit.getStyledDocument();
		bigEdit = notepad.bigEdit;
		
		replaceDialog = new javax.swing.JDialog();
	}

	public static ReplaceDialog create(BIGNotepad notepad, JDialog findDialog) {
		return new ReplaceDialog(notepad, findDialog);
	}
	
	public void setVisible(boolean status){
		replaceDialog.setVisible(status);
	}
	
	void replaceDialogComponentShown(java.awt.event.ComponentEvent evt) {
		findDialog.dispose();
		replaceDialog.setLocationRelativeTo(notepad);
		String noStringSelected = "";
		addSelectedStringAsFindItem(replaceDSearchCombo, noStringSelected);
	}
	
	void replaceDCloseActionPerformed(java.awt.event.ActionEvent evt) {
		replaceDialog.dispose();
	}
	
	void replaceGotoFindMouseClicked(java.awt.event.MouseEvent evt) {
		replaceDialog.dispose();
		if (replaceDSearchCombo.getSelectedItem() != null) {
			findDSearchCombo.addItem(replaceDSearchCombo.getSelectedItem());
			findDSearchCombo.setSelectedItem(replaceDSearchCombo.getSelectedItem());
		}
		findDialog.setVisible(true);
	}
	
	void replaceDFindNextActionPerformed(java.awt.event.ActionEvent evt) {
		if (replaceDSearchCombo.getSelectedItem() != null) {
			replaceDSearchCombo.insertItemAt(replaceDSearchCombo.getSelectedItem(), 0);
			findNextString(replaceDSearchCombo);
		}
	}

	void replaceDFindPrevActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO catalin.podariu search engine call
	}
}
