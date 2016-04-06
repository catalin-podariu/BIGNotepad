/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import gui.BIGNotepad;

/**
 *
 * @author mrbigheart
 */
public class RecentFiles extends BIGNotepad {

    private BIGNotepad pad;

    public RecentFiles(BIGNotepad pad) {
        this.pad = pad;
    }

    public static RecentFiles valueOf(BIGNotepad pad) {
        return new RecentFiles(pad);
    }

    /**
     * Recent files menu.
     * <br>
     * Ads items to recent files menu, a history of the 10 most recent files
     * opened. If "rememberRecentFiles" is false, shows "no recent items to
     * show". Checks for null the item[] and also every item. This way it will
     * not add "null" in Recent Files list. The JMenuItem text will have part of
     * the filename if it exceeds 20 chars. But the Tool-Tip will show the full
     * path.
     * <br>
     *
     * @param files array of objects, that will be 'stripped' toString and for
     * each will be created a new JMenuItem, assigned with the text and path to
     * open that file
     */
    public void addRecentFileItems(Object[] files) {
        if (pad.rememberRecentFiles != false & files != null) {
            for (Object recentFile : files) {
                JMenuItem menuItem = new JMenuItem();
                // trim long paths to ~20 chars e.g."C:\Win...System32\doc.txt"
                int temp = recentFile.toString().length();
                // get the last slash index so you can display full file name
                int lastSlash = recentFile.toString().lastIndexOf('\\');
                if (temp > 20) {
                    menuItem.setText(recentFile.toString().substring(0, 10)
                            + "..." + recentFile.toString().substring(lastSlash, temp));
                } else {
                    menuItem.setText(recentFile.toString());
                }
                // action listener and remove missing recent item if null
                menuItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int openStatus = 0;
                        if (pad.documentIsModified) {
                            // save opened document first
                            int saveStatus = SaveFile.valueOf(pad).saveConfirmation();
                            if (saveStatus == 0 | saveStatus == 1) {
                                pad.currentlyOpenedFile = new File((String) recentFile);
                                openStatus = OpenFile.valueOf(pad).openNew(pad.currentlyOpenedFile);
                            }
                        } else {
                            pad.currentlyOpenedFile = new File((String) recentFile);
                            openStatus = OpenFile.valueOf(pad).openNew(pad.currentlyOpenedFile);
                        }
                        // if file is null
                        if (openStatus == -1) {
                            JOptionPane.showConfirmDialog((Component) e.getSource(),
                                    "Error reading this file..",
                                    "Read error",
                                    JOptionPane.PLAIN_MESSAGE);
                            // if the file is not found, removes menuItem entry
                            int removeStatus = removeMissingItem();
                            // in the event of an error
                            if (removeStatus == -1) {
                                JOptionPane.showConfirmDialog((Component) e.getSource(),
                                        "Error removing item from Recent Files menu..",
                                        "MenuItem not found",
                                        JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                    }

                    // remove menuItem if file is not found
                    private int removeMissingItem() {
                        ArrayList<Object> temp = new ArrayList();
                        temp.addAll(Arrays.asList(pad.recentFilesItems));
                        if (temp.contains(recentFile)) {
                            temp.remove(recentFile);
                            return 0;
                        }
                        pad.recentFilesItems = temp.toArray(pad.recentFilesItems);
                        return -1;
                    }
                });
                // show full path & file name in Tool-Tip
                menuItem.setToolTipText(recentFile.toString());
                // make sure no 'null' are displayed
                if (!menuItem.getText().equalsIgnoreCase("null")) {
                    // insert new files at the top
                    pad.fileRecentMenu.insert(menuItem, 0);
                }
                // keep the list to 10 elements, always remove the last one
                if (pad.fileRecentMenu.getItemCount() > 10) {
                    pad.fileRecentMenu.remove(pad.fileRecentMenu.getItemCount() - 1);
                }
            }
        }
    }
}
