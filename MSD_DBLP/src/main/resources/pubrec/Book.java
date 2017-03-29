package resources.pubrec;

public class Book {
	
	private int id;
	private String key;
	private String editorName;
	private String title;
	private String year;
	private String publisherName;
	
	public Book(){
		
	}
		
	public Book(int id, String key, String editorName, String title, String year, String publisherName) {
		super();
		this.id = id;
		this.key = key;
		this.editorName = editorName;
		this.title = title;
		this.year = year;
		this.setPublisherName(publisherName);
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getEditorName() {
		return editorName;
	}
	public void setEditorName(String editorName) {
		this.editorName = editorName;
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

	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
}
