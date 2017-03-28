package tester;

import queryengine.app.App;
import resources.personrecord.FavouriteAuthor;

public class Tester {

	public static void main(String[] args) {
	
		//
		/*object should not die*/
		//
	
		App app = App.getTestAppInstance(20);
		System.out.println("----------------------------");
		
		System.out.println(app.insertFavoriteAuthor(new FavouriteAuthor(-1, "a", "u")).getMessage());
//		System.out.println(app.getAllFavoriteAuthors().size());
		System.out.println(app.deleteFavoriteAuthor(new FavouriteAuthor(-1, "a", "u")).isSuccess());

	}
}
