package queryengine.app.utils;

import java.util.ArrayList;
import java.util.List;

import persistence.Data;
import queryengine.interfaces.ISearch;
import queryengine.query.utils.Title;
import resources.person.Author;
import resources.person.IPerson;
import resources.pubrec.*;

public class SearchUtils {
	
	public static List<IPerson> processArticles(List<ISearch> searchCriteria){
		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		// Article Processing
		List<Article> refinedArticleDataSet = Data.getArticles();
		for (ISearch i: searchCriteria) {
			if (i instanceof Title) {
				refinedArticleDataSet = processArticlesByTitle((Title) i, refinedArticleDataSet);
			}
			//TODO add other search criteria
			
		}
		// after refinedArticleDataSet is final
		searchedAuthor.addAll(getAuthorFromRefinedArticleDataSet(refinedArticleDataSet));
		return searchedAuthor;
	}

	public static List<IPerson> processIncollection(List<ISearch> searchCriteria){
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

	}

	private static List<Article> processArticlesByTitle(Title t, List<Article> refinedArticleDataSet) {
		List<Article> filteredArticles = new ArrayList<Article>();

		for (Article a: refinedArticleDataSet) {
			if (keyWordMatchFound(a.getTitle(), t.getKeys())) {
				filteredArticles.add(a);
			}
		}
		return filteredArticles;
	}

	private static List<IPerson> getAuthorFromRefinedArticleDataSet( List<Article> refinedArticleDataSet){

		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		for(Article article:refinedArticleDataSet ){
			Author author = new Author(article.getAuthorName(),
										article.getId(),
										article.getTitle(),
										article.getJournalName(),
										article.getYear(),
										PublicationType.ARTICLE);
			
			searchedAuthor.add(author);
		}
		return searchedAuthor;
	}

	private static List<Incollection> processIncollectionsByTitle(Title t, List<Incollection> refinedIncollectionDataSet) {

		List<Incollection> filteredIncollections = new ArrayList<Incollection>();

		for (Incollection i: refinedIncollectionDataSet) {
			if (keyWordMatchFound(i.getTitle(), t.getKeys())) {
				filteredIncollections.add(i);
			}
		}
		return filteredIncollections;
	}

	private static List<IPerson> getAuthorFromRefinedIncollectionDataSet( List<Incollection> refinedIncollectionDataSet){

		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		for(Incollection incollection:refinedIncollectionDataSet ){
			Author author = new Author(incollection.getAuthorName(),
										incollection.getId(),
										incollection.getTitle(),
										"",
										incollection.getYear(),
										PublicationType.INCOLLECTION);
			searchedAuthor.add(author);
		}

		return searchedAuthor;
	}

	private static List<Inproceeding> processInproceedingsByTitle(Title t, List<Inproceeding> refinedInproceedingDataSet) {

		List<Inproceeding> filteredInproceedings = new ArrayList<Inproceeding>();

		for (Inproceeding i: refinedInproceedingDataSet) {
			if (keyWordMatchFound(i.getTitle(), t.getKeys())) {
				filteredInproceedings.add(i);
			}
		}
		return filteredInproceedings;
	}

	private static List<IPerson> getAuthorFromRefinedInproceedingDataSet( List<Inproceeding> refinedInproceedingDataSet){

		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		for(Inproceeding inproceeding:refinedInproceedingDataSet ){
			Author author = new Author(inproceeding.getAuthorName(),
										inproceeding.getId(),
										inproceeding.getTitle(),
										"",
										inproceeding.getYear(),
										PublicationType.INPROCEEDING);

			searchedAuthor.add(author);
		}

		return searchedAuthor;
	}

	private static List<PhdThesis> processPhdthesesByTitle(Title t, List<PhdThesis> refinedPhdThesisDataSet) {

		List<PhdThesis> filteredPhdTheses = new ArrayList<PhdThesis>();

		for (PhdThesis p: refinedPhdThesisDataSet) {
			if (keyWordMatchFound(p.getTitle(), t.getKeys())) {
				filteredPhdTheses.add(p);
			}
		}
		return filteredPhdTheses;
	}

	private static List<IPerson> getAuthorFromRefinedPhdThesisDataSet( List<PhdThesis> refinedPhdThesisDataSet){

		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		for(PhdThesis phdThesis:refinedPhdThesisDataSet ){
			Author author = new Author(phdThesis.getAuthorName(),
										phdThesis.getId(),
										phdThesis.getTitle(),
										"",
										phdThesis.getYear(),
										PublicationType.PHDTHESIS);
			searchedAuthor.add(author);
		}

		return searchedAuthor;
	}
	
	private static boolean keyWordMatchFound(String title, String[] keys) {
		
		if (title == null) {
			return false;
		}
		
		float  keySize = keys.length;
		float matchingWords = 0;
		title = title.toLowerCase();
		for (String key: keys) {
			if (title.contains(key)) {
				matchingWords++;
			}
		}
		
		return ((matchingWords / keySize) >= MIN_MATCH_PERCENTAGE);
	}
	
	public class PublicationType { 
		public static final String ARTICLE = "article";
		public static final String INCOLLECTION = "incollection";
		public static final String INPROCEEDING = "inproceeding";
		public static final String PHDTHESIS = "phdthesis";
	}
	
	public static final float MIN_MATCH_PERCENTAGE = (float) 0.66;
}