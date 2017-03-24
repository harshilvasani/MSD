package backend.parser.pubrec;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Book {
	private String key;
	private List<String> editor;
	private String title;
	private String year;
	private String publisher;
	
	public Book(){
		
	}
	
	public Book(String key, List<String> editor, String title, String year, String publisher) {
		super();
		setKey(key);
		setEditor(editor);
		setTitle(title);
		setYear(year);
		setPublisher(publisher);
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
