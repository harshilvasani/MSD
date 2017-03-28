package frontend.utils;

import java.util.List;

import queryengine.app.App;
import queryengine.miscellaneous.ResponseMessage;
import resources.personrecord.FavouriteAuthor;
import resources.personrecord.User;
import validator.utils.Validator;

public class FavoriteAuthorUtils {

	private static App app = App.getAppInstance();	


	public static List<FavouriteAuthor> getFavoriteAuthors() {
		return app.getAllFavoriteAuthorsForLoggedInUser();
	}

	public static ResponseMessage addAuthorToFavouriteList(String authorName){

		if(!Validator.isNonEmptyString(authorName))
			return new ResponseMessage (false, "Auhor name cannot be empty/null");

		User loggedInUser = app.getLoggedInUser();
		if(loggedInUser == null)
			return new ResponseMessage (false, "Logged in user is null");

		FavouriteAuthor favAuthor = new FavouriteAuthor(-1, authorName, loggedInUser.getUsername());

		return  app.insertFavoriteAuthor(favAuthor);

	}

	public static ResponseMessage removeAuthorToFavouriteList(String authorName){

		if(!Validator.isNonEmptyString(authorName))
			return new ResponseMessage (false, "Auhor name cannot be empty/null");

		User loggedInUser = app.getLoggedInUser();
		if(loggedInUser == null)
			return new ResponseMessage (false, "Logged in user is null");

		FavouriteAuthor favAuthor = new FavouriteAuthor(-1, authorName, loggedInUser.getUsername());

		return  app.deleteFavoriteAuthor(favAuthor);

	}
}
