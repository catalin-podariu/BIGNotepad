package gui;

import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

public class ReplaceDialog extends JDialog {
	
	private BIGNotepad notepad;
	private StyledDocument document;
	private JTextPane bigEdit;

	private ReplaceDialog(BIGNotepad notepad) {
		this.notepad = notepad;
		document = bigEdit.getStyledDocument();
		bigEdit = notepad.bigEdit;
	}

	public static ReplaceDialog create(BIGNotepad notepad) {
		return new ReplaceDialog(notepad);
	}
	
	public void setVisible(boolean status){
		this.setVisible(status);
	}
	
	void replaceDialogComponentShown(java.awt.event.ComponentEvent evt) {
		notepad.findDialog.dispose();
		this.setLocationRelativeTo(notepad);
		String noStringSelected = "";
		addSelectedStringAsFindItem(replaceDSearchCombo, noStringSelected);
	}
	
	void replaceDCloseActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
	}
	
	void replaceGotoFindMouseClicked(java.awt.event.MouseEvent evt) {
		this.dispose();
		if (replaceDSearchCombo.getSelectedItem() != null) {
			findDSearchCombo.addItem(replaceDSearchCombo.getSelectedItem());
			findDSearchCombo.setSelectedItem(replaceDSearchCombo.getSelectedItem());
		}
		notepad.findDialog.setVisible(true);
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
	
	javax.swing.JCheckBox highlightRSearchCombo;
	javax.swing.JCheckBox highlightSearchCombo;
	javax.swing.JCheckBox incrementalRSearchCombo;
	javax.swing.JButton replaceDClose;
	javax.swing.JButton replaceDFindNext;
	javax.swing.JButton replaceDFindPrev;
	javax.swing.JCheckBox replaceDMatchCase;
	javax.swing.JCheckBox replaceDMatchWord;
	javax.swing.JCheckBox replaceDMatchWordStart;
	javax.swing.JCheckBox replaceDRegex;
	javax.swing.JButton replaceDReplace;
	javax.swing.JButton replaceDReplaceAll;
	javax.swing.JComboBox<String> replaceDReplaceCombo;
	javax.swing.JLabel replaceDReplaceLabel;
	javax.swing.JComboBox<Object> replaceDSearchCombo;
	javax.swing.JLabel replaceDSearchLabel;
	javax.swing.JCheckBox replaceDSelectedText;
	javax.swing.JDialog replaceDialog;
	javax.swing.JLabel replaceGotoFind;
}
