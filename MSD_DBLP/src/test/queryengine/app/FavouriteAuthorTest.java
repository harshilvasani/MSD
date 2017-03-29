package queryengine.app;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import resources.personrecord.FavouriteAuthor;
import resources.personrecord.User;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FavouriteAuthorTest {

	private App app = App.getAppInstance();	
	private int favAuthorsCount;
	
	@Test
	public void Test1_AddFavouriteAuthorSuccess() {
		
		User u = new User();
		u.setUsername("u");
		app.setLoggedInUser(u);
		
		favAuthorsCount = app.getAllFavoriteAuthorsForLoggedInUser().size();
		
		assertTrue(app.insertFavoriteAuthor(new FavouriteAuthor(-1, "a", "u")).isSuccess());
	}
	
	@Test
	public void Test2_AddFavouriteAuthorFail() {
		assertFalse(app.insertFavoriteAuthor(new FavouriteAuthor(-1, "a", "u")).isSuccess());
	}

	@Test
	public void Test3_GetFavoriteAuthorsSuccess() {
		assertEquals(favAuthorsCount + 1, app.getAllFavoriteAuthorsForLoggedInUser().size());
	}
	
	@Test
	public void Test4_DeleteFavouriteAuthorSuccess() {
		assertTrue(app.deleteFavoriteAuthor(new FavouriteAuthor(-1, "a", "u")).isSuccess());	
	}
	
	@Test
	public void Test5_DeleteFavouriteAuthorFail() {
		assertFalse(app.deleteFavoriteAuthor(new FavouriteAuthor(-1, "a", "u")).isSuccess());	
	}
	
	@Test
	public void Test6_GetFavoriteAuthorsSuccess() {
		assertEquals(favAuthorsCount, app.getAllFavoriteAuthorsForLoggedInUser().size());
	}
	
	
}
