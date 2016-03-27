/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.awt.Cursor;
import java.awt.Dimension;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import config.TitleDisplayMode;
import gui.BIGNotepad;

/**
 *
 * @author mrbigheart
 */
public class OpenFile extends BIGNotepad {

    private BIGNotepad pad;

    // private constructor
    private OpenFile(BIGNotepad pad) {
        this.pad = pad;
        document = this.pad.bigEdit.getStyledDocument();
    }
    
    // public static factory
    public static OpenFile valueOf(BIGNotepad pad){
        return new OpenFile(pad);
    }

    // open new file
    public void fileOpenNew() {
        if (pad.askToSave) {
            // save opened document first
            int status = SaveFile.valueOf(pad).saveConfirmation();
            // 1 = NO was pressed; 0 = file was saved
            if (status == 1 | status == 0) {
                openNewDialog();
            }
        } else {
            openNewDialog();
        }
        pad.bigEdit.setCaretPosition(0);
        // otherwise it will "undo" every line read by fastReader
        pad.undoManager.discardAllEdits();
    }

    /**
     * Custom File Chooser.
     * <br>
     * Customize and display Open Dialog (fileChooser)
     */
    protected void openNewDialog() {
        JFileChooser openFileChooser = new JFileChooser(pad.currentPath);
        FileFilter filter = new FileNameExtensionFilter("Plain text document  "
                + "*.txt *.log *.lst *.srt *.sub", "*.properties");
        openFileChooser.addChoosableFileFilter(filter);
        openFileChooser.setDialogTitle("Open new file");
        openFileChooser.setPreferredSize(new Dimension(600, 400));
        if (openFileChooser.showOpenDialog(
                this) == JFileChooser.APPROVE_OPTION) {
            pad.currentlyOpenedFile = openFileChooser.getSelectedFile();
            openNew(openFileChooser.getSelectedFile());
        }
    }

    /**
     * Open new file.
     * <br>
     * Because of the repeated insert of strings into the bigEdit, undoManager
     * together with "ask to save" and setWindowTitleDisplay will add a star, as
     * if the document has changed, at the opening of a big file. That has been
     * solved by reseting the title after opening new file.
     * <br>
     * Uses fast reader, trims path names until last '\' to show in Recent
     * Files, and while the document is opening shows "wait cursor" while
     * hovering over bigEdit JTextPane.
     *
     * @param file the text file to open
     * @return the only place where findFeedback is needed is in RecentMenuAction
     */
    public int openNew(File file) {
        // discard old text & title
        pad.bigEdit.setText("");
        this.setTitle(pad.defaultTitle);
        // hide line numbers before open, to avoid 'offset out of bounds' error
        pad.editorScrollPane.setRowHeaderView(null);

        pad.bigEdit.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        // read text that will be displayed in bigEdit
        int status = FastReader.valueOf(pad).fastReader(file.getPath());
        pad.bigEdit.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        // if fastReader throws any exception
        if (status == -1) {
            System.err.println("[openNew] - File is null..");
            return -1;
        } else if (status == -2 | status == -3) {
            JOptionPane.showConfirmDialog(this,
                    "Error reading this file.",
                    "Read error",
                    JOptionPane.PLAIN_MESSAGE);
        }
        // add to recent files
        if (pad.currentlyOpenedFile.getPath() != null) {
            pad.currentPath = pad.currentlyOpenedFile.getPath();
        }
        Object[] recentFile = {pad.currentlyOpenedFile.getPath()};
        RecentFiles.valueOf(pad).addRecentFileItems(recentFile);
        pad.firstTimeOpen = true;
        // reset title
        pad.askToSave = false;
        TitleDisplayMode.valueOf(pad).setWindowTitleDisplay(windowTitleDisplayMode);
        // set cursor to start of document
        pad.bigEdit.setCaretPosition(0);
        // otherwise it will "undo" every line read by fastReader
        pad.undoManager.discardAllEdits();

        // bring back the line numbers if they were displayed before
        if (pad.displayLineNumMenuItem.isSelected()) {
            pad.displayLineNumbers = true;
            pad.editorScrollPane.setRowHeaderView(pad.lineNumbers);
        } else {
            pad.displayLineNumbers = false;
            pad.editorScrollPane.setRowHeaderView(null);
        }
        return 0;
    }
}
