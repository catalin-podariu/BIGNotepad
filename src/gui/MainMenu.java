package gui;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.Locale;

import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

import config.ConfigOLD;
import config.IconHandler;
import config.SaveCurrentSettings;
import config.TitleDisplayMode;
import io.OpenFile;
import io.SaveFile;
import utilities.MinimizeToSystemTray;
import utilities.WrapText;

public class MainMenu {

	private BIGNotepad notepad;
	private StyledDocument document;
	private JTextPane bigEdit;
	private UndoManager undoManager;

	private MainMenu(BIGNotepad notepad) {
		this.notepad = notepad;
		document = bigEdit.getStyledDocument();
		bigEdit = notepad.bigEdit;
		undoManager = notepad.undoManager;
	}

	public static MainMenu create(BIGNotepad notepad) {
		return new MainMenu(notepad);
	}

	void viewWrapMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		notepad.wordWrap = viewWrapMenuItem.isSelected();
		WrapText wrapper = new WrapText(notepad.wordWrap);
		wrapper.getScrollableTracksViewportWidth();
	}

	void editClearClipboardMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		StringSelection stringSelection = new StringSelection("");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	void editMenuMenuSelected(javax.swing.event.MenuEvent evt) {
		if (bigEdit.getSelectedText() == null) {
			editMenuAccess(false);
		} else {
			editMenuAccess(true);
		}
		String clipboard = getClipboardContent();
		if (clipboard.length() >= 1) {
			editPasteMenuItem.setEnabled(true);
		} else {
			editPasteMenuItem.setEnabled(false);
		}
	}

	private void editMenuAccess(boolean state) {
		editConvertMenu.setEnabled(state);
		editCopyMenuItem.setEnabled(state);
		editCutMenuItem.setEnabled(state);
	}

	private String getClipboardContent() {
		String clipboard = "";
		try {
			clipboard = Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString();
		} catch (UnsupportedFlavorException | IOException ex) {
			System.err.println("Nothig on the clipboard. " + ex);
		}
		return clipboard;
	}

	void editPasteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		bigEdit.paste();
	}

	void editCopyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		bigEdit.copy();
	}

	void editCutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		bigEdit.cut();
	}

	void viewThemeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO catalin.podariu add color themes
	}

	void settAlwaysOnTopMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		if (settAlwaysOnTopMenuItem.isSelected()) {
			notepad.isAlwaysOnTop = true;
			notepad.setAlwaysOnTop(true);
		} else {
			notepad.isAlwaysOnTop = false;
			notepad.setAlwaysOnTop(false);
		}
	}

	void setMinToTrayMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		if (setMinToTrayMenuItem.isSelected()) {
			MinimizeToSystemTray.valueOf(notepad).sysTrayMenu();
			notepad.isMinimizedToTray = true;
		} else {
			notepad.isMinimizedToTray = false;
		}
	}

	void editConvToLowerCaseActionPerformed(java.awt.event.ActionEvent evt) {
		convertStringCase("low");
	}

	void editConvToUpperCaseActionPerformed(java.awt.event.ActionEvent evt) {
		convertStringCase("UP");
	}

	void editConvInvertCaseActionPerformed(java.awt.event.ActionEvent evt) {
		convertStringCase("invert");
	}

	private String convertStringCase(String mode) {
		String convertedString = bigEdit.getSelectedText();
		switch (mode) {
		case "low":
			convertedString = convertedString.toLowerCase();
			break;
		case "UP":
			convertedString = convertedString.toUpperCase();
			break;
		case "invert":
			convertedString = invertStringCaseConvertMode(convertedString);
			break;
		}
		updateConvertedStringInDocument(convertedString);
		return convertedString;
	}

	private String invertStringCaseConvertMode(String convertedString) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < convertedString.length(); i++) {
			char c = convertedString.charAt(i);
			if (Character.isLowerCase(c)) {
				stringBuilder.append(Character.toUpperCase(c));
			} else if (Character.isUpperCase(c)) {
				stringBuilder.append(Character.toLowerCase(c));
			}
		}
		convertedString = stringBuilder.toString();
		return convertedString;
	}

	private void updateConvertedStringInDocument(String convertedString) {
		try {
			document.remove(bigEdit.getSelectionStart(), //
					bigEdit.getSelectedText().length());
			document.insertString(bigEdit.getSelectionStart(), //
					convertedString, null);
		} catch (BadLocationException ex) {
			System.err.println(ex);
		}
	}

	void editUndoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			undoManager.undo();
			notepad.updateUndoMenuItems();
		} catch (CannotUndoException cue) {
			notepad.documentIsModified = undoManager.canUndo();
			TitleDisplayMode.valueOf(notepad).setWindowTitleDisplay(notepad.windowTitleDisplayMode);
			System.err.println("CannotUndo ex: " + cue);
		}
	}

	void editRedoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			undoManager.redo();
			notepad.updateUndoMenuItems();
		} catch (CannotRedoException cre) {
			System.err.println(cre);
		}
	}

	void editSelectAllMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		bigEdit.selectAll();
	}

	void aboutAuthorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		AboutDialog.display(notepad);
	}

	void viewStatusBarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		if (viewStatusBarMenuItem.isSelected()) {
			notepad.mainStatusPanel.setVisible(true);
			notepad.displayStatusBar = true;
		} else {
			notepad.mainStatusPanel.setVisible(false);
			notepad.displayStatusBar = false;
		}
	}

	void viewQuickMMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		if (viewQuickMMenuItem.isSelected()) {
			notepad.quickIconsPanel.setVisible(true);
			notepad.displayQuickMenu = true;
		} else {
			notepad.quickIconsPanel.setVisible(false);
			notepad.displayQuickMenu = false;
		}
	}

	void fileOpenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		OpenFile.valueOf(notepad).fileOpenNew();
	}

	void fileSaveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		SaveFile.valueOf(notepad).fileSaveAs();
	}

	void fileSaveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		String fileStatus = "empty";
		if (!notepad.fileIsReadOnly & !bigEdit.getText().equals("")) {
			SaveFile.valueOf(notepad).saveCurrentFile();
			if (notepad.fileIsReadOnly) {
				fileStatus = "read only";
			}
		} else {
			fileCannotBeSavedUserFeedback(fileStatus);
		}
	}

	private void fileCannotBeSavedUserFeedback(String fileStatus) {
		int select = JOptionPane.showConfirmDialog(notepad,
				"This file is " + fileStatus + "!\nSave with a different name?", //
				"File not saved", JOptionPane.YES_NO_OPTION);
		if (select == JOptionPane.YES_OPTION) {
			SaveFile.valueOf(notepad).fileSaveAs();
		}
	}

	void settSaveNowMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		int temp = SaveCurrentSettings.valueOf(notepad).saveSettings();
		if (temp == 0) {
			JOptionPane.showConfirmDialog(notepad, //
					"Settings were saved successfully", "BIGNotepad settings", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showConfirmDialog(notepad, //
					"Settings were NOT saved", "BIGNotepad settings", JOptionPane.PLAIN_MESSAGE);
		}
	}

	void viewResetZoomMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		notepad.zoomFactor = 100;
	}

	void viewDefaultFontActionPerformed(java.awt.event.ActionEvent evt) {
		JFontChooser fontChooser = new JFontChooser();
		fontChooser.createDialog(notepad).setVisible(true);
		bigEdit.setFont(fontChooser.getSelectedFont());
	}

	void insertShortDateActionPerformed(java.awt.event.ActionEvent evt) {
		insertDateFormat("short"); // default
	}

	void insertLongDateActionPerformed(java.awt.event.ActionEvent evt) {
		insertDateFormat("long");
	}

	private void insertDateFormat(String dateFormatMode) {
		int dateConstant = DateFormat.SHORT;
		if (dateFormatMode.equals("long")) {
			dateConstant = DateFormat.LONG;
		}
		DateFormat dateFormat = DateFormat.getDateInstance(dateConstant, Locale.getDefault());
		try {
			document.insertString(bigEdit.getCaretPosition(), dateFormat.toString(), null);
		} catch (BadLocationException ex) {
			System.err.println(ex);
		}
	}

	void filePrintMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			bigEdit.print();
		} catch (PrinterException ex) {
			System.err.println(ex);
		}
	}

	void fileSetReadOnlyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		if (notepad.currentlyOpenedFile != null) {
			if (fileSetReadOnlyMenuItem.isSelected()) {
				notepad.currentlyOpenedFile.setWritable(false);
				notepad.fileIsReadOnly = true;
			} else {
				notepad.currentlyOpenedFile.setWritable(true);
				notepad.fileIsReadOnly = false;
			}
		}
	}

	void winTitleDisplayMode2ActionPerformed(java.awt.event.ActionEvent evt) {
		TitleDisplayMode.valueOf(notepad) //
				.setWindowTitleDisplay(notepad.windowTitleDisplayMode = notepad.FULL_PATH);
	}

	void winTitleDisplayMode1ActionPerformed(java.awt.event.ActionEvent evt) {
		TitleDisplayMode.valueOf(notepad) //
				.setWindowTitleDisplay(notepad.windowTitleDisplayMode = notepad.FILE_NAME_AND_PARENT_FOLDER);
	}

	void winTitleDisplayMode0ActionPerformed(java.awt.event.ActionEvent evt) {
		TitleDisplayMode.valueOf(notepad) //
				.setWindowTitleDisplay(notepad.windowTitleDisplayMode = notepad.FILE_NAME);
	}

	void displayLineNumMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		notepad.lineNumbers = new LineNumbers(notepad.editorScrollPane, bigEdit);

		if (displayLineNumMenuItem.isSelected()) {
			notepad.lineNumbersActive = true;
			notepad.editorScrollPane.setRowHeaderView(notepad.lineNumbers);
		} else {
			notepad.lineNumbersActive = false;
			notepad.editorScrollPane.setRowHeaderView(null);
		}
	}

	void helpTopicsActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO catalin.podariu move to object ?!
		Icon msgIcon = IconHandler.getIcon().getIcon("/Resources/images/notepad.png");
		if (msgIcon != null) {
			JOptionPane.showMessageDialog(notepad,
					"Unfortunately, the disabled menu items are not available at the moment\n"
							+ "But they will be brought to life very soon!",
					"BIGNotepad october 2015", JOptionPane.PLAIN_MESSAGE, msgIcon);
		} else {
			JOptionPane.showConfirmDialog(null,
					"Unfortunately, the disabled menu items are not available at the moment\n"
							+ "But they will be brought to life very soon!\n" //
							+ "BIGNotepad october 2015" + "\nIcon not found\n",
					"BIGNotepad message", JOptionPane.PLAIN_MESSAGE);
		}
	}

	void viewLongLineMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		notepad.displayLongLineMarker = viewLongLineMenuItem.isSelected();

	}

	void settRecentFilesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		notepad.rememberRecentFiles = settRecentFilesMenuItem.isSelected();
	}

	void settSaveOnExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		notepad.saveSettingsOnExit = settSaveOnExitMenuItem.isSelected();
	}

	void settRecentSearchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		notepad.rememberRecentSearches = settRecentSearchMenuItem.isSelected();
	}

	void formWindowClosing(java.awt.event.WindowEvent evt) {
		notepad.exit(0);
	}

	void fileEncodingANSIActionPerformed(java.awt.event.ActionEvent evt) {
		settEncoding("CP1252");
	}

	void fileEncodingUnicodeActionPerformed(java.awt.event.ActionEvent evt) {
		settEncoding("UTF-8");
	}

	void fileEncodingBEActionPerformed(java.awt.event.ActionEvent evt) {
		settEncoding("UTF-16BE");
	}

	void fileEncodingUTF8ActionPerformed(java.awt.event.ActionEvent evt) {
		settEncoding("UTF-8");
	}

	void fileEncodingLatin1ActionPerformed(java.awt.event.ActionEvent evt) {
		settEncoding("ISO-8859-1");
	}

	private void settEncoding(String encodeTo) {
		try {
			System.setProperty("file.encoding", encodeTo);
			Field charset = Charset.class.getDeclaredField("defaultCharset");
			charset.setAccessible(true);
			charset.set(null, null);
			notepad.encodingStatusLabel.setText(encodeTo);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
			System.err.println("Set encoding error: " + ex);
		}
	}

	void fileNewEmptyWindowActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO catalin.podariu (research creating new process)
	}

	void settingsWinSizePositionActionPerformed(java.awt.event.ActionEvent evt) {
		notepad.rememeberMainWindowSize = settingsMainWindowSizePosition.isSelected();
	}

	void settingsResetAllActionPerformed(java.awt.event.ActionEvent evt) {
		ConfigOLD config = new ConfigOLD(notepad.defaultTempFolder);
		int status = config.failSafe();
		if (status == 0) {
			JOptionPane.showConfirmDialog(notepad, "Settings set to default.", "BIGNotepad settings",
					JOptionPane.PLAIN_MESSAGE);
		}
	}

	void findMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		FindDialog.create(notepad).setVisible(true);
	}

	void replaceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		ReplaceDialog.create(notepad).setVisible(true);
	}

	void fileNewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		if (notepad.documentIsModified) {
			int status = SaveFile.valueOf(notepad).saveConfirmation();
			errorWritingFileUserFeedback(status);
		} else {
			notepad.newBlankDocument();
		}
	}

	private void errorWritingFileUserFeedback(int status) {
		if (status == -1 | status == 2) {
			JOptionPane.showConfirmDialog(notepad, //
					"Error writing file.", "File not saved", //
					JOptionPane.PLAIN_MESSAGE);
		} else {
			notepad.newBlankDocument();
		}
	}

	void fileExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		if (notepad.documentIsModified) {
			int status = SaveFile.valueOf(notepad).saveConfirmation();
			if (status == 1) {
				notepad.exit(1);
			}
		} else {
			notepad.exit(0);
		}
	}

	public javax.swing.JMenuBar mainMenu;

	public javax.swing.JCheckBoxMenuItem displayLineNumMenuItem;
	public javax.swing.JMenuItem editClearClipboardMenuItem;
	public javax.swing.JMenuItem editConvInvertCase;
	public javax.swing.JMenuItem editConvToLowerCase;
	public javax.swing.JMenuItem editConvToUpperCase;
	public javax.swing.JMenu editConvertMenu;
	public javax.swing.JMenuItem editCopyMenuItem;
	public javax.swing.JMenuItem editCutMenuItem;
	public javax.swing.JMenu editInsertMenu;
	public javax.swing.JMenu editMenu;
	public javax.swing.JMenuItem editPasteMenuItem;
	public javax.swing.JMenuItem editRedoMenuItem;
	public javax.swing.JMenuItem editSelectAllMenuItem;
	public javax.swing.JMenuItem editUndoMenuItem;
	public javax.swing.JMenuItem fileEncodingANSI;
	public javax.swing.JMenuItem fileEncodingBE;
	public javax.swing.JMenuItem fileEncodingLatin1;
	public javax.swing.JMenuItem fileEncodingUTF8;
	public javax.swing.JMenuItem fileEncodingUnicode;
	public javax.swing.JMenuItem fileExitMenuItem;
	public javax.swing.JMenu fileMenu;
	public javax.swing.JMenuItem fileNewEmptyWindow;
	public javax.swing.JMenuItem fileNewMenuItem;
	public javax.swing.JMenuItem fileOpenMenuItem;
	public javax.swing.JMenuItem filePrintMenuItem;
	public javax.swing.JMenu fileRecentMenu;
	public javax.swing.JMenuItem fileSaveAsMenuItem;
	public javax.swing.JMenuItem fileSaveMenuItem;
	public javax.swing.JPopupMenu.Separator fileSeparator1;
	public javax.swing.JPopupMenu.Separator fileSeparator2;
	public javax.swing.JPopupMenu.Separator fileSeparator3;
	public javax.swing.JPopupMenu.Separator fileSeparator4;
	public javax.swing.JPopupMenu.Separator fileSeparator5;
	public javax.swing.JPopupMenu.Separator fileSeparator6;
	public javax.swing.JCheckBoxMenuItem fileSetReadOnlyMenuItem;
	public javax.swing.JMenuItem insertLongDate;
	public javax.swing.JMenuItem insertShortDate;
	public javax.swing.JMenu jMenu1;
	public javax.swing.JMenu jMenu2;
	public javax.swing.JMenuItem jMenuItem8;
	public javax.swing.JPopupMenu.Separator jSeparator1;
	public javax.swing.JPopupMenu.Separator jSeparator10;
	public javax.swing.JPopupMenu.Separator jSeparator2;
	public javax.swing.JPopupMenu.Separator jSeparator3;
	public javax.swing.JPopupMenu.Separator jSeparator4;
	public javax.swing.JPopupMenu.Separator jSeparator5;
	public javax.swing.JPopupMenu.Separator jSeparator6;
	public javax.swing.JMenuItem findMenuItem;
	public javax.swing.JMenu helpMenu;
	public javax.swing.JMenuItem helpTopics;
	public javax.swing.JMenuItem replaceMenuItem;
	public javax.swing.JCheckBoxMenuItem setMinToTrayMenuItem;
	public javax.swing.JCheckBoxMenuItem settAlwaysOnTopMenuItem;
	public javax.swing.JCheckBoxMenuItem settRecentFilesMenuItem;
	public javax.swing.JCheckBoxMenuItem settRecentSearchMenuItem;
	public javax.swing.JMenuItem settSaveNowMenuItem;
	public javax.swing.JCheckBoxMenuItem settSaveOnExitMenuItem;
	public javax.swing.JMenu settingsMenu;
	public javax.swing.JMenuItem settingsResetAll;
	public javax.swing.JCheckBoxMenuItem settingsMainWindowSizePosition;
	public javax.swing.JMenuItem viewDefaultFont;
	public javax.swing.JCheckBoxMenuItem viewLongLineMenuItem;
	public javax.swing.JMenu viewMenu;
	public javax.swing.JCheckBoxMenuItem viewQuickMMenuItem;
	public javax.swing.JMenuItem viewResetZoomMenuItem;
	public javax.swing.JCheckBoxMenuItem viewStatusBarMenuItem;
	public javax.swing.JMenuItem viewThemeMenuItem;
	public javax.swing.JCheckBoxMenuItem viewWrapMenuItem;
	public javax.swing.JMenuItem winTitleDisplayMode0;
	public javax.swing.JMenuItem winTitleDisplayMode1;
	public javax.swing.JMenuItem winTitleDisplayMode2;
	public javax.swing.JMenuItem aboutAuthorMenuItem;
}
