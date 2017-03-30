package queryengine.app.searchfilter;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import queryengine.app.App;
import queryengine.interfaces.ISearch;
import queryengine.query.utils.*;
import resources.personrecord.IPerson;

public class SearchWithoutFilterTest {

	private App app = App.getAppInstance();

	// Searching authors based on keywords in title of publication
	@Test
	public void SearchSuccessSearchByTitle(){
		ISearch title = new Title("analysis of data");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(title));
		List<IPerson> actualResult = app.search(searchCriteria);
		assertTrue(actualResult.size() == 11373);
	}

	// Searching authors based on keywords in title of publication and filtering it based on year
	@Test
	public void SearchSuccessSearchByTitleAndYear(){
		ISearch title = new Title("object-oriented");
		ISearch year = new Year("2007");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(title, year));
		List<IPerson> actualResult = app.search(searchCriteria);
		assertTrue(actualResult.size() == 528);
	}

	// Searching authors based on based on year of publication
	@Test
	public void SearchSuccessSearchByYear(){
		ISearch year = new Year("2012");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(year));
		List<IPerson> actualResult = app.search(searchCriteria);
		assertTrue(actualResult.size() == 76721);
	}

	// Search based on Conference in which paper was published
	@Test
	public void SearchSuccessSearchByConference(){
		ISearch conference = new Conferences("IEEE");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference));
		List<IPerson> actualResult = app.search(searchCriteria);
		assertTrue(actualResult.size() == 18563);
	}

	// Search using 2 criteria - Conference and Title of Paper
	@Test
	public void SearchSuccessSearchByConferencesAndTitle(){
		ISearch conference = new Conferences("ECOOP");
		ISearch title = new Title("Subobject-based Inheritance.");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, title));
		List<IPerson> actualResult = app.search(searchCriteria);
		assertTrue(actualResult.size() == 3);
	}

	// Search using 2 criteria - Year and Conference
	@Test
	public void SearchSuccessSearchByConferencesAndYear(){
		ISearch conference = new Conferences("IEEE");
		ISearch year = new Year("2013");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, year));
		List<IPerson> actualResult = app.search(searchCriteria);
		assertTrue(actualResult.size() == 4807);
	}

	// Search using 2 criteria - Conference and Number of years author has not been present on a committee
	@Test
	public void SearchSuccessSearchByConferencesAndAbsenceFromCommittees(){
		ISearch conference = new Conferences("WRT");
		ISearch absenceFromCommittees = new AbsenceFromCommittees("5");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, absenceFromCommittees));
		List<IPerson> actualResult = app.search(searchCriteria);
		assertTrue(actualResult.size() == 3);
	}

	// Search using 2 criteria - Year and Number of years author has not been present on a committee
	@Test
	public void SearchSuccessSearchByYearAndAbsenceFromCommittees(){
		ISearch year = new Year("2011");
		ISearch absenceFromCommittees = new AbsenceFromCommittees("3");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(year, absenceFromCommittees));
		List<IPerson> actualResult = app.search(searchCriteria);
		assertTrue(actualResult.size() == 91567);
	}

	// Search using 3 criteria - Year, Conference and Number of years author has not been present on a committee
	@Test
	public void SearchSuccessSearchByConferencesAndAbsenceFromCommitteesAndYear(){
		ISearch conference = new Conferences("FICS");
		ISearch year = new Year("2000");
		ISearch absenceFromCommittees = new AbsenceFromCommittees("3");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, absenceFromCommittees, year));
		List<IPerson> actualResult = app.search(searchCriteria);
		assertTrue(actualResult.size() == 0);
	}

	// Search using 3 criteria - Year, Conference and Title of Paper
	@Test
	public void SearchSuccessSearchByConferencesAndTitleAndYear(){
		ISearch conference = new Conferences("RAM-SE");
		ISearch title = new Title("Publish-Subscribe Interaction.");
		ISearch year = new Year("2003");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, title, year));
		List<IPerson> actualResult = app.search(searchCriteria);
		assertTrue(actualResult.size() == 0);
	}

	// Search based on Number of years author has not been present on a committee
	@Test
	public void SearchSuccessSearchByAbsencefromCommittee(){
		ISearch absenceFromCommittees  = new AbsenceFromCommittees ("10");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absenceFromCommittees));
		List<IPerson> actualResult = app.search(searchCriteria);
		assertTrue(actualResult.size() == 211429);
	}

	// Search using 2 criteria - Title of Paper and Number of years author has not been present on a committee
	@Test
	public void SearchSuccessSearchByAbsencefromCommitteeAndTitle(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("5");
		ISearch title = new Title("DNA");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title));
		List<IPerson> actualResult = app.search(searchCriteria);
		assertTrue(actualResult.size() == 145);
	}

	// Search using 3 criteria - Year, Title of Paper and Number of years author has not been present on a committee
	@Test
	public void SearchSuccessSearchByAbsencefromCommitteeAndTitleAndYear(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("10");
		ISearch title = new Title("Multiple Granularities of Parallelism");
		ISearch year = new Year("1980");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title, year));
		List<IPerson> actualResult = app.search(searchCriteria);
		assertTrue(actualResult.size() == 3);
	}

	// Search using 3 criteria - Conference, Title of Paper and Number of years author has not been present on a committee
	@Test
	public void SearchSuccessSearchByAbsencefromCommitteeAndTitleAndConference(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("6");
		ISearch title = new Title("Data Centric Synchronization");
		ISearch conference = new Conferences("ECOOP");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title, conference));
		List<IPerson> actualResult = app.search(searchCriteria);
		assertTrue(actualResult.size() == 5);
	}

	// Search using all criteria - Year, Conference, Title of Paper and Number of years author has not been present on a committee
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
}
