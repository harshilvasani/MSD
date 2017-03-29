package resources.personrecord;

public class FavoriteStat implements IPerson{

	private String name;
	private int totalPublications;
	private String mostPublications;
	
	public FavoriteStat(String name, int totalPublications, String mostPublications) {
		this.name = name;
		this.totalPublications = totalPublications;
		this.mostPublications = mostPublications;
	}

	public int getTotalPublications() {
		return this.totalPublications;
	}
	
	public String getMostPublications() {
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
}
