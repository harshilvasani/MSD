package frontEnd.parser.publicationRecord;

public class CommitteeMember {
	
	private String confName;
	private String year;
	private String memberName;
	private String position;
	
	public CommitteeMember(String confName, String year, String memberName, String position) {
		super();
		this.confName = confName;
		this.year = year;
		this.memberName = memberName;
		this.position = position;
	}
	
	public String getConfName() {
		return confName;
	}
	public void setConfName(String confName) {
		this.confName = confName;
	}
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
