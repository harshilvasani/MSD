package frontend.utils;

import java.util.ArrayList;
import java.util.List;

import queryengine.app.App;
import queryengine.interfaces.IFilter;
import queryengine.query.utils.AuthorName;
import queryengine.query.utils.MinPublications;
import resources.personrecord.IPerson;
import validator.utils.Validator;

public class FilterUtils {

	public static List<IPerson> getFilteredResult(String authorNameContains, String minPublicationCount, List<IPerson> searchResult){
		
		App app = App.getTestAppInstance(10);
		
		List<IFilter> filterCriteria = new ArrayList<IFilter>();

		if (Validator.isNonEmptyString(authorNameContains)) 
			filterCriteria.add(new AuthorName(authorNameContains));

		if (Validator.isValidN(minPublicationCount)) 	
			filterCriteria.add(new MinPublications(minPublicationCount));

		List<IPerson> filteredResult = app.filter(filterCriteria, searchResult);
		return filteredResult;
	}
}
