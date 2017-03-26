package queryengine.app.utils;

import java.util.List;
import java.util.Set;

import persistence.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import resources.person.IPerson;
import resources.pubrec.Article;
import resources.pubrec.Incollection;
import resources.pubrec.Inproceeding;
import resources.pubrec.PhdThesis;

public class SimilarAuthorsUtils {

	private static HashMap<String, HashMap<String, Integer>> countMap = new HashMap<String, HashMap<String, Integer>>();
	public static List<SimilarAuthor> retrieveSimilarAuthors(String authorName) {
		buildCountMap(authorName);
		
		List<IPerson> coAuthors = CoAuthorUtils.retrieveCoAuthors(authorName);
		Set<String> coAuthorNames = new HashSet<String>();
		
		for (IPerson coAuthor: coAuthors) {
			coAuthorNames.add(coAuthor.getPersonName());
		}
		
		HashMap<String, Integer> queryAuthorJournalMap = countMap.get(authorName);
		List<SimilarAuthor> similarAuthors = new ArrayList<SimilarAuthor>();
		
		for (String coAuthor: coAuthorNames) {
			// Continue here
			HashMap<String, Integer> currentAuthorJournalMap = countMap.get(coAuthor);
			long score = 0;
			for (String key: queryAuthorJournalMap.keySet()) {
				score += Math.abs(queryAuthorJournalMap.get(key) - 
								((currentAuthorJournalMap.get(key) == null) ? 
								  0 : currentAuthorJournalMap.get(key)));
			}
			similarAuthors.add(new SimilarAuthor(coAuthor, score));
		}
		// Sort Here -- You have to add Google Logic here -- Don't forget
		Collections.sort(similarAuthors);
		return similarAuthors;
	}
	
	private static void buildCountMap(String authorName) {
		countMap = new HashMap<String, HashMap<String, Integer>>();
		processArticles(authorName);
		processIncollections(authorName);
		processInproceedings(authorName);
		processPhdThesis(authorName);
	}
	
	private static void processArticles(String authorName){
	
		// Article Processing
		List<Article> articleDataSet = Data.getArticles();
		
		for (Article a: articleDataSet) {
			if (a.getAuthorName() != null) {
				String authorKey =  a.getAuthorName().toLowerCase().contains(authorName) ? 
									authorName : a.getAuthorName();
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
	
	private static void processInproceedings(String authorName){
		
		List<Inproceeding> inproceedingsDataSet = Data.getInproceedings();
		
		for (Inproceeding i: inproceedingsDataSet) {
			if (i.getAuthorName() != null) {
				String authorKey =  i.getAuthorName().toLowerCase().contains(authorName) ? 
									authorName : i.getAuthorName();
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
	
	private static void processIncollections(String authorName){
		
		List<Incollection> incollectionDataSet = Data.getIncollections();
		
		for (Incollection i: incollectionDataSet) {
			if (i.getAuthorName() != null) {
				String authorKey =  i.getAuthorName().toLowerCase().contains(authorName) ? 
									authorName : i.getAuthorName();
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
	
	private static void processPhdThesis(String authorName){
		
		List<PhdThesis> phdThesisDataSet = Data.getPhdthesis();
		
		for (PhdThesis p: phdThesisDataSet) {
			if (p.getAuthorName() != null) {
				String authorKey =  p.getAuthorName().toLowerCase().contains(authorName) ? 
									authorName : p.getAuthorName();
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