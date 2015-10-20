/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author mrbigheart
 */
public class MinimizeToSystemTray extends BIGNotepad {

    private BIGNotepad pad;
    
    private MinimizeToSystemTray(BIGNotepad pad){
        this.pad = pad;
    }
    
    public static MinimizeToSystemTray valueOf(BIGNotepad pad){
        return new MinimizeToSystemTray(pad);
    }
    
    /**
     * Minimize to system tray.
     * <br>
     * Pop-up menu, menu items and action listeners for System Tray icon.
     */
    public void sysTrayMenu() {
        if (java.awt.SystemTray.isSupported()) {
            pad.sysTray = java.awt.SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage(pad.bigIcon);
            ActionListener exitListener = (ActionEvent evt) -> {
                // otherwise it will only show the fileChooser
                if (pad.askToSave) {
                    pad.setVisible(true);
                    pad.setExtendedState(JFrame.NORMAL);
                }
                pad.exit(0);
            };
            PopupMenu trayMenu = new PopupMenu();
            MenuItem mItem = new MenuItem("Exit?!");
            mItem.addActionListener(exitListener);
            trayMenu.add(mItem);
            mItem = new MenuItem("Show BIGNotepad");
            mItem.addActionListener((ActionEvent e) -> {
                pad.setVisible(true);
                pad.setExtendedState(JFrame.NORMAL);
            });
            trayMenu.add(mItem);
            pad.trayIcon = new TrayIcon(image, "BIGNotepad", trayMenu);
            // double-click to restore
            pad.trayIcon.addActionListener((ActionEvent evt) -> {
                pad.setVisible(true);
                pad.setExtendedState(JFrame.NORMAL);
            });
            pad.trayIcon.setImageAutoSize(true);
        } else {
            System.err.println("SysTray is not available");
        }
    }
}
