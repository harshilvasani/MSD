package resources.pubrec;

public class Inproceeding{
	
	private int id;
	private String key;
	private String authorName;
	private String title;
	private String year;
	private String crossref;
	private String booktitle;
	private String conference;
	
	public Inproceeding(){
		
	}
	
	public Inproceeding(int id, String key, String authorName, String title, String year, String crossref,
			String booktitle) {
		super();
		this.id = id;
		this.key = key;
		this.conference = key.split("/")[1];
		this.authorName = authorName;
		this.title = title;
		this.year = year;
		this.crossref = crossref;
		this.booktitle = booktitle;
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
		this.conference = key.split("/")[1];
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
	
	public String getCrossref() {
		return crossref;
	}
	public void setCrossref(String crossref) {
		this.crossref = crossref;
	}

	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConference() {
		return this.conference;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Inproceeding) {
			Inproceeding i = (Inproceeding) obj;
			return this.key.equals(i.key) &&
					this.title.equals(i.title);
		}
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	
	@Override
	public int hashCode() {
		//System.out.println(this.key.hashCode());
		return (this.key + this.title).hashCode();
	}
}