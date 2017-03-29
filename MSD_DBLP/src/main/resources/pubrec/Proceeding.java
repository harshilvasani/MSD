package resources.pubrec;

public class Proceeding {
		
	private int id;
	private String key;
	private String editorName;
	private String title;
	private String year;
	private String booktitle;
	private String series;
	private String publisher;
	
	public Proceeding(){
		
	}
	
	public Proceeding(int id, String key, String editorName, String title, String year, String booktitle, String series,
			String publisher) {
		super();
		this.id = id;
		this.key = key;
		this.editorName = editorName;
		this.title = title;
		this.year = year;
		this.booktitle = booktitle;
		this.series = series;
		this.publisher = publisher;
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

	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}

	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getEditorName() {
		return editorName;
	}
	public void setEditorName(String editorName) {
		this.editorName = editorName;
	}
}