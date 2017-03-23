package queryengine.query.utils;

import queryengine.interfaces.ISearch;

public class Title implements ISearch {
	private String title;

	public Title(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
