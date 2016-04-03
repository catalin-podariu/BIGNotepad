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

	// this is only reached if selectedCheckBoxes > 0
	private void checkSelectedCheckBoxesValues() {
		selectedBoxesValues = new LinkedList<>();
		for (int index = 0; index < allCheckBoxesValues.size(); index++) {
			int boxValue = allCheckBoxesValues.get(index);
			if (boxValue == Type.get().IGNORE_CASE) {
				selectedBoxesValues.add(boxValue);
			}
		}
	}

	private void getUserSelectedSearchMode(JPanel panel) {
		allCheckBoxesValues = new LinkedList<>();
		Component[] allComponentsInsidePanel = panel.getComponents();
		for (Component item : allComponentsInsidePanel) {
			if (item instanceof JCheckBox) {
				if (((JCheckBox) item).isSelected()) {
					allCheckBoxesValues.add(Integer.valueOf(item.getName()));
				}
			}
		}
		if (allCheckBoxesValues.size() == 0) {
			goToDefaultSearchMode();
		}
	}

	private void goToDefaultSearchMode() {
		// TODO catalin.podariu default search, ignore case
	}

	LinkedList<Integer> allCheckBoxesValues;
	LinkedList<Integer> selectedBoxesValues;
}
