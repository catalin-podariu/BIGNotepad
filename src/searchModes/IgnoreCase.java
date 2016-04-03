package searchModes;

import gui.BIGNotepad;

public class IgnoreCase {

	private BIGNotepad notepad;

	public IgnoreCase(BIGNotepad notepad) {
		this.notepad = notepad;
	}
	
	public static IgnoreCase get(BIGNotepad notepad) {
		return new IgnoreCase(notepad);
	}
	
	public void find(String toFind, int index, String temp) {
		if (temp.equalsIgnoreCase(toFind)) {
			Feedback.valueOf(notepad).selectString(index, toFind.length());
		}
	}

}