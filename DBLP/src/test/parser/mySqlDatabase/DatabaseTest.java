package parser.mySqlDatabase;

import static org.junit.Assert.*;

import org.hibernate.*;
import org.junit.Test;

import persistence.HibernateUtil;

public class DatabaseTest {

	@Test
	public void testDatabaseConnection() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		assertTrue(s instanceof org.hibernate.Session);
		if (s!=null){
			s.close();
		}
	}
	
	@Test
	public void articleExists(){
		Object o = null;
		try{
			o = HibernateUtil.getSessionFactory().openSession().createQuery("from Article");
		}catch(Exception e){
			
		}
		assertTrue(o instanceof Query);
	}
	
	@Test
	public void bookExists(){
		Object o = null;
		try{
			o = HibernateUtil.getSessionFactory().openSession().createQuery("from Book");
		}catch(Exception e){
			
		}
		assertTrue(o instanceof Query);
	}
	
	@Test
	public void committeeMemberExists(){
		Object o = null;
		try{
			o = HibernateUtil.getSessionFactory().openSession().createQuery("from CommitteeMember");
		}catch(Exception e){
			
		}
		assertTrue(o instanceof Query);
	}
	
	@Test
	public void inCollectionExists(){
		Object o = null;
		try{
			o = HibernateUtil.getSessionFactory().openSession().createQuery("from Incollection");
		}catch(Exception e){
			
		}
		assertTrue(o instanceof Query);
	}
	
	@Test
	public void inProceedingExists(){
		Object o = null;
		try{
			o = HibernateUtil.getSessionFactory().openSession().createQuery("from Inproceeding");
		}catch(Exception e){
			
		}
		assertTrue(o instanceof Query);
	}
	
	@Test
	public void phdThesisExists(){
		Object o = null;
		try{
			o = HibernateUtil.getSessionFactory().openSession().createQuery("from PhdThesis");
		}catch(Exception e){
			
		}
		assertTrue(o instanceof Query);
	}
	
	@Test
	public void proceedingExists(){
		Object o = null;
		try{
			o = HibernateUtil.getSessionFactory().openSession().createQuery("from Proceeding");
		}catch(Exception e){
			
		}
		assertTrue(o instanceof Query);
	}
}
