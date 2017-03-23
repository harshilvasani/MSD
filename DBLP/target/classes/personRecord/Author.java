package resources.personRecord;

public class Author implements IPerson{
	private enum PublicationType { article, incollection, inproceeding, phdthesis }
	
	private int id;
	private String name;
	private Integer publicationId;// can be article, incollection, inproceeding or phdthesis
	private String publicationTitle;
	private String publicationYear;
	private PublicationType publicationType;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String getPersonName() {
		return name;
	}
	@Override
	public void setPersonName(String name) {
		this.name = name;
	}
	
	public Integer getPublicationId() {
		return publicationId;
	}
	public void setPublicationId(Integer publicationId) {
		this.publicationId = publicationId;
	}
	
	public String getPublicationTitle() {
		return publicationTitle;
	}
	public void setPublicationTitle(String publicationTitle) {
		this.publicationTitle = publicationTitle;
	}
	
	public String getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	public PublicationType getPublicationType() {
		return publicationType;
	}
	public void setPublicationType(String publicationType) {
		this.publicationType = PublicationType.valueOf(publicationType);
	}	
}
