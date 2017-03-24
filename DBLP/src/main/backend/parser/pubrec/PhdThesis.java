package backend.parser.pubrec;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class PhdThesis {
	
	private String key;
	private String author;
	private String title;
	private String year;
	private String school;
	
	public PhdThesis(){
		
	}
	
	public PhdThesis(String key, String author, String title, String year, String school) {
		super();
		this.key = key;
		this.author = author;
		this.title = title;
		this.year = year;
		this.school = school;
	}
	
	@XmlAttribute
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	@XmlElement
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
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
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
}
