package resources.pubrec;

public class Incollection{
	
	private int id;
	private String key;
	private String authorName;
	private String title;
	private String year;
	private String booktitle;
	private String crossref;
	private String journal;
	
	public Incollection(){
		
	}
	
	public Incollection(int id, String key, String authorName, String title, String year, String booktitle,
			String crossref) {
		super();
		this.setId(id);
		this.key = key;
		this.journal = key.split("/")[1];
		this.authorName = authorName;
		this.title = title;
		this.year = year;
		this.booktitle = booktitle;
		this.crossref = crossref;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
		this.journal = key.split("/")[1];
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
	
	public String getCrossref() {
		return crossref;
	}
	public void setCrossref(String crossref) {
		this.crossref = crossref;
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
	
	public String getJournal() {
		return this.journal;
	}
	
	@Override
	public int hashCode() {
		return (this.key + this.title).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Incollection) {
			Incollection i = (Incollection) obj;
			return this.key.equals(i.key) && this.title.equals(i.title);
		}
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}