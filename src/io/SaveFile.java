/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.SAVE_DIALOG;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import config.TitleDisplayMode;
import gui.BIGNotepad;

/**
 *
 * @author Agnosto Theo
 */
public class SaveFile extends BIGNotepad {

    private JFileChooser fileChooser;
    private BIGNotepad pad;

    private SaveFile(BIGNotepad pad) {
        this.pad = pad;
    }

    public static SaveFile valueOf(BIGNotepad pad) {
        return new SaveFile(pad);
    }

    /**
     * Save file.
     * <br>
     * Checks the filename with a predefined regex pattern.
     * <br>
     *
     * @param text String of text to save.
     * @param fileName document file name.
     * @return - "file saved" if operation was successful. "IOException" +
     * exception. "pattern error" if file name is wrong.
     */
    protected int saver(String text, String fileName) {
        String filePattern = "[-_ a-zA-Z0-9]+\\.[-_a-zA-Z0-9]+";
        Pattern pattern = Pattern.compile(filePattern);
        // only the file name must match the pattern, not the whole path
        String temp = fileName.substring(fileName.lastIndexOf('\\') + 1);
        Matcher match = pattern.matcher(temp);
        int status;
        if (match.matches()) {
            try (PrintWriter out = new PrintWriter(
                    new BufferedWriter(new FileWriter(fileName)))) {
                out.write(text);
                status = 0;
            } catch (IOException ex) {
                status = -1;
                JOptionPane.showConfirmDialog(pad,
                        "Error saving file..\nWe advise you to copy your work..",
                        "I/O error",
                        JOptionPane.PLAIN_MESSAGE);
                System.err.println(ex);
            }
        } else {
            status = -2;
        }
        return status;
    }

    public int fileSaveAs() {
        // overwrite check
        fileChooser = new JFileChooser(pad.currentPath) {
            @Override
            public void approveSelection() {
                File f = getSelectedFile();
                if (f.exists() && getDialogType() == SAVE_DIALOG) {
                    int result = JOptionPane.showConfirmDialog(this,
                            "The file already exists, overwrite?",
                            "Existing file",
                            JOptionPane.YES_NO_CANCEL_OPTION);
                    switch (result) {
                        case JOptionPane.YES_OPTION:
                            super.approveSelection();
                            return;
                        case JOptionPane.NO_OPTION:
                            return;
                        case JOptionPane.CLOSED_OPTION:
                            return;
                        case JOptionPane.CANCEL_OPTION:
                            cancelSelection();
                            return;
                    }
                }
                super.approveSelection();
            }
        };
        fileChooser.setSelectedFile(new File("Untitled document.txt"));
        FileFilter filter = new FileNameExtensionFilter("Plain text document  "
                + "*.txt *.log *.lst *.srt *.sub", "*.properties");
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setFileFilter(filter);
        int status = -1;
        if (fileChooser.showSaveDialog(this.getParent()) == JFileChooser.APPROVE_OPTION) {
            fileChooser.setPreferredSize(new Dimension(600, 400));
            pad.currentlyOpenedFile = fileChooser.getSelectedFile();
            status = saveCurrentFile();
        }
        return status;
    }

    public int saveCurrentFile() {
        int status = -1;
        // check if file is read only and not empty
        if (pad.currentlyOpenedFile != null) {
            int fileIsSaved = saver(pad.bigEdit.getText(),
                    pad.currentlyOpenedFile.getPath());
            // file saved!
            if (fileIsSaved == 0) {
                status = 0;
                //IOException
            } else if (fileIsSaved == -1) {
                status = -1;
                JOptionPane.showConfirmDialog(this,
                        "Error writing file.",
                        "File not saved",
                        JOptionPane.PLAIN_MESSAGE);
                // pattern error
            } else if (fileIsSaved == -2) {
                status = 1;
                JOptionPane.showConfirmDialog(this,
                        "File should be named '[filename].[ext]'",
                        "File not saved - Filename error",
                        JOptionPane.PLAIN_MESSAGE);
            }
            pad.askToSave = false;
            TitleDisplayMode.valueOf(pad).setWindowTitleDisplay(pad.windowTitleDisplayMode);
        } else {
            // save with a different name
            fileSaveAs();
        }
        if (pad.currentlyOpenedFile != null) {
            pad.currentPath = pad.currentlyOpenedFile.getPath();
        }
        return status;
    }

    /**
     * JOptionPane Dialog.
     * <br>
     * Confirm saving of the changes made.
     *
     * @return -1 means saveConfirmation window was closed <br>
     * 0 means file was saved <br>
     * 1 means file was NOT saved <br>
     * 2 means cancel was selected
     */
    public int saveConfirmation() {
        int select = JOptionPane.showConfirmDialog(this,
                "Do you need to the save changes made to this document?",
                "One more thing..", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null);
        if (select == JOptionPane.YES_OPTION) {
            // overwrite check
            fileChooser = new JFileChooser(pad.currentPath) {
                @Override
                public void approveSelection() {
                    File f = getSelectedFile();
                    if (f.exists() && getDialogType() == SAVE_DIALOG) {
                        int result = JOptionPane.showConfirmDialog(this,
                                "The file already exists, overwrite?",
                                "Existing file",
                                JOptionPane.YES_NO_CANCEL_OPTION);
                        switch (result) {
                            case JOptionPane.YES_OPTION:
                                super.approveSelection();
                                return;
                            case JOptionPane.NO_OPTION:
                                return;
                            case JOptionPane.CLOSED_OPTION:
                                return;
                            case JOptionPane.CANCEL_OPTION:
                                cancelSelection();
                                return;
                        }
                    }
                    super.approveSelection();
                }
            };
            fileChooser.setSelectedFile(new File("Untitled document.txt"));
            FileFilter filter = new FileNameExtensionFilter("Plain text document  "
                    + "*.txt *.log *.lst *.srt *.sub", "*.properties");
            fileChooser.addChoosableFileFilter(filter);
            fileChooser.setFileFilter(filter);
            int result = fileChooser.showSaveDialog(this.getParent());
            if (result == JFileChooser.APPROVE_OPTION) {
                pad.currentlyOpenedFile = fileChooser.getSelectedFile();
                int status = saveCurrentFile();
                if (status == 0) {
                    // file saved
                    return 0;
                } else {
                    // file not saved
                    return 1;
                }
            }
        } else if (select == JOptionPane.NO_OPTION) {
            return 1;
        } else if (select == JOptionPane.CANCEL_OPTION) {
            return 2;
        }
        // window was closed
        return -1;
    }
}
