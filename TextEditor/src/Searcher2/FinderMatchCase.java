/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Searcher2;

import javax.swing.JTextPane;
import javax.swing.text.Document;

/**
 *
 * @author Agnosto Theo
 */
public class FinderMatchCase extends Finder {

    private JTextPane notepad; // bigEdit
    private String toFind;
    private String match;

    private int searchLocation;
    private Document document;

    // private constructor
    private FinderMatchCase(JTextPane notepad, String toFind, String match) {
        super(notepad, toFind, match);
        this.match = match;
        this.notepad = notepad;
        this.toFind = toFind;
        document = notepad.getDocument();
        searchLocation = notepad.getCaretPosition();
    }

    // static factory
    public static FinderMatchCase getSearch(JTextPane notepad, String toFind, String match) {
        return new FinderMatchCase(notepad, toFind, match);
    }

    /**
     * MATCH CASE.
     * Find Next String.
     * <br>
     * The search direction is forward.
     *
     * @param toFind String to find (and compare to 'match')
     * @return 1 if String was found; 0 if String was NOT found.
     */
    @Override
    public int findNextString(String toFind) {

        for (int index = searchLocation; index - toFind.length() >= 0; index--) {
            if (toFind.equals(match)) {
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
     * MATCH CASE.
     * Find Previous String.
     * <br>
     * The search direction is.. backwards.
     *
     * @param toFind String to find (and compare to 'match')
     * @return 1 if String was found; 0 if String was NOT found.
     */
    @Override
    public int findPreviousString(String toFind) {

        for (int index = searchLocation; index - toFind.length() >= 0; index--) {
            if (toFind.equals(match)) {
                feedback(index);
                return 1;
            }
            if (searchLocation == document.getLength()) {
                message(-1);
            }
        }
        return 0;
    }
}
