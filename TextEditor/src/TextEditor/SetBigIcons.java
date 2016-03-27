/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextEditor;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Agnosto Theo
 */
public class SetBigIcons extends BIGNotepad {

    private BIGNotepad pad;
    private URL ideOrJar;

    // private constructor
    private SetBigIcons(BIGNotepad pad) {
        // test a resource
        this.ideOrJar = getClass().getResource("/Resources/images/notepad.png");
        this.pad = pad;
    }

    /**
     * public static "Icon" factory.
     *
     * @param pad
     * @return
     */
    public static SetBigIcons getter(BIGNotepad pad) {
        return new SetBigIcons(pad);
    }

    /**
     *
     * @param path of the Icon to retrieve either from physical file or from JAR
     * file, stored as resource.
     * @return new Icon from the given path.
     */
    public Icon bigIcon(String path) {
        // determine if you are running this inside JAR or project (IDE)
        if (ideOrJar.toString().startsWith("jar:")) {
            // inside JAR
            return new ImageIcon(getClass().getResource(path));
        } else {
            // inside IDE
            try {
                path = System.getProperty("user.dir")
                        + "\\src" + path.replace('/', '\\');
                return new ImageIcon(ImageIO.read(new File(path)));
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        return null;
    }

    /**
     *
     * @param path of the Image to retrieve either from physical file or from
     * JAR file, stored as resource.
     * @return new Image from the given path.
     */
    public Image bigImage(String path) {
        // determine if you are running this inside JAR or project (IDE)
        if (ideOrJar.toString().startsWith("jar:")) {
            try {
                // inside JAR
                return ImageIO.read(getClass().getResource(path));
            } catch (IOException ex) {
                System.err.println(ex);
            }
        } else {
            // inside IDE
            try {
                path = System.getProperty("user.dir")
                        + "\\src" + path.replace('/', '\\');
                return ImageIO.read(new File(path));
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        return null;
    }
    
    /**
     *
     * @param path of the ImageIcon to retrieve either from physical file or from
     * JAR file, stored as resource.
     * @return new ImageIcon from the given path.
     */
    public ImageIcon bigImageIcon(String path) {
        // determine if you are running this inside JAR or project (IDE)
        if (ideOrJar.toString().startsWith("jar:")) {
            try {
                // inside JAR
                return new ImageIcon(ImageIO.read(getClass().getResource(path)));
            } catch (IOException ex) {
                System.err.println(ex);
            }
        } else {
            // inside IDE
            try {
                path = System.getProperty("user.dir")
                        + "\\src" + path.replace('/', '\\');
                return new ImageIcon(ImageIO.read(new File(path)));
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        return null;
    }

}
