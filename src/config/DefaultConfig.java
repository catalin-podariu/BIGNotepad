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
public class DefaultConfig {

	public DefaultConfig(BIGNotepad notepad, StyledDocument document) {
		this.notepad = notepad;
		this.document = document;
	}

	public void loadDefaultSettings() {
		setDefaultNotepadParameters();

		Task task = new Task(notepad);
		task.execute();

		ConfigOLD config = new ConfigOLD(notepad.defaultTempFolder);
		Object[] windowSizeAndLocation = config.get("WindowSettings");

		notepad.setSize((int) windowSizeAndLocation[0], (int) windowSizeAndLocation[1]);
		notepad.setLocation((int) windowSizeAndLocation[2], (int) windowSizeAndLocation[3]);

		setInternalSettings(config);

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
		notepad.askToSave = false;
		notepad.firstTimeOpen = true;
		notepad.currentlyOpenedFile = null;
		notepad.defaultTitle = "Untitled document  |  BIGNotepad";
		notepad.currentPath = System.getProperty("user.home") + "\\Desktop";
	}

	private void setInternalSettings(ConfigOLD config) {
		Object[] intSett = config.get("InternalSettings");
		notepad.alwaysOnTop = Boolean.valueOf(intSett[0].toString());
		notepad.settAlwaysOnTopMenuItem.setSelected(notepad.alwaysOnTop);

		notepad.minimizeToTray = Boolean.valueOf(intSett[1].toString());
		notepad.setMinToTrayMenuItem.setSelected(notepad.minimizeToTray);

		notepad.rememeberMainWindowSize = Boolean.valueOf(intSett[2].toString());
		notepad.settingsMainWindowSizePosition.setSelected(notepad.rememeberMainWindowSize);

		notepad.rememberRecentFiles = Boolean.valueOf(intSett[3].toString());
		notepad.settRecentFilesMenuItem.setSelected(notepad.rememberRecentFiles);

		notepad.rememberRecentSearches = Boolean.valueOf(intSett[4].toString());
		notepad.settRecentSearchMenuItem.setSelected(notepad.rememberRecentSearches);

		notepad.saveSettingsOnExit = Boolean.valueOf(intSett[5].toString());
		notepad.settSaveOnExitMenuItem.setSelected(notepad.saveSettingsOnExit);

		notepad.wordWrap = Boolean.valueOf(intSett[6].toString());
		notepad.viewWrapMenuItem.setSelected(notepad.wordWrap);

		notepad.displayLongLineMarker = Boolean.valueOf(intSett[7].toString());
		notepad.viewLongLineMenuItem.setSelected(notepad.displayLongLineMarker);

		notepad.displayStatusBar = Boolean.valueOf(intSett[8].toString());
		notepad.viewStatusBarMenuItem.setSelected(notepad.displayStatusBar);

		notepad.displayQuickMenu = Boolean.valueOf(intSett[9].toString());
		notepad.viewQuickMMenuItem.setSelected(notepad.displayQuickMenu);

		notepad.displayLineNumbers = Boolean.valueOf(intSett[10].toString());
		if (notepad.displayLineNumbers) {
			notepad.editorScrollPane.setRowHeaderView(notepad.lineNumbers);
		} else {
			notepad.editorScrollPane.setRowHeaderView(null);
		}
		notepad.displayLineNumMenuItem.setSelected(notepad.displayLineNumbers);
	}

	private void setRecentFilesInComboBoxes(ConfigOLD config) {
		RecentFiles.valueOf(notepad).addRecentFileItems(config.get("RecentFiles"));

		populateComboBox(notepad.findDSearchCombo, config.get("RecentFind"));

		populateComboBox(notepad.replaceDSearchCombo, config.get("RecentFind"));

		populateComboBox(notepad.replaceDReplaceCombo, config.get("RecentReplace"));
	}

	protected void populateComboBox(javax.swing.JComboBox comboName, Object[] values) {
		if (values != null) {
			for (Object item : values) {
				// check to see if item not empty
				if (item != null) {
					if (!item.toString().isEmpty()) {
						comboName.addItem((String) item);
					}
				}
			}
		}
	}

	private BIGNotepad notepad;
	private StyledDocument document;

}
