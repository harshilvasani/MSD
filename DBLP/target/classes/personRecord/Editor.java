package resources.personRecord;

import java.util.List;

public class Editor implements IPerson{

	private int id;
	private String name;
	private List<Integer> proceedingIdsEdited;
	private List<Integer> bookIdsEdited;

	public Editor(){

	}

	public Editor(int id, String name, List<Integer> proceedingIdsEdited, List<Integer> bookIdsEdited) {
		super();
		this.id = id;
		this.name = name;
		this.proceedingIdsEdited = proceedingIdsEdited;
		this.bookIdsEdited = bookIdsEdited;
	}

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

	public List<Integer> getProceedingIdsEdited() {
		return proceedingIdsEdited;
	}
	public void setProceedingIdsEdited(List<Integer> proceedingIdsEdited) {
		this.proceedingIdsEdited = proceedingIdsEdited;
	}

	public List<Integer> getBookIdsEdited() {
		return bookIdsEdited;
	}
	public void setBookIdsEdited(List<Integer> bookIdsEdited) {
		this.bookIdsEdited = bookIdsEdited;
	}
}
