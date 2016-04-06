package config;

import java.util.Stack;

public class ConfigRecentFiles {

	private Stack<String> recentFileItems;

	public ConfigRecentFiles() {
		recentFileItems = new Stack<>();
	}

	public void addRecentFile(String recentFileName) {
		recentFileItems.push(recentFileName);
	}

	public Object[] getAllItems() {
		return recentFileItems.toArray();
	}

	public void getItemByIndex(int itemIndex) {
		recentFileItems.get(itemIndex);
	}
}
