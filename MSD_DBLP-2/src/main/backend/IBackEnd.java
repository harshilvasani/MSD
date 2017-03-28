package backend;

import java.util.List;

import queryengine.miscellaneous.ResponseMessage;
import resources.personrecord.FavouriteAuthor;
import resources.personrecord.User;

public interface IBackEnd {

	void parseXMLAndInsertData();
	void textParserAndInsertData();
	void loadData(int rowsCount);
	boolean isPublicationDataLoaded();
	boolean isCommitteeMemberDataLoaded();

	ResponseMessage checkUserExistsByUsenameAndEmail(String username, String emailId);
	User getUserCredentials(String username, String password);
	ResponseMessage insertUserData(User user);
	ResponseMessage updateUserData(User user);
	User selectUserByUsername(String username);
	
	ResponseMessage insertFavoriteAuthor(FavouriteAuthor favouriteAuthor);
	ResponseMessage deleteFavoriteAuthor(FavouriteAuthor favouriteAuthor);
	List<FavouriteAuthor> getAllFavoriteAuthorsForLoggedInUser(String username);
}
