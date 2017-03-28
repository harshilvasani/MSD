package backend.parser.mysqldb;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.*;
import org.junit.Test;

import persistence.HibernateUtil;
import resources.personrecord.FavouriteAuthor;
import resources.personrecord.User;
import resources.pubrec.*;

@SuppressWarnings("unchecked")
public class DatabaseTest {
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	@Test
	public void testDatabaseConnection() {	
		assertTrue(session instanceof org.hibernate.Session);	
	}
	
	@Test
	public void articleTableExists(){
		 
		List<Article> articles = null;
		try{
			Query query = session.createQuery("from Article");
			articles = query.list();
		}catch(Exception e){
			
		}
		assertTrue(articles != null);
	}

	@Test
	public void bookTableExists(){
		List<Book> books = null;
		try{
			Query query = session.createQuery("from Book");
			books = query.list();
		}catch(Exception e){
			
		}
		assertTrue(books != null);
	}
	
	@Test
	public void committeeMemberTableExists(){
		
		List<CommitteeMember> committeeMembers = null;
		try{
			Query query = session.createQuery("from CommitteeMember");
			committeeMembers = query.list();
		}catch(Exception e){
			
		}
		assertTrue(committeeMembers != null);
		
	}
	
	@Test
	public void inCollectionTableExists(){
		List<Incollection> incollections = null;
		try{
			Query query = session.createQuery("from Incollection");
			incollections = query.list();
		}catch(Exception e){
			
		}
		assertTrue(incollections != null);
	}
	
	@Test
	public void inProceedingTableExists(){
		
		List<Inproceeding> inproceedings = null;
		try{
			Query query = session.createQuery("from Inproceeding");
			inproceedings = query.list();
		}catch(Exception e){
			
		}
		assertTrue(inproceedings != null);
	}
	
	@Test
	public void phdThesisTableExists(){
		List<PhdThesis> phdTheses = null;
		try{
			Query query = session.createQuery("from PhdThesis");
			phdTheses = query.list();
		}catch(Exception e){
			
		}
		assertTrue(phdTheses != null);
		
	}
	
	@Test
	public void proceedingTableExists(){
		List<Proceeding> proceedings = null;
		try{
			Query query = session.createQuery("from Proceeding");
			proceedings = query.list();
		}catch(Exception e){
			
		}
		assertTrue(proceedings != null);
	}
	
	@Test
	public void userTableExists(){
		List<User> users = null;
		try{
			Query query = session.createQuery("from User");
			users = query.list();
		}catch(Exception e){
			
		}
		assertTrue(users != null);
	}
	
	@Test
	public void favoriteListTableExists(){
		List<FavouriteAuthor> favoriteLists = null;
		try{
			Query query = session.createQuery("from FavouriteAuthor");
			favoriteLists = query.list();
		}catch(Exception e){
			
		}
		assertTrue(favoriteLists != null);
	}
}
