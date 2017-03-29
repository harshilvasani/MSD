package queryengine.app;

import java.util.ArrayList;
import java.util.List;

import backend.BackEnd;
import persistence.Data;
import queryengine.interfaces.ICoAuthorSearch;
import queryengine.interfaces.IFilter;
import queryengine.interfaces.ISearch;
import queryengine.interfaces.ISimAuthorSearch;
import queryengine.miscellaneous.ResponseMessage;
import resources.personrecord.FavouriteAuthor;
import resources.personrecord.IPerson;
import resources.personrecord.User;

public class App implements IApp{

	private static App app;
/*	private static App testApp;*/
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
	
	public User getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(User loggedInUser) {
			this.loggedInUser = loggedInUser;
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
	public List<FavouriteAuthor> getAllFavoriteAuthorsForLoggedInUser() {
		return backend.getAllFavoriteAuthorsForLoggedInUser(loggedInUser.getUsername());
	}
	
	@Override
	public List<IPerson> search(List<ISearch> searchCriteria) {
		// TODO Auto-generated method stub
		return new ArrayList<IPerson>();
	}

	@Override
	public List<IPerson> searchCoAuthors(ICoAuthorSearch searchCriteria) {
		// TODO Auto-generated method stub
		return new ArrayList<IPerson>();
	}

	@Override
	public List<IPerson> searchSimilarAuthors(ISimAuthorSearch searchCriteria) {
		// TODO Auto-generated method stub
		return new ArrayList<IPerson>();
	}

	@Override
	public List<IPerson> filter(List<IFilter> filterCriteria, List<IPerson> searchResult) {
		// TODO Auto-generated method stub
		return new ArrayList<IPerson>();
	}

	@Override
	public List<IPerson> getFavoriteAuthorsStatistics() {
		// TODO Auto-generated method stub
		return new ArrayList<IPerson>();
	}
}
