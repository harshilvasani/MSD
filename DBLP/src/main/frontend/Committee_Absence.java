package frontend;
import queryengine.interfaces.ISearch;

public class Committee_Absence implements ISearch{
	private int years;
	public Committee_Absence(int years){
		this.years = years;
	}
	public void setAbsenceYears(int years){
		this.years = years;
	}
	public int getAbsenceYears(int years){
		return this.years;
	}
}
