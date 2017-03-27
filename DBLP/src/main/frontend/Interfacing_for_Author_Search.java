package frontend;
import java.util.ArrayList;
import java.util.List;

import queryengine.app.App;
import queryengine.interfaces.IFilter;
import queryengine.interfaces.IQuery;
import queryengine.interfaces.ISearch;
import queryengine.query.utils.AbsenceFromCommittees;
import queryengine.query.utils.AuthorName;
import queryengine.query.utils.Conferences;
import queryengine.query.utils.MinPublications;
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
	private String minimumPublication;
	private List<IPerson> result;
	
	public Interfacing_for_Author_Search(String titleText, String searchYear,
			String journalName, String absenceYears){
		this.titleText = titleText;
		this.searchYear = searchYear;
		this.journalName = journalName;
		this.absenceYears = absenceYears;
	}
	
	public void setFilters(String authorNameContains, String minimumPublications){
		this.authorNameContains = authorNameContains;
		this.minimumPublication = minimumPublication;
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
		if (Validator.isValidN(this.absenceYears))
			searchCriteria.add(new AbsenceFromCommittees(absenceYears));
		this.result = app.search(searchCriteria);
		return this.result;
	}
	
	public List<IPerson> sendFiltersToApp(){
		App app = new App();
		List<IFilter> filterCriteria = new ArrayList<IFilter>();
		
		if (Validator.isNonEmptyString(this.authorNameContains)) 
			filterCriteria.add(new AuthorName(this.authorNameContains));
		if (Validator.isValidN(this.minimumPublication)) 	
			filterCriteria.add(new MinPublications(this.minimumPublication));
		
		this.result = app.filter(filterCriteria, result);
		return this.result;
	}
}
