package searchEngine;

public class Type {

	public final int IGNORE_CASE = 1;
	public final int IGNORE_CASE_WHOLE_WORD = 13;
	public final int IGNORE_CASE_WORD_START = 14;
	public final int IGNORE_CASE_SELECTION = 15;
	
	public final int IGNORE_CASE_WHOLE_WORD_SELECTION = 135;
	public final int IGNORE_CASE_WORD_START_SELECTION = 145;

	public final int MATCH_CASE = 2;
	public final int MATCH_CASE_WHOLE_WORD = 23;
	public final int MATCH_CASE_WORD_START = 24;
	public final int MATCH_CASE_SELECTION = 25;

	public final int MATCH_CASE_WHOLE_WORD_SELECTION = 235;
	public final int MATCH_CASE_WORD_START_SELECTION = 245;

	public final int REGEX = 6;
	
	public final int WRAP_AROUND = 7;
	
	public final int HIGHLIGHTER = 8;
	
	public final int INCREMENTAL = 9;

	private Type() {
	}
	
	public static Type get(){
		return new Type();
	}
	
}
