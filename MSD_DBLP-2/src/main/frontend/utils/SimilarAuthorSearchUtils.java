package frontend.utils;

import java.util.List;

import queryengine.app.App;
import queryengine.interfaces.ISimAuthorSearch;
import queryengine.query.utils.AuthorName;
import resources.personrecord.IPerson;

public class SimilarAuthorSearchUtils {

	public List<IPerson> getSimilarAuthors(String authorName){
		App app = App.getAppInstance();	
		ISimAuthorSearch searchCriteria = new AuthorName(authorName);
		
		List<IPerson> searchResult = app.searchSimilarAuthors(searchCriteria);
		return searchResult;
	}
}
