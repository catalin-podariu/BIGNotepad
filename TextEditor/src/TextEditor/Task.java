/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

import java.awt.AWTException;
import static java.awt.Frame.ICONIFIED;
import static java.awt.Frame.MAXIMIZED_BOTH;
import static java.awt.Frame.NORMAL;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Agnosto Theo
 */
public class Task extends SwingWorker<Void, Void> {

    private BIGNotepad pad;
    private StyledDocument document;

    public Task(BIGNotepad pad) {
        this.pad = pad;
        document = this.pad.bigEdit.getStyledDocument();
    }

    @Override
    public Void doInBackground() {
        // assign document undo / redo
        pad.document.addUndoableEditListener((UndoableEditEvent e) -> {
            pad.undoManager.addEdit(e.getEdit());
            pad.askToSave = pad.undoManager.canUndo();
            if (pad.firstTimeOpen) {
                pad.firstTimeOpen = false;
                pad.askToSave = false;
            }
            TitleDisplayMode.valueOf(pad).setWindowTitleDisplay(pad.windowTitleDisplayMode);
            pad.updateUndoMenuItems();
        });

        // undo/redo change listeners
        pad.document.addDocumentListener(new DocumentListener() {

            /*
             *  Updates to the Document as a result of Undo/Redo will cause the
             *  Caret to be repositioned
             */
            @Override
            public void insertUpdate(final DocumentEvent e) {
                SwingUtilities.invokeLater(() -> {
                    int offset = e.getOffset() + e.getLength();
                    offset = Math.min(offset, pad.document.getLength());
                    pad.bigEdit.setCaretPosition(offset);
                });
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                pad.bigEdit.setCaretPosition(e.getOffset());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        /*
         Drag and drop.
         Also using fastReader.
         */
        pad.bigEdit.setDragEnabled(true);
        pad.bigEdit.setDropTarget(new DropTarget() {
            @Override
            public synchronized void drop(DropTargetDropEvent evt) {
                try {
                    evt.acceptDrop(DnDConstants.ACTION_COPY);
                    /*
                     This only works for WINDOWS!
                     On Linux instead of DataFlavor.javaFileListFlavor 
                     you should use something int the neighbourhood of 
                     new DataFlavor("text/uri-list;class=java.lang.String")
                     */
                    List<File> droppedFiles = (List<File>) evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                    droppedFiles.stream().forEach((File file) -> {
                        if (pad.askToSave) {
                            int status = SaveFile.valueOf(pad).saveConfirmation();
                            // safe to open new dragged document
                            if (status != -1 | status != 2) {
                                pad.currentlyOpenedFile = file;
                                OpenFile.valueOf(pad).openNew(file);
                            }
                        } else {
                            pad.currentlyOpenedFile = file;
                            OpenFile.valueOf(pad).openNew(file);
                        }
                    });
                } catch (UnsupportedFlavorException | IOException ex) {
                    System.err.println(ex);
                }
            }
        });

        // System tray - window state listener
        pad.addWindowStateListener((WindowEvent evt) -> {
            if (pad.trayIcon != null) {
                if (evt.getNewState() == ICONIFIED) {
                    try {
                        pad.sysTray.add(pad.trayIcon);
                        pad.setVisible(false);
                    } catch (AWTException ex) {
                        System.err.println(ex);
                    }
                }
                if (evt.getNewState() == 7) {
                    try {
                        pad.sysTray.add(pad.trayIcon);
                        pad.setVisible(false);
                    } catch (AWTException ex) {
                        System.err.println(ex);
                    }
                }
                if (evt.getNewState() == MAXIMIZED_BOTH) {
                    pad.sysTray.remove(pad.trayIcon);
                    pad.setVisible(true);
                }
                if (evt.getNewState() == NORMAL) {
                    pad.sysTray.remove(pad.trayIcon);
                    pad.setVisible(true);
                }
            }
        });
        return null;
    }
}
