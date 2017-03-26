package queryengine.app.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import resources.person.IPerson;

public class FilterUtils {
	
	public static List<IPerson> filterByAuthorName(String authorName, List<IPerson> searchResult) {
		List<IPerson> temp = new ArrayList<IPerson>();
		for (IPerson person: searchResult) {
			if (person.getPersonName() != null &&
				person.getPersonName().toLowerCase().contains(authorName)) {
				temp.add(person);
			}
		}
		return temp;
	}
	
	public static List<IPerson> filterByMinPublications(int minPublications, List<IPerson> searchResult) {
		List<IPerson> temp = new ArrayList<IPerson>();
		HashMap<String, Integer> publicationCount = new HashMap<String, Integer>();
		// Prepare Count
		for (IPerson person: searchResult) {
			Integer x = publicationCount.get(person.getPersonName());
			if (x == null) {
				x = 0;
			}
			publicationCount.put(person.getPersonName(), x + 1);
		}
		
		// Filter
		for (IPerson person: searchResult) {
			if (publicationCount.get(person.getPersonName()) >= minPublications) {
				temp.add(person);
			}
		}
		return temp;
	}
}