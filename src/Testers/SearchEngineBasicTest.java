package Testers;

import static org.junit.Assert.*;

import org.junit.Test;

import gui.BIGNotepad;
import searchModes.RegEx;

public class SearchEngineBasicTest {

	@Test
	public void test() {
		BIGNotepad notepad = BIGNotepad.getInstance();
		boolean expectedResult = true;
		String toFind = "words are everything";
		String regexPattern = "[\\w+ ]+";
		boolean result = RegEx.valueOf(notepad).compileAndMatch(toFind, regexPattern);
		assertEquals(expectedResult, result);
	}

}
