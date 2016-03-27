/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

/**
 * @author Stanislav Lapitsky
 * @version 1.0
 */
import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;
import javax.swing.text.*;

public class Zoom extends JTextPane {

    private JTextPane component;
    protected static double inc;

    public Zoom(JTextPane component, int increment) {
        super();
        this.component = component;
        if(increment == 0){
            inc-=10;
        } else if(increment == 1){
            inc-=10;
        }
        final SimpleAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setFontSize(attrs, 12);
        setEditorKit(new ScaledEditorKit());
        StyledDocument doc = (StyledDocument) component.getDocument();
        doc.setCharacterAttributes(0, 1, attrs, true);
        try {
            StyledDocument doc1 = (StyledDocument) component.getDocument();
            doc1.setCharacterAttributes(0, 1, attrs, true);
            doc1.insertString(0, "", null); //refresh
        } catch (Exception ex) {
        }
    }

    @Override
    public void repaint() {
        super.repaint(0, 0, getWidth(), getHeight());
    }

}

class ScaledEditorKit extends StyledEditorKit {

    @Override
    public ViewFactory getViewFactory() {
        return new StyledViewFactory();
    }

    class StyledViewFactory implements ViewFactory {

        @Override
        public View create(Element elem) {
            String kind = elem.getName();
            if (kind != null) {
                switch (kind) {
                    case AbstractDocument.ContentElementName:
                        return new LabelView(elem);
                    case AbstractDocument.ParagraphElementName:
                        return new ParagraphView(elem);
                    case AbstractDocument.SectionElementName:
                        return new ScaledView(elem, View.Y_AXIS);
                    case StyleConstants.ComponentElementName:
                        return new ComponentView(elem);
                    case StyleConstants.IconElementName:
                        return new IconView(elem);
                }
            }

            // default to text display
            return new LabelView(elem);
        }

    }
}

class ScaledView extends BoxView {

    public ScaledView(Element elem, int axis) {
        super(elem, axis);
    }

    public double getZoomFactor() {
        Double scale = Zoom.inc;
        return scale;
    }

    @Override
    public void paint(Graphics g, Shape allocation) {
        Graphics2D g2d = (Graphics2D) g;
        double zoomFactor = getZoomFactor();
        AffineTransform old = g2d.getTransform();
        g2d.scale(zoomFactor, zoomFactor);
        super.paint(g2d, allocation);
        g2d.setTransform(old);
    }

    @Override
    public float getMinimumSpan(int axis) {
        float f = super.getMinimumSpan(axis);
        f *= getZoomFactor();
        return f;
    }

    @Override
    public float getMaximumSpan(int axis) {
        float f = super.getMaximumSpan(axis);
        f *= getZoomFactor();
        return f;
    }

    @Override
    public float getPreferredSpan(int axis) {
        float f = super.getPreferredSpan(axis);
        f *= getZoomFactor();
        return f;
    }

    @Override
    protected void layout(int width, int height) {
        super.layout(new Double(width / getZoomFactor()).intValue(),
                new Double(height
                        * getZoomFactor()).intValue());
    }

    @Override
    public Shape modelToView(int pos, Shape a, Position.Bias b) throws BadLocationException {
        double zoomFactor = getZoomFactor();
        Rectangle alloc;
        alloc = a.getBounds();
        Shape s = super.modelToView(pos, alloc, b);
        alloc = s.getBounds();
        alloc.x *= zoomFactor;
        alloc.y *= zoomFactor;
        alloc.width *= zoomFactor;
        alloc.height *= zoomFactor;

        return alloc;
    }

    @Override
    public int viewToModel(float x, float y, Shape a,
            Position.Bias[] bias) {
        double zoomFactor = getZoomFactor();
        Rectangle alloc = a.getBounds();
        x /= zoomFactor;
        y /= zoomFactor;
        alloc.x /= zoomFactor;
        alloc.y /= zoomFactor;
        alloc.width /= zoomFactor;
        alloc.height /= zoomFactor;

        return super.viewToModel(x, y, alloc, bias);
    }
}
