package queryengine.query.utils;

import java.util.List;

import queryengine.interfaces.IFavorite;

public class Favorite implements IFavorite{

	private List<String> authorNames;
	
	public Favorite(List<String> authorNames) {
		this.authorNames = authorNames;
	}
	
	public List<String> getAuthorNames() {
		return this.authorNames;
	}
}
