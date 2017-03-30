package queryengine.app;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import queryengine.interfaces.IFilter;
import queryengine.interfaces.ISearch;
import queryengine.query.utils.*;
import resources.personrecord.IPerson;

public class SearchFilterTest {

	App app = App.getAppInstance();	

	@Test
	public void SearchSuccessSearchByAbsencefromCommitteeAndTitleAndYearAndJournal(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("5");
		ISearch title = new Title("User-Centric Similarity Search.");
		ISearch year = new Year("2017");
		ISearch conference = new Conferences("IEEE");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title, year, conference));
		List<String> expectedResult = new ArrayList<String>(Arrays.asList("ID: 0 Name: Konstantinos Georgoulas Publication ID: 36 Publication Year: 2017 Journal/Publisher/Conf: IEEE Trans. Knowl. Data Eng.\n Publication Title: User-Centric Similarity Search. Publication Type: article",
				"ID: 0 Name: Akrivi Vlachou Publication ID: 37 Publication Year: 2017 Journal/Publisher/Conf: IEEE Trans. Knowl. Data Eng.\n Publication Title: User-Centric Similarity Search. Publication Type: article", 
				"ID: 0 Name: Christos Doulkeridis Publication ID: 38 Publication Year: 2017 Journal/Publisher/Conf: IEEE Trans. Knowl. Data Eng.\n Publication Title: User-Centric Similarity Search. Publication Type: article",
				"ID: 0 Name: Yannis Kotidis Publication ID: 39 Publication Year: 2017 Journal/Publisher/Conf: IEEE Trans. Knowl. Data Eng.\n Publication Title: User-Centric Similarity Search. Publication Type: article"));
		List<IPerson> actualResult = app.search(searchCriteria);
		for(int i=0; i<actualResult.size(); i++){
			assertTrue(actualResult.get(i).toString().equals(expectedResult.get(i)));
		}
	}
	@Test
	public void SearchSuccessSearchByAbsencefromCommitteeAndTitleAndYearAndJournalAnd(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("5");
		ISearch title = new Title("User-Centric Similarity Search.");
		ISearch year = new Year("2017");
		ISearch conference = new Conferences("IEEE");
		IFilter authorName = new AuthorName("Chris");
		IFilter minPublications = new MinPublications("1");
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(authorName, minPublications));
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title, year, conference));
		List<IPerson> actualResult = app.search(searchCriteria);
		assertTrue(actualResult.size() == 4);
	}

	@Test
	public void SearchSuccessSearchByYearAndAuthor(){
		ISearch year = new Year(2016);
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(year));
		List<String> expectedResult = new ArrayList<String>();
		List<IPerson> actualResult = app.search(searchCriteria);
		assertTrue(actualResult.size() == 12837);
	}

	@Test
	public void SearchSuccessSearchByAbsencefromCommitteeAndTitleAndYearAndConferencesAndAuthorName(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("3");
		ISearch title = new Title("Verifying traits fine-grained reuse.");
		Year year = new Year("2017");
		ISearch conference = new Conferences("ECOOP");
		IFilter authorName = new AuthorName("Johan");
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(authorName));
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title, year, conference));
		List<IPerson> actualResult = app.search(searchCriteria);
		actualResult = app.filter(filterCriteria, actualResult);
		assertTrue(actualResult.size() == 0);
	}
}
