package resources.PublicationRecord;

public class Citation {
	
	private Integer id;
	private String paperCitedKey;
	private String paperCiteKey;
	

	public Citation() {
	}

	public Citation(String paperCitedKey, String paperCiteKey) {
		 this.setPaperCitedKey(paperCitedKey);
		 this.setPaperCiteKey(paperCiteKey);
	}

	public String getPaperCitedKey() {
		return paperCitedKey;
	}

	public void setPaperCitedKey(String paperCitedKey) {
		this.paperCitedKey = paperCitedKey;
	}

	public String getPaperCiteKey() {
		return paperCiteKey;
	}

	public void setPaperCiteKey(String paperCiteKey) {
		this.paperCiteKey = paperCiteKey;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

}
