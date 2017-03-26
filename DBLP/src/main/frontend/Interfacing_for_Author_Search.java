package frontend;
import java.util.ArrayList;
import java.util.List;

import queryengine.app.App;
import queryengine.interfaces.IQuery;
import queryengine.interfaces.ISearch;
import queryengine.query.utils.AbsenceFromCommittees;
import queryengine.query.utils.Conferences;
import queryengine.query.utils.Title;
import queryengine.query.utils.Year;
import resources.person.IPerson;
import validator.utils.Validator;

public class Interfacing_for_Author_Search {
	private String titleText;
	private String searchYear;
	private String journalName;
	private String absenceYears;
	private String authorNameContains;
	private String minimumPublications;
	private String favoriteAuthor;
	private List<IPerson> result;
	
	public Interfacing_for_Author_Search(String titleText, String searchYear,
			String journalName, String absenceYears){
		this.titleText = titleText;
		this.searchYear = searchYear;
		this.journalName = journalName;
		this.absenceYears = absenceYears;
	}
	
	public List<IPerson> sendSearchCriteriaToApp(){
		App app = new App();
		List<ISearch> searchCriteria = new ArrayList<ISearch>();
		if (Validator.isNonEmptyString(this.titleText)) 
			searchCriteria.add(new Title(this.titleText));
		if (Validator.isValidN(this.searchYear)) 	
			searchCriteria.add(new Year(this.searchYear));
		if (Validator.isNonEmptyString(this.journalName)) 	
			searchCriteria.add(new Conferences(this.journalName));
		searchCriteria.add(new AbsenceFromCommittees(absenceYears));
		this.result = app.search(searchCriteria);
		return this.result;
	}
}
