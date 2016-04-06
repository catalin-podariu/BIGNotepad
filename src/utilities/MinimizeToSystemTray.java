package utilities;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import config.IconHandler;
import gui.BIGNotepad;

/**
 *
 * @author catalin.podariu[at]gmail.com
 */
public class MinimizeToSystemTray {

	private BIGNotepad notepad;
	private PopupMenu sysTrayMenu;

	private MinimizeToSystemTray(BIGNotepad notepad) {
		this.notepad = notepad;
	}

	public static MinimizeToSystemTray valueOf(BIGNotepad pad) {
		return new MinimizeToSystemTray(pad);
	}

	public void sysTrayMenu() {
		if (java.awt.SystemTray.isSupported()) {
			notepad.sysTray = java.awt.SystemTray.getSystemTray();
			sysTrayMenu = new PopupMenu();
			createSystemTrayMenu();
		} else {
			System.err.println("SysTray is not available");
		}
	}

	private void createSystemTrayMenu() {
		createExitNotepadSysTrayMenuItem();
		createShowNotepadSysTrayMenuItem();
		createTrayIconMenuItem();
	}

	private void createTrayIconMenuItem() {
		Image notepadIcon = IconHandler.getIcon().getImage("/Resources/images/notepad.png");
		notepad.trayIcon = new TrayIcon(notepadIcon, "BIG Notepad", sysTrayMenu);
		// double-click this to restore
		notepad.trayIcon.addActionListener((ActionEvent evt) -> {
			notepad.setVisible(true);
			notepad.setExtendedState(JFrame.NORMAL);
		});
		notepad.trayIcon.setImageAutoSize(true);
	}

	private void createExitNotepadSysTrayMenuItem() {
		MenuItem menuItem = new MenuItem("Exit");
		menuItem.addActionListener((ActionEvent evt) -> {
			// otherwise it will only show the fileChooser
			if (notepad.documentIsModified) {
				notepad.setVisible(true);
				notepad.setExtendedState(JFrame.NORMAL);
			}
			notepad.exit(0);
		});
		sysTrayMenu.add(menuItem);
	}

	private void createShowNotepadSysTrayMenuItem() {
		MenuItem menuItem = new MenuItem("Show BIGNotepad");
		menuItem.addActionListener((ActionEvent evt) -> {
			notepad.setVisible(true);
			notepad.setExtendedState(JFrame.NORMAL);
		});
		sysTrayMenu.add(menuItem);
	}
}
