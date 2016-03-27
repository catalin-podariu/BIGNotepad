package gui;

import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.Locale;

import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

import config.ConfigOLD;
import config.DefaultConfig;
import config.IconHandler;
import config.TitleDisplayMode;
import io.OpenFile;
import io.SaveCurrentSettings;
import io.SaveFile;
import utilities.MinimizeToSystemTray;
import utilities.WrapText;

/**
 * BIG Notepad start point.
 * 
 * @author catalin.podariu[at]gmail.com
 */
public class BIGNotepad extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	private static final int FILE_NAME = 0;
	private static final int FILE_NAME_AND_PARENT_FOLDER = 1;
	private static final int FULL_PATH = 2;

	private final static int FILE_NOT_SAVED = 0;
	private final static int FILE_SAVED = 1;

	public BIGNotepad() {
		defaultTempFolder = System.getProperty("user.dir") + "\\BigTextEditor\\";
	}

	public static BIGNotepad getInstance() {
		BIGNotepad notepad = new BIGNotepad();
		new GUIComponents(notepad).initComponents();
		notepad.initConfig();
		return notepad;
	}

	void fileExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		if (askToSave) {
			int status = SaveFile.valueOf(this).saveConfirmation();
			if (status == 1) {
				exit(1);
			}
		} else {
			exit(0);
		}
	}

	void formWindowOpened(java.awt.event.WindowEvent evt) {
		// TODO catalin.podariu ?!
	}

	void replaceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		replaceDialog.setVisible(true);
	}

	void replaceDCloseActionPerformed(java.awt.event.ActionEvent evt) {
		replaceDialog.dispose();
	}

	void findDCloseActionPerformed(java.awt.event.ActionEvent evt) {
		findDialog.dispose();
	}

	void replaceGotoFindMouseClicked(java.awt.event.MouseEvent evt) {
		replaceDialog.dispose();
		if (replaceDSearchCombo.getSelectedItem() != null) {
			findDSearchCombo.addItem(replaceDSearchCombo.getSelectedItem());
			findDSearchCombo.setSelectedItem(replaceDSearchCombo.getSelectedItem());
		}
		findDialog.setVisible(true);
	}

	void findGotoReplaceMouseClicked(java.awt.event.MouseEvent evt) {
		findDialog.dispose();
		if (findDSearchCombo.getSelectedItem() != null) {
			replaceDSearchCombo.addItem(findDSearchCombo.getSelectedItem());
			replaceDSearchCombo.setSelectedItem(findDSearchCombo.getSelectedItem());
		}
		replaceDialog.setVisible(true);
	}

	void findMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		findDialog.setVisible(true);
	}

	void fileNewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		if (askToSave) {
			int status = SaveFile.valueOf(this).saveConfirmation();
			errorWritingFileUserFeedback(status);
		} else {
			newBlankDocument();
		}
	}

	private void errorWritingFileUserFeedback(int status) {
		if (status == -1 | status == 2) {
			JOptionPane.showConfirmDialog(this, //
					"Error writing file.", "File not saved", //
					JOptionPane.PLAIN_MESSAGE);
		} else {
			newBlankDocument();
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

	void editUndoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			undoManager.undo();
			updateUndoMenuItems();
		} catch (CannotUndoException cue) {
			askToSave = undoManager.canUndo();
			TitleDisplayMode.valueOf(this).setWindowTitleDisplay(windowTitleDisplayMode);
			System.err.println("CannotUndo ex: " + cue);
		}
	}

	void editRedoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			undoManager.redo();
			updateUndoMenuItems();
		} catch (CannotRedoException cre) {
			System.err.println(cre);
		}
	}

	void editSelectAllMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		bigEdit.selectAll();
	}

	void aboutAuthorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		AboutDialog.display(this);
	}

	void findDFindNextActionPerformed(java.awt.event.ActionEvent evt) {
		if (findDSearchCombo.getSelectedItem() != null) {
			findDSearchCombo.insertItemAt(findDSearchCombo.getSelectedItem(), 0);
			findNextString(findDSearchCombo);
		}
	}

	void findDFindPrevActionPerformed(java.awt.event.ActionEvent evt) {

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

	void fileSaveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		SaveFile.valueOf(this).fileSaveAs();
	}

	void fileSaveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		String fileStatus = "empty";
		if (!fileIsReadOnly & !bigEdit.getText().equals("")) {
			SaveFile.valueOf(this).saveCurrentFile();
			if (fileIsReadOnly) {
				fileStatus = "read only";
			}
		} else {
			fileCannotBeSavedUserFeedback(fileStatus);
		}
	}

	private void fileCannotBeSavedUserFeedback(String fileStatus) {
		int select = JOptionPane.showConfirmDialog(this,
				"This file is " + fileStatus + "!\nSave with a different name?", //
				"File not saved", JOptionPane.YES_NO_OPTION);
		if (select == JOptionPane.YES_OPTION) {
			SaveFile.valueOf(this).fileSaveAs();
		}
	}

	void fileOpenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		OpenFile.valueOf(this).fileOpenNew();
	}

	void newFileIconMouseClicked(java.awt.event.MouseEvent evt) {
		OpenFile.valueOf(this).fileOpenNew();
	}

	void openFileIconMouseClicked(java.awt.event.MouseEvent evt) {
		OpenFile.valueOf(this).fileOpenNew();
	}

	void saveFileIconMouseClicked(java.awt.event.MouseEvent evt) {
		SaveFile.valueOf(this).saveCurrentFile();
	}

	void findStringIconMouseClicked(java.awt.event.MouseEvent evt) {
		findDialog.setVisible(true);
	}

	void settSaveNowMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		int temp = SaveCurrentSettings.valueOf(this).saveSettings();
		if (temp == 0) {
			JOptionPane.showConfirmDialog(this, //
					"Settings were saved successfully", "BIGNotepad settings", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showConfirmDialog(this, //
					"Settings were NOT saved", "BIGNotepad settings", JOptionPane.PLAIN_MESSAGE);
		}
	}

	void viewResetZoomMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		zoomFactor = 100;
	}

	void viewDefaultFontActionPerformed(java.awt.event.ActionEvent evt) {
		JFontChooser jfc = new JFontChooser();
		jfc.createDialog(this).setVisible(true);
		bigEdit.setFont(jfc.getSelectedFont());
	}

	void viewWrapMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		wordWrap = viewWrapMenuItem.isSelected();
		WrapText wrapper = new WrapText(wordWrap);
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
			alwaysOnTop = true;
			this.setAlwaysOnTop(true);
		} else {
			alwaysOnTop = false;
			this.setAlwaysOnTop(false);
		}
	}

	void setMinToTrayMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		if (setMinToTrayMenuItem.isSelected()) {
			MinimizeToSystemTray.valueOf(this).sysTrayMenu();
			minimizeToTray = true;
		} else {
			minimizeToTray = false;
		}
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

	void fileNewEmptyWindowActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO catalin.podariu (research creating new process)
	}

	void settingsWinSizePositionActionPerformed(java.awt.event.ActionEvent evt) {
		rememeberMainWindowSize = settingsMainWindowSizePosition.isSelected();
	}

	void settingsResetAllActionPerformed(java.awt.event.ActionEvent evt) {
		ConfigOLD config = new ConfigOLD(defaultTempFolder);
		int status = config.failSafe();
		if (status == 0) {
			JOptionPane.showConfirmDialog(this, "Settings set to default.", "BIGNotepad settings",
					JOptionPane.PLAIN_MESSAGE);
		}
	}

	void viewStatusBarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		if (viewStatusBarMenuItem.isSelected()) {
			mainStatusPanel.setVisible(true);
			displayStatusBar = true;
		} else {
			mainStatusPanel.setVisible(false);
			displayStatusBar = false;
		}
	}

	void viewQuickMMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		if (viewQuickMMenuItem.isSelected()) {
			quickIconsPanel.setVisible(true);
			displayQuickMenu = true;
		} else {
			quickIconsPanel.setVisible(false);
			displayQuickMenu = false;
		}
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

	void bigEditMouseClicked(java.awt.event.MouseEvent evt) {
		if (evt.getButton() == MouseEvent.BUTTON3) {
			QuickMenu.display(this);
		} else if (evt.getButton() == MouseEvent.BUTTON1) {
			multipleMouseClicksAction(evt);
		}
	}

	private void multipleMouseClicksAction(java.awt.event.MouseEvent evt) {
		if (evt.getClickCount() == 3) {
			int caretPosition = bigEdit.getCaretPosition();
			int documentLength = document.getLength();
			String lineSeparator = System.getProperty("line.separator");
			threeMouseClicksSelectWholeTextLine(caretPosition, documentLength, lineSeparator);
		} else if (evt.getClickCount() == 4) {
			bigEdit.selectAll();
		}
	}

	private void threeMouseClicksSelectWholeTextLine(int caretPosition, //
			int documentLength, String lineSeperator) {
		for (int i = caretPosition; i > 0; i--) {
			try {
				if (bigEdit.getText().substring(i, i + 1).equals(lineSeperator)) {
					bigEdit.setCaretPosition(i);
					break;
				}
			} catch (StringIndexOutOfBoundsException ex) {
				System.err.println(ex);
			}
		}
		for (int i = caretPosition; i < documentLength; i++) {
			if (bigEdit.getText().substring(i, i + 1).equals(lineSeperator)) {
				bigEdit.moveCaretPosition(i);
				break;
			}
		}
	}

	void bigEditMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
		ScrollBar scr = new ScrollBar(evt);
		JScrollBar verticalScroll = editorScrollPane.getVerticalScrollBar();
		JScrollBar horizontalScroll = editorScrollPane.getHorizontalScrollBar();
		if (InputEvent.CTRL_DOWN_MASK != 0 & InputEvent.SHIFT_DOWN_MASK != 0) {
			verticalScroll.setValue(scr.adjustScrollBar(verticalScroll));
		}
		if (!wordWrap & (evt.getModifiersEx() != 0 & InputEvent.SHIFT_DOWN_MASK != 0)) {
			horizontalScroll.setValue(scr.adjustScrollBar(horizontalScroll));
		}
		adjustTextZoom(evt);
	}

	private void adjustTextZoom(java.awt.event.MouseWheelEvent evt) {
		if (evt.getModifiersEx() != 0 & InputEvent.CTRL_DOWN_MASK != 0) {
			if (evt.getWheelRotation() < 0) {
				Zoom zoom = new Zoom(this, 1);
				zoom.repaint();
				System.out.println("makes text bigger");
			} else if (evt.getWheelRotation() > 0) {
				Zoom zoom = new Zoom(this, 0);
				zoom.repaint();
				System.out.println("makes text smaller");
			}
		}
	}

	void replaceDialogComponentShown(java.awt.event.ComponentEvent evt) {
		findDialog.dispose();
		replaceDialog.setLocationRelativeTo(this);
		String noStringSelected = "";
		addSelectedStringAsFindItem(replaceDSearchCombo, noStringSelected);
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

	void filePrintMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			bigEdit.print();
		} catch (PrinterException ex) {
			System.err.println(ex);
		}
	}

	void fileSetReadOnlyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		if (currentlyOpenedFile != null) {
			if (fileSetReadOnlyMenuItem.isSelected()) {
				currentlyOpenedFile.setWritable(false);
				fileIsReadOnly = true;
			} else {
				currentlyOpenedFile.setWritable(true);
				fileIsReadOnly = false;
			}
		}
	}

	void winTitleDisplayMode2ActionPerformed(java.awt.event.ActionEvent evt) {
		TitleDisplayMode.valueOf(this) //
				.setWindowTitleDisplay(windowTitleDisplayMode = FULL_PATH);
	}

	void winTitleDisplayMode1ActionPerformed(java.awt.event.ActionEvent evt) {
		TitleDisplayMode.valueOf(this) //
				.setWindowTitleDisplay(windowTitleDisplayMode = FILE_NAME_AND_PARENT_FOLDER);
	}

	void winTitleDisplayMode0ActionPerformed(java.awt.event.ActionEvent evt) {
		TitleDisplayMode.valueOf(this) //
				.setWindowTitleDisplay(windowTitleDisplayMode = FILE_NAME);
	}

	void displayLineNumMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		lineNumbers = new LineNumbers(editorScrollPane, bigEdit);

		if (displayLineNumMenuItem.isSelected()) {
			displayLineNumbers = true;
			editorScrollPane.setRowHeaderView(lineNumbers);
		} else {
			displayLineNumbers = false;
			editorScrollPane.setRowHeaderView(null);
		}
	}

	void viewLongLineMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		displayLongLineMarker = viewLongLineMenuItem.isSelected();

	}

	void settRecentFilesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		rememberRecentFiles = settRecentFilesMenuItem.isSelected();
	}

	void settSaveOnExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		saveSettingsOnExit = settSaveOnExitMenuItem.isSelected();
	}

	void settRecentSearchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		rememberRecentSearches = settRecentSearchMenuItem.isSelected();
	}

	void formWindowClosing(java.awt.event.WindowEvent evt) {
		exit(0);
	}

	void bigEditCaretUpdate(javax.swing.event.CaretEvent evt) {

		//

		//

	}

	void helpTopicsActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO catalin.podariu move to object
		Icon msgIcon = IconHandler.getIcon().getIcon("/Resources/images/notepad.png");
		if (msgIcon != null) {
			JOptionPane.showMessageDialog(this,
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

	void replaceDReplaceActionPerformed(java.awt.event.ActionEvent evt) {
		selectReplacedStringUserFeedback();
		findNextString(replaceDSearchCombo);
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(BIGNotepad.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		java.awt.EventQueue.invokeLater(() -> {
			BIGNotepad.getInstance().setVisible(true);
		});

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

	public void exit(int mode) {
		switch (mode) {
		case FILE_NOT_SAVED:
			exitProcedureWithSaveCheck();
			break;
		case FILE_SAVED:
			if (saveSettingsOnExit) {
				SaveCurrentSettings.valueOf(this).saveSettings();
			} else {
				System.exit(0);
			}
		}
	}

	private void exitProcedureWithSaveCheck() {
		if (askToSave) {
			exitProcedureSaveChangesFirst();
		} else if (saveSettingsOnExit) {
			SaveCurrentSettings.valueOf(this).saveSettings();
			System.exit(0);
		} else {
			System.exit(0);
		}
	}

	private void exitProcedureSaveChangesFirst() {
		int status = SaveFile.valueOf(this).saveConfirmation();
		/**
		 * Save Confirmation Window returns: <br>
		 * -1 means saveConfirmation window was closed <br>
		 * 0 means file was saved 1 means file was <b>not</b> saved <br>
		 * 2 means cancel was selected
		 */
		if (status != -1 & status != 2) {
			System.exit(0);
		}
	}

	protected void newBlankDocument() {
		bigEdit.setText("");
		this.setTitle(defaultTitle);
		askToSave = false;
		undoManager.discardAllEdits();
		currentlyOpenedFile = null;
		fileSetReadOnlyMenuItem.setSelected(false);
		fileIsReadOnly = false;
	}

	protected String[] getRecentFileItems() {
		String[] items = new String[recentFilesItems.length];
		for (int i = recentFilesItems.length - 1; i >= 0; i--) {
			items[i] = recentFilesItems[i];
		}
		return items;
	}

	protected String[] getComboSearches(javax.swing.JComboBox comboBoxName) { // REVERSE!
		String[] stringValues = new String[comboBoxName.getItemCount()];
		for (int i = 0; i < comboBoxName.getItemCount(); i++) {
			if (stringValues[i] != null) {
				stringValues[i] = comboBoxName.getItemAt(i).toString();
			}
		}
		return stringValues;
	}

	public void settEncoding(String encodeTo) {
		try {
			System.setProperty("file.encoding", encodeTo);
			Field charset = Charset.class.getDeclaredField("defaultCharset");
			charset.setAccessible(true);
			charset.set(null, null);
			encodingStatusLabel.setText(encodeTo);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
			System.err.println("Set encoding error: " + ex);
		}
	}

	protected void updateUndoMenuItems() {

		editUndoMenuItem.setEnabled(undoManager.canUndo());
		editRedoMenuItem.setEnabled(undoManager.canRedo());

		// quickUndo.setEnabled(undoManager.canUndo());
		// quickRedo.setEnabled(undoManager.canRedo());
	}

	public void editMenuAccess(boolean state) {
		editConvertMenu.setEnabled(state);
		editCopyMenuItem.setEnabled(state);
		editCutMenuItem.setEnabled(state);
	}

	protected String convertStringCase(String mode) {
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
			document.remove(bigEdit.getSelectionStart(), bigEdit.getSelectedText().length());
			document.insertString(bigEdit.getSelectionStart(), convertedString, null);
		} catch (BadLocationException ex) {
			System.err.println(ex);
		}
	}

	void initConfig() {
		DefaultConfig def = new DefaultConfig(this, document);
		def.loadDefaultSettings();
	}

	public boolean fileIsReadOnly;

	public boolean askToSave = false;
	public boolean firstTimeOpen;

	public String defaultTitle;
	public File currentlyOpenedFile;
	public String currentPath;
	public String defaultTempFolder;

	public String[] recentFilesItems;
	public String[] findHistoryItems;
	public String[] replaceHistoryItems;

	public int windowTitleDisplayMode;
	public int zoomFactor = 100;

	public boolean alwaysOnTop;
	public boolean minimizeToTray;
	public boolean rememeberMainWindowSize;
	public boolean rememberRecentFiles;
	public boolean rememberRecentSearches;
	public boolean saveSettingsOnExit;
	public boolean wordWrap;
	public boolean displayLongLineMarker;
	public boolean displayStatusBar;
	public boolean displayQuickMenu;

	public boolean displayLineNumbers;
	public LineNumbers lineNumbers;

	public UndoManager undoManager;
	public StyledDocument document;
	public SimpleAttributeSet attrs;

	public TrayIcon trayIcon;
	public SystemTray sysTray;
	public String bigIcon;

	public String defaultEncoding = "UTF-16"; // default for java Strings
	public String defaultSyntaxScheme = "Plain text";

	javax.swing.JMenuItem aboutAuthorMenuItem;

	public javax.swing.JTextPane bigEdit;

	public javax.swing.JCheckBoxMenuItem displayLineNumMenuItem;

	javax.swing.JMenuItem editClearClipboardMenuItem;
	javax.swing.JMenuItem editConvInvertCase;
	javax.swing.JMenuItem editConvToLowerCase;
	javax.swing.JMenuItem editConvToUpperCase;
	javax.swing.JMenu editConvertMenu;
	javax.swing.JMenuItem editCopyMenuItem;
	javax.swing.JMenuItem editCutMenuItem;
	javax.swing.JMenu editInsertMenu;
	javax.swing.JMenu editMenu;
	javax.swing.JMenuItem editPasteMenuItem;
	public javax.swing.JMenuItem editRedoMenuItem;
	javax.swing.JMenuItem editSelectAllMenuItem;
	public javax.swing.JMenuItem editUndoMenuItem;
	public javax.swing.JScrollPane editorScrollPane;
	public javax.swing.JLabel encodingStatusLabel;
	public javax.swing.JPanel encodingStatusPanel;
	javax.swing.JMenuItem fileEncodingANSI;
	javax.swing.JMenuItem fileEncodingBE;
	javax.swing.JMenuItem fileEncodingLatin1;
	javax.swing.JMenuItem fileEncodingUTF8;
	javax.swing.JMenuItem fileEncodingUnicode;
	javax.swing.JMenuItem fileExitMenuItem;
	javax.swing.JMenu fileMenu;
	javax.swing.JMenuItem fileNewEmptyWindow;
	javax.swing.JMenuItem fileNewMenuItem;
	javax.swing.JMenuItem fileOpenMenuItem;
	javax.swing.JMenuItem filePrintMenuItem;
	public javax.swing.JMenu fileRecentMenu;
	javax.swing.JMenuItem fileSaveAsMenuItem;
	javax.swing.JMenuItem fileSaveMenuItem;
	javax.swing.JPopupMenu.Separator fileSeparator1;
	javax.swing.JPopupMenu.Separator fileSeparator2;
	javax.swing.JPopupMenu.Separator fileSeparator3;
	javax.swing.JPopupMenu.Separator fileSeparator4;
	javax.swing.JPopupMenu.Separator fileSeparator5;
	javax.swing.JPopupMenu.Separator fileSeparator6;
	javax.swing.JCheckBoxMenuItem fileSetReadOnlyMenuItem;
	javax.swing.JButton findDClose;
	javax.swing.JButton findDFindNext;
	javax.swing.JButton findDFindPrev;
	public javax.swing.JCheckBox findDMatchCase;
	public javax.swing.JCheckBox findDMatchWord;
	public javax.swing.JCheckBox findDMatchWordStart;
	public javax.swing.JCheckBox findDRegex;
	public javax.swing.JComboBox<Object> findDSearchCombo;
	javax.swing.JLabel findDSearchLabel;
	public javax.swing.JCheckBox findDSelectedText;
	javax.swing.JDialog findDialog;
	javax.swing.JLabel findGotoReplace;
	javax.swing.JMenuItem findMenuItem;
	protected javax.swing.JLabel findStringIcon;
	javax.swing.JMenu helpMenu;
	javax.swing.JMenuItem helpTopics;
	public javax.swing.JCheckBox highlightRSearchCombo;
	public javax.swing.JCheckBox highlightSearchCombo;
	public javax.swing.JCheckBox incrementalRSearchCombo;
	public javax.swing.JCheckBox incrementalSearchCombo;
	javax.swing.JMenuItem insertLongDate;
	javax.swing.JMenuItem insertShortDate;
	javax.swing.JMenu jMenu1;
	javax.swing.JMenu jMenu2;
	javax.swing.JMenuItem jMenuItem8;
	javax.swing.JPopupMenu.Separator jSeparator1;
	javax.swing.JPopupMenu.Separator jSeparator10;
	javax.swing.JPopupMenu.Separator jSeparator2;
	javax.swing.JPopupMenu.Separator jSeparator3;
	javax.swing.JPopupMenu.Separator jSeparator4;
	javax.swing.JPopupMenu.Separator jSeparator5;
	javax.swing.JPopupMenu.Separator jSeparator6;
	protected javax.swing.JLabel lineColSelStatusLabel;
	protected javax.swing.JPanel lineColSelStatusPanel;
	protected javax.swing.JMenuBar mainMenu;
	public javax.swing.JPanel mainStatusPanel;
	protected javax.swing.JLabel newFileIcon;
	protected javax.swing.JLabel openFileIcon;

	public javax.swing.JPanel quickIconsPanel;

	javax.swing.JButton replaceDClose;
	javax.swing.JButton replaceDFindNext;
	javax.swing.JButton replaceDFindPrev;
	public javax.swing.JCheckBox replaceDMatchCase;
	public javax.swing.JCheckBox replaceDMatchWord;
	public javax.swing.JCheckBox replaceDMatchWordStart;
	public javax.swing.JCheckBox replaceDRegex;
	javax.swing.JButton replaceDReplace;
	javax.swing.JButton replaceDReplaceAll;
	public javax.swing.JComboBox<String> replaceDReplaceCombo;
	javax.swing.JLabel replaceDReplaceLabel;
	public javax.swing.JComboBox<Object> replaceDSearchCombo;
	javax.swing.JLabel replaceDSearchLabel;
	public javax.swing.JCheckBox replaceDSelectedText;
	javax.swing.JDialog replaceDialog;
	javax.swing.JLabel replaceGotoFind;
	javax.swing.JMenuItem replaceMenuItem;
	protected javax.swing.JLabel saveFileIcon;
	protected javax.swing.JLabel separatorLabel;
	protected javax.swing.JLabel separatorLabel1;
	protected javax.swing.JLabel separatorLabel2;
	protected javax.swing.JLabel separatorLabel3;
	public javax.swing.JCheckBoxMenuItem setMinToTrayMenuItem;
	public javax.swing.JCheckBoxMenuItem settAlwaysOnTopMenuItem;
	public javax.swing.JCheckBoxMenuItem settRecentFilesMenuItem;
	public javax.swing.JCheckBoxMenuItem settRecentSearchMenuItem;
	public javax.swing.JMenuItem settSaveNowMenuItem;
	public javax.swing.JCheckBoxMenuItem settSaveOnExitMenuItem;
	javax.swing.JMenu settingsMenu;
	public javax.swing.JMenuItem settingsResetAll;
	public javax.swing.JCheckBoxMenuItem settingsMainWindowSizePosition;
	public javax.swing.JMenuItem viewDefaultFont;
	public javax.swing.JCheckBoxMenuItem viewLongLineMenuItem;
	javax.swing.JMenu viewMenu;
	public javax.swing.JCheckBoxMenuItem viewQuickMMenuItem;
	public javax.swing.JMenuItem viewResetZoomMenuItem;
	public javax.swing.JCheckBoxMenuItem viewStatusBarMenuItem;
	public javax.swing.JMenuItem viewThemeMenuItem;
	public javax.swing.JCheckBoxMenuItem viewWrapMenuItem;
	javax.swing.JMenuItem winTitleDisplayMode0;
	javax.swing.JMenuItem winTitleDisplayMode1;
	javax.swing.JMenuItem winTitleDisplayMode2;
}
