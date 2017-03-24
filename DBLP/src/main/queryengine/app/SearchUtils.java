package queryengine.app;

import java.util.ArrayList;
import java.util.List;

import persistence.Data;
import queryengine.interfaces.ISearch;
import queryengine.query.utils.Title;
import resources.personRecord.Author;
import resources.personRecord.IPerson;
import resources.publicationRecord.*;

public class SearchUtils {

	public static List<IPerson> processArticles(List<ISearch> searchCriteria){
		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		// Article Processing
		List<Article> refinedArticleDataSet = Data.getArticles();
		for (ISearch i: searchCriteria) {
			if (i instanceof Title) {
				refinedArticleDataSet = SearchUtils.processArticlesByTitle((Title) i, refinedArticleDataSet);
			}
			//TODO add other search criteria
			
		}
		// after refinedArticleDataSet is final
		searchedAuthor.addAll(SearchUtils.getAuthorFromRefinedArticleDataSet(refinedArticleDataSet));
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
			if (a.getTitle() != null && 
					a.getTitle().toLowerCase().contains(t.getTitle().toLowerCase())) {

				filteredArticles.add(a);
			}
		}
		return filteredArticles;
	}

	private static List<IPerson> getAuthorFromRefinedArticleDataSet( List<Article> refinedArticleDataSet){

		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		for(Article article:refinedArticleDataSet ){
			Author author = new Author();

			author.setPersonName(article.getAuthorName());
			author.setPublicationType("article");
			author.setPublicationId(article.getId());
			author.setPublicationTitle(article.getTitle());
			author.setPublicationYear(article.getYear());

			searchedAuthor.add(author);
		}

		return searchedAuthor;
	}

	private static List<Incollection> processIncollectionsByTitle(Title t, List<Incollection> refinedIncollectionDataSet) {

		List<Incollection> filteredIncollections = new ArrayList<Incollection>();

		for (Incollection a: refinedIncollectionDataSet) {
			if (a.getTitle() != null && 
					a.getTitle().toLowerCase().contains(t.getTitle().toLowerCase())) {

				filteredIncollections.add(a);
			}
		}
		return filteredIncollections;
	}

	private static List<IPerson> getAuthorFromRefinedIncollectionDataSet( List<Incollection> refinedIncollectionDataSet){

		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		for(Incollection incollection:refinedIncollectionDataSet ){
			Author author = new Author();

			author.setPersonName(incollection.getAuthorName());
			author.setPublicationType("incollection");
			author.setPublicationId(incollection.getId());
			author.setPublicationTitle(incollection.getTitle());
			author.setPublicationYear(incollection.getYear());

			searchedAuthor.add(author);
		}

		return searchedAuthor;
	}

	private static List<Inproceeding> processInproceedingsByTitle(Title t, List<Inproceeding> refinedInproceedingDataSet) {

		List<Inproceeding> filteredInproceedings = new ArrayList<Inproceeding>();

		for (Inproceeding a: refinedInproceedingDataSet) {
			if (a.getTitle() != null && 
					a.getTitle().toLowerCase().contains(t.getTitle().toLowerCase())) {

				filteredInproceedings.add(a);
			}
		}
		return filteredInproceedings;
	}

	private static List<IPerson> getAuthorFromRefinedInproceedingDataSet( List<Inproceeding> refinedInproceedingDataSet){

		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		for(Inproceeding inproceeding:refinedInproceedingDataSet ){
			Author author = new Author();

			author.setPersonName(inproceeding.getAuthorName());
			author.setPublicationType("inproceeding");
			author.setPublicationId(inproceeding.getId());
			author.setPublicationTitle(inproceeding.getTitle());
			author.setPublicationYear(inproceeding.getYear());

			searchedAuthor.add(author);
		}

		return searchedAuthor;
	}

	private static List<PhdThesis> processPhdthesesByTitle(Title t, List<PhdThesis> refinedPhdThesisDataSet) {

		List<PhdThesis> filteredPhdTheses = new ArrayList<PhdThesis>();

		for (PhdThesis a: refinedPhdThesisDataSet) {
			if (a.getTitle() != null && 
					a.getTitle().toLowerCase().contains(t.getTitle().toLowerCase())) {

				filteredPhdTheses.add(a);
			}
		}
		return filteredPhdTheses;
	}

	private static List<IPerson> getAuthorFromRefinedPhdThesisDataSet( List<PhdThesis> refinedPhdThesisDataSet){

		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		for(PhdThesis phdThesis:refinedPhdThesisDataSet ){
			Author author = new Author();

			author.setPersonName(phdThesis.getAuthorName());
			author.setPublicationType("phdthesis");
			author.setPublicationId(phdThesis.getId());
			author.setPublicationTitle(phdThesis.getTitle());
			author.setPublicationYear(phdThesis.getYear());

			searchedAuthor.add(author);
		}

		return searchedAuthor;
	}

}
