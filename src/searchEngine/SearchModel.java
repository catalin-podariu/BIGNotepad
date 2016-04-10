package searchEngine;

import java.awt.Component;
import java.util.LinkedList;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class SearchModel {

	private SearchModel() {
	}

	public static SearchModel valueOf() {
		return new SearchModel();
	}

	public void getUserSelectedSearchMode(JPanel panel) {
		StringBuilder searchMode = new StringBuilder();
		Component[] allComponentsInsidePanel = panel.getComponents();
		for (Component item : allComponentsInsidePanel) {
			if (item instanceof JCheckBox) {
				if (((JCheckBox) item).isSelected()) {
					searchMode.append(item.getName());
				}
			}
		}
		if (searchMode.length() == 0) {
			goToDefaultSearchMode();
		} else {
			// TODO catalin.podariu searchMode.toString();
		}
	}

	private void goToDefaultSearchMode() {
		// TODO catalin.podariu default search, ignore case
		
	}
}
