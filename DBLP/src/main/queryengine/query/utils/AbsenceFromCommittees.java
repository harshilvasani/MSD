package queryengine.query.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.time.Year;

import persistence.Data;
import queryengine.interfaces.ISearch;
import resources.pubrec.CommitteeMember;

public class AbsenceFromCommittees implements ISearch {

	private int absenceYears;
	private Set<String> invalidCommitteeMembers;
	
	public AbsenceFromCommittees(String absenceYears) {
		this.absenceYears = Integer.parseInt(absenceYears);
		List<CommitteeMember> allCommitteeMembers = Data.getCommitteeMembers();
		int validTillYear = Year.now().getValue() - Integer.parseInt(absenceYears);
		this.invalidCommitteeMembers = new HashSet<String>();
		for (CommitteeMember member: allCommitteeMembers) {
			if (Integer.parseInt(member.getYear()) > validTillYear) {
				this.invalidCommitteeMembers.add(member.getMemberName());
			}
		}
	}
	
	public void setAbsence(String absenceYears) {
		this.absenceYears = Integer.parseInt(absenceYears);
		List<CommitteeMember> allCommitteeMembers = Data.getCommitteeMembers();
		int validTillYear = Year.now().getValue() - Integer.parseInt(absenceYears);
		this.invalidCommitteeMembers = new HashSet<String>();
		for (CommitteeMember member: allCommitteeMembers) {
			if (Integer.parseInt(member.getYear()) > validTillYear) {
				this.invalidCommitteeMembers.add(member.getMemberName());
			}
		}
	}
	
	public int getAbsenceYears() {
		return this.absenceYears;
	}
	
	public Set<String> getInvalidCommitteeMembers(){
		return this.invalidCommitteeMembers;
	}
}