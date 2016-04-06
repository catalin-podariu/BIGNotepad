package config;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;

import gui.BIGNotepad;
import gui.Task;
import io.RecentFiles;
import utilities.CompoundUndo;

/**
 *
 * @author catalin.podariu[at]gmail.com
 */
public class DefaultConfigOLD {

	private BIGNotepad notepad;

	public DefaultConfigOLD(BIGNotepad notepad) {
		this.notepad = notepad;
	}

	public void loadDefaultSettings() {
		setDefaultNotepadParameters();

		Task task = new Task(notepad);
		task.execute();

		ConfigOLD config = new ConfigOLD(notepad.defaultTempFolder);
		Object[] windowSizeAndLocation = config.get("WindowSettings");

		notepad.setSize((int) windowSizeAndLocation[0], (int) windowSizeAndLocation[1]);
		notepad.setLocation((int) windowSizeAndLocation[2], (int) windowSizeAndLocation[3]);

		setInternalSettings();

		setRecentFilesInComboBoxes(config);

		notepad.setIconImage(IconHandler.getIcon().getImage("/Resources/images/notepad.png"));
	}

	private void setDefaultNotepadParameters() {
		notepad.undoManager = new CompoundUndo(notepad);
		notepad.document = notepad.bigEdit.getStyledDocument();
		notepad.attrs = new SimpleAttributeSet();
		notepad.recentFilesItems = new String[10];

		notepad.quickIconsPanel.setVisible(false);
		notepad.mainStatusPanel.setVisible(false);

		notepad.encodingStatusLabel.setText(notepad.defaultEncoding);

		notepad.fileIsReadOnly = false;
		notepad.documentIsModified = false;
		notepad.firstTimeOpen = true;
		notepad.currentlyOpenedFile = null;
		notepad.defaultTitle = "Untitled document  |  BIGNotepad";
		notepad.currentPath = System.getProperty("user.home") + "\\Desktop";
	}

	/**
	 * Set internal settings. It also sets JCheckBoxMenuItem selected.
	 * 
	 * @param config
	 */
	private void setInternalSettings() {
		ConfigInternalSettings cfgIntSettings = new ConfigInternalSettings(notepad);

		notepad.isAlwaysOnTop = cfgIntSettings.isAlwaysOnTop();
		notepad.isMinimizedToTray = cfgIntSettings.isMinimizedToTray();
		notepad.rememeberMainWindowSize = cfgIntSettings.rememeberMainWindowSize();
		notepad.rememberRecentFiles = cfgIntSettings.rememberRecentFiles();
		notepad.rememberRecentSearches = cfgIntSettings.rememberRecentSearches();
		notepad.saveSettingsOnExit = cfgIntSettings.saveSettingsOnExit();
		notepad.wordWrap = cfgIntSettings.isWordWrapActive();
		notepad.displayLongLineMarker = cfgIntSettings.displaysLongLineMarker();
		notepad.displayStatusBar = cfgIntSettings.isStatusBarActive();
		notepad.displayQuickMenu = cfgIntSettings.isQuickMenuActive();
		notepad.lineNumbersActive = cfgIntSettings.isLineNumbersActive();
	}

	private void setRecentFilesInComboBoxes(ConfigOLD config) {
		RecentFiles.valueOf(notepad).addRecentFileItems(config.get("RecentFiles"));
		populateComboBox(notepad.findDSearchCombo, config.get("RecentFind"));
		populateComboBox(notepad.replaceDSearchCombo, config.get("RecentFind"));
		populateComboBox(notepad.replaceDReplaceCombo, config.get("RecentReplace"));
	}

	protected void populateComboBox(javax.swing.JComboBox comboName, Object[] comboValues) {
		if (comboValues != null) {
			for (Object valueItem : comboValues) {
				if (valueItem != null) {
					if (!valueItem.toString().isEmpty()) {
						comboName.addItem((String) valueItem);
					}
				}
			}
		}
	}
}
