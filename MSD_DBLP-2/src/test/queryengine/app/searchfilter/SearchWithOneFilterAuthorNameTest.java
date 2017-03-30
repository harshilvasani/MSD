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


public class SearchWithOneFilterAuthorNameTest {

	private App aObj = App.getAppInstance();

	// Searching authors based on keywords in title of publication
	@Test
	public void SearchSuccessSearchByTitleAndAuthorName(){
		ISearch title = new Title("object-oriented");
		IFilter author = new AuthorName("andrew");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(title));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 16);
	}

	// Searching authors based on keywords in title of publication and filtering it based on year
	@Test
	public void SearchSuccessSearchByTitleAndYearAndAuthorName(){
		ISearch title = new Title("object-oriented");
		ISearch year = new Year("2016");
		IFilter author = new AuthorName("tom");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(title, year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Searching authors based on based on year of publication
	@Test
	public void SearchSuccessSearchByYearAndAuthorName(){
		ISearch year = new Year("1988");
		IFilter author = new AuthorName("Sunil");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 38);
	}

	// Searching based on Conference
	// and filter - Author name contains
	@Test
	public void SearchSuccessSearchByConferencesAndAuthorName(){
		ISearch conference = new Conferences("FICS");
		IFilter author = new AuthorName("Curtis");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Searching based on Title(Keywords) and Conference of publication
	// and filter - Author name contains
	@Test
	public void SearchSuccessSearchByConferencesAndTitleAndAuthorName(){
		ISearch conference = new Conferences("ECOOP");
		ISearch title = new Title("automation");
		IFilter author = new AuthorName("Mitchell");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, title));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Searching based on Conference of publication and year
	// and filter - Author name contains
	@Test
	public void SearchSuccessSearchByConferencesAndYearAndAuthorName(){
		ISearch conference = new Conferences("IEEE");
		ISearch year = new Year("2015");
		IFilter author = new AuthorName("John");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 6);
	}

	// Searching based on 2 criteria - Conference and absence from presence in committee in years
	// and filter - Author name contains
	@Test
	public void SearchSuccessSearchByConferencesAndAbsenceFromCommitteesAndAuthorName(){
		ISearch conference = new Conferences("IEEE");
		ISearch absenceFromCommittees = new AbsenceFromCommittees("2");
		IFilter author = new AuthorName("Mary");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, absenceFromCommittees));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 37);
	}

	// Searching based on 2 criteria -  Year and absence from presence in committee in years
	// and filter - Author name contains
	@Test
	public void SearchSuccessSearchByYearAndAbsenceFromCommitteesAndAuthorName(){
		ISearch year = new Year("2000");
		ISearch absenceFromCommittees = new AbsenceFromCommittees("5");
		IFilter author = new AuthorName("Craig");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(year, absenceFromCommittees));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 125);
	}

	// Searching based on 3 criteria - Year, Conference and absence from presence in committee in years
	// and filter - Author name contains
	@Test
	public void SearchSuccessSearchByConferencesAndAbsenceFromCommitteesAndYearAndAuthorName(){
		ISearch conference = new Conferences("ECOOP");
		ISearch year = new Year("2016");
		ISearch absenceFromCommittees = new AbsenceFromCommittees("3");
		IFilter author = new AuthorName("Robert");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, absenceFromCommittees, year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 1);
	}

	// Searching based on 3 criteria - Title(Keywords), Year and Conference
	// and filter - Author name contains
	@Test
	public void SearchSuccessSearchByConferencesAndTitleAndYearAndAuthorName(){
		ISearch conference = new Conferences("WRT");
		ISearch title = new Title("programming");
		ISearch year = new Year("2016");
		IFilter author = new AuthorName("Doug");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(conference, title, year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Searching based on absence from presence in committee in years
	// and filter - Author name contains
	@Test
	public void SearchSuccessSearchByAbsencefromCommitteeAndAuthorName(){
		ISearch absenceFromCommittees  = new AbsenceFromCommittees ("2");
		IFilter author = new AuthorName("andrew");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absenceFromCommittees));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 977);
	}

	// Searching based on 2 criteria - Title(Keywords) and absence from presence in committee in years
	// and filter - Author name contains
	@Test
	public void SearchSuccessSearchByAbsencefromCommitteeAndTitleAndAuthorName(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("5");
		ISearch title = new Title("Predicting Missing Items in Shopping Carts.");
		IFilter author = new AuthorName("Kamal");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 1);
	}

	// Searching based on 3 criteria - Title(Keywords), Year and absence from presence in committee in years
	// and filter - Author name contains
	@Test
	public void SearchSuccessSearchByAbsencefromCommitteeAndTitleAndYearAndAuthorName(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("6");
		ISearch title = new Title("A Similarity Measure for Comparing XACML Policies.");
		ISearch year = new Year("2011");
		IFilter author = new AuthorName("Rao");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title, year));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 1);
	}

	// Searching based on 3 criteria - Title(Keywords), Conference and absence from presence in committee in years
	// and filter - Author name contains
	@Test
	public void SearchSuccessSearchByAbsencefromCommitteeAndTitleAndConferencesAndAuthorName(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("2");
		ISearch title = new Title("A Rule-Based Object-Oriented OWL Reasoner.");
		ISearch conference = new Conferences("ECOOP");
		IFilter author = new AuthorName("tony");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title, conference));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 0);
	}

	// Searching based on all criteria - Title(Keywords), Year, Conference and absence from presence in committee in years
	// and filter - Author name contains
	@Test
	public void SearchSuccessSearchByAbsencefromCommitteeAndTitleAndYearAndConferencesAndAuthorName(){
		ISearch absencefromCommittee = new AbsenceFromCommittees("5");
		ISearch title = new Title("Video Content Management in Consumer Devices.");
		ISearch year = new Year("1990");
		ISearch conference = new Conferences("IEEE");
		IFilter author = new AuthorName("thomas");
		List<ISearch> searchCriteria = new ArrayList<>(Arrays.asList(absencefromCommittee, title, year, conference));
		List<IPerson> interimResult = aObj.search(searchCriteria);
		List<IFilter> filterCriteria = new ArrayList<>(Arrays.asList(author));
		List<IPerson> actualResult = aObj.filter(filterCriteria, interimResult);
		assertTrue(actualResult.size() == 1);
	}
}


