package wrapLines;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public final class WrapApp extends JFrame {

    public static final String LINE_BREAK_ATTRIBUTE_NAME = "line_break_attribute";
    private JTextPane edit = new JTextPane();

    public WrapApp(JTextPane edit) {
        this.edit = edit;
        edit.setEditorKit(new WrapEditorKit());
        initKeyMap();
    }

    protected void insertLineBreak() {
        try {
            int offs = edit.getCaretPosition();
            Document doc = edit.getDocument();
            SimpleAttributeSet attrs;
            if (doc instanceof StyledDocument) {
                attrs = new SimpleAttributeSet(((StyledDocument) doc)
                        .getCharacterElement(offs).getAttributes());
            } else {
                attrs = new SimpleAttributeSet();
            }
            attrs.addAttribute(LINE_BREAK_ATTRIBUTE_NAME, Boolean.TRUE);
            doc.insertString(offs, "\r", attrs);
            edit.setCaretPosition(offs + 1);
        } catch (BadLocationException ex) {
        }
    }

    public void initKeyMap() {
        Keymap kMap = edit.getKeymap();
        Action a = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertLineBreak();
            }
        };
        kMap.addActionForKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,
                KeyEvent.SHIFT_MASK), a);
    }
}

class WrapEditorKit extends StyledEditorKit {

    ViewFactory defaultFactory = new WrapColumnFactory();

    @Override
    public ViewFactory getViewFactory() {
        return defaultFactory;
    }

    @Override
    public MutableAttributeSet getInputAttributes() {
        MutableAttributeSet mAttrs = super.getInputAttributes();
        mAttrs.removeAttribute(WrapApp.LINE_BREAK_ATTRIBUTE_NAME);
        return mAttrs;
    }
}

class WrapColumnFactory implements ViewFactory {

    @Override
    public View create(Element elem) {
        String kind = elem.getName();
        if (kind != null) {
            switch (kind) {
                case AbstractDocument.ContentElementName:
                    return new WrapLabelView(elem);
                case AbstractDocument.ParagraphElementName:
                    return new NoWrapParagraphView(elem);
                case AbstractDocument.SectionElementName:
                    return new BoxView(elem, View.Y_AXIS);
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
