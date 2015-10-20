/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

//import java.util.regex.Pattern;
//import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author Agnosto Theo
 */
public class FindReplace extends BIGNotepad {

    private int currentSearchLocation;
    private Document doc;
    private String toFind;
    private String replaceWith;

    // find check boxes
    private boolean fMmatchCase;
    private boolean fWholeWord;
    private boolean fWordStart;
    private boolean fRegex;

    // replace check boxes
    private boolean rBMatchCase;
    private boolean rBWholeWord;
    private boolean rBWordStart;
    private boolean rBRegex;

    public FindReplace() {
        this.currentSearchLocation = bigEdit.getCaretPosition();
        this.doc = bigEdit.getDocument();

        // find check boxes
        this.fMmatchCase = findDMatchCase.isSelected();
        this.fRegex = findDRegex.isSelected();
        this.fWordStart = findDMatchWordStart.isSelected();
        this.fWholeWord = findDMatchWord.isSelected();

        // replace check boxes
        this.rBRegex = replaceDRegex.isSelected();
        this.rBWordStart = replaceDMatchWordStart.isSelected();
        this.rBWholeWord = replaceDMatchWord.isSelected();
        this.rBMatchCase = replaceDMatchCase.isSelected();
    }

    
    
    
//    private void replace(int index) {
//        if (replaceDReplaceCombo.getSelectedItem() != null
//                & findDSearchCombo.getSelectedItem() != null) {
//            replaceWith = replaceDReplaceCombo.getSelectedItem().toString();
//            bigEdit.requestFocus();
//            try {
//                doc.remove(index, toFind.length());
//                doc.insertString(index, replaceWith, attrs);
//            } catch (BadLocationException ex) {
//                System.err.println("replace() error: " + ex);
//            }
//            // find and select the following String
////            findNextString();
//        } else {
//            toFind = "";
//            replaceWith = "";
//            JOptionPane.showConfirmDialog(this,
//                    "Either find string or replace with string are null",
//                    "No string found..",
//                    JOptionPane.PLAIN_MESSAGE);
//        }
//    }
}
