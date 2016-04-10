package gui;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

public class FindDialog extends JDialog {

	private BIGNotepad notepad;
	private StyledDocument document;
	private JTextPane bigEdit;
	
	private FindDialogComponents components;

	private FindDialog(BIGNotepad notepad) {
		this.notepad = notepad;
		document = bigEdit.getStyledDocument();
		bigEdit = notepad.bigEdit;
		
		components = new FindDialogComponents(this);
		components.initComponents();
	}

	public static FindDialog create(BIGNotepad notepad) {
		return new FindDialog(notepad);
	}

	public void showDialog(boolean status) {
		this.setVisible(status);
	}

	void findDialogComponentShown(java.awt.event.ComponentEvent evt) {
		replaceDialog.dispose();
		notepad.findDialog.setLocationRelativeTo(this);
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

	void findDCloseActionPerformed(java.awt.event.ActionEvent evt) {
		findDialog.dispose();
	}

	void findGotoReplaceMouseClicked(java.awt.event.MouseEvent evt) {
		findDialog.dispose();
		if (findDSearchCombo.getSelectedItem() != null) {
			replaceDSearchCombo.addItem(findDSearchCombo.getSelectedItem());
			replaceDSearchCombo.setSelectedItem(findDSearchCombo.getSelectedItem());
		}
		replaceDialog.showDialog(true);
	}

	void findDFindNextActionPerformed(java.awt.event.ActionEvent evt) {
		if (findDSearchCombo.getSelectedItem() != null) {
			findDSearchCombo.insertItemAt(findDSearchCombo.getSelectedItem(), 0);
			findNextString(findDSearchCombo);
		}
	}

	void findDFindPrevActionPerformed(java.awt.event.ActionEvent evt) {

	}
	
	public javax.swing.JButton findDClose;
	public javax.swing.JButton findDFindNext;
	public javax.swing.JButton findDFindPrev;
	public javax.swing.JCheckBox findDMatchCase;
	public javax.swing.JCheckBox findDMatchWord;
	public javax.swing.JCheckBox findDMatchWordStart;
	public javax.swing.JCheckBox findDRegex;
	public javax.swing.JComboBox<Object> findDSearchCombo;
	public javax.swing.JLabel findDSearchLabel;
	public javax.swing.JCheckBox findDSelectedText;
	public javax.swing.JLabel findGotoReplace;

	
}
