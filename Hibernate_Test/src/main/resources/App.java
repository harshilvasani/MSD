package resources;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.HibernateUtil;
import resources.PersonRecord.Author;
import resources.PublicationRecord.Citation;
import resources.PublicationRecord.Conference;
import resources.PublicationRecord.Paper;

public class App {
	public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        //readTopXCityRows(10);
        readTopXAuthorRows(10);
        System.out.println("-------------------");
        readTopXCitationRows(10);
        System.out.println("-------------------");
        readTopXConferenceRows(10);
        System.out.println("-------------------");
        readTopXPaperRows(10);
    }
	
	private static void readTopXPaperRows(int rowsCount){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		session.beginTransaction();
		
		 try{
	         tx = session.beginTransaction();
	          
	         Query queryResult = session.createQuery("from Paper");
	         
	         queryResult.setMaxResults(rowsCount);
	         
	         @SuppressWarnings("unchecked")
			List<Paper> papers  = queryResult.list();
	         
	         for (Iterator<Paper> iterator = papers.iterator(); iterator.hasNext();){
	        	 Paper paper = iterator.next(); 
	        	System.out.print("Id: " + paper.getId()); 
	            System.out.print(" Conference: " + paper.getConference()); 
	            System.out.print(" Paper Key: " + paper.getPaperKey()); 	
	            System.out.print(" Title: " + paper.getTitle()); 
	            System.out.println(" Year: " + paper.getYear()); 

	         }
	         
	         tx.commit();
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         
	      }finally {
	         session.close(); 
	      }
	}
	
	private static void readTopXAuthorRows(int rowsCount){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		session.beginTransaction();
		
		 try{
	         tx = session.beginTransaction();
	          
	         Query queryResult = session.createQuery("from Author");
	         
	         queryResult.setMaxResults(rowsCount);
	         
	         @SuppressWarnings("unchecked")
			List<Author> authors  = queryResult.list();
	         
	         for (Iterator<Author> iterator = authors.iterator(); iterator.hasNext();){
	        	 Author author = iterator.next(); 
	        	 
		        System.out.print("Id: " + author.getId()); 

	            System.out.print(" City Id: " + author.getAuthorName()); 
	            System.out.println(" City Name: " + author.getPaperKey()); 
	         }
	         
	         tx.commit();
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         
	      }finally {
	         session.close(); 
	      }
	}
		
	private static void readTopXConferenceRows(int rowsCount){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		session.beginTransaction();
		
		 try{
	         tx = session.beginTransaction();
	          
	         Query queryResult = session.createQuery("from Conference");
	         
	         queryResult.setMaxResults(rowsCount);
	         
	         @SuppressWarnings("unchecked")
			List<Conference> conferences  = queryResult.list();
	         
	         for (Iterator<Conference> iterator = conferences.iterator(); iterator.hasNext();){
	        	 Conference conference = iterator.next(); 
	        	 
		        System.out.print("Id: " + conference.getId()); 

	            System.out.print(" Conf Key: " + conference.getConfKey()); 
	            System.out.print(" Conf Name: " + conference.getConfName()); 
	            System.out.println(" Detail: " + conference.getDetail()); 
	         }
	         
	         tx.commit();
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         
	      }finally {
	         session.close(); 
	      }
	}
	
	private static void readTopXCitationRows(int rowsCount){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		session.beginTransaction();
		
		 try{
	         tx = session.beginTransaction();
	          
	         Query queryResult = session.createQuery("from Citation");
	         
	         queryResult.setMaxResults(rowsCount);
	         
	         @SuppressWarnings("unchecked")
			List<Citation> citations  = queryResult.list();
	         
	         for (Iterator<Citation> iterator = citations.iterator(); iterator.hasNext();){
	        	 Citation citation = iterator.next(); 
	        	 
			    System.out.print("Id: " + citation.getId()); 

	            System.out.print(" Paper Cited Key: " + citation.getPaperCitedKey()); 
	            System.out.println(" Paper Cite Key: " + citation.getPaperCiteKey()); 
	         }
	         
	         tx.commit();
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         
	      }finally {
	         session.close(); 
	      }
	}

}
