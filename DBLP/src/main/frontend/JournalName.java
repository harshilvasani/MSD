package frontend;
import queryengine.interfaces.ISearch;

public class JournalName implements ISearch{
	private String journalName;
	public JournalName(String journalName){
		this.journalName = journalName;
	}
	public void setJournalName(String journalName){
		this.journalName = journalName;
	}
	public String getJounralName(){
		return this.journalName;
	}
}
