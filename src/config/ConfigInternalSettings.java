package config;

public class ConfigInternalSettings {

	protected boolean isAlwaysOnTop() {
		return isAlwaysOnTop;
	}
	protected void setAlwaysOnTop(boolean isAlwaysOnTop) {
		this.isAlwaysOnTop = isAlwaysOnTop;
	}
	
	protected boolean isMinimizedToTray() {
		return isMinimizedToTray;
	}
	protected void setMinimizedToTray(boolean isMinimizedToTray) {
		this.isMinimizedToTray = isMinimizedToTray;
	}
	
	protected boolean isRememebersWinSize() {
		return rememebersWinSize;
	}
	protected void setRememebersWinSize(boolean rememebersWinSize) {
		this.rememebersWinSize = rememebersWinSize;
	}
	
	protected boolean isRemembersRecentFiles() {
		return remembersRecentFiles;
	}
	protected void setRemembersRecentFiles(boolean remembersRecentFiles) {
		this.remembersRecentFiles = remembersRecentFiles;
	}
	
	protected boolean isRemembersRecentSearches() {
		return remembersRecentSearches;
	}
	protected void setRemembersRecentSearches(boolean remembersRecentSearches) {
		this.remembersRecentSearches = remembersRecentSearches;
	}
	
	protected boolean isSaveSettingsOnExit() {
		return saveSettingsOnExit;
	}
	protected void setSaveSettingsOnExit(boolean saveSettingsOnExit) {
		this.saveSettingsOnExit = saveSettingsOnExit;
	}
	
	protected boolean isWordWrapActive() {
		return wordWrapActive;
	}
	protected void setWordWrapActive(boolean wordWrapActive) {
		this.wordWrapActive = wordWrapActive;
	}
	
	protected boolean isDisplaysLongLineMarker() {
		return displaysLongLineMarker;
	}
	protected void setDisplaysLongLineMarker(boolean displaysLongLineMarker) {
		this.displaysLongLineMarker = displaysLongLineMarker;
	}
	
	protected boolean isDisplaysStatusBar() {
		return displaysStatusBar;
	}
	protected void setDisplaysStatusBar(boolean displaysStatusBar) {
		this.displaysStatusBar = displaysStatusBar;
	}
	
	protected boolean isDisplaysQuickMenu() {
		return displaysQuickMenu;
	}
	protected void setDisplaysQuickMenu(boolean displaysQuickMenu) {
		this.displaysQuickMenu = displaysQuickMenu;
	}
	
	protected boolean isDisplaysLineNumbers() {
		return displaysLineNumbers;
	}
	protected void setDisplaysLineNumbers(boolean displaysLineNumbers) {
		this.displaysLineNumbers = displaysLineNumbers;
	}

	private boolean isAlwaysOnTop;
	private boolean isMinimizedToTray;
	private boolean rememebersWinSize;
	private boolean remembersRecentFiles;
	private boolean remembersRecentSearches;
	private boolean saveSettingsOnExit;
	private boolean wordWrapActive;
	private boolean displaysLongLineMarker;
	private boolean displaysStatusBar;
	private boolean displaysQuickMenu;
	private boolean displaysLineNumbers;
}
