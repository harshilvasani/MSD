package queryengine.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import persistence.Data;
import queryengine.app.SearchUtils.PublicationType;
import queryengine.interfaces.ISearch;
import queryengine.query.utils.AuthorName;
import queryengine.query.utils.Title;
import resources.person.Author;
import resources.person.IPerson;
import resources.pubrec.Article;
import resources.pubrec.Incollection;
import resources.pubrec.Inproceeding;
import resources.pubrec.PhdThesis;

public class CoAuthorUtils {
	public static List<IPerson> processArticles(AuthorName authorName){
		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		// Article Processing
		List<Article> articleDataSet = Data.getArticles();
		Set<Article> authorArticles = new HashSet<Article>();
		
		for (Article a: articleDataSet) {
			if (a.getAuthorName() != null &&
				a.getAuthorName().toLowerCase().contains(authorName.getAuthorName())) {
				authorArticles.add(a);
			}
		}
		// Use authorArticles to get co-authors
		
		for (Article a: articleDataSet) {
			if (authorArticles.contains(a) &&
				!a.getAuthorName().toLowerCase().contains(authorName.getAuthorName())) {
				Author author = new Author(a.getAuthorName(),
											a.getId(), 
											a.getTitle(), 
											a.getYear(),
											PublicationType.ARTICLE);
				searchedAuthor.add(author);
			}
		}
		return searchedAuthor;
	}

	/*public static List<IPerson> processIncollection(List<ISearch> searchCriteria){
		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		List<Incollection> refinedIncollectionDataSet = Data.getIncollections();
		for (ISearch i: searchCriteria) {
			if (i instanceof Title) {
				refinedIncollectionDataSet = SearchUtils.processIncollectionsByTitle((Title) i, refinedIncollectionDataSet);
			}	
			//TODO add other search criteria

		}
		// after refinedInproceedingDataSet is final
		searchedAuthor.addAll(SearchUtils.getAuthorFromRefinedIncollectionDataSet(refinedIncollectionDataSet));	
		return searchedAuthor;

	}

	public static List<IPerson> processInproceeding(List<ISearch> searchCriteria){
		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		List<Inproceeding> refinedInproceedingDataSet = Data.getInproceedings();
		for (ISearch i: searchCriteria) {
			if (i instanceof Title) {
				refinedInproceedingDataSet = SearchUtils.processInproceedingsByTitle((Title) i, refinedInproceedingDataSet);
			}
			//TODO add other search criteria

		}
		// after refinedInproceedingDataSet is final
		searchedAuthor.addAll(SearchUtils.getAuthorFromRefinedInproceedingDataSet(refinedInproceedingDataSet));	
		return searchedAuthor;

	}

	public static List<IPerson> processPhdThesis(List<ISearch> searchCriteria){
		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		List<PhdThesis> refinedPhdThesisDataSet = Data.getPhdtheses();
		for (ISearch i: searchCriteria) {
			if (i instanceof Title) {
				refinedPhdThesisDataSet = SearchUtils.processPhdthesesByTitle((Title) i, refinedPhdThesisDataSet);
			}
			//TODO add other search criteria

		}
		// after refinedPhdThesisDataSet is final
		searchedAuthor.addAll(SearchUtils.getAuthorFromRefinedPhdThesisDataSet(refinedPhdThesisDataSet));	
		return searchedAuthor;

	}*/
}
