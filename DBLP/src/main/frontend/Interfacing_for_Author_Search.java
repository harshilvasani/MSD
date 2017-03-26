package frontend;
import java.util.ArrayList;
import java.util.List;

import queryengine.app.App;
import queryengine.interfaces.IQuery;
import queryengine.interfaces.ISearch;
import queryengine.query.utils.Title;
import queryengine.query.utils.Year;
import resources.person.IPerson;

public class Interfacing_for_Author_Search {
	private String titleText;
	private String searchYear;
	private String journalName;
	private String absenceYears;
	private String authorNameContains;
	private String minimumPublications;
	private String favoriteAuthor;
	private List<IPerson> result;
	public Interfacing_for_Author_Search(String titleText, String searchYear,
			String journalName, String absenceYears){
		this.titleText = titleText;
		this.searchYear = searchYear;
		this.journalName = journalName;
		this.absenceYears = absenceYears;
	}
	public void sendSearchCriteriaToApp(){
		App app = new App();
		List<ISearch> searchCriteria = new ArrayList<ISearch>();
		searchCriteria.add(new Title(titleText));
		searchCriteria.add(new Year(Integer.parseInt(this.searchYear)));
		searchCriteria.add(new JournalName(journalName));
		searchCriteria.add(new Committee_Absence(Integer.parseInt(absenceYears)));
		if (searchCriteria.size() > 0)
			this.result = app.search(searchCriteria);
	}
}
