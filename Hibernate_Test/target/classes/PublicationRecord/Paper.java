package resources.PublicationRecord;

public class Paper {
	
	private Integer id;
	private String paperKey;
	private String title;
	private Integer year;
	private String conference;
	
	public Paper() {
	}

	public Paper(String paperKey, String title, Integer year, String conference) {
		 this.setPaperKey(paperKey);
		 this.setTitle(title);
		 this.setYear(year);
		 this.setConference(conference);
	}

	public String getPaperKey() {
		return paperKey;
	}

	public void setPaperKey(String paperKey) {
		this.paperKey = paperKey;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getConference() {
		return conference;
	}

	public void setConference(String conference) {
		this.conference = conference;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
}
