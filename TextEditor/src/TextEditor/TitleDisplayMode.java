/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

/**
 *
 * @author mrbigheart
 */
public class TitleDisplayMode {

    private BIGNotepad pad;

    private TitleDisplayMode(BIGNotepad pad) {
        this.pad = pad;
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
    protected void setWindowTitleDisplay(int mode) {
        if (pad.currentlyOpenedFile != null) {
            // default is 0 - just the file name
            if (mode == 0) {
                if (pad.askToSave) {
                    // star to notify file has changed
                    pad.setTitle(pad.currentlyOpenedFile.getName()
                            + "  |  BIGNotepad" + "*");
                } else {
                    pad.setTitle(pad.currentlyOpenedFile.getName()
                            + "  |  BIGNotepad");
                }
            } else if (mode == 1) {
                String path = pad.currentlyOpenedFile.getAbsolutePath();
                String fileName = path.substring(0, path.lastIndexOf('\\') - 1);
                String directoryName = path.substring(fileName.lastIndexOf('\\')
                        + 1, path.length());
                if (pad.askToSave) {
                    // star to notify file has changed
                    pad.setTitle(directoryName + "  |  BIGNotepad" + "*");
                } else {
                    pad.setTitle(directoryName + "  |  BIGNotepad");
                }
            } else if (mode == 2) {
                String fullPath = pad.currentlyOpenedFile.getAbsolutePath();
                // trim paths that are longer than 50 characters
                if (fullPath.length() > 50) {
                    fullPath = fullPath.substring(0, 50) + " .... "
                            + fullPath.substring(fullPath.lastIndexOf('\\') - 1,
                                    fullPath.length());
                }
                if (pad.askToSave) {
                    // star to notify file has changed
                    pad.setTitle(fullPath + "  |  BIGNotepad" + "*");
                } else {
                    pad.setTitle(fullPath + "  |  BIGNotepad");
                }
            }
        } else {
            if (pad.askToSave) {
                // star to notify file has changed
                pad.setTitle(pad.defaultTitle + "*");
            } else {
                pad.setTitle(pad.defaultTitle);
            }
        }
    }
}
