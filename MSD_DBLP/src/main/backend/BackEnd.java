package backend;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import backend.parser.Parser;
import backend.parser.mysqldb.Database;
import backend.parser.pubrec.CommitteeMember;
import backend.parser.pubrec.DBLP;
import persistence.Data;
import persistence.HibernateUtil;
import queryengine.miscellaneous.ResponseMessage;
import resources.personrecord.FavouriteAuthor;
import resources.personrecord.User;
import resources.pubrec.Article;

@SuppressWarnings("unchecked")
public class BackEnd implements IBackEnd {

	private static String fileUri = "C:/Users/Harshil Vasani/Desktop/NEU/Sem - 3/MSD/Project/DATA/dblp.xml";
	final static File folder = new File("C:/Users/Harshil Vasani/Desktop/NEU/Sem - 3/MSD/Project/DATA/committees");
	private static Session session = null;
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

	public void textParserAndInsertData(){

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
	public void loadData(int rowsCount) {

		if (Data.getArticles() != null && Data.getCommitteeMembers() != null) {
			return;
		}
		try{
			session = HibernateUtil.getSessionFactory().openSession();

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

			queryResult = session.createQuery("from CommitteeMember");
			if (rowsCount > 0)  
				queryResult.setMaxResults(rowsCount);
			Data.setCommitteeMembers(queryResult.list());


		}catch (HibernateException e) {
			e.printStackTrace();
			System.err.println("Load Failed.. Please Restart Application!");
			System.exit(-1);
		}finally{
			if(session!=null)
				HibernateUtil.shutdown();
		}
	}

	@Override
	public boolean isPublicationDataLoaded() {

		List<Article> articles = null;

		try{
			session = HibernateUtil.getSessionFactory().openSession();

			Query query = session.createQuery("from Article");
			articles = query.list();

		}catch(Exception e){
			return false;
		}

		return (articles != null && articles.size() > 0);
	}

	@Override
	public boolean isCommitteeMemberDataLoaded() {

		List<CommitteeMember> committeeMembers = null;

		try{
			session = HibernateUtil.getSessionFactory().openSession();

			Query query = session.createQuery("from CommitteeMember");
			committeeMembers = query.list();

		}catch(Exception e){
			return false;
		}
		finally{
			if(session!=null)
				HibernateUtil.shutdown();
		}
		return (committeeMembers != null && committeeMembers.size() > 0);
	}

	@Override
	public ResponseMessage checkUserExistsByUsenameAndEmail(String username, String emailId) {

		try{
			session = HibernateUtil.getSessionFactory().openSession();

			queryResult = session.createQuery("from User where username = :userName OR email_id = :emailId")
					.setParameter("userName", username)
					.setParameter("emailId", emailId);

			@SuppressWarnings("rawtypes")
			List result = queryResult.list();

			if(result.isEmpty()){
				return new ResponseMessage(true, "");
			}
			else{
				return new ResponseMessage(false, Integer.toString(result.size()));
			}

		}catch(Exception e){
			e.printStackTrace();
			return new ResponseMessage(false, "Error Occured, Please try again...!!!");
		}
	}

	@Override
	public ResponseMessage insertUserData(User user) {
		try{
			session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();
			//Save the user in database
			session.save(user);

			//Commit the transaction
			session.getTransaction().commit();

			return new ResponseMessage(true, "Success");

		}catch(Exception e){
			e.printStackTrace();
			return new ResponseMessage(false, "Registration Failed");
		}
	}

	@Override
	public ResponseMessage updateUserData(User updatedUser) {

		try{
			session = HibernateUtil.getSessionFactory().openSession();

			queryResult = session.createQuery("From User Where (username = :username OR email_id = :emailId) And id != :userId)")
					.setParameter("username", updatedUser.getUsername())
					.setParameter("emailId", updatedUser.getEmailId())
					.setParameter("userId", updatedUser.getId());

			if(queryResult.list().size() > 0)
				return new ResponseMessage(true, "Username/Email-Id already exists");


			String hql = "UPDATE User set username = :username, password = :password, fullname = :fullName, phone_number = :phoneNumber, email_id = :emailId "
					+ "WHERE id = :userId";

			session.beginTransaction();

			queryResult = session.createQuery(hql);

			queryResult.setParameter("username", updatedUser.getUsername());
			queryResult.setParameter("password", updatedUser.getPassword());
			queryResult.setParameter("fullName", updatedUser.getFullName());
			queryResult.setParameter("phoneNumber", updatedUser.getPhoneNumber());
			queryResult.setParameter("emailId", updatedUser.getEmailId());
			queryResult.setParameter("userId", updatedUser.getId());

			int result = queryResult.executeUpdate();

			session.getTransaction().commit();

			if(result == 1)
				return new ResponseMessage(true, "Success");
			else
				return new ResponseMessage(true, "Profile updation Failed");
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseMessage(false, "Profile updation Failed");
		}
	}

	@Override
	public User getUserCredentials(String username, String password) {
		try{
			session = HibernateUtil.getSessionFactory().openSession();

			queryResult = session.createQuery("from User where username = :userName AND password = :password")
					.setParameter("userName", username)
					.setParameter("password", password);

			@SuppressWarnings("rawtypes")
			List result = queryResult.list();

			if(!result.isEmpty()){
				return (User) result.get(0);
			}
			else{
				return null;
			}

		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User selectUserByUsername(String username) {
		try{
			session = HibernateUtil.getSessionFactory().openSession();

			queryResult = session.createQuery("from User where username = :userName")
					.setParameter("userName", username);

			List<User> result = queryResult.list();

			if(result.isEmpty()){
				return null;
			}
			else{
				return result.get(0);
			}

		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResponseMessage insertFavoriteAuthor(FavouriteAuthor favouriteAuthor) {
		try{
			session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			queryResult = session.createQuery("from FavouriteAuthor where username = :userName And author_name = :authorName")
					.setParameter("userName", favouriteAuthor.getUsername())
					.setParameter("authorName", favouriteAuthor.getAuthorName());

			List<User> result = queryResult.list();

			if(result.isEmpty()){
				//Save the user in database
				session.save(favouriteAuthor);

				//Commit the transaction
				session.getTransaction().commit();
				return new ResponseMessage(true, "Success");
			}

			return new ResponseMessage(false, "Author already present in favourite list");

		}catch(Exception e){
			e.printStackTrace();
			return new ResponseMessage(false, "Adding to favourite list Failed");
		}
	}

	@Override
	public ResponseMessage deleteFavoriteAuthor(FavouriteAuthor favouriteAuthor) {
		try{

			session = HibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			queryResult = session.createQuery("delete from FavouriteAuthor where username = :userName And author_name = :authorName")
					.setParameter("userName", favouriteAuthor.getUsername())
					.setParameter("authorName", favouriteAuthor.getAuthorName());

			int result = queryResult.executeUpdate();

			session.getTransaction().commit();

			if(result == 1)
				return new ResponseMessage(true, "Success");
			else
				return new ResponseMessage(false, "Deleting from favourite list Failed");

		}catch(Exception e){
			e.printStackTrace();
			return new ResponseMessage(false, "Deleting from favourite list Failed due to exception");
		}
	}

	@Override
	public List<FavouriteAuthor> getAllFavoriteAuthorsForLoggedInUser(String username) {
		try{
			if(session == null || !session.isOpen())
				session = HibernateUtil.getSessionFactory().openSession();

			queryResult = session.createQuery("from FavouriteAuthor where username = :username")
					.setParameter("username", username);
			
			return queryResult.list();

		}catch(Exception e){
			return new ArrayList<FavouriteAuthor>();
		}
	}
}