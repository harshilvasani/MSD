package queryengine.app.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import persistence.Data;
import queryengine.app.utils.SearchUtils.PublicationType;
import resources.person.Author;
import resources.person.IPerson;
import resources.pubrec.Article;
import resources.pubrec.Incollection;
import resources.pubrec.Inproceeding;

public class CoAuthorUtils {
	
	public static List<IPerson> retrieveCoAuthors(String authorName){
		List<IPerson> coAuthors = new ArrayList<IPerson>();
		
		coAuthors.addAll(processArticles(authorName));
		coAuthors.addAll(processInproceedings(authorName));
		coAuthors.addAll(processIncollections(authorName));
		
		return coAuthors;
	}
	
	public static List<IPerson> processArticles(String authorName){
		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		// Article Processing
		List<Article> articleDataSet = Data.getArticles();
		Set<Article> authorArticles = new HashSet<Article>();
		
		for (Article a: articleDataSet) {
			if (a.getAuthorName() != null &&
				a.getAuthorName().toLowerCase().contains(authorName)) {
				authorArticles.add(a);
			}
		}
		// Use authorArticles to get co-authors
		
		for (Article a: articleDataSet) {
			if (authorArticles.contains(a) &&
				!a.getAuthorName().toLowerCase().contains(authorName)) {
				Author author = new Author(a.getAuthorName(),
											a.getId(), 
											a.getTitle(), 
											a.getJournalName(),
											a.getYear(),
											PublicationType.ARTICLE);
				searchedAuthor.add(author);
			}
		}
		return searchedAuthor;
	}
	
	public static List<IPerson> processInproceedings(String authorName){
		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		List<Inproceeding> inproceedingsDataSet = Data.getInproceedings();
		Set<Inproceeding> authorInproceedings = new HashSet<Inproceeding>();
		for (Inproceeding i: inproceedingsDataSet) {
			if (i.getAuthorName() != null &&
				i.getAuthorName().toLowerCase().contains(authorName)) {
				authorInproceedings.add(i);
			}
		}
		for (Inproceeding i: inproceedingsDataSet) {
			if (authorInproceedings.contains(i) &&
				!i.getAuthorName().toLowerCase().contains(authorName)) {
				Author author = new Author(i.getAuthorName(),
											i.getId(), 
											i.getTitle(),
											i.getKey(),
											i.getYear(),
											PublicationType.INPROCEEDING);
				searchedAuthor.add(author);
			}
		}
		return searchedAuthor;
	}
	
	public static List<IPerson> processIncollections(String authorName){
		List<IPerson> searchedAuthor = new ArrayList<IPerson>();
		
		List<Incollection> incollectionsDataSet = Data.getIncollections();
		Set<Incollection> authorIncollections = new HashSet<Incollection>();
		for (Incollection i: incollectionsDataSet) {
			if (i.getAuthorName() != null &&
				i.getAuthorName().toLowerCase().contains(authorName)) {
				authorIncollections.add(i);
			}
		}
		for (Incollection i: incollectionsDataSet) {
			if (authorIncollections.contains(i) &&
				!i.getAuthorName().toLowerCase().contains(authorName)) {
				Author author = new Author(i.getAuthorName(),
											i.getId(), 
											i.getTitle(),
											i.getKey(),
											i.getYear(),
											PublicationType.INCOLLECTION);
				searchedAuthor.add(author);
			}
		}
		return searchedAuthor;
	}
}