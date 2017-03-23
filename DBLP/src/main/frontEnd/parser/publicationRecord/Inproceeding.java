package frontEnd.parser.publicationrecord;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Inproceeding {
	private String key;
	private List<String> author;
	private String title;
	private String year;
	private String crossref;
	private String booktitle;
	
	public Inproceeding(){
		
	}
	
	public Inproceeding(String key, List<String> author, String title, String year, String crossref, String booktitle) {
		super();
		this.key = key;
		this.author = author;
		this.title = title;
		this.year = year;
		this.crossref = crossref;
		this.booktitle = booktitle;
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
	public String getCrossref() {
		return crossref;
	}
	public void setCrossref(String crossref) {
		this.crossref = crossref;
	}
	
	@XmlElement
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
}
