package gui;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import config.TitleDisplayMode;

/**
 * Right click menu.
 * 
 * @author catalin.podariu[at]gmail.com
 */
public class QuickMenu {

	protected javax.swing.JPopupMenu popupMenu;

	protected javax.swing.JMenuItem quickUndo, quickRedo;
	protected javax.swing.JPopupMenu.Separator quickMenuS1;
	protected javax.swing.JMenuItem quickCut, quickCopy, quickCopyAll, quickPaste, quickSwap, quickClear;
	protected javax.swing.JPopupMenu.Separator quickMenuS2;
	protected javax.swing.JMenuItem quickSelectAll;

	private BIGNotepad notepad;

	private QuickMenu(BIGNotepad notepad) {
		this.notepad = notepad;
	}

	public static QuickMenu display(BIGNotepad notepad) {
		return new QuickMenu(notepad);
	}

	protected void createNewQuickMenu(java.awt.event.MouseEvent evt) {
		initializeComponents();

		popupMenu.setLocation(evt.getXOnScreen(), evt.getYOnScreen());
		quickUndo.setEnabled(notepad.undoManager.canUndo());
		quickRedo.setEnabled(notepad.undoManager.canRedo());
		quickCut.setEnabled(notepad.bigEdit.getSelectedText() != null);
		quickCopy.setEnabled(notepad.bigEdit.getSelectedText() != null);
		quickSelectAll.setEnabled(notepad.bigEdit.getText().length() != 0);
		String data = null;
		try {
			data = (String) Toolkit.getDefaultToolkit() //
					.getSystemClipboard().getData(DataFlavor.stringFlavor);
		} catch (UnsupportedFlavorException | IOException ex) {
			System.err.println("Clipboard error. " + ex);
		}
		quickPaste.setEnabled(data != null);
		quickSwap.setEnabled(data != null & notepad.bigEdit.getSelectedText() != null);

		displayQuickMenuGUI();
	}

	private void initializeComponents() {
		new QuickMenuComponents(notepad, this).initComponents();
	}

	private void displayQuickMenuGUI() {
		popupMenu.setVisible(true);
	}

	void quickUndoActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			notepad.undoManager.undo();
			notepad.updateUndoMenuItems();
		} catch (CannotUndoException cue) {
			notepad.documentIsModified = notepad.undoManager.canUndo();
			TitleDisplayMode.valueOf(notepad).setWindowTitleDisplay(notepad.windowTitleDisplayMode);
			System.err.println("CannotUndo ex: " + cue);
		}
	}

	void quickRedoActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			notepad.undoManager.redo();
			notepad.updateUndoMenuItems();
		} catch (CannotRedoException cre) {
			System.err.println(cre);
		}
	}

	void quickCutActionPerformed(java.awt.event.ActionEvent evt) {
		notepad.bigEdit.cut();
	}

	void quickCopyActionPerformed(java.awt.event.ActionEvent evt) {
		notepad.bigEdit.copy();
	}

	void quickCopyAllActionPerformed(java.awt.event.ActionEvent evt) {
		notepad.bigEdit.selectAll();
		notepad.bigEdit.copy();
	}

	void quickPasteActionPerformed(java.awt.event.ActionEvent evt) {
		notepad.bigEdit.paste();
	}

	void quickSwapActionPerformed(java.awt.event.ActionEvent evt) {
		String currentlySelectedText = notepad.bigEdit.getSelectedText();
		String textAlreadyOnClipboard = "";
		try {
			textAlreadyOnClipboard = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
					.getData(DataFlavor.getTextPlainUnicodeFlavor());
		} catch (UnsupportedFlavorException | IOException ex) {
			System.err.println("Clipboard error. " + ex);
		}

		StringSelection stringSelection = new StringSelection(currentlySelectedText);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		notepad.bigEdit.replaceSelection(textAlreadyOnClipboard);
	}

	void quickClearActionPerformed(java.awt.event.ActionEvent evt) {
		notepad.bigEdit.setText("");
	}

	void quickSelectAllActionPerformed(java.awt.event.ActionEvent evt) {
		notepad.bigEdit.selectAll();
	}

}
