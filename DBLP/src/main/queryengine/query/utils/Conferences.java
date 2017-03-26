package queryengine.query.utils;

import queryengine.interfaces.ISearch;

public class Conferences implements ISearch{

	private String conferences[];
	
	public Conferences(String conferencesCommaSep) {
		this.conferences = conferencesCommaSep.toLowerCase().split("\\s*,\\s*");
	}
	
	public void setConferences(String conferencesCommaSep) {
		this.conferences = conferencesCommaSep.toLowerCase().split("\\s*,\\s*");
	}
	
	public String[] getConferences() {
		return this.conferences;
	}
}
