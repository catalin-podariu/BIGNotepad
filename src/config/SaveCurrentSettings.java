/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import gui.BIGNotepad;

/**
 *
 * @author mrbigheart
 */
public class SaveCurrentSettings extends BIGNotepad {

    private BIGNotepad pad;

    public SaveCurrentSettings(BIGNotepad notepad) {
        this.pad = notepad;
    }

    public static SaveCurrentSettings valueOf(BIGNotepad pad) {
        return new SaveCurrentSettings(pad);
    }

    /**
     * Save Current Settings.
     * <br>
     * It saves currently selected settings (ie: window size and position,
     * recent files, etc).
     *
     * @return 1 - some or all of the settings were not saved.
     * <br>
     * 0 - all of the settings were saved.
     */
    public int saveSettings() {

        ConfigOLD cfg = new ConfigOLD(pad.defaultTempFolder);
        int winSettingsStatus = 0;
        int recentFilesStatus = 0;
        int findHistoryStatus = 0;
        int replaceHistoryStatus = 0;

        // collect and send to properties file the window settings
        if (pad.rememeberMainWindowSize) {
            String[] windowSettings = {
                "width", pad.getWidth() + "",
                "height", pad.getHeight() + "",
                "x", pad.getX() + "",
                "y", pad.getY() + ""
            };
            winSettingsStatus = cfg.set(windowSettings, "settings");
        }

        // collect and send to properties file all recent files history
        if (pad.rememberRecentFiles) {
            pad.recentFilesItems = getRecentFileItems();
            if (pad.recentFilesItems != null) {
                recentFilesStatus = cfg.set(pad.recentFilesItems,
                        "recentFiles");
            }
        }

        // collect and send to properties file all search history
        if (pad.rememberRecentSearches) {
            pad.findHistoryItems = getComboSearches(pad.findDSearchCombo);
            pad.replaceHistoryItems = getComboSearches(pad.replaceDReplaceCombo);
            if (pad.findHistoryItems != null | pad.replaceHistoryItems != null) {
                findHistoryStatus = cfg.set(pad.findHistoryItems, "recentFind");
                replaceHistoryStatus = cfg.set(pad.replaceHistoryItems,
                        "recentReplace");
            }
        }

        String[] internalSettings = {
            "windowTitleDisplayMode", pad.windowTitleDisplayMode + "",
            "zoomFactor", pad.zoomFactor + "",
            "alwaysOnTop", String.valueOf(pad.isAlwaysOnTop),
            "minimizeToTray", String.valueOf(pad.isMinimizedToTray),
            "rememeberWinSize", String.valueOf(pad.rememeberMainWindowSize),
            "rememberRecentFiles", String.valueOf(pad.rememberRecentFiles),
            "rememberRecentSearches", String.valueOf(pad.rememberRecentSearches),
            "saveSettingsOnExit", String.valueOf(pad.saveSettingsOnExit),
            "wordWrap", String.valueOf(pad.wordWrap),
            "displayLongLineMarker", String.valueOf(pad.displayLongLineMarker),
            "displayStatusBar", String.valueOf(pad.displayStatusBar),
            "displayQuickMenu", String.valueOf(pad.displayQuickMenu),
            "displayLineNumbers", String.valueOf(pad.lineNumbersActive)
        };

        int status2 = cfg.set(internalSettings, "settings");

        // findFeedback
        if (winSettingsStatus == 1 | status2 == 1 | recentFilesStatus == 1
                | findHistoryStatus == 1 | replaceHistoryStatus == 1) {
            // some or all of the settings were not saved.
            return 1;
        } else {
            // all of the settings were saved.
            return 0;
        }
    }
}
