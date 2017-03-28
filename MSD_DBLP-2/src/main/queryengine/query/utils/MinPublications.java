package queryengine.query.utils;

import queryengine.interfaces.IFilter;

public class MinPublications implements IFilter{

	private int minPublications;
	
	public MinPublications(String minPublications) {
		this.minPublications = Integer.parseInt(minPublications);
	}
	
	public int getMinPublications() {
		return this.minPublications;
	}
}