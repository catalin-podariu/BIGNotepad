package config;

import gui.BIGNotepad;
import gui.MainMenu;

/**
 * 
 * @author catalin.podariu[at]gmail.com
 */
public class ConfigInternalSettings {

	private BIGNotepad notepad;

	private boolean isAlwaysOnTop;
	private boolean isMinimizedToTray;
	private boolean rememeberMainWindowSize, rememberRecentFiles, rememberRecentSearches;
	private boolean saveSettingsOnExit;
	private boolean wordWrapActive;
	private boolean longLineMarkerActive, statusBarActive, quickMenuActive, lineNumbersActive;

	public ConfigInternalSettings(BIGNotepad notepad) {
		this.notepad = notepad;
	}

	protected boolean isAlwaysOnTop() {
		notepad.mainMenu.settAlwaysOnTopMenuItem.setSelected(isAlwaysOnTop);
		return isAlwaysOnTop;
	}

	protected void setAlwaysOnTop(boolean isAlwaysOnTop) {
		this.isAlwaysOnTop = isAlwaysOnTop;
	}

	protected boolean isMinimizedToTray() {
		notepad.mainMenu.setMinToTrayMenuItem.setSelected(isMinimizedToTray);
		return isMinimizedToTray;
	}

	protected void setMinimizedToTray(boolean isMinimizedToTray) {
		this.isMinimizedToTray = isMinimizedToTray;
	}

	protected boolean rememeberMainWindowSize() {
		notepad.mainMenu.settingsMainWindowSizePosition.setSelected(rememeberMainWindowSize);
		return rememeberMainWindowSize;
	}

	protected void setRememeberWinSize(boolean rememeberWinSize) {
		this.rememeberMainWindowSize = rememeberWinSize;
	}

	protected boolean rememberRecentFiles() {
		notepad.mainMenu.settRecentFilesMenuItem.setSelected(rememberRecentFiles);
		return rememberRecentFiles;
	}

	protected void setRememberRecentFiles(boolean rememberRecentFiles) {
		this.rememberRecentFiles = rememberRecentFiles;
	}

	protected boolean rememberRecentSearches() {
		notepad.mainMenu.settRecentSearchMenuItem.setSelected(rememberRecentSearches);
		return rememberRecentSearches;
	}

	protected void setRememberRecentSearches(boolean rememberRecentSearches) {
		this.rememberRecentSearches = rememberRecentSearches;
	}

	protected boolean saveSettingsOnExit() {
		notepad.mainMenu.settSaveOnExitMenuItem.setSelected(saveSettingsOnExit);
		return saveSettingsOnExit;
	}

	protected void setSaveSettingsOnExit(boolean saveSettingsOnExit) {
		this.saveSettingsOnExit = saveSettingsOnExit;
	}

	protected boolean isWordWrapActive() {
		notepad.mainMenu.viewWrapMenuItem.setSelected(wordWrapActive);
		return wordWrapActive;
	}

	protected void setWordWrapActive(boolean wordWrapActive) {
		this.wordWrapActive = wordWrapActive;
	}

	protected boolean displaysLongLineMarker() {
		notepad.mainMenu.viewLongLineMenuItem.setSelected(longLineMarkerActive);
		return longLineMarkerActive;
	}

	protected void setDisplaysLongLineMarker(boolean displaysLongLineMarker) {
		this.longLineMarkerActive = displaysLongLineMarker;
	}

	protected boolean isStatusBarActive() {
		notepad.mainMenu.viewStatusBarMenuItem.setSelected(notepad.displayStatusBar);
		return statusBarActive;
	}

	protected void setDisplaysStatusBar(boolean displaysStatusBar) {
		this.statusBarActive = displaysStatusBar;
	}

	protected boolean isQuickMenuActive() {
		notepad.mainMenu.viewQuickMMenuItem.setSelected(notepad.displayQuickMenu);
		return quickMenuActive;
	}

	protected void setDisplaysQuickMenu(boolean displaysQuickMenu) {
		this.quickMenuActive = displaysQuickMenu;
	}

	protected boolean isLineNumbersActive() {
		notepad.mainMenu.displayLineNumMenuItem.setSelected(lineNumbersActive);
		return lineNumbersActive;
	}

	protected void setDisplaysLineNumbers(boolean displaysLineNumbers) {
		this.lineNumbersActive = displaysLineNumbers;
	}
}
