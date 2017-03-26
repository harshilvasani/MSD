package queryengine.app.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import persistence.Data;
import queryengine.interfaces.ISearch;
import queryengine.query.utils.AbsenceFromCommittees;
import queryengine.query.utils.Conferences;
import queryengine.query.utils.Title;
import queryengine.query.utils.Year;
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
				refinedArticleDataSet = processArticlesByTitle(((Title) i).getKeys(), refinedArticleDataSet);
			}
			else if (i instanceof Year) {
				refinedArticleDataSet = processArticlesByYear(((Year) i).getYear(), refinedArticleDataSet);
			}
			else if (i instanceof Conferences) {
				refinedArticleDataSet = processArticlesByConferences((((Conferences) i).getConferences()), refinedArticleDataSet);
			}
			else if (i instanceof AbsenceFromCommittees) {
				refinedArticleDataSet = processArticlesByAbsence(((AbsenceFromCommittees) i).getInvalidCommitteeMembers(), refinedArticleDataSet);
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
				refinedIncollectionDataSet = processIncollectionsByTitle(((Title) i).getKeys(), refinedIncollectionDataSet);
			}
			else if (i instanceof Year) {
				refinedIncollectionDataSet = processIncollectionsByYear(((Year) i).getYear(), refinedIncollectionDataSet);
			}
			else if (i instanceof Conferences) {
				refinedIncollectionDataSet = processIncollectionsByConferences(((Conferences) i).getConferences(), refinedIncollectionDataSet);
			}
			else if (i instanceof AbsenceFromCommittees) {
				refinedIncollectionDataSet = processIncollectionsByAbsence(((AbsenceFromCommittees) i).getInvalidCommitteeMembers(), refinedIncollectionDataSet);
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
				refinedInproceedingDataSet = processInproceedingsByTitle(((Title) i).getKeys(), refinedInproceedingDataSet);
			}
			else if (i instanceof Year) {
				refinedInproceedingDataSet = processInproceedingsByYear(((Year) i).getYear(), refinedInproceedingDataSet);
			}
			else if (i instanceof Conferences) {
				refinedInproceedingDataSet = processInproceedingsByConferences((((Conferences) i).getConferences()), refinedInproceedingDataSet);
			}
			else if (i instanceof AbsenceFromCommittees) {
				refinedInproceedingDataSet = processInproceedingsByAbsence(((AbsenceFromCommittees) i).getInvalidCommitteeMembers(), refinedInproceedingDataSet);
			}
			//TODO add other search criteria

		}
		// after refinedInproceedingDataSet is final
		searchedAuthor.addAll(SearchUtils.getAuthorFromRefinedInproceedingDataSet(refinedInproceedingDataSet));	
		return searchedAuthor;

	}

	public static List<IPerson> processPhdThesis(List<ISearch> searchCriteria){
		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		List<PhdThesis> refinedPhdThesisDataSet = Data.getPhdthesis();
		for (ISearch i: searchCriteria) {
			if (i instanceof Title) {
				refinedPhdThesisDataSet = processPhdthesisByTitle(((Title) i).getKeys(), refinedPhdThesisDataSet);
			}
			else if (i instanceof Year) {
				refinedPhdThesisDataSet = processPhdthesisByYear(((Year) i).getYear(), refinedPhdThesisDataSet);
			}
			else if (i instanceof Conferences) {
				refinedPhdThesisDataSet = processPhdthesisByConferences(((Conferences) i).getConferences(), refinedPhdThesisDataSet);
			}
			else if (i instanceof AbsenceFromCommittees) {
				refinedPhdThesisDataSet = processPhdthesisByAbsence(((AbsenceFromCommittees) i).getInvalidCommitteeMembers(), refinedPhdThesisDataSet);
			}
			//TODO add other search criteria

		}
		// after refinedPhdThesisDataSet is final
		searchedAuthor.addAll(SearchUtils.getAuthorFromRefinedPhdThesisDataSet(refinedPhdThesisDataSet));	
		return searchedAuthor;

	}

	private static List<Article> processArticlesByTitle(String[] keys, List<Article> refinedArticleDataSet) {
		List<Article> filteredArticles = new ArrayList<Article>();

		for (Article a: refinedArticleDataSet) {
			if (keyWordMatchFound(a.getTitle(), keys)) {
				filteredArticles.add(a);
			}
		}
		return filteredArticles;
	}

	private static List<Article> processArticlesByYear(int pubYear, List<Article> refinedArticleDataSet) {
		List<Article> filteredArticles = new ArrayList<Article>();

		for (Article a: refinedArticleDataSet) {
			if (Integer.parseInt(a.getYear()) >= pubYear) {
				filteredArticles.add(a);
			}
		}
		return filteredArticles;
	}
	
	private static List<Article> processArticlesByConferences(String conferences[], List<Article> refinedArticleDataSet) {
		List<Article> filteredArticles = new ArrayList<Article>();

		for (Article a: refinedArticleDataSet) {
			if (conferenceMatchFound(a.getJournalName(), conferences)) {
				filteredArticles.add(a);
			}
		}
		return filteredArticles;
	}

	private static List<Article> processArticlesByAbsence(Set<String> invalidCommitteeMembers, List<Article> refinedArticleDataSet) {
		List<Article> filteredArticles = new ArrayList<Article>();

		for (Article a: refinedArticleDataSet) {
			if (a.getAuthorName() != null &&
				!invalidCommitteeMembers.contains(a.getAuthorName())) {
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

	private static List<Incollection> processIncollectionsByTitle(String[] keys, List<Incollection> refinedIncollectionDataSet) {

		List<Incollection> filteredIncollections = new ArrayList<Incollection>();

		for (Incollection i: refinedIncollectionDataSet) {
			if (keyWordMatchFound(i.getTitle(), keys)) {
				filteredIncollections.add(i);
			}
		}
		return filteredIncollections;
	}

	private static List<Incollection> processIncollectionsByYear(int pubYear, List<Incollection> refinedIncollectionDataSet) {
		List<Incollection> filteredIncollections = new ArrayList<Incollection>();

		for (Incollection i: refinedIncollectionDataSet) {
			if (Integer.parseInt(i.getYear()) >= pubYear) {
					filteredIncollections.add(i);
			}
		}
		return filteredIncollections;
	}
	
	private static List<Incollection> processIncollectionsByConferences(String[] conferences, List<Incollection> refinedIncollectionDataSet) {
		List<Incollection> filteredIncollections = new ArrayList<Incollection>();

		for (Incollection i: refinedIncollectionDataSet) {
			if (conferenceMatchFound(i.getKey(), conferences)) {
					filteredIncollections.add(i);
			}
		}
		return filteredIncollections;
	}

	private static List<Incollection> processIncollectionsByAbsence(Set<String> invalidCommitteeMembers, List<Incollection> refinedIncollectionDataSet) {
		List<Incollection> filteredIncollections = new ArrayList<Incollection>();

		for (Incollection i: refinedIncollectionDataSet) {
			if (i.getAuthorName() != null &&
				!invalidCommitteeMembers.contains(i.getAuthorName())) {
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
										incollection.getKey(),
										incollection.getYear(),
										PublicationType.INCOLLECTION);
			searchedAuthor.add(author);
		}

		return searchedAuthor;
	}

	private static List<Inproceeding> processInproceedingsByTitle(String[] keys, List<Inproceeding> refinedInproceedingDataSet) {

		List<Inproceeding> filteredInproceedings = new ArrayList<Inproceeding>();

		for (Inproceeding i: refinedInproceedingDataSet) {
			if (keyWordMatchFound(i.getTitle(), keys)) {
				filteredInproceedings.add(i);
			}
		}
		return filteredInproceedings;
	}
	
	private static List<Inproceeding> processInproceedingsByYear(int pubYear, List<Inproceeding> refinedInproceedingDataSet) {

		List<Inproceeding> filteredInproceedings = new ArrayList<Inproceeding>();

		for (Inproceeding i: refinedInproceedingDataSet) {
			if (Integer.parseInt(i.getYear()) >= pubYear) {
				filteredInproceedings.add(i);
			}
		}
		return filteredInproceedings;
	}
	
	private static List<Inproceeding> processInproceedingsByConferences(String[] conferences, List<Inproceeding> refinedInproceedingDataSet) {

		List<Inproceeding> filteredInproceedings = new ArrayList<Inproceeding>();

		for (Inproceeding i: refinedInproceedingDataSet) {
			if (conferenceMatchFound(i.getKey(), conferences)) {
				filteredInproceedings.add(i);
			}
		}
		return filteredInproceedings;
	}

	private static List<Inproceeding> processInproceedingsByAbsence(Set<String> invalidCommitteeMembers, List<Inproceeding> refinedInproceedingDataSet) {

		List<Inproceeding> filteredInproceedings = new ArrayList<Inproceeding>();

		for (Inproceeding i: refinedInproceedingDataSet) {
			if (i.getAuthorName() != null &&
				!invalidCommitteeMembers.contains(i.getAuthorName())) {
				filteredInproceedings.add(i);
			}
		}
		return filteredInproceedings;
	}
	
	private static List<IPerson> getAuthorFromRefinedInproceedingDataSet(List<Inproceeding> refinedInproceedingDataSet){

		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		for(Inproceeding inproceeding:refinedInproceedingDataSet ){
			Author author = new Author(inproceeding.getAuthorName(),
										inproceeding.getId(),
										inproceeding.getTitle(),
										inproceeding.getKey(),
										inproceeding.getYear(),
										PublicationType.INPROCEEDING);

			searchedAuthor.add(author);
		}

		return searchedAuthor;
	}

	private static List<PhdThesis> processPhdthesisByTitle(String[] keys, List<PhdThesis> refinedPhdThesisDataSet) {

		List<PhdThesis> filteredPhdthesis = new ArrayList<PhdThesis>();

		for (PhdThesis p: refinedPhdThesisDataSet) {
			if (keyWordMatchFound(p.getTitle(), keys)) {
				filteredPhdthesis.add(p);
			}
		}
		return filteredPhdthesis;
	}

	private static List<PhdThesis> processPhdthesisByYear(int pubYear, List<PhdThesis> refinedPhdThesisDataSet) {

		List<PhdThesis> filteredPhdthesis = new ArrayList<PhdThesis>();

		for (PhdThesis p: refinedPhdThesisDataSet) {
			if (Integer.parseInt(p.getYear()) >= pubYear) {
				filteredPhdthesis.add(p);
			}
		}
		return filteredPhdthesis;
	}
	
	private static List<PhdThesis> processPhdthesisByConferences(String[] conferences, List<PhdThesis> refinedPhdThesisDataSet) {

		List<PhdThesis> filteredPhdthesis = new ArrayList<PhdThesis>();

		for (PhdThesis p: refinedPhdThesisDataSet) {
			if (conferenceMatchFound(p.getKey(), conferences)) {
				filteredPhdthesis.add(p);
			}
		}
		return filteredPhdthesis;
	}

	private static List<PhdThesis> processPhdthesisByAbsence(Set<String> invalidCommitteeMembers, List<PhdThesis> refinedPhdThesisDataSet) {

		List<PhdThesis> filteredPhdthesis = new ArrayList<PhdThesis>();

		for (PhdThesis p: refinedPhdThesisDataSet) {
			if (p.getAuthorName() != null &&
				!invalidCommitteeMembers.contains(p.getAuthorName())) {
				filteredPhdthesis.add(p);
			}
		}
		return filteredPhdthesis;
	}
	
	private static List<IPerson> getAuthorFromRefinedPhdThesisDataSet( List<PhdThesis> refinedPhdThesisDataSet){

		List<IPerson> searchedAuthor = new ArrayList<IPerson>();

		for(PhdThesis phdThesis:refinedPhdThesisDataSet ){
			Author author = new Author(phdThesis.getAuthorName(),
										phdThesis.getId(),
										phdThesis.getTitle(),
										phdThesis.getKey(),
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
	
	private static boolean conferenceMatchFound(String conference, String[] conferences) {
		if (conference == null)
			return false;
		
		conference = conference.toLowerCase();
		for (String c: conferences) {
			if (conference.contains(c))
				return true;
		}
		
		return false;
	}
	
	public class PublicationType { 
		public static final String ARTICLE = "article";
		public static final String INCOLLECTION = "incollection";
		public static final String INPROCEEDING = "inproceeding";
		public static final String PHDTHESIS = "phdthesis";
	}
	
	public static final float MIN_MATCH_PERCENTAGE = (float) 0.66;
}