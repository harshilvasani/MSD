package queryengine.app;
import java.util.ArrayList;
import java.util.List;

import antlr.debug.SemanticPredicateAdapter;
import queryengine.app.utils.CoAuthorUtils;
import queryengine.app.utils.SearchUtils;
import queryengine.interfaces.ICoAuthorSearch;
import queryengine.interfaces.ISearch;
import queryengine.miscellaneous.ResponseMessage;
import queryengine.query.utils.AuthorName;
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
		
		// Publications after a year
		for (ISearch s: searchCriteria) {
			if (s instanceof Year) {
				List<IPerson> temp = new ArrayList<IPerson>();
				int pubYear = ((Year) s).getYear();
				
				for (IPerson p: searchedAuthor) {
					if (p instanceof Author && ((Author) p).getPublicationYear() >= pubYear) {
						temp.add(p);
					}	
				}
				searchedAuthor = temp;
			}
		}
		// Then Return authors -- From all refined results
		return searchedAuthor;
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

	@Override
	public List<IPerson> searchCoAuthors(ICoAuthorSearch searchCriteria) {
		if (searchCriteria instanceof AuthorName) {
			AuthorName authorName = (AuthorName) searchCriteria;
			return CoAuthorUtils.processArticles(authorName);	
		}
		return null;
	}
}
