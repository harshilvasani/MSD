package queryengine.app;

import static org.junit.Assert.*;

import org.junit.Test;

import resources.personrecord.FavouriteAuthor;

public class FavouriteAuthorTest {

	private App aObj = App.getTestAppInstance(20);

	@Test
	public void AddFavouriteAuthorFail() {
		assertFalse(aObj.insertFavoriteAuthor(new FavouriteAuthor(-1, "a", "u")).isSuccess());
	}

	@Test
	public void DeleteFavouriteAuthorFail() {
		assertFalse(aObj.deleteFavoriteAuthor(new FavouriteAuthor(-1, "a", "u")).isSuccess());	
	}
}
