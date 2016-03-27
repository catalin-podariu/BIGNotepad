/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchEngine;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

/**
 *
 * @author mrbigheart
 */
public class IgnoreCase implements Find {

    private JTextPane notepad; // bigEdit
    private String toFind;
    private String match;

    private int searchLocation;
    private StyledDocument findDoc;

    // private constructor
    private IgnoreCase(JTextPane notepad, String toFind, String match) {
        this.match = match;
        this.notepad = notepad;
        this.toFind = toFind;
        findDoc = notepad.getStyledDocument();
        searchLocation = notepad.getCaretPosition();
    }

    // static factory
    public static IgnoreCase valueOf(JTextPane notepad, String toFind, String match) {
        return new IgnoreCase(notepad, toFind, match);
    }

    @Override
    public int findNextString(String toFind) {

        for (int index = searchLocation;
                index + toFind.length() < findDoc.getLength(); index++) {
            if (toFind.equalsIgnoreCase(match)) {
                feedback(index);
                return 1;
            }
            if (searchLocation == findDoc.getLength()) {
                message(1);
            }
        }
        return 0;
    }

    @Override
    public int findPreviousString(String toFind) {

        for (int index = searchLocation; index - toFind.length() >= 0; index--) {
            if (toFind.equalsIgnoreCase(match)) {
                feedback(index);
                return 1;
            }
            if (searchLocation == findDoc.getLength()) {
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
    private void message(int direction) {
        int status = JOptionPane.showConfirmDialog(null, // ?!
                "Start search from the begining of document?",
                "No String found..",
                JOptionPane.YES_NO_OPTION);
        if (status == 0) { // meaning YES was pressed
            resetCurrentSearchLocation(direction);
        }
    }

    /**
     * Find/Replace feedback.
     * <br>
     * It receives the found location and selects String in
     * TextEditor.BIGNotepad.bigEdit
     *
     * @param location location where the String was found.
     */
    @Override
    public void feedback(int location) {
        searchLocation = location + toFind.length();
        notepad.requestFocus();
        // next two lines keep the found String selected
        notepad.setCaretPosition(location);
        notepad.moveCaretPosition(location + toFind.length());
    }

    @Override
    public void resetCurrentSearchLocation(int direction) {
        if (direction == 1) {
            searchLocation = 0;
        } else if (direction == -1) {
            searchLocation = findDoc.getLength();
        }
    }
}
