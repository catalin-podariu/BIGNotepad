/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

import javax.swing.JScrollBar;

/**
 * Mouse scroll, up/down and left/right.
 * <br>
 * Modify the incremented value (default is 50 ~4 lines of text)
 *
 * @author mrbigheart
 */
public class Scroller {

    java.awt.event.MouseWheelEvent evt;

    public Scroller(java.awt.event.MouseWheelEvent evt) {
        this.evt = evt;
    }

    public int scrollBar(JScrollBar bar) {
        int previousValue = bar.getValue();
        int max = bar.getMaximum() - bar.getVisibleAmount();
        if (evt.getWheelRotation() < 0) {
            // if wheel moves up (away from the user) scroll up
            if (bar.getValue() == 0 && previousValue == 0) {
                // add message to mainErrorLabel "Reached begining of document"
            } else {
                /* increase/decrease value for multiple line/single line scroll
                 50 = 4 lines of text */
                return previousValue -= 50;
            }
            // if wheel moves down (towards the user) scroll down
        } else if (evt.getWheelRotation() > 0) {
            if (bar.getValue() == max && previousValue == max) {
                // add message to mainErrorLabel "Reached EOF"
                return bar.getMaximum();
            } else {
                /* increase/decrease value for multiple line/single line scroll
                 50 = 4 lines of text */
                return previousValue += 50;
            }
        }
        return 0;
    }
}
