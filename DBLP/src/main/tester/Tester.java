package tester;

import java.util.ArrayList;
import java.util.List;

import backend.FrontEnd;
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
		FrontEnd frontend = new FrontEnd();
		
		//frontend.parseXMLAndInsertData();
		//frontend.textParser();
		frontend.loadData(200);
		
		App app = new App();
		
		// From front end
		List<ISearch> searchCriteria = new ArrayList<ISearch>();
		searchCriteria.add(new Title("proc"));
		searchCriteria.add(new Year(2007));
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
		AuthorName aname = new AuthorName("Christian");
		searchPerson = app.searchCoAuthors(aname);
		for(IPerson person: searchPerson){
			if(person instanceof Author){
				System.out.println(((Author)person).toString());
				System.out.println();
			}
			if(person instanceof Editor){
				System.out.println(((Editor)person).getPersonName());

			}
		}
		
		//Victor Khomenko
	}
}
