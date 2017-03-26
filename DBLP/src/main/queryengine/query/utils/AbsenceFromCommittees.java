package queryengine.query.utils;

import queryengine.interfaces.ISearch;

public class AbsenceFromCommittees implements ISearch {

	private int absenceYears;
	
	public AbsenceFromCommittees(String absenceYears) {
		this.absenceYears = Integer.parseInt(absenceYears);
	}
	
	public void setAbsence(String absenceYears) {
		this.absenceYears = Integer.parseInt(absenceYears);
	}
	
	public int getAbsenceYears() {
		return this.absenceYears;
	}
}
