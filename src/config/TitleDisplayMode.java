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
public class TitleDisplayMode {

    private BIGNotepad notepad;

    private TitleDisplayMode(BIGNotepad notepad) {
        this.notepad = notepad;
    }

    public static TitleDisplayMode valueOf(BIGNotepad pad) {
        return new TitleDisplayMode(pad);
    }

    /**
     * Set Window Title Mode.
     * <br>
     * Choose how you want the file name to be displayed in the title.
     * <br>
     *
     * @param mode 0 = fileName (default); 1 = file name and parent directory;
     * <br> 2 = full path
     */
    public void setWindowTitleDisplay(int mode) {
        if (notepad.currentlyOpenedFile != null) {
            // default is 0 - just the file name
            if (mode == 0) {
                if (notepad.askToSave) {
                    // star to notify file has changed
                    notepad.setTitle(notepad.currentlyOpenedFile.getName()
                            + "  |  BIGNotepad" + "*");
                } else {
                    notepad.setTitle(notepad.currentlyOpenedFile.getName()
                            + "  |  BIGNotepad");
                }
            } else if (mode == 1) {
                String path = notepad.currentlyOpenedFile.getAbsolutePath();
                String fileName = path.substring(0, path.lastIndexOf('\\') - 1);
                String directoryName = path.substring(fileName.lastIndexOf('\\')
                        + 1, path.length());
                if (notepad.askToSave) {
                    // star to notify file has changed
                    notepad.setTitle(directoryName + "  |  BIGNotepad" + "*");
                } else {
                    notepad.setTitle(directoryName + "  |  BIGNotepad");
                }
            } else if (mode == 2) {
                String fullPath = notepad.currentlyOpenedFile.getAbsolutePath();
                // trim paths that are longer than 50 characters
                if (fullPath.length() > 50) {
                    fullPath = fullPath.substring(0, 50) + " .... "
                            + fullPath.substring(fullPath.lastIndexOf('\\') - 1,
                                    fullPath.length());
                }
                if (notepad.askToSave) {
                    // star to notify file has changed
                    notepad.setTitle(fullPath + "  |  BIGNotepad" + "*");
                } else {
                    notepad.setTitle(fullPath + "  |  BIGNotepad");
                }
            }
        } else {
            if (notepad.askToSave) {
                // star to notify file has changed
                notepad.setTitle(notepad.defaultTitle + "*");
            } else {
                notepad.setTitle(notepad.defaultTitle);
            }
        }
    }
}
