/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchEngine;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.Document;

/**
 *
 * @author Agnosto Theo
 */
public class FindString {

    private JTextPane notepad; // bigEdit
    private String toFind;
    private String match;

    private int searchLocation;
    private Document document;
    
    // private constructor
    protected FindString(JTextPane notepad, String toFind, String match) {
        this.match = match;
        this.notepad = notepad;
        this.toFind = toFind;
        document = notepad.getDocument();
        searchLocation = notepad.getCaretPosition();
    }

    // static factory
    public static FindString getSearch(JTextPane notepad, String toFind, String match) {
        return new FindString(notepad, toFind, match);
    }
    
    /**
     * Find Next String.
     * <br>
     * The search direction is forward.
     *
     * @param toFind String to find (and compare to 'match')
     * @return 1 if String was found; 0 if String was NOT found.
     */
    public int findNextString(String toFind) {
        
        for (int index = searchLocation; index - toFind.length() >= 0; index--) {
            if (toFind.equalsIgnoreCase(match)) {
                feedback(index);
                return 1;
            }
            if (searchLocation == document.getLength()) {
                message(-1);
            }
        }
        return 0;
    }
    
    /**
     * Find Previous String.
     * <br>
     * The search direction is.. backwards.
     *
     * @param toFind String to find (and compare to 'match')
     * @return 1 if String was found; 0 if String was NOT found.
     */
    public int findPreviousString(String toFind) {

        for (int index = searchLocation; index - toFind.length() >= 0; index--) {
            if (toFind.equalsIgnoreCase(match)) {
                feedback(index);
                return 1;
            }
            if (searchLocation == document.getLength()) {
                message(-1);
            }
        }
        return 0;
    }

    /**
     * Confirmation message.
     *
     * @param direction used by resetCurrentSearchLocation()
     */
    protected void message(int direction) {
        int status = JOptionPane.showConfirmDialog(null, // ?!
                "Start search from the begining of document?",
                "No String found..",
                JOptionPane.YES_NO_OPTION);
        if (status == 0) { // meaning YES was pressed
            resetCurrentSearchLocation(direction);
        }
    }

    /**
     * FindString/Replace feedback.
     * <br>
     * It receives the found location and selects String in
     * TextEditor.BIGNotepad.bigEdit
     *
     * @param location location where the String was found.
     */
    protected void feedback(int location) {
        searchLocation = location + toFind.length();
        notepad.requestFocus();
        // next two lines keep the found String selected
        notepad.setCaretPosition(location);
        notepad.moveCaretPosition(location + toFind.length());
    }

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
    protected void resetCurrentSearchLocation(int direction) {
        if (direction == 1) {
            searchLocation = 0;
        } else if (direction == -1) {
            searchLocation = document.getLength();
        }
    }

}
