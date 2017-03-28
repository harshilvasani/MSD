package resources.publicationrecord;

public class PhdThesis{
	
	private int id;
	private String key;
	private String authorName;
	private String title;
	private String year;
	private String school;
	
	public PhdThesis(){
		
	}
	
	public PhdThesis(int id, String key, String authorName, String title, String year, String school) {
		super();
		this.setId(id);
		this.key = key;
		this.setAuthorName(authorName);
		this.title = title;
		this.year = year;
		this.school = school;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
