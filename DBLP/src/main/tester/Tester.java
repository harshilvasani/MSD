package tester;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import backend.BackEnd;
import queryengine.app.App;
import queryengine.app.utils.SimilarAuthor;
import queryengine.interfaces.IFilter;
import queryengine.interfaces.ISearch;
import queryengine.query.utils.AbsenceFromCommittees;
import queryengine.query.utils.AuthorName;
import queryengine.query.utils.Conferences;
import queryengine.query.utils.MinPublications;
import queryengine.query.utils.Title;
import queryengine.query.utils.Year;
import resources.person.Author;
import resources.person.Editor;
import resources.person.IPerson;


public class Tester {

	public static void main(String[] args) {
		
		//
		/*object should not die*/
		//
		BackEnd backend = new BackEnd();
		
		//frontend.parseXMLAndInsertData();
		//frontend.textParser();
		backend.loadData(0);
		System.out.println("Data loaded");
		App app = new App();
		
		// From front end
		List<ISearch> searchCriteria = new ArrayList<ISearch>();
		searchCriteria.add(new Title("proc supv signal"));
		searchCriteria.add(new Year(2008));
		List<IPerson> searchPerson = app.search(searchCriteria);
		
		for(IPerson person: searchPerson){
			if(person instanceof Author){
				System.out.println(((Author)person).toString());
				System.out.println();
			}
			if(person instanceof Editor){
				System.out.println(((Editor)person).getPersonName());
			}
		}
		System.out.println("---------------------------- COmmon Authors ---------");
		// 
/*		AuthorName aname = new AuthorName("al");
		searchPerson = app.searchCoAuthors(aname);
		for(IPerson person: searchPerson){
			if (person instanceof Author){
				System.out.println(((Author)person).toString());
				System.out.println();
			}
			if (person instanceof Editor){
				System.out.println(((Editor)person).getPersonName());

			}
		}*/
		System.out.println("\n---------------------------- Simiilar Authors ---------\n");
		AuthorName a2name = new AuthorName("Jan Vitek");
		
		List<IPerson> similarAuthors = app.searchSimilarAuthors(a2name);
		
		for (IPerson a: similarAuthors) {
			System.out.println(a.getPersonName() + " " + ((SimilarAuthor) a).getScore());
		}
		System.out.println(similarAuthors.size());
		/*System.out.println("---------------------------- conferences ---------");
		// 
		searchCriteria = new ArrayList<ISearch>();
		//searchCriteria.add(new Conferences("lncs, ecoop"));
		searchCriteria.add(new AbsenceFromCommittees("19"));
		searchPerson = app.search(searchCriteria);
		
		for(IPerson person: searchPerson){
			if(person instanceof Author){
				System.out.println(((Author)person).toString());
				System.out.println();
			}
			if(person instanceof Editor){
				System.out.println(((Editor)person).getPersonName());
			}
		}
		System.out.println("\n------Absence from committee---------\n");
		System.out.println(searchPerson.size());
		
		Set<String> temp = new HashSet<String>();
		for (IPerson person: searchPerson) {
			temp.add(((Author) person).toString());
		}
		searchCriteria = new ArrayList<ISearch>();
		//searchCriteria.add(new Conferences("lncs, ecoop"));
		searchPerson = app.search(searchCriteria);
		System.out.println(searchPerson.size());
		for (IPerson person: searchPerson) {
			String name = person.getPersonName();
			if (!temp.contains(((Author) person).toString())) {
				System.out.println(((Author)person).toString());
				// Should print only Rachid for load data param = 100
			}
		}
		System.out.println("\n------Min Publications---------\n");
		searchCriteria = new ArrayList<ISearch>();
		searchCriteria.add(new Year(1995));
		searchPerson = app.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<IFilter>();
		filterCriteria.add(new MinPublications("3"));
		
		searchPerson = app.filter(filterCriteria, searchPerson);
		
		for(IPerson person: searchPerson){
			if(person instanceof Author){
				System.out.println(((Author)person).toString());
				System.out.println();
			}
			if(person instanceof Editor){
				System.out.println(((Editor)person).getPersonName());
			}
		}
		System.out.println("\n------Filter Name---------\n");
		
		// Filter using name as well
		filterCriteria.add(new AuthorName("james"));
		
		searchPerson = app.filter(filterCriteria, searchPerson);
		
		for(IPerson person: searchPerson){
			if(person instanceof Author){
				System.out.println(((Author)person).toString());
				System.out.println();
			}
			if(person instanceof Editor){
				System.out.println(((Editor)person).getPersonName());
			}
		}*/
	}
}
