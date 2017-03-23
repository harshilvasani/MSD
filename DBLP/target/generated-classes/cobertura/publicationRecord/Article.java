package resources.publicationRecord;

public class Article {
		
	private int id;
	private String key;
	private String authorName;
	private String title;
	private String year;
	private String journalName;
		
	public Article(){
		
	}
		
	public Article(int id, String key, String authorName, String title, String year, String journalName) {

		this.id = id;
		this.key = key;
		this.authorName = authorName;
		this.title = title;
		this.year = year;
		this.journalName = journalName;
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String author) {
		this.authorName = author;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJournalName() {
		return journalName;
	}

	public void setJournalName(String journalName) {
		this.journalName = journalName;
	}
}
