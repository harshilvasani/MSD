package frontEnd.parser.publicationrecord;

import java.util.List;

import javax.xml.bind.annotation.*;

public class Proceeding {
		
	private String key;
	private List<String> editor;
	private String title;
	private String year;
	private String booktitle;
	private String series;
	private String publisher;
	
	
	public Proceeding(){
		
	}

	public Proceeding(String key, List<String> editor, String title, String year, String booktitle, String series,
			String publisher) {
		super();
		this.key = key;
		this.editor = editor;
		this.title = title;
		this.year = year;
		this.booktitle = booktitle;
		this.series = series;
		this.publisher = publisher;
	}
	
	@XmlAttribute
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	@XmlElement
	public List<String> getEditor() {
		return editor;
	}
	public void setEditor(List<String> editor) {
		this.editor = editor;
	}

	@XmlElement
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	@XmlElement
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	@XmlElement
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}

	@XmlElement
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
