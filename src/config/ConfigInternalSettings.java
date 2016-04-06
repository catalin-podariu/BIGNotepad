package config;

/**
 * 
 * @author catalin.podariu[at]gmail.com
 */
import gui.BIGNotepad;

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
		notepad.settAlwaysOnTopMenuItem.setSelected(isAlwaysOnTop);
		return isAlwaysOnTop;
	}

	protected void setAlwaysOnTop(boolean isAlwaysOnTop) {
		this.isAlwaysOnTop = isAlwaysOnTop;
	}

	protected boolean isMinimizedToTray() {
		notepad.setMinToTrayMenuItem.setSelected(isMinimizedToTray);
		return isMinimizedToTray;
	}

	protected void setMinimizedToTray(boolean isMinimizedToTray) {
		this.isMinimizedToTray = isMinimizedToTray;
	}

	protected boolean rememeberMainWindowSize() {
		notepad.settingsMainWindowSizePosition.setSelected(rememeberMainWindowSize);
		return rememeberMainWindowSize;
	}

	protected void setRememeberWinSize(boolean rememeberWinSize) {
		this.rememeberMainWindowSize = rememeberWinSize;
	}

	protected boolean rememberRecentFiles() {
		notepad.settRecentFilesMenuItem.setSelected(rememberRecentFiles);
		return rememberRecentFiles;
	}

	protected void setRememberRecentFiles(boolean rememberRecentFiles) {
		this.rememberRecentFiles = rememberRecentFiles;
	}

	protected boolean rememberRecentSearches() {
		notepad.settRecentSearchMenuItem.setSelected(rememberRecentSearches);
		return rememberRecentSearches;
	}

	protected void setRememberRecentSearches(boolean rememberRecentSearches) {
		this.rememberRecentSearches = rememberRecentSearches;
	}

	protected boolean saveSettingsOnExit() {
		notepad.settSaveOnExitMenuItem.setSelected(saveSettingsOnExit);
		return saveSettingsOnExit;
	}

	protected void setSaveSettingsOnExit(boolean saveSettingsOnExit) {
		this.saveSettingsOnExit = saveSettingsOnExit;
	}

	protected boolean isWordWrapActive() {
		notepad.viewWrapMenuItem.setSelected(wordWrapActive);
		return wordWrapActive;
	}

	protected void setWordWrapActive(boolean wordWrapActive) {
		this.wordWrapActive = wordWrapActive;
	}

	protected boolean displaysLongLineMarker() {
		notepad.viewLongLineMenuItem.setSelected(longLineMarkerActive);
		return longLineMarkerActive;
	}

	protected void setDisplaysLongLineMarker(boolean displaysLongLineMarker) {
		this.longLineMarkerActive = displaysLongLineMarker;
	}

	protected boolean isStatusBarActive() {
		notepad.viewStatusBarMenuItem.setSelected(notepad.displayStatusBar);
		return statusBarActive;
	}

	protected void setDisplaysStatusBar(boolean displaysStatusBar) {
		this.statusBarActive = displaysStatusBar;
	}

	protected boolean isQuickMenuActive() {
		notepad.viewQuickMMenuItem.setSelected(notepad.displayQuickMenu);
		return quickMenuActive;
	}

	protected void setDisplaysQuickMenu(boolean displaysQuickMenu) {
		this.quickMenuActive = displaysQuickMenu;
	}

	protected boolean isLineNumbersActive() {
		notepad.displayLineNumMenuItem.setSelected(lineNumbersActive);
		return lineNumbersActive;
	}

	protected void setDisplaysLineNumbers(boolean displaysLineNumbers) {
		this.lineNumbersActive = displaysLineNumbers;
	}
}
