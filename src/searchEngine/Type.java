package searchEngine;

import gui.BIGNotepad;
import searchModes.Feedback;

/**
 *
 * @author catalin.podariu[at]gmail.com
 */
public enum Type {

	IGNORE_CASE(1) {
		@Override
		public void find(BIGNotepad notepad, String toFind, int index, String temp) {
			if (temp.equalsIgnoreCase(toFind)) {
				Feedback.valueOf(notepad).selectString(index, toFind.length());
			}
		}

		@Override
		public int getValue() {
			return 1;
		}
	},
	IGNORE_CASE_WHOLE_WORD(13) {
		@Override
		public void find(BIGNotepad notepad, String toFind, int index, String temp) {
			char space = ' ';
			if (temp.equalsIgnoreCase(space + toFind + space)) {
				Feedback.valueOf(notepad).selectString(index, toFind.length());
			}
		}

		@Override
		public int getValue() {
			return 13;
		}
	},
	IGNORE_CASE_WORD_START(14) {
		@Override
		public void find(BIGNotepad notepad, String toFind, int index, String temp) {
			char space = ' ';
			if (temp.equalsIgnoreCase(space + toFind)) {
				Feedback.valueOf(notepad).selectString(index, toFind.length());
			}
		}

		@Override
		public int getValue() {
			return 14;
		}
	},

	MATCH_CASE(2) {
		@Override
		public void find(BIGNotepad notepad, String toFind, int index, String temp) {
			if (temp.equals(toFind)) {
				Feedback.valueOf(notepad).selectString(index, toFind.length());
			}
		}

		@Override
		public int getValue() {
			return 2;
		}
	},
	MATCH_CASE_WHOLE_WORD(23) {
		@Override
		public void find(BIGNotepad notepad, String toFind, int index, String temp) {
			char space = ' ';
			if (temp.equals(space + toFind + space)) {
				Feedback.valueOf(notepad).selectString(index, toFind.length());
			}
		}

		@Override
		public int getValue() {
			return 23;
		}
	},
	MATCH_CASE_WORD_START(24) {
		@Override
		public void find(BIGNotepad notepad, String toFind, int index, String temp) {
			char space = ' ';
			if (temp.equals(space + toFind)) {
				Feedback.valueOf(notepad).selectString(index, toFind.length());
			}
		}

		@Override
		public int getValue() {
			return 24;
		}
	};

	// REGEX(6),
	//
	// WRAP_AROUND(7),
	//
	// HIGHLIGHTER(8),
	//
	// INCREMENTAL(9);

	private int value;

	private Type(int value) {
		this.value = value;
	}

	public abstract void find(BIGNotepad notepad, String toFind, int index, String temp);

	public abstract int getValue();
}
