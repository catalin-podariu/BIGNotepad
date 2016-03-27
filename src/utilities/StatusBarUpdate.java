/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.Utilities;

import gui.BIGNotepad;

/**
 *
 * @author Agnosto Theo
 */
public class StatusBarUpdate extends BIGNotepad {

    /**
     * Line Counter.
     * <br>
     * It counts the total number of lines in the document and displays this in
     * the status bar.
     * <br>
     *
     * @param comp the component to count the lines in
     * @return an integer representing total number of lines in current
     * document.
     */
    static int lineCounter(JTextComponent comp) {
        // using comp.getText().getLength() throws a BadLocationException
        int chars = comp.getDocument().getLength();
        int lineCount = (chars == 0) ? 1 : 0;
        int lineOffset = chars;
        try {
            while (lineOffset >= 0) {
                lineOffset = Utilities.getRowStart(comp, lineOffset) - 1;
                lineCount++;
            }
        } catch (BadLocationException ex) {
            System.err.println(ex);
        }
        return lineCount;
    }

    /**
     * Get the current line number.
     * <br>
     *
     * @param comp the component (JTextPane)
     * @param cursorPosition current cursor position
     * @return an integer representing the line number
     */
    static int getCurrentLineNumber(JTextComponent comp, int cursorPosition) {
        Document doc = comp.getDocument();
        if (cursorPosition < 0) {
            System.err.println("offset smaller than document length");
        } else if (cursorPosition > doc.getLength()) {
            System.err.println("offset bigger than document length");
        } else {
            Element map = doc.getDefaultRootElement();
            return map.getElementIndex(cursorPosition);
        }
        return 0;
    }

//    /**
//     * Line start offset.
//     * <br>
//     * Keep track of the offset inside a certain line, in the text document.
//     * <br>
//     *
//     * @param comp the component to count the lines in
//     * @param lineNumber get current line number from cursor position
//     * @return an integer representing the offset.
//     */
//    static int getLineStartOffset(JTextComponent comp, int lineNumber) {
//        Element map = comp.getDocument().getDefaultRootElement();
//        if (lineNumber < 0) {
//        } else if (lineNumber >= map.getElementCount()) {
//        } else {
//            Element lineElem = map.getElement(lineNumber);
//            return lineElem.getStartOffset();
//        }
//        return 0;
//    }
}
