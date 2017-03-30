package resources.personrecord;

public class FavoriteStat implements IPerson{

	private String name;
	private int totalPublications;
	private int mostPublications;
	private String publicationTitle;
	
	public FavoriteStat(String name, int totalPublications, int mostPublications, String publicationTitle) {
		this.name = name;
		this.totalPublications = totalPublications;
		this.mostPublications = mostPublications;
		this.publicationTitle = publicationTitle;
	}

	public int getTotalPublications() {
		return this.totalPublications;
	}
	
	public int getMostPublications() {
		return this.mostPublications;
	}
	
	@Override
	public String getPersonName() {
		return this.name;
	}

	@Override
	public void setPersonName(String name) {
		this.name = name;
	}

	public String getPublicationTitle() {
		return publicationTitle;
	}

	public void setPublicationTitle(String publicationTitle) {
		this.publicationTitle = publicationTitle;
	}
}
