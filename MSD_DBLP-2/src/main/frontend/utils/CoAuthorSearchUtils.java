package frontend.utils;

import java.util.List;

import queryengine.app.App;
import queryengine.interfaces.ICoAuthorSearch;
import queryengine.query.utils.AuthorName;
import resources.personrecord.IPerson;

public class CoAuthorSearchUtils {
	
	public static List<IPerson> getCoAuthorSearchResults(String authorName){
		
		App app = App.getTestAppInstance(20);	
		ICoAuthorSearch searchCriteria = new AuthorName(authorName);
	
		List<IPerson> searchResult = app.searchCoAuthors(searchCriteria);
		return searchResult;
	}
}
