package frontEnd.parser.publicationRecord;

import java.util.List;

import javax.xml.bind.annotation.*;

public class Article {
		
	private String key;
	private List<String> author;
	private String title;
	private String year;
	private String journal;
		
	public Article(){
		
	}
	
	public Article(String key, List<String> author, String title, String year, String journal) {
		super();
		this.key = key;
		this.author = author;
		this.title = title;
		this.year = year;
		this.journal = journal;
	}
	
	@XmlAttribute
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	@XmlElement
	public List<String> getAuthor() {
		return author;
	}
	public void setAuthor(List<String> author) {
		this.author = author;
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
	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}
}
