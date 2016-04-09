package gui;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class FindDialog {

	private BIGNotepad notepad;
	private StyledDocument document;
	private JTextPane bigEdit;
	
	private JDialog findDialog;

	private FindDialog(BIGNotepad notepad) {
		this.notepad = notepad;
		document = bigEdit.getStyledDocument();
		bigEdit = notepad.bigEdit;
		
		findDialog = new javax.swing.JDialog();
	}

	public static FindDialog create(BIGNotepad notepad) {
		return new FindDialog(notepad);
	}

	public void showDialog(boolean status) {
		findDialog.setVisible(status);
	}
	
	

	void findDialogComponentShown(java.awt.event.ComponentEvent evt) {
		replaceDialog.dispose();
		findDialog.setLocationRelativeTo(this);
		String noStringSelected = "";
		addSelectedStringAsFindItem(findDSearchCombo, noStringSelected);
	}

	private void addSelectedStringAsFindItem(JComboBox<Object> comboBox, String noStringSelected) {
		if (bigEdit.getSelectedText() != null) {
			String selectedString = bigEdit.getSelectedText();
			findDSearchCombo.addItem(selectedString);
			findDSearchCombo.setSelectedItem(selectedString);
		} else {
			replaceDSearchCombo.setSelectedItem(noStringSelected);
		}
	}
	
	void replaceDReplaceActionPerformed(java.awt.event.ActionEvent evt) {
		selectReplacedStringUserFeedback();
		findNextString(replaceDSearchCombo);
	}
	
	public void findNextString(JComboBox<Object> comboBox) {
		if (comboBox.getSelectedItem() != null) {
			String stringToFind = comboBox.getItemAt(0).toString();
			int currentSearchLocation = bigEdit.getCaretPosition();
			try {
				findStringIgnoreCase(stringToFind, currentSearchLocation);
			} catch (BadLocationException ex) {
				System.err.println(ex);
			}
		}
	}

	private void findStringIgnoreCase(String stringToFind, int currentSearchLocation) throws BadLocationException {
		for (int index = currentSearchLocation; //
		index + stringToFind.length() < document.getLength(); index++) {
			String stringToMatch = document.getText(index, stringToFind.length());
			if (stringToFind.equalsIgnoreCase(stringToMatch)) {
				selectFoundString(index, stringToFind.length());
				break;
			}
			if (index == document.getLength()) {
				JOptionPane.showMessageDialog(this, "EOF reached");
			}
		}
	}
	
	private void selectFoundString(int location, int toFindLength) {
		bigEdit.requestFocus();
		bigEdit.setCaretPosition(location);
		bigEdit.moveCaretPosition(location + toFindLength);
	}

	private void selectReplacedStringUserFeedback() {
		try {
			String replaceWith = replaceDReplaceCombo.getSelectedItem().toString();
			bigEdit.getDocument().remove(bigEdit.getSelectionStart(), bigEdit.getSelectedText().length());
			bigEdit.getDocument().insertString(bigEdit.getSelectionStart(), replaceWith, null);
		} catch (BadLocationException ex) {
		}
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
