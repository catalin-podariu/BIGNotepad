/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Searcher;

/**
 * Whole Words.
 * <br>
 * Matches the search text only to whole words in the file. Does not match words
 * that contain but do not exactly equal the search text. Text separated by
 * periods (for example, javax.swing.jPanel) is considered to be separate whole
 * words. For example, if the search word is add and the Match Whole Words Only
 * option is not selected, jPanel.add and blueSlider.addChangeListener both
 * contain matches. If Match Whole Words Only is selected, only jPanel.add
 * contains a match.
 *
 * @author mrbigheart
 */
public class WholeWord {

}
