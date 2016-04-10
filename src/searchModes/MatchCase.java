package searchModes;

import gui.BIGNotepad;

public class MatchCase {

	private BIGNotepad notepad;

	public MatchCase(BIGNotepad notepad) {
		this.notepad = notepad;
	}
	
	public static MatchCase get(BIGNotepad notepad) {
		return new MatchCase(notepad);
	}
	
	public void find(String toFind, int index, String temp) {
		if (temp.equals(toFind)) {
			Feedback.valueOf(notepad).selectString(index, toFind.length());
		}
	}
}