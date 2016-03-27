package utilities;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import config.IconHandler;
import gui.BIGNotepad;

/**
 *
 * @author catalin.podariu[at]gmail.com
 */
public class MinimizeToSystemTray {

    private BIGNotepad notepad;
    
    private MinimizeToSystemTray(BIGNotepad notepad){
        this.notepad = notepad;
    }
    
    public static MinimizeToSystemTray valueOf(BIGNotepad pad){
        return new MinimizeToSystemTray(pad);
    }
    
    public void sysTrayMenu() {
        if (java.awt.SystemTray.isSupported()) {
            notepad.sysTray = java.awt.SystemTray.getSystemTray();
            Image notepadIcon = IconHandler.getIcon()
                    .getImage("/Resources/images/notepad.png");
            ActionListener exitListener = (ActionEvent evt) -> {
                // otherwise it will only show the fileChooser
                if (notepad.askToSave) {
                    notepad.setVisible(true);
                    notepad.setExtendedState(JFrame.NORMAL);
                }
                notepad.exit(0);
            };
            createSystemTrayMenu(notepadIcon, exitListener);
        } else {
            System.err.println("SysTray is not available");
        }
    }

	private void createSystemTrayMenu(Image notepadIcon, ActionListener exitListener) {
		PopupMenu sysTrayMenu = new PopupMenu();
		menuItem = new MenuItem("Exit?!");
		menuItem.addActionListener(exitListener);
		sysTrayMenu.add(menuItem);
		menuItem = new MenuItem("Show BIGNotepad");
		menuItem.addActionListener((ActionEvent e) -> {
		    notepad.setVisible(true);
		    notepad.setExtendedState(JFrame.NORMAL);
		});
		sysTrayMenu.add(menuItem);
		notepad.trayIcon = new TrayIcon(notepadIcon, "BIGNotepad", sysTrayMenu);
		// double-click to restore
		notepad.trayIcon.addActionListener((ActionEvent evt) -> {
		    notepad.setVisible(true);
		    notepad.setExtendedState(JFrame.NORMAL);
		});
		notepad.trayIcon.setImageAutoSize(true);
	}
	
	MenuItem menuItem;
}
