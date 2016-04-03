package searchModes;

import gui.BIGNotepad;

public class WordStart {

	private BIGNotepad notepad;

	public WordStart(BIGNotepad notepad) {
		this.notepad = notepad;
	}

	public static WordStart get(BIGNotepad notepad) {
		return new WordStart(notepad);
	}

	public void find(String toFind, int index, String temp) {
		char space = ' ';
		if (temp.equals(space + toFind)) {
			Feedback.valueOf(notepad).selectString(index, toFind.length());
		}
	}
}