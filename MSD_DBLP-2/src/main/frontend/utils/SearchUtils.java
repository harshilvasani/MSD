package frontend.utils;

import java.util.ArrayList;
import java.util.List;

import queryengine.app.App;
import queryengine.interfaces.ISearch;
import queryengine.query.utils.AbsenceFromCommittees;
import queryengine.query.utils.Conferences;
import queryengine.query.utils.Title;
import queryengine.query.utils.Year;
import resources.personrecord.IPerson;
import validator.utils.Validator;

public class SearchUtils {

	public static List<IPerson> getSearchResult(String publicationTitle, String minYear, String journalName, String absenceYears){
		
		App app = App.getTestAppInstance(10);
		List<ISearch> searchCriteria = createSearchCriteria(publicationTitle, minYear, journalName, absenceYears);
				
		List<IPerson> searchResult = app.search(searchCriteria);
		return searchResult;
	}
	
	private static List<ISearch> createSearchCriteria(String publicationTitle, String minYear, String journalName, String absenceYears){
		
		List<ISearch> searchCriteria = new ArrayList<ISearch>();
		
		if (Validator.isNonEmptyString(publicationTitle)) 
			searchCriteria.add(new Title(publicationTitle));
		
		if (Validator.isValidN(minYear)) 	
			searchCriteria.add(new Year(minYear));
		
		if (Validator.isNonEmptyString(journalName)) 	
			searchCriteria.add(new Conferences(journalName));
		
		if (Validator.isValidN(absenceYears))
			searchCriteria.add(new AbsenceFromCommittees(absenceYears));
		
		return searchCriteria;
	}
}
