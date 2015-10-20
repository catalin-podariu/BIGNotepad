/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

import java.awt.Toolkit;
import javax.swing.text.SimpleAttributeSet;

/**
 *
 * @author mrbigheart
 */
public class DefaultConfig extends BIGNotepad {

    private BIGNotepad pad;
    
    public DefaultConfig(BIGNotepad pad){
        this.pad = pad;
        document = this.pad.bigEdit.getStyledDocument();
    }
    
    /**
     * Initial default configuration.
     * <br>
     * It starts right after every component has been created, it sets window
     * size and location (middle of the screen by default), always on top, etc.
     */
    public void defaultSettings() {

        // valueOf undo manager
        pad.undoManager = new CompoundUndo(pad);
        // initialize "document"
        pad.document = pad.bigEdit.getStyledDocument();
        pad.attrs = new SimpleAttributeSet();
        // remember just the 10 most recent files opened
        pad.recentFilesItems = new String[10];

        // status bar and quick menu are not shown by default
        pad.quickIconsPanel.setVisible(false);
        pad.mainStatusPanel.setVisible(false);

        // status bar Syntax Scheme and Encoding update
        pad.encodingStatusLabel.setText(pad.defaultEncoding);

        pad.fileIsReadOnly = false;
        pad.askToSave = false;
        pad.firstTimeOpen = true;
        pad.currentlyOpenedFile = null;
        pad.defaultTitle = "Untitled document  |  BIGNotepad";
        pad.currentPath = System.getProperty("user.home") + "\\Desktop";

        Task t = new Task(pad);
        t.execute();

        // load user defined settings or go to default if not found
        // it will also valueOf a fresh copy in current folder
        Config cfg = new Config();
        Object[] winSett = cfg.get("WindowSettings");
        pad.setSize((int) winSett[0], (int) winSett[1]);
        pad.setLocation((int) winSett[2], (int) winSett[3]);

        Object[] intSett = cfg.get("InternalSettings");
        pad.alwaysOnTop = Boolean.valueOf(intSett[0].toString());
        pad.settAlwaysOnTopMenuItem.setSelected(pad.alwaysOnTop);

        pad.minimizeToTray = Boolean.valueOf(intSett[1].toString());
        pad.setMinToTrayMenuItem.setSelected(pad.minimizeToTray);

        pad.rememeberWinSize = Boolean.valueOf(intSett[2].toString());
        pad.settingsWinSizePosition.setSelected(pad.rememeberWinSize);

        pad.rememberRecentFiles = Boolean.valueOf(intSett[3].toString());
        pad.settRecentFilesMenuItem.setSelected(pad.rememberRecentFiles);

        pad.rememberRecentSearches = Boolean.valueOf(intSett[4].toString());
        pad.settRecentSearchMenuItem.setSelected(pad.rememberRecentSearches);

        pad.saveSettingsOnExit = Boolean.valueOf(intSett[5].toString());
        pad.settSaveOnExitMenuItem.setSelected(pad.saveSettingsOnExit);

        pad.wordWrap = Boolean.valueOf(intSett[6].toString());
        pad.viewWrapMenuItem.setSelected(pad.wordWrap);

        pad.displayLongLineMarker = Boolean.valueOf(intSett[7].toString());
        pad.viewLongLineMenuItem.setSelected(pad.displayLongLineMarker);

        pad.displayStatusBar = Boolean.valueOf(intSett[8].toString());
        pad.viewStatusBarMenuItem.setSelected(pad.displayStatusBar);

        pad.displayQuickMenu = Boolean.valueOf(intSett[9].toString());
        pad.viewQuickMMenuItem.setSelected(pad.displayQuickMenu);

        pad.displayLineNumbers = Boolean.valueOf(intSett[10].toString());
        if (pad.displayLineNumbers) {
            pad.editorScrollPane.setRowHeaderView(pad.lineNumbers);
        } else {
            pad.editorScrollPane.setRowHeaderView(null);
        }
        pad.displayLineNumMenuItem.setSelected(pad.displayLineNumbers);

        // add menu items on "Recent Files" menu
//        RecentFiles.valueOf().addRecentFileItems(cfg.get("RecentFiles"));
        RecentFiles.valueOf(pad).addRecentFileItems(cfg.get("RecentFiles"));

        // add items to Find drop-down list
        populateComboBox(pad.findDSearchCombo, cfg.get("RecentFind"));

        // add items to Replace drop-down "find" list
        populateComboBox(pad.replaceDSearchCombo, cfg.get("RecentFind"));
        // add items to Replace drop-down "replace" list
        populateComboBox(pad.replaceDReplaceCombo, cfg.get("RecentReplace"));

        // set icon
        pad.bigIcon = System.getProperty("user.dir")
                + "\\src\\Resources\\images\\notepad.png";

        pad.setIconImage(Toolkit.getDefaultToolkit().getImage(pad.bigIcon));
    }

    // ads items to find/replace recent searches
    protected void populateComboBox(javax.swing.JComboBox comboName, Object[] items) {
        for (Object i : items) {
            // check to see if item not empty
            if (i != null) {
                if (!((String) i).equals("")) {
                    comboName.addItem((String) i);
                }
            }
        }
    }
}
