package queryengine.app.utils;

import java.util.ArrayList;
import java.util.List;

import queryengine.interfaces.ISearch;
import resources.person.IPerson;

public class FilterUtils {
	public static List<IPerson> filterResults(List<IFilter> searchCriteria, List<IPerson> searchResult) {
		
		return null;
	}
	
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
}
