package queryengine.app;

import java.util.List;

import queryengine.interfaces.ICoAuthorSearch;
import queryengine.interfaces.IFilter;
import queryengine.interfaces.ISearch;
import queryengine.interfaces.ISimAuthorSearch;
import queryengine.miscellaneous.ResponseMessage;
import resources.personrecord.FavouriteAuthor;
import resources.personrecord.IPerson;
import resources.personrecord.User;

public interface IApp {
	
	ResponseMessage login(String username, String password);
	ResponseMessage register(User newUser);
	ResponseMessage updateProfile(User updateUser);
	User getUserByUsername(String username);
	List<IPerson> search(List<ISearch> searchCriteria);
	
	ResponseMessage insertFavoriteAuthor(FavouriteAuthor favouriteAuthor);
	ResponseMessage deleteFavoriteAuthor(FavouriteAuthor favouriteAuthor);
	List<FavouriteAuthor> getAllFavoriteAuthorsForLoggedInUser();
	List<IPerson> searchCoAuthors(ICoAuthorSearch searchCriteria);
	List<IPerson> searchSimilarAuthors(ISimAuthorSearch searchCriteria);
	List<IPerson> filter(List<IFilter> filterCriteria, List<IPerson> searchResult);
	List<IPerson> getFavoriteAuthorsStatistics();

}
