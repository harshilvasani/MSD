package queryengine.app.searchfilter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import queryengine.app.App;
import queryengine.interfaces.IFilter;
import queryengine.interfaces.ISearch;
import queryengine.query.utils.*;
import resources.personrecord.IPerson;


public class SearchWithOneFilterMinPublicationTest {

	private App aObj = App.getAppInstance();

	// Searching authors based on keywords in title of publication
	// and filter criteria - minimum number of publications
	@Test
	public void SearchSuccessSearchByTitleAndMinimumPublications(){
		ISearch title = new Title("spatial logics");
		IFilter minPublication = new MinPublications("5");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(title));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Searching authors based on keywords in title of publication and filtering it based on year
	@Test
	public void SearchSuccessSearchByTitleAndYearAndMinimumPublications(){
		ISearch title = new Title("Constrait Programming");
		ISearch year = new Year("2006");
		IFilter minPublication = new MinPublications("5");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(title, year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Searching authors based on based on year of publication
	// and filter criteria - minimum number of publications
	@Test
	public void SearchSuccessSearchByYearAndMinimumPublications(){
		ISearch year = new Year("2015");
		IFilter minPublication = new MinPublications("20");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 223);
	}

	// Search based on Conference of publication
	// and filter criteria - minimum number of publications
	@Test
	public void SearchSuccessSearchByConferencesAndMinimumPublications(){
		ISearch conference = new Conferences("IEEE");
		IFilter minPublication = new MinPublications("15");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 1187);
	}

	// Search with 2 criteria - Title(Keywords) and Conference of publication
	// and filter criteria - minimum number of publications
	@Test
	public void SearchSuccessSearchByConferencesAndTitleAndMinimumPublications(){
		ISearch conference = new Conferences("ECOOP");
		ISearch title = new Title("Semantic analysis");
		IFilter minPublication = new MinPublications("5");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, title));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Search with 2 criteria - Year and Conference of publication
	// and filter criteria - minimum number of publications
	@Test
	public void SearchSuccessSearchByConferencesAndYearAndMinimumPublications(){
		ISearch conference = new Conferences("Gradual Typing for Objects.");
		ISearch year = new Year("2010");
		IFilter minPublication = new MinPublications("5");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Search with 2 criteria - Conference of publication and number of years they have not been on a committee
	// and filter criteria - minimum number of publications
	@Test
	public void SearchSuccessSearchByConferencesAndAbsenceFromCommitteesAndMinimumPublications(){
		ISearch conference = new Conferences("IEEE");
		ISearch absenceFromCommittees = new AbsenceFromCommittees("3");
		IFilter minPublication = new MinPublications("25");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, absenceFromCommittees));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 416);
	}

	// Search with 2 criteria - Year and number of years they have not been on a committee
	// and filter criteria - minimum number of publications
	@Test
	public void SearchSuccessSearchByYearAndAbsenceFromCommitteesAndMinimumPublications(){
		ISearch year = new Year("2014");
		ISearch absenceFromCommittees = new AbsenceFromCommittees("5");
		IFilter minPublication = new MinPublications("20");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(year, absenceFromCommittees));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 326);
	}

	// Search with 3 criteria - Year, Conference of publication and number of years they have not been on a committee
	// and filter criteria - minimum number of publications
	@Test
	public void SearchSuccessSearchByConferencesAndAbsenceFromCommitteesAndYearAndMinimumPublications(){
		ISearch conference = new Conferences("FICS");
		ISearch year = new Year("2010");
		ISearch absenceFromCommittees = new AbsenceFromCommittees("3");
		IFilter minPublication = new MinPublications("5");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, absenceFromCommittees, year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Search with 3 criteria - Title(Keywords), Year and Conference of publication
	// and filter criteria - minimum number of publications
	@Test
	public void SearchSuccessSearchByConferencesAndTitleAndYearAndMinimumPublications(){
		ISearch conference = new Conferences("FICS");
		ISearch title = new Title("Feature Interactions Outside a Telecom Domain.");
		ISearch year = new Year("2000");
		IFilter minPublication = new MinPublications("15");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, title, year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Search based on number of years they have not been on a committee
	// and filter criteria - minimum number of publications
	@Test
	public void SearchSuccessSearchByAbsencefromCommitteeAndMinimumPublications(){
		ISearch absenceFromCommittees  = new AbsenceFromCommittees ("2");
		IFilter minPublication = new MinPublications("100");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absenceFromCommittees));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 386);
	}

	// Search with 2 criteria - Title(Keywords) and number of years they have not been on a committee
	// and filter criteria - minimum number of publications
	@Test
	public void SearchSuccessSearchByAbsencefromCommitteeAndTitleAndMinimumPublications(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("5");
		ISearch title = new Title("Implementing scoped method tracing with ContextJS.");
		IFilter minPublication = new MinPublications("5");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Search with 3 criteria - Title(Keywords), Year, and number of years they have not been on a committee
	// and filter criteria - minimum number of publications
	@Test
	public void SearchSuccessSearchByAbsencefromCommitteeAndTitleAndYearAndMinimumPublications(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("2");
		ISearch title = new Title("Java Virtual Types");
		ISearch year = new Year("1990");
		IFilter minPublication = new MinPublications("25");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title, year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Search with 3 criteria - Title(Keywords), Conference of publication and number of years they have not been on a committee
	// and filter criteria - minimum number of publications
	@Test
	public void SearchSuccessSearchByAbsencefromCommitteeAndTitleAndConferencesAndMinimumPublications(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("3");
		ISearch title = new Title("Distributeed Cache Store");
		ISearch conference = new Conferences("ECOOP");
		IFilter minPublication = new MinPublications("5");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title, conference));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Search with all criteria - Title(Keywords), Year, Conference of publication and number of years they have not been on a committee
	// and filter criteria - minimum number of publications
	@Test
	public void SearchSuccessSearchByAbsencefromCommitteeAndTitleAndYearAndConferencesAndMinimumPublications(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("3");
		ISearch title = new Title("Space and Time efficient");
		ISearch year = new Year(2007);
		ISearch conference = new Conferences("ECOOP");
		IFilter minPublication = new MinPublications("5");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title, year, conference));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}
}


