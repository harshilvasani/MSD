package tester;

import java.util.List;

import queryengine.app.App;
import resources.personrecord.FavoriteStat;
import resources.personrecord.FavouriteAuthor;
import resources.personrecord.IPerson;

public class Tester {

	public static void main(String[] args) {
	
		//
		/*object should not die*/
		//
	
		App app = App.getAppInstance();	
		System.out.println("----------------------------");
		
		System.out.println(app.insertFavoriteAuthor(new FavouriteAuthor(-1, "a", "u")).getMessage());
//		System.out.println(app.getAllFavoriteAuthors().size());
		System.out.println(app.deleteFavoriteAuthor(new FavouriteAuthor(-1, "a", "u")).isSuccess());

		List<IPerson> persons = app.getFavoriteAuthorsStatistics();
		System.out.println(persons.size());
		
		for (IPerson p: persons) {
			FavoriteStat f = (FavoriteStat) p;
			System.out.println(f.getPersonName() + " " + f.getTotalPublications() + " " + f.getMostPublications());
		}
	}
}
