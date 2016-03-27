/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchEngine;

/**
 *
 * @author Agnosto Theo
 */
public class test {

    public void getOptions(
            boolean matchCase,
            boolean wholeWord,
            boolean regex,
            boolean wrapAround) {
        
        if(matchCase & !wholeWord & !regex & !wrapAround){
            // MATCH CASE
        } else if (matchCase & wholeWord & !regex & !wrapAround){
            // MATCH CASE WHOLE WORDS ONLY
        } else if (matchCase & wholeWord & regex & !wrapAround){
            // REGEX SEARCH
            matchCase = false;
            wholeWord = false;
        } else if (matchCase & wholeWord & regex & wrapAround){
            // REGEX SEARCH WITH WRAP AROUND
            matchCase = false;
            wholeWord = false;
        }
        
    }

}
