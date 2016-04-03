package searchModes;

import gui.BIGNotepad;

public class WholeWord {

	private BIGNotepad notepad;

	public WholeWord(BIGNotepad notepad) {
		this.notepad = notepad;
	}
	
	public static WholeWord get(BIGNotepad notepad) {
		return new WholeWord(notepad);
	}
	
	public void find(String toFind, int index, String temp) {
		char space = ' ';
		if (temp.equals(space + toFind + space)) {
			Feedback.valueOf(notepad).selectString(index, toFind.length());
		}
	}

}