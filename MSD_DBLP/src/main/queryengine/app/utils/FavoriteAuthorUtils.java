package queryengine.app.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import persistence.Data;
import resources.personrecord.FavoriteStat;
import resources.personrecord.FavouriteAuthor;
import resources.personrecord.IPerson;
import resources.pubrec.Article;
import resources.pubrec.Incollection;
import resources.pubrec.Inproceeding;
import resources.pubrec.PhdThesis;

public class FavoriteAuthorUtils {
	
	private static HashMap<String, HashMap<String, Integer>> countMap = new HashMap<String, HashMap<String, Integer>>();

	public static List<IPerson> getFavoriteAuthorStatistics(List<FavouriteAuthor> favoriteAuthors) {
		buildCountMap();
		List<IPerson> favoriteStatistics = new ArrayList<IPerson>();
		for (FavouriteAuthor favAuthor: favoriteAuthors) {
			HashMap<String, Integer> authorPublications = countMap.get(favAuthor.getAuthorName());
			if (authorPublications != null) {
				int maxPublications = 0;
				String journal = new String();
				int publicationCount = 0;
				
				for (String key: authorPublications.keySet()) {
					int currCount = authorPublications.get(key);
					publicationCount += currCount;
					if (currCount > maxPublications) {
						maxPublications = currCount;
						journal = key;
					}
				}
				
				favoriteStatistics.add(new FavoriteStat(favAuthor.getAuthorName(), publicationCount, maxPublications + " ; " + journal));
			}
		}
		return favoriteStatistics;
	}
	
	private static void buildCountMap() {
		countMap = new HashMap<String, HashMap<String, Integer>>();
		processArticles();
		processIncollections();
		processInproceedings();
		processPhdThesis();
	}
	
	private static void processArticles(){
		
		// Article Processing
		List<Article> articleDataSet = Data.getArticles();
		
		for (Article a: articleDataSet) {
			if (a.getAuthorName() != null) {
				String authorKey = a.getAuthorName();
				HashMap<String, Integer> authorCountMap = countMap.get(authorKey);
				if (authorCountMap == null) {
					authorCountMap = new HashMap<String, Integer>();
				}
				Integer journalCount = authorCountMap.get(a.getJournalName());
				if (journalCount == null) {
					journalCount = 0;
				}
				authorCountMap.put(a.getJournalName(), journalCount + 1);
				countMap.put(authorKey, authorCountMap);
			}
		}
	}
	
	private static void processInproceedings(){
		
		List<Inproceeding> inproceedingsDataSet = Data.getInproceedings();
		
		for (Inproceeding i: inproceedingsDataSet) {
			if (i.getAuthorName() != null) {
				String authorKey = i.getAuthorName();
				HashMap<String, Integer> authorCountMap = countMap.get(authorKey);
				if (authorCountMap == null) {
					authorCountMap = new HashMap<String, Integer>();
				}
				Integer confCount = authorCountMap.get(i.getConference());
				if (confCount == null) {
					confCount = 0;
				}
				authorCountMap.put(i.getConference(), confCount + 1);
				countMap.put(authorKey, authorCountMap);
			}
		}
	}
	
	private static void processIncollections(){
		
		List<Incollection> incollectionDataSet = Data.getIncollections();
		
		for (Incollection i: incollectionDataSet) {
			if (i.getAuthorName() != null) {
				String authorKey =  i.getAuthorName();
				HashMap<String, Integer> authorCountMap = countMap.get(authorKey);
				if (authorCountMap == null) {
					authorCountMap = new HashMap<String, Integer>();
				}
				Integer journalCount = authorCountMap.get(i.getJournal());
				if (journalCount == null) {
					journalCount = 0;
				}
				authorCountMap.put(i.getJournal(), journalCount + 1);
				countMap.put(authorKey, authorCountMap);
			}
		}
	}
	
	private static void processPhdThesis(){
		
		List<PhdThesis> phdThesisDataSet = Data.getPhdtheses();
		
		for (PhdThesis p: phdThesisDataSet) {
			if (p.getAuthorName() != null) {
				String authorKey = p.getAuthorName();
				HashMap<String, Integer> authorCountMap = countMap.get(authorKey);
				if (authorCountMap == null) {
					authorCountMap = new HashMap<String, Integer>();
				}
				Integer pubCount = authorCountMap.get(p.getPublisher());
				if (pubCount == null) {
					pubCount = 0;
				}
				authorCountMap.put(p.getPublisher(), pubCount + 1);
				countMap.put(authorKey, authorCountMap);
			}
		}
	}
}