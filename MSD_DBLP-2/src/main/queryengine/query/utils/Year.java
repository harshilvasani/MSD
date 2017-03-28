package queryengine.query.utils;

import queryengine.interfaces.ISearch;

public class Year implements ISearch{
	private int year;
	
	public Year(int year) {
		super();
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = Integer.parseInt(year);
	}

	public Year(String searchYear) {
		this.year = Integer.parseInt(searchYear);
	}
}
