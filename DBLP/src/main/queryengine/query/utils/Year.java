package queryengine.query.utils;

import queryengine.interfaces.ISearch;

public class Year implements ISearch{
	private int year;
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Year(int year) {
		this.year = year;
	}
}
