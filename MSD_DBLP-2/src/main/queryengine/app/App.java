package queryengine.app;

import java.util.ArrayList;
import java.util.List;

import backend.BackEnd;
import persistence.Data;
import queryengine.app.utils.CoAuthorUtils;
import queryengine.app.utils.FilterUtils;
import queryengine.app.utils.SearchUtils;
import queryengine.app.utils.SimilarAuthorsUtils;
import queryengine.interfaces.ICoAuthorSearch;
import queryengine.interfaces.IFilter;
import queryengine.interfaces.ISearch;
import queryengine.interfaces.ISimAuthorSearch;
import queryengine.miscellaneous.ResponseMessage;
import queryengine.query.utils.AuthorName;
import queryengine.query.utils.MinPublications;
import resources.personrecord.FavouriteAuthor;
import resources.personrecord.IPerson;
import resources.personrecord.User;

public class App implements IApp{

	private static App app;
	private static App testApp;
	private BackEnd backend ;
	private User loggedInUser; 

	/**
	 * @param rowsCount If 0 or less, retrieves all rows. Else, retrieve rowCount no. of rows. Does for all tables
	 */
	private App(int rows){
		if (app != null) {
			return;
		}
		backend = new BackEnd();

		if(!backend.isPublicationDataLoaded()){
			backend.parseXMLAndInsertData();
		}

		if(!backend.isCommitteeMemberDataLoaded()){
			backend.textParserAndInsertData();
		}

		backend.loadData(rows);
		app = this;
		System.out.println(Data.getArticles().size());
		System.out.println(Data.getBooks().size());
		System.out.println(Data.getCommitteeMembers().size());
		System.out.println(Data.getIncollections().size());
		System.out.println(Data.getInproceedings().size());
		System.out.println(Data.getPhdtheses().size());
		System.out.println(Data.getProceedings().size());
	}

	public static App getAppInstance() {
		if (null == app) {
			app = new App(0);
		}
		return app;
	}

	public static App getTestAppInstance(int rows) {
		if (null == testApp) {
			/*if(rows == 0)
				rows = 20;*/
			rows = 0;
			testApp = new App(rows);
		}
		return testApp;
	}

	@Override
	public ResponseMessage login(String username, String password) {

		User loggedInUser = backend.getUserCredentials(username, password);

		if(loggedInUser != null){
			setLoggedInUser(loggedInUser);
			return new ResponseMessage(true, "Valid username and/or password");
		}
			
		else
			return new ResponseMessage(false, "Incorrect username and/or password");
	}

	@Override
	public ResponseMessage register(User newUser) {

		ResponseMessage userExistsMsg = backend.checkUserExistsByUsenameAndEmail(newUser.getUsername(), newUser.getPassword());

		if(!userExistsMsg.isSuccess()){
			return new ResponseMessage(false, "Username/Email-Id already exists");
		}

		return backend.insertUserData(newUser);
	}

	@Override
	public ResponseMessage updateProfile(User updatedUser) {

		ResponseMessage rm = backend.updateUserData(updatedUser);
		if(rm.isSuccess())
			setLoggedInUser(updatedUser);
		return rm;
	}

	@Override
	public User getUserByUsername(String username) {
		return backend.selectUserByUsername(username);
	}

	@Override
	public ResponseMessage insertFavoriteAuthor(FavouriteAuthor favouriteAuthor) {

		return backend.insertFavoriteAuthor(favouriteAuthor);
	}

	@Override
	public ResponseMessage deleteFavoriteAuthor(FavouriteAuthor favouriteAuthor) {

		return backend.deleteFavoriteAuthor(favouriteAuthor);
	}

	@Override
	public List<FavouriteAuthor> getAllFavoriteAuthors() {
		return backend.getAllFavoriteAuthors();
	}

	public User getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(User loggedInUser) {
			this.loggedInUser = loggedInUser;
	}

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
	
	@Override
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
	public List<IPerson> searchSimilarAuthors(ISimAuthorSearch searchCriteria) {
		if (searchCriteria instanceof AuthorName) {
			AuthorName authorName = (AuthorName) searchCriteria;
			return SimilarAuthorsUtils.retrieveSimilarAuthors(authorName.getAuthorName());	
		}
		return null;
	}
	
}
