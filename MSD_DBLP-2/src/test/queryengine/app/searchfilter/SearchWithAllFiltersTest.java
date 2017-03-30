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

public class SearchWithAllFiltersTest {

	private App aObj = App.getAppInstance();


	// Searching authors based on keywords in title of publication
	// and all filter criteria - Min No. of Publications and Author name contains
	@Test
	public void SearchSuccessSearchByTitleAndAuthorNameAndAuthorNameAndMinimumPublications(){
		ISearch title = new Title("Deductive Object Databases.");
		IFilter author = new AuthorName("eli");
		IFilter minPublication = new MinPublications("15");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(title));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author, minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);	
		assertTrue(actualResult.size() == 0);
	}

	// Searching authors based on keywords in title of publication and year of publication
	// and all filter criteria - Min No. of Publications and Author name contains
	@Test
	public void SearchSuccessSearchByTitleAndYearAndAuthorNameAndAuthorNameAndMinimumPublications(){
		ISearch title = new Title("Tagged Objects");
		ISearch year = new Year("2015");
		IFilter author = new AuthorName("Troy");
		IFilter minPublication = new MinPublications("10");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(title, year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author, minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Searching authors based on based on year of publication
	// and all filter criteria - Min No. of Publications and Author name contains
	@Test
	public void SearchSuccessSearchByYearAndAuthorNameAndAuthorNameAndMinimumPublications(){
		ISearch year = new Year("2015");
		IFilter author = new AuthorName("Elizabeth");
		IFilter minPublication = new MinPublications("20");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author, minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Search based on Conference of publication
	// and all filter criteria - Min No. of Publications and Author name contains
	@Test
	public void SearchSuccessSearchByJournalAndAuthorNameAndAuthorNameAndMinimumPublications(){
		ISearch conference = new Conferences("IEEE");
		IFilter author = new AuthorName("Jenny");
		IFilter minPublication = new MinPublications("25");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author, minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Search using 2 criteria - Title(Keywords) and Conference of publication
	// and all filter criteria - Min No. of Publications and Author name contains
	@Test
	public void SearchSuccessSearchByJournalAndTitleAndAuthorNameAndAuthorNameAndMinimumPublications(){
		ISearch conference = new Conferences("ECOOP");
		ISearch title = new Title("Real time filters");
		IFilter author = new AuthorName("William");
		IFilter minPublication = new MinPublications("20");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, title));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author, minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Search using 2 criteria - Year and Conference of publication
	// and all filter criteria - Min No. of Publications and Author name contains
	@Test
	public void SearchSuccessSearchByJournalAndYearAndAuthorNameAndMinimumPublications(){
		ISearch conference = new Conferences("ECOOP");
		ISearch year = new Year("2013");
		IFilter author = new AuthorName("Michael");
		IFilter minPublication = new MinPublications("5");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author, minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Search using 2 criteria - Conference of publication and number of years not present on a committee
	// and all filter criteria - Min No. of Publications and Author name contains
	@Test
	public void SearchSuccessSearchByJournalAndAbsenceFromCommitteesAndAuthorNameAndMinimumPublications(){
		ISearch conference = new Conferences("IEEE");
		ISearch absenceFromCommittees = new AbsenceFromCommittees("3");
		IFilter author = new AuthorName("Shim");
		IFilter minPublication = new MinPublications("5");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, absenceFromCommittees));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author, minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 9);
	}

	// Search using 2 criteria - Year and number of years not present on a committee
	// and all filter criteria - Min No. of Publications and Author name contains
	@Test
	public void SearchSuccessSearchByYearAndAbsenceFromCommitteesAndAuthorNameAndMinimumPublications(){
		ISearch year = new Year("2015");
		ISearch absenceFromCommittees = new AbsenceFromCommittees("2");
		IFilter author = new AuthorName("Raj");
		IFilter minPublication = new MinPublications("10");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(year, absenceFromCommittees));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author, minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Search using 3 criteria - Year, Conference of publication and number of years not present on a committee
	// and all filter criteria - Min No. of Publications and Author name contains
	@Test
	public void SearchSuccessSearchByJournalAndAbsenceFromCommitteesAndYearAndAuthorNameAndMinimumPublications(){
		ISearch conference = new Conferences("IEEE");
		ISearch year = new Year("2007");
		ISearch absenceFromCommittees = new AbsenceFromCommittees("5");
		IFilter author = new AuthorName("Rao");
		IFilter minPublication = new MinPublications("50");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, absenceFromCommittees, year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author, minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Search using 3 criteria - Title(Keywords), Year and Conference of publication
	// and all filter criteria - Min No. of Publications and Author name contains
	@Test
	public void SearchSuccessSearchByJournalAndTitleAndYearAndAuthorNameAndMinimumPublications(){
		ISearch conference = new Conferences("IEEE");
		ISearch title = new Title("Association Rules Categorical");
		ISearch year = new Year("2000");
		IFilter author = new AuthorName("Jing");
		IFilter minPublication = new MinPublications("10");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, title, year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author, minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Search using based on number of years not present on a committee
	// and all filter criteria - Min No. of Publications and Author name contains
	@Test
	public void SearchSuccessSearchByAbsenceFromCommitteesAndAuthorNameAndMinimumPublications(){
		ISearch absenceFromCommittees  = new AbsenceFromCommittees ("2");
		IFilter author = new AuthorName("Rao");
		IFilter minPublication = new MinPublications("25");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absenceFromCommittees));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author, minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 27);
	}

	// Search using 2 criteria - Title(Keywords) and number of years not present on a committee
	// and all filter criteria - Min No. of Publications and Author name contains
	@Test
	public void SearchSuccessSearchByAbsenceFromCommitteesAndTitleAndAuthorNameAndMinimumPublications(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("5");
		ISearch title = new Title("Structured documents difference");
		IFilter author = new AuthorName("Lee");
		IFilter minPublication = new MinPublications("5");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author, minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Search using 3 criteria - Title(Keywords), Year and number of years not present on a committee
	// and all filter criteria - Min No. of Publications and Author name contains
	@Test
	public void SearchSuccessSearchByAbsenceFromCommitteesAndTitleAndYearAndAuthorNameAndMinimumPublications(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("5");
		ISearch title = new Title("sub graph queries");
		ISearch year = new Year("2014");
		IFilter author = new AuthorName("Choi");
		IFilter minPublication = new MinPublications("15");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title, year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author, minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Search using 3 criteria - Title(Keywords), Conference of publication and number of years not present on a committee
	// and all filter criteria - Min No. of Publications and Author name contains
	@Test
	public void SearchSuccessSearchByAbsenceFromCommitteesAndTitleAndJournalAndAuthorNameAndMinimumPublications(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("3");
		ISearch title = new Title("threshold network graph");
		ISearch conference = new Conferences("IEEE");
		IFilter author = new AuthorName("Ran");
		IFilter minPublication = new MinPublications("5");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title, conference));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author, minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Search using all criteria - Title(Keywords), Year, Conference of publication and number of years not present on a committee
	// and all filter criteria - Min No. of Publications and Author name contains
	@Test
	public void SearchSuccessSearchByAbsenceFromCommitteesAndTitleAndYearAndJournalAndAuthorNameAndMinimumPublications(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("3");
		ISearch title = new Title("parallel computing");
		ISearch year = new Year("2015");
		ISearch conference = new Conferences("Data Mining");
		IFilter author = new AuthorName("Mirek");
		IFilter minPublication = new MinPublications("5");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title, year, conference));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author, minPublication));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}	
}
