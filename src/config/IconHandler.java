package config;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author catalin.podariu[at]gmail.com
 */
public class IconHandler {

	private URL insideIDEorJAR;

	private IconHandler() {
		insideIDEorJAR = getClass().getResource("/Resources/images/notepad.png");
	}

	public static IconHandler getIcon() {
		return new IconHandler();
	}

	public Icon getIcon(String path) {
		if (insideIDEorJAR.toString().startsWith("jar:")) {
			return new ImageIcon(getClass().getResource(path));
		} else {
			try {
				path = System.getProperty("user.dir") + "\\src" + path.replace('/', '\\');
				return new ImageIcon(ImageIO.read(new File(path)));
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}
		return null;
	}

	public Image getImage(String path) {
		if (insideIDEorJAR.toString().startsWith("jar:")) {
			try {
				return ImageIO.read(getClass().getResource(path));
			} catch (IOException ex) {
				System.err.println(ex);
			}
		} else {
			try {
				path = System.getProperty("user.dir") + "\\src" + path.replace('/', '\\');
				return ImageIO.read(new File(path));
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}
		return null;
	}

	public ImageIcon getImageIcon(String path) {
		if (insideIDEorJAR.toString().startsWith("jar:")) {
			try {
				return new ImageIcon(ImageIO.read(getClass().getResource(path)));
			} catch (IOException ex) {
				System.err.println(ex);
			}
		} else {
			try {
				path = System.getProperty("user.dir") + "\\src" + path.replace('/', '\\');
				return new ImageIcon(ImageIO.read(new File(path)));
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}
		return null;
	}
}
