/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author mrbigheart
 */
public class AboutDialog {

    private BIGNotepad pad;

    private AboutDialog(BIGNotepad pad) {
        this.pad = pad;
    }

    public static AboutDialog valueOf(BIGNotepad pad) {
        return new AboutDialog(pad);
    }

    public void about() {
        pad.aboutDialog.setLocationRelativeTo(pad);
        // BIGNotepad icons path
        ImageIcon authorImageIcon = SetBigIcons.getter(pad)
                .bigImageIcon("/Resources/images/author.png");
        ImageIcon softwareImageIcon = SetBigIcons.getter(pad)
                .bigImageIcon("/Resources/images/software.gif");

        if (authorImageIcon != null & softwareImageIcon != null) {
            pad.aboutPane.addTab("About Author", authorImageIcon,
                    pad.aboutAuthorPanel);
            pad.aboutPane.addTab("About Software", softwareImageIcon,
                    pad.aboutSoftwarePanel);
        } else {
            JOptionPane.showConfirmDialog(null,
                    "AboutDialog: Something went wrong..",
                    "BIGNotepad message",
                    JOptionPane.PLAIN_MESSAGE);
        }

        Config cfg = new Config(pad.defaultTempFolder);
        String[] temp = cfg.getInfo();
        // add text to "About Author" panel
        pad.aboutAuthorText.setText(temp[0]);
        // add text to "About Software" panel
        pad.aboutSoftwareText.setText(temp[1]);
        // add 'forced' insets
        pad.aboutSoftwareText.setCaretPosition(0);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        pad.aboutSoftwareText.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(5, 7, 7, 7)));
        pad.aboutAuthorText.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(5, 7, 7, 7)));
        pad.clickable.setToolTipText("<html><p width=\"250\">"
                + temp[2] + "</p></html>");
        pad.aboutPane.setMnemonicAt(0, KeyEvent.VK_1);
        pad.aboutPane.setMnemonicAt(1, KeyEvent.VK_2);
    }
}
