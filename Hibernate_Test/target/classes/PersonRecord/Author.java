package resources.PersonRecord;

public class Author {
	
	private Integer id;
	private String paperKey;
	private String authorName;
	

	public Author() {
	}

	public Author(String paperKey, String authorName) {
		 this.setPaperKey(paperKey);
		 this.setAuthorName(authorName);
	}

	public String getPaperKey() {
		return paperKey;
	}

	public void setPaperKey(String paperKey) {
		this.paperKey = paperKey;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
}
