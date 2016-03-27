/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchEngine;

/**
 * Find string.
 * <br>
 *
 * @author mrbigheart
 */
public interface Find {

    /**
     * Find Next String.
     * <br>
     * The search direction is forward.
     *
     * @param toFind String to find (and compare to 'match')
     * @return 1 if String was found; 0 if String was NOT found.
     */
    public int findNextString(String toFind);

    /**
     * Find Previous String.
     * <br>
     * The search direction is.. backwards.
     *
     * @param toFind String to find (and compare to 'match')
     * @return 1 if String was found; 0 if String was NOT found.
     */
    public int findPreviousString(String toFind);

    /**
     * Reset current search location.
     * <br>
     * Used when you want to Wrap Around (ie: continues the search from the
     * beginning of the file when the end is reached.
     * <br>
     * If the END of document was reached, the new search location should be 0
     * <br>
     * If the BEGINING of the document was reached, the new search location
     * should be document.getLength()
     *
     * @param direction -1 is backwards and 1 is forward.
     */
    public void resetCurrentSearchLocation(int direction);

    /**
     * Find/Replace feedback.
     * <br>
     * It receives the found location and selects String in
     * TextEditor.BIGNotepad.bigEdit
     *
     * @param location location where the String was found.
     */
    public void feedback(int location);
}
