package frontEnd;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import frontEnd.parser.Parser;
import frontEnd.parser.mySqlDatabase.Database;
import frontEnd.parser.publicationRecord.CommitteeMember;
import frontEnd.parser.publicationRecord.DBLP;
import persistence.Data;
import persistence.HibernateUtil;

public class FrontEnd implements IFrontEnd {

	private static String fileUri = "C:/Users/Harshil Vasani/Desktop/NEU/Sem - 3/MSD/Project/DATA/dblp.xml";
	final static File folder = new File("C:/Users/Harshil Vasani/Desktop/NEU/Sem - 3/MSD/Project/DATA/committees");
	private static Session session = null;
	private static Transaction tx = null;
	private static Query queryResult = null;
	
	public void parseXMLAndInsertData(){
		
		DBLP dblpTag = Parser.XmlParser(fileUri);
		
		try {
			Database.InsertDblpData(dblpTag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void textParser(){

		List<CommitteeMember> committeeMembers = Parser.ParseFilesForFolder(folder);
		System.out.println(committeeMembers.size());
		try {
			Database.InsertCommitteeData(committeeMembers);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param rowsCount If 0 or less, retrieves all rows. Else, retrieve rowCount no. of rows. Does for all tables
	 */
	@SuppressWarnings("unchecked")
	public void loadData(int rowsCount) {

		try{
			session = HibernateUtil.getSessionFactory().openSession();
			tx = null;

			session.beginTransaction();

			tx = session.beginTransaction();

			queryResult = session.createQuery("from Article");
			if (rowsCount > 0)
				queryResult.setMaxResults(rowsCount);   
			Data.setArticles(queryResult.list());

			queryResult = session.createQuery("from Book");
			if (rowsCount > 0)  
				queryResult.setMaxResults(rowsCount);
			Data.setBooks(queryResult.list());

			queryResult = session.createQuery("from Incollection");
			if (rowsCount > 0)  
				queryResult.setMaxResults(rowsCount);
			Data.setIncollections(queryResult.list());

			queryResult = session.createQuery("from Inproceeding");
			if (rowsCount > 0)  
				queryResult.setMaxResults(rowsCount);
			Data.setInproceedings(queryResult.list());

			queryResult = session.createQuery("from PhdThesis");
			if (rowsCount > 0)  
				queryResult.setMaxResults(rowsCount);
			Data.setPhdtheses(queryResult.list());

			queryResult = session.createQuery("from Proceeding");
			if (rowsCount > 0)  
				queryResult.setMaxResults(rowsCount);
			Data.setProceedings(queryResult.list());

			/*queryResult = session.createQuery("from CommitteeMember");
			if (rowsCount > 0)  
				queryResult.setMaxResults(rowsCount);
			Data.setCommitteeMembers(queryResult.list());
			*/
			tx.commit();

		}catch (HibernateException e) {
			if (tx != null) 
				tx.rollback();
			e.printStackTrace();
			System.err.println("Load Failed.. Please Restart Application!");
			System.exit(-1);
		}finally {
			if(session != null)
				session.close(); 
		}
	}
}
