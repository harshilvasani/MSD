package tester;

import java.util.ArrayList;
import java.util.List;

import backend.BackEnd;
import queryengine.app.App;
import queryengine.interfaces.ISearch;
import queryengine.query.utils.AuthorName;
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
		backend.loadData(20);
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
		AuthorName aname = new AuthorName("alex");
		searchPerson = app.searchCoAuthors(aname);
		for(IPerson person: searchPerson){
			if (person instanceof Author){
				System.out.println(((Author)person).toString());
				System.out.println();
			}
			if (person instanceof Editor){
				System.out.println(((Editor)person).getPersonName());

			}
		}
		
		//Victor Khomenko
	}
}
