package gui;

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

import config.TitleDisplayMode;
import io.OpenFile;
import io.SaveFile;

/**
 *
 * @author catalin.podariu[at]gmail.com
 */
public class Task extends SwingWorker<Void, Void> {

	public Task(BIGNotepad notepad) {
		this.notepad = notepad;
	}

	@Override
	public Void doInBackground() {
		notepad.document.addUndoableEditListener((UndoableEditEvent e) -> {
			notepad.undoManager.addEdit(e.getEdit());
			notepad.documentIsModified = notepad.undoManager.canUndo();
			if (notepad.firstTimeOpen) {
				notepad.firstTimeOpen = false;
				notepad.documentIsModified = false;
			}
			TitleDisplayMode.valueOf(notepad).setWindowTitleDisplay(notepad.windowTitleDisplayMode);
			notepad.updateUndoMenuItems();
		});
		notepad.document.addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(final DocumentEvent event) {
				SwingUtilities.invokeLater(() -> {
					int offset = event.getOffset() + event.getLength();
					offset = Math.min(offset, notepad.document.getLength());
					notepad.bigEdit.setCaretPosition(offset);
				});
			}

			@Override
			public void removeUpdate(DocumentEvent event) {
				notepad.bigEdit.setCaretPosition(event.getOffset());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
//				notepad.bigEdit.setCaretPosition(event.getOffset());
			}
		});

		notepad.bigEdit.setDragEnabled(true);
		notepad.bigEdit.setDropTarget(new DropTarget() {
			@Override
			public synchronized void drop(DropTargetDropEvent evt) {
				try {
					evt.acceptDrop(DnDConstants.ACTION_COPY);
					/*
					 * This only works for WINDOWS! On Linux instead of
					 * DataFlavor.javaFileListFlavor you should use something in
					 * the neighborhood of new
					 * DataFlavor("text/uri-list;class=java.lang.String")
					 */
					List<File> droppedFiles = (List<File>) evt.getTransferable() //
							.getTransferData(DataFlavor.javaFileListFlavor);
					getDroppedFiles(droppedFiles);
				} catch (UnsupportedFlavorException | IOException ex) {
					System.err.println(ex);
				}
			}

			private void getDroppedFiles(List<File> droppedFiles) {
				droppedFiles.stream().forEach((File file) -> {
					if (notepad.documentIsModified) {
						int status = SaveFile.valueOf(notepad).saveConfirmation();
						// safe to open new dragged document
						if (status != -1 | status != 2) {
							notepad.currentlyOpenedFile = file;
							OpenFile.valueOf(notepad).openNew(file);
						}
					} else {
						notepad.currentlyOpenedFile = file;
						OpenFile.valueOf(notepad).openNew(file);
					}
				});
			}
		});

		// System tray - window state listener
		notepad.addWindowStateListener((WindowEvent evt) -> {
			if (notepad.trayIcon != null) {
				if (evt.getNewState() == ICONIFIED) {
					try {
						notepad.sysTray.add(notepad.trayIcon);
						notepad.setVisible(false);
					} catch (AWTException ex) {
						System.err.println(ex);
					}
				}
				if (evt.getNewState() == 7) {
					try {
						notepad.sysTray.add(notepad.trayIcon);
						notepad.setVisible(false);
					} catch (AWTException ex) {
						System.err.println(ex);
					}
				}
				if (evt.getNewState() == MAXIMIZED_BOTH) {
					notepad.sysTray.remove(notepad.trayIcon);
					notepad.setVisible(true);
				}
				if (evt.getNewState() == NORMAL) {
					notepad.sysTray.remove(notepad.trayIcon);
					notepad.setVisible(true);
				}
			}
		});
		return null;
	}

	private BIGNotepad notepad;
	
}
