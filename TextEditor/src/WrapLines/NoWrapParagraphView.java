package WrapLines;

import javax.swing.text.*;

public class NoWrapParagraphView extends ParagraphView {
    public NoWrapParagraphView(Element elem) {
        super(elem);
    }

    @Override
    public void layout(int width, int height) {
        super.layout(Short.MAX_VALUE, height);
    }

    @Override
    public float getMinimumSpan(int axis) {
        return super.getPreferredSpan(axis);
    }
}
