package gui;

import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;
import javax.swing.undo.UndoManager;

import config.DefaultConfigOLD;
import config.SaveCurrentSettings;
import io.SaveFile;

/**
 * BIG Notepad start point.
 * 
 * @author catalin.podariu[at]gmail.com
 */
public class BIGNotepad extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	public static final int FILE_NAME = 0;
	public static final int FILE_NAME_AND_PARENT_FOLDER = 1;
	public static final int FULL_PATH = 2;

	private final static int FILE_NOT_SAVED = 0;
	private final static int FILE_SAVED = 1;

	public BIGNotepad() {
		defaultTempFolder = System.getProperty("user.dir") + "\\BigTextEditor\\";
	}

	public static BIGNotepad getInstance() {
		BIGNotepad notepad = new BIGNotepad();
		new GUIComponents(notepad).initComponents();
		notepad.initConfig();
		notepad.mainMenu = MainMenu.create(notepad);
		return notepad;
	}
	
	void initConfig() {
		DefaultConfigOLD def = new DefaultConfigOLD(this);
		def.loadDefaultSettings();
	}

	void formWindowOpened(java.awt.event.WindowEvent evt) {
		findDialog = FindDialog.create(this);
		replaceDialog = ReplaceDialog.create(this);
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

	void bigEditCaretUpdate(javax.swing.event.CaretEvent evt) {

		//

		//

	}

	protected void updateUndoMenuItems() {
		mainMenu.editUndoMenuItem.setEnabled(undoManager.canUndo());
		mainMenu.editRedoMenuItem.setEnabled(undoManager.canRedo());
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
		if (documentIsModified) {
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
		documentIsModified = false;
		undoManager.discardAllEdits();
		currentlyOpenedFile = null;
		// fileSetReadOnlyMenuItem.setSelected(false);
		// TODO catalin.podariu reference needs replacement
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

	public MainMenu mainMenu;
	public JDialog replaceDialog;
	public JDialog findDialog;

	public int currentSearchLocation;
	public boolean searchWrapAround;

	public boolean fileIsReadOnly;

	public boolean documentIsModified = false;
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

	public boolean isAlwaysOnTop;
	public boolean isMinimizedToTray;
	public boolean rememeberMainWindowSize;
	public boolean rememberRecentFiles;
	public boolean rememberRecentSearches;
	public boolean saveSettingsOnExit;
	public boolean wordWrap;
	public boolean displayLongLineMarker;
	public boolean displayStatusBar;
	public boolean displayQuickMenu;

	public boolean lineNumbersActive;
	public LineNumbers lineNumbers;

	public UndoManager undoManager;
	public StyledDocument document;
	public SimpleAttributeSet attrs;

	public TrayIcon trayIcon;
	public SystemTray sysTray;
	public String bigIcon;

	public String defaultEncoding = "UTF-16"; // default for java Strings
	public String defaultSyntaxScheme = "Plain text";

	public javax.swing.JTextPane bigEdit;

	public javax.swing.JLabel encodingStatusLabel;
	public javax.swing.JPanel encodingStatusPanel;
	public javax.swing.JScrollPane editorScrollPane;

	protected javax.swing.JLabel findStringIcon;

	public javax.swing.JCheckBox incrementalSearchCombo;

	protected javax.swing.JLabel lineColSelStatusLabel;
	protected javax.swing.JPanel lineColSelStatusPanel;

	public javax.swing.JPanel mainStatusPanel;
	protected javax.swing.JLabel newFileIcon;
	protected javax.swing.JLabel openFileIcon;

	public javax.swing.JPanel quickIconsPanel;

	protected javax.swing.JLabel saveFileIcon;
	protected javax.swing.JLabel separatorLabel;
	protected javax.swing.JLabel separatorLabel1;
	protected javax.swing.JLabel separatorLabel2;
	protected javax.swing.JLabel separatorLabel3;

}
