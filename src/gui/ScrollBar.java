package gui;

import javax.swing.JScrollBar;

/**
 * <br>
 * Modify the incremented value (default is 50 ~4 lines of text)
 *
 * @author catalin.podariu[at]gmail.com
 */
public class ScrollBar {

	java.awt.event.MouseWheelEvent mouseWheelEvent;

	public ScrollBar(java.awt.event.MouseWheelEvent mouseWheelEvent) {
		this.mouseWheelEvent = mouseWheelEvent;
	}

	public int adjustScrollBar(JScrollBar scrollBar) {
		int previousValue = scrollBar.getValue();
		int max = scrollBar.getMaximum() - scrollBar.getVisibleAmount();
		if (mouseWheelEvent.getWheelRotation() < 0) {
			if (scrollBar.getValue() == 0 && previousValue == 0) {
			} else {
				return previousValue -= 50;
			}
		} else if (mouseWheelEvent.getWheelRotation() > 0) {
			if (scrollBar.getValue() == max && previousValue == max) {
				return scrollBar.getMaximum();
			} else {
				return previousValue += 50;
			}
		}
		return 0;
	}
}