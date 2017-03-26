package queryengine.app;
import java.util.ArrayList;
import java.util.List;

import antlr.debug.SemanticPredicateAdapter;
import queryengine.app.utils.CoAuthorUtils;
import queryengine.app.utils.FilterUtils;
import queryengine.app.utils.SearchUtils;
import queryengine.app.utils.SimilarAuthor;
import queryengine.app.utils.SimilarAuthorsUtils;
import queryengine.interfaces.ICoAuthorSearch;
import queryengine.interfaces.IFilter;
import queryengine.interfaces.ISearch;
import queryengine.interfaces.ISimAuthorSearch;
import queryengine.miscellaneous.ResponseMessage;
import queryengine.query.utils.AuthorName;
import queryengine.query.utils.MinPublications;
import queryengine.query.utils.Year;
import resources.person.Author;
import resources.person.IPerson;
import resources.person.User;

public class App implements IApp{

	public List<IPerson> search(List<ISearch> searchCriteria) {

		List<IPerson> searchedAuthor = new ArrayList<IPerson>();
		//List<IPerson> searchedEditor = new ArrayList<IPerson>();

		// Article Processing		
		searchedAuthor.addAll(SearchUtils.processArticles(searchCriteria));

		// Incollection Processing	
		searchedAuthor.addAll(SearchUtils.processIncollection(searchCriteria));	

		// Inproceeding Processing
		searchedAuthor.addAll(SearchUtils.processInproceeding(searchCriteria));

		// PhdThesis Processing
		searchedAuthor.addAll(SearchUtils.processPhdThesis(searchCriteria));
		
		// Then Return authors -- From all refined results
		return searchedAuthor;
	}
	
	public List<IPerson> filter(List<IFilter> filterCriteria, List<IPerson> searchResult) {
		for (IFilter f: filterCriteria) {
			if (f instanceof AuthorName) {
				searchResult = FilterUtils.filterByAuthorName(((AuthorName) f).getAuthorName(), searchResult);
			}
			else if (f instanceof MinPublications) {
				searchResult = FilterUtils.filterByMinPublications(((MinPublications) f).getMinPublications(), searchResult);
			}
		}
		return searchResult;
	}
	
	@Override
	public List<IPerson> searchCoAuthors(ICoAuthorSearch searchCriteria) {
		if (searchCriteria instanceof AuthorName) {
			AuthorName authorName = (AuthorName) searchCriteria;
			return CoAuthorUtils.retrieveCoAuthors(authorName.getAuthorName());	
		}
		return null;
	}
	
	@Override
	public List<SimilarAuthor> searchSimilarAuthors(ISimAuthorSearch searchCriteria) {
		if (searchCriteria instanceof AuthorName) {
			AuthorName authorName = (AuthorName) searchCriteria;
			return SimilarAuthorsUtils.retrieveSimilarAuthors(authorName.getAuthorName());	
		}
		return null;
	}
	
	@Override
	public ResponseMessage login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMessage register(User regInformation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseMessage updateProfile(User regInformation) {
		// TODO Auto-generated method stub
		return null;
	}
}
