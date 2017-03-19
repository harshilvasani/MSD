package resources;

import java.util.*;

import org.hibernate.*;

import persistence.HibernateUtil;
import resources.publicationRecord.*;

public class HibernateCRUD {
	
	public static void readTopXArticleRows(int rowsCount){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		session.beginTransaction();
		
		 try{
	         tx = session.beginTransaction();
	          
	         Query queryResult = session.createQuery("from Article");
	         
	         queryResult.setMaxResults(rowsCount);
	            
			 @SuppressWarnings("unchecked")
			List<Article> articles  = queryResult.list();
	         
	         for (Iterator<Article> iterator = articles.iterator(); iterator.hasNext();){
	        	 Article article = iterator.next(); 
	        	 
		        System.out.println("article-key: " + article.getKey());         
	         }
	         System.out.println();
	         
	         tx.commit();
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         
	      }finally {
	         session.close(); 
	      }
	}

	public static void readTopXBookRows(int rowsCount){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		session.beginTransaction();
		
		 try{
	         tx = session.beginTransaction();
	          
	         Query queryResult = session.createQuery("from Book");
	         
	         queryResult.setMaxResults(rowsCount);
	            
			 @SuppressWarnings("unchecked")
			List<Book> books  = queryResult.list();
	         
	         for (Iterator<Book> iterator = books.iterator(); iterator.hasNext();){
	        	 Book book = iterator.next(); 
	        	 
		        System.out.println("book-key: " + book.getKey()); 
	         }
	         System.out.println();

	         tx.commit();
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         
	      }finally {
	         session.close(); 
	      }
	}

	public static void readTopXIncollectionRows(int rowsCount){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		session.beginTransaction();
		
		 try{
	         tx = session.beginTransaction();
	          
	         Query queryResult = session.createQuery("from Incollection");
	         
	         queryResult.setMaxResults(rowsCount);
	            
			 @SuppressWarnings("unchecked")
			List<Incollection> incollections  = queryResult.list();
	         
	         for (Iterator<Incollection> iterator = incollections.iterator(); iterator.hasNext();){
	        	 Incollection incollection = iterator.next(); 
	        	 
		        System.out.println("incollection-key: " + incollection.getKey()); 
	         }
	         System.out.println();

	         tx.commit();
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         
	      }finally {
	         session.close(); 
	      }
	}

	public static void readTopXInproceedingRows(int rowsCount){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		session.beginTransaction();
		
		 try{
	         tx = session.beginTransaction();
	          
	         Query queryResult = session.createQuery("from Inproceeding");
	         
	         queryResult.setMaxResults(rowsCount);
	            
			 @SuppressWarnings("unchecked")
			List<Inproceeding> inproceedings  = queryResult.list();
	         
	         for (Iterator<Inproceeding> iterator = inproceedings.iterator(); iterator.hasNext();){
	        	 Inproceeding inproceeding = iterator.next(); 
	        	 
		        System.out.println("inproceeding-key: " + inproceeding.getKey()); 
	         }
	         System.out.println();

	         tx.commit();
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         
	      }finally {
	         session.close(); 
	      }
	}

	public static void readTopXPhdThesisRows(int rowsCount){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		session.beginTransaction();
		
		 try{
	         tx = session.beginTransaction();
	          
	         Query queryResult = session.createQuery("from PhdThesis");
	         
	         queryResult.setMaxResults(rowsCount);
	            
			 @SuppressWarnings("unchecked")
			List<PhdThesis> phdTheses  = queryResult.list();
	         
	         for (Iterator<PhdThesis> iterator = phdTheses.iterator(); iterator.hasNext();){
	        	 PhdThesis phdThesis = iterator.next(); 
	        	 
		        System.out.println("phdThesis-key: " + phdThesis.getKey()); 
	         }
	         System.out.println();

	         tx.commit();
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         
	      }finally {
	         session.close(); 
	      }
	}

	public static void readTopXProceedingRows(int rowsCount){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		session.beginTransaction();
		
		 try{
	         tx = session.beginTransaction();
	          
	         Query queryResult = session.createQuery("from Proceeding");
	         
	         queryResult.setMaxResults(rowsCount);
	            
			 @SuppressWarnings("unchecked")
			List<Proceeding> proceedings  = queryResult.list();
	         
	         for (Iterator<Proceeding> iterator = proceedings.iterator(); iterator.hasNext();){
	        	 Proceeding proceeding = iterator.next(); 
	        	 
		        System.out.println("proceeding-key: " + proceeding.getKey()); 
	         }
	         System.out.println();

	         tx.commit();
	         
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         
	      }finally {
	         session.close(); 
	      }
	}

}
