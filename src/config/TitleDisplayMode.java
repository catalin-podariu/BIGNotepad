package config;

import gui.BIGNotepad;

/**
 *
 * @author catalin.podariu[at]gmail.com
 */
public class TitleDisplayMode {

	private BIGNotepad notepad;
	private final String IS_CHANGED_FLAG = "*";

	private TitleDisplayMode(BIGNotepad notepad) {
		this.notepad = notepad;
	}

	public static TitleDisplayMode valueOf(BIGNotepad notepad) {
		return new TitleDisplayMode(notepad);
	}

	public void setWindowTitleDisplay(int titleMode) {
		if (notepad.currentlyOpenedFile != null) {
			if (titleMode == BIGNotepad.FILE_NAME) { // default
				setTitleDisplayModeTo_FileName();
			} else if (titleMode == BIGNotepad.FILE_NAME_AND_PARENT_FOLDER) {
				setTitleDisplayModeTo_FileNameAndParentFolder();
			} else if (titleMode == BIGNotepad.FULL_PATH) {
				setTitleDisplayModeTo_FullPath();
			}
		} else {
			if (notepad.documentIsModified) {
				notepad.setTitle(notepad.defaultTitle + IS_CHANGED_FLAG);
			} else {
				notepad.setTitle(notepad.defaultTitle);
			}
		}
	}

	private void setTitleDisplayModeTo_FullPath() {
		String fullFilePath = notepad.currentlyOpenedFile.getAbsolutePath();
		if (fullFilePath.length() > 50) {
			fullFilePath = fullFilePath.substring(0, 50) + " .... " //
					+ fullFilePath.substring(fullFilePath.lastIndexOf('\\') - 1, //
							fullFilePath.length());
		}
		if (notepad.documentIsModified) {
			notepad.setTitle(fullFilePath + "  |  BIGNotepad" + IS_CHANGED_FLAG);
		} else {
			notepad.setTitle(fullFilePath + "  |  BIGNotepad");
		}
	}

	private void setTitleDisplayModeTo_FileName() {
		if (notepad.documentIsModified) {
			notepad.setTitle(notepad.currentlyOpenedFile.getName() //
					+ "  |  BIGNotepad" + IS_CHANGED_FLAG);
		} else {
			notepad.setTitle(notepad.currentlyOpenedFile.getName() //
					+ "  |  BIGNotepad");
		}
	}

	private void setTitleDisplayModeTo_FileNameAndParentFolder() {
		String filePath = notepad.currentlyOpenedFile.getAbsolutePath();
		String fileName = filePath.substring(0, filePath.lastIndexOf('\\') - 1);
		String folderName = filePath.substring(fileName.lastIndexOf('\\') + 1, //
				filePath.length());
		if (notepad.documentIsModified) {
			notepad.setTitle("\\" + folderName + "\\" //
					+ fileName + "  |  BIGNotepad" + IS_CHANGED_FLAG);
		} else {
			notepad.setTitle(folderName + "  |  BIGNotepad");
		}
	}
}
