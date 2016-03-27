/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchEngine;

import gui.BIGNotepad;

/**
 *
 * @author Agnosto Theo
 */
public class FindMode {

    public FindMode(BIGNotepad pad) {
        this.pad = pad;
        this.matchCase = this.pad.findDMatchCase.isSelected();
        this.wholeWord = this.pad.findDMatchWord.isSelected();
        this.wordStart = this.pad.findDMatchWordStart.isSelected();
        this.selection = this.pad.findDSelectedText.isSelected();
        this.regex = this.pad.findDRegex.isSelected();
        this.incremental = this.pad.incrementalSearchCombo.isSelected();
        this.highlight = this.pad.highlightSearchCombo.isSelected();
    }

    /**
     * Find Mode.
     * <br>
     * Decides which options will be used to search for a given String.<br>
     * <br>
     * You can find below all the cases:<br>
     * ignoreCase = 0<br>
     * matchCase = 1<br>
     * wholeWord = 2<br>
     * wordStart = 3<br>
     * regex = 4<br>
     *
     * @return a case or a combination of cases<br>
     * ie. 0 - ignore case. 2 - whole word.<br>
     * 20 - ignore case AND whole word. ('02' is not an integer!)
     */
    public final int findMode() {
        int mode = -1;
        if (regex) {
            matchCase = false;
            wholeWord = false;
            wordStart = false;

        } else if (matchCase & !wholeWord | !wordStart) {

        } else if (wholeWord & !matchCase | !wordStart) {

        } else if (wordStart & !matchCase | !wholeWord) {

        }

        // other options
        if (selection) {

        }
        if (incremental) {

        }
        if (highlight) {

        }

        return mode;
    }

    private boolean matchCase, wholeWord, wordStart,
            selection, regex, incremental, highlight;

    private BIGNotepad pad;
}
