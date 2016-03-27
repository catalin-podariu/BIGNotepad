/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import config.ConfigOLD;
import config.IconHandler;

/**
 *
 * @author catalin.podariu[at]gmail.com
 */
public class AboutDialog {


    private AboutDialog(BIGNotepad notepad) {
        this.notepad = notepad;
        initComponents();
        aboutDialog.setVisible(true);
    }

    public static AboutDialog display(BIGNotepad pad) {
        return new AboutDialog(pad);
    }
    
    private void initComponents(){
    	new AboutDialogComponents(this).initComponents();
    }

    public void initDialogContents() {
        aboutDialog.setLocationRelativeTo(notepad);
        
        ImageIcon authorImageIcon = IconHandler.getIcon()
                .getImageIcon("/Resources/images/author.png");
        ImageIcon softwareImageIcon = IconHandler.getIcon()
                .getImageIcon("/Resources/images/software.gif");

        if (authorImageIcon != null & softwareImageIcon != null) {
            aboutPane.addTab("About Author", authorImageIcon,
                    aboutAuthorPanel);
            aboutPane.addTab("About Software", softwareImageIcon,
                    aboutSoftwarePanel);
        } else {
            JOptionPane.showConfirmDialog(null,
                    "AboutDialog: Something went wrong..",
                    "BIGNotepad message",
                    JOptionPane.PLAIN_MESSAGE);
        }

        getDialogTextFromPropertiesFile();
    }

	private void getDialogTextFromPropertiesFile() {
		ConfigOLD config = new ConfigOLD(notepad.defaultTempFolder);
        String[] properties = config.getInfo();
        aboutAuthorText.setText(properties[0]);
        aboutSoftwareText.setText(properties[1]);
        aboutSoftwareText.setCaretPosition(0);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        clickable.setToolTipText("<html><p width=\"250\">"
        		+ properties[2] + "</p></html>");
        aboutSoftwareText.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(5, 7, 7, 7)));
        aboutAuthorText.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(5, 7, 7, 7)));
        aboutPane.setMnemonicAt(0, KeyEvent.VK_1);
        aboutPane.setMnemonicAt(1, KeyEvent.VK_2);
	}
    
    void aboutDialogComponentShown(java.awt.event.ComponentEvent evt) {
		if (aboutAuthorText.getText().length() == 0) {
			initDialogContents();
		}
	}
    
    protected javax.swing.JScrollPane aboutAuthorP;
	protected javax.swing.JPanel aboutAuthorPanel;
	protected javax.swing.JTextArea aboutAuthorText;
	protected javax.swing.JDialog aboutDialog;
	protected javax.swing.JTabbedPane aboutPane;
	protected javax.swing.JScrollPane aboutSoftwareP;
	protected javax.swing.JLabel clickable;
	protected javax.swing.JPanel aboutSoftwarePanel;
	protected javax.swing.JTextArea aboutSoftwareText;
    
    private BIGNotepad notepad;
}
