package config;

import java.util.Stack;

public class ConfigRecentSearches {

	private Stack<String> recentSearchItems;

	public ConfigRecentSearches() {
		recentSearchItems = new Stack<>();
	}

	public void addSearchItem(String searchString) {
		recentSearchItems.push(searchString);
	}

	public Object[] getAllItems() {
		return recentSearchItems.toArray();
	}

	public void getItemByIndex(int itemIndex) {
		recentSearchItems.get(itemIndex);
	}
}
