package queryengine.query.utils;

import java.util.List;

import queryengine.interfaces.IFavorite;

public class Favorite implements IFavorite{

	private String username; // This is username of the signed in user who adds favorites
	private List<String> authorNames;
	
	public Favorite(String username, List<String> authorNames) {
		this.username = username;
		this.authorNames = authorNames;
	}
	
	public List<String> getAuthorNames() {
		return this.authorNames;
	}
	
	public String getUser() {
		return this.username;
	}
}
