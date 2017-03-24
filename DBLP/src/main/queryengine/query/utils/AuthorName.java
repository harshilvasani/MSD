package queryengine.query.utils;

import queryengine.interfaces.ICoAuthorSearch;

public class AuthorName implements ICoAuthorSearch{
	private String authorName;

	public AuthorName(String authorName) {
		this.authorName = authorName.toLowerCase();
	}
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName.toLowerCase();
	}
}
