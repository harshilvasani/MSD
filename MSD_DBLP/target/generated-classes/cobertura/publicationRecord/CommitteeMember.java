package resources.publicationrecord;

public class CommitteeMember {
	
	private int id;
	private String confName;
	private String year;
	private String memberName;
	private String position;

	public CommitteeMember(){
		
	}
	
	public CommitteeMember(int id, String confName, String year, String memberName, String position) {
		super();
		this.id = id;
		this.confName = confName;
		this.year = year;
		this.memberName = memberName;
		this.position = position;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getConfName() {
		return confName;
	}
	public void setConfName(String confName) {
		this.confName = confName;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
}
