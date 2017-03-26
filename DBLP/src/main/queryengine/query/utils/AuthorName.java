package queryengine.query.utils;

import queryengine.interfaces.ICoAuthorSearch;
import queryengine.interfaces.IFilter;

/*
 * Common Class which will be used for Finding Co-Authors and to filter by Author Name
 */
public class AuthorName implements ICoAuthorSearch, IFilter{
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