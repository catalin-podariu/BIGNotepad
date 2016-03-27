/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JTextPane;

/**
 *
 * @author Agnosto Theo
 */
public class LongLineMarker extends JTextPane {

    private JTextPane edit;

    LongLineMarker(JTextPane edit) {
        this.edit = edit;
    }

    public void drawLongLineMarker() {
        paint(edit.getGraphics());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        FontMetrics fontMetrics = g.getFontMetrics();
        int pageWidth = fontMetrics.charWidth('m') * 72;
        g.setColor(Color.DARK_GRAY);
        g.drawLine(pageWidth, 0, pageWidth, edit.getHeight());
        
    }
}
