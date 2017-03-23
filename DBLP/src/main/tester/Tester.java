package tester;

import java.util.ArrayList;
import java.util.List;

import frontEnd.FrontEnd;
import queryengine.app.App;
import queryengine.interfaces.ISearch;
import queryengine.query.utils.Title;
import resources.personRecord.Author;
import resources.personRecord.Editor;
import resources.personRecord.IPerson;


public class Tester {

	public static void main(String[] args) {
		
		//
		/*object should not die*/
		//
		FrontEnd frontend = new FrontEnd();
		
		//frontend.parseXMLAndInsertData();
		//frontend.textParser();
		frontend.loadData(25);
		
		App app = new App();
		
		// From front end
		List<ISearch> searchCriteria = new ArrayList<ISearch>();
		searchCriteria.add(new Title("proc"));
		
		List<IPerson> searchPerson = app.search(searchCriteria);
		
		for(IPerson person:searchPerson){
			if(person instanceof Author){
				System.out.println(((Author)person).getPersonName());
				System.out.println(((Author)person).getPublicationTitle());
				System.out.println(((Author)person).getPublicationType());
				System.out.println(((Author)person).getPublicationYear());
				System.out.println(((Author)person).getPublicationId());
				System.out.println();
			}
			if(person instanceof Editor){
				System.out.println(((Editor)person).getPersonName());

			}
		}
	}
}
