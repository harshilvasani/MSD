package queryengine.query.utils;

import queryengine.interfaces.ISearch;

public class Title implements ISearch {
	private String[] keys;

	public Title(String keys) {
		this.keys = keys.toLowerCase().split("\\s+");
	}
	
	public String[] getKeys() {
		return keys;
	}

	public void setTitle(String keys) {
		this.keys = keys.toLowerCase().split("\\s+");
	}
}
