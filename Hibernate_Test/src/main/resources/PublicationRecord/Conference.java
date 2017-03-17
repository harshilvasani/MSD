package resources.PublicationRecord;

public class Conference {
	
	private Integer id;
	private String confKey;
	private String confName;
	private String detail;

	public Conference() {
	}

	public Conference(String confKey, String confName, String detail) {
		 this.setConfKey(confKey);
		 this.setConfName(confName);
		 this.setDetail(detail);
	}

	public String getConfKey() {
		return confKey;
	}

	public void setConfKey(String confKey) {
		this.confKey = confKey;
	}

	public String getConfName() {
		return confName;
	}

	public void setConfName(String confName) {
		this.confName = confName;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}

}
