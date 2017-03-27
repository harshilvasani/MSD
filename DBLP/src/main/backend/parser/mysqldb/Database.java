package backend.parser.mysqldb;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;

import backend.parser.pubrec.*;

public class Database {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/dblp2?useServerPrepStmts=false&rewriteBatchedStatements=true";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Vasani99";
	
	public static String insertTableSQL = null;

	private static Connection dbConnection = null;
	private static Statement statement = null;

	public static void InsertDblpData(DBLP dblpTag) throws SQLException {

		try {
			if(dblpTag == null)
				return;
			
			try {
				Class.forName(DB_DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
    		
			statement = ((Connection) dbConnection).createStatement();
			
			InsertArticleData(dblpTag.getArticle());
			InsertProceedingData(dblpTag.getProceedings());
			InsertInroceedingData(dblpTag.getInproceedings());			
			InsertBookData(dblpTag.getBook());
			InsertIncollectionData(dblpTag.getIncollection());
			InsertPhdthesisData(dblpTag.getPhdthesis());

			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				((Connection) dbConnection).close();
			}

		}

	}

	private static void InsertArticleData(List<Article> articleTags){
		try {	
			
			if(articleTags == null || articleTags.isEmpty()){
				return;
			}
			
			String insertSql = "INSERT INTO article(article_key, author, title, year, journal) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = (PreparedStatement) dbConnection.prepareStatement(insertSql);

			final int batchSize = 10000;
			int i=0;
			
			for(Article articleTag:articleTags) {

				String key = articleTag.getKey();
				List<String> authors = articleTag.getAuthor();
				String title = articleTag.getTitle();
				String year = articleTag.getYear();
				String journal = articleTag.getJournal();
					
				if(key == null || key.isEmpty() || authors == null || authors.isEmpty() || title == null || title.isEmpty() || year == null || year.isEmpty() || journal == null || journal.isEmpty()){
					continue;
				}
					
				if(!isUTF8MisInterpreted(title) || !isUTF8MisInterpreted(journal)){
					continue;
				}
					
				for(String author:authors){
					if(author == null || author.isEmpty()){
						continue;
					}
					
					pstmt.setString(1, key); 
					pstmt.setString(2, author);
					pstmt.setString(3, title);	
					pstmt.setString(4, year);
					pstmt.setString(5, journal);
						
					pstmt.addBatch();
				}
				
				if(++i % batchSize == 0) {
					pstmt.executeBatch();
				}
				
			}
			pstmt.executeBatch();
			System.out.println("Records is inserted into Article table!");

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}
	
	private static void InsertProceedingData(List<Proceeding> proceedingTags){
		try {	
			
			if(proceedingTags == null || proceedingTags.isEmpty()){
				return;
			}
			
			String insertSql = "INSERT INTO proceeding(proceeding_key, editor, title, year, book_title, series, publisher) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = (PreparedStatement) dbConnection.prepareStatement(insertSql);

			final int batchSize = 10000;
			int i=0;
			
			for(Proceeding proceedingTag:proceedingTags) {

				String key = proceedingTag.getKey();
				List<String> editors = proceedingTag.getEditor();
				String title = proceedingTag.getTitle();
				String year = proceedingTag.getYear();
				String bookTitle = proceedingTag.getBooktitle();
				String series = proceedingTag.getSeries();
				String publisher = proceedingTag.getPublisher();
					
				if(key == null || key.isEmpty() || title == null || title.isEmpty() 
						|| year == null || year.isEmpty() || bookTitle == null || bookTitle.isEmpty() 
						|| series == null || series.isEmpty() || publisher == null || publisher.isEmpty()){
					continue;
				}
					
				if(!isUTF8MisInterpreted(title) || !isUTF8MisInterpreted(bookTitle) 
						|| !isUTF8MisInterpreted(series) || !isUTF8MisInterpreted(publisher)){
					continue;
				}
				
				if(editors != null && !editors.isEmpty()){
					for(String editor:editors){
						if(editor == null || editor.isEmpty()){
							continue;
						}				
							
						pstmt.setString(1, key); 
						pstmt.setString(2, editor);
						pstmt.setString(3, title);	
						pstmt.setString(4, year);
						pstmt.setString(5, bookTitle);
						pstmt.setString(6, series);
						pstmt.setString(7, publisher);
						
						pstmt.addBatch();
					}
				}
				else{
					pstmt.setString(1, key); 
					pstmt.setNull(2, Types.VARCHAR);
					pstmt.setString(3, title);	
					pstmt.setString(4, year);
					pstmt.setString(5, bookTitle);
					pstmt.setString(6, series);
					pstmt.setString(7, publisher);
					
					pstmt.addBatch();
				}
							
				if(++i % batchSize == 0) {
					pstmt.executeBatch();
				}
				
			}
			pstmt.executeBatch();
			System.out.println("Records is inserted into Proceeding table!");

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}
	
	private static void InsertInroceedingData(List<Inproceeding> inproceedingTags){
		try {	
			
			if(inproceedingTags == null || inproceedingTags.isEmpty()){
				return;
			}
			
			String insertSql = "INSERT INTO inproceeding(inproceeding_key, author, title, year, crossref, book_title) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = (PreparedStatement) dbConnection.prepareStatement(insertSql);

			final int batchSize = 10000;
			int i=0;
			
			for(Inproceeding inproceedingTag:inproceedingTags) {

				String key = inproceedingTag.getKey();
				List<String> authors = inproceedingTag.getAuthor();
				String title = inproceedingTag.getTitle();
				String year = inproceedingTag.getYear();
				String crossRef = inproceedingTag.getCrossref();
				String bookTitle = inproceedingTag.getBooktitle();
					
				if(key == null || key.isEmpty() || title == null || title.isEmpty() 
						|| year == null || year.isEmpty() || bookTitle == null || bookTitle.isEmpty() 
						|| crossRef == null || crossRef.isEmpty() || authors == null || authors.isEmpty()){
					continue;
				}
					
				if(!isUTF8MisInterpreted(title) || !isUTF8MisInterpreted(bookTitle)){
					continue;
				}
				
				for(String author:authors){
					if(author == null || author.isEmpty()){
						continue;
					}
											
					pstmt.setString(1, key); 
					pstmt.setString(2, author);
					pstmt.setString(3, title);	
					pstmt.setString(4, year);
					pstmt.setString(5, crossRef);
					pstmt.setString(6, bookTitle);
					
					pstmt.addBatch();
				}
				
							
				if(++i % batchSize == 0) {
					pstmt.executeBatch();
				}
				
			}
			pstmt.executeBatch();
			System.out.println("Records is inserted into Inproceeding table!");

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
	
	private static void InsertBookData(List<Book> bookTags){
		try {	
			
			if(bookTags == null || bookTags.isEmpty()){
				return;
			}
			
			String insertSql = "INSERT INTO book(book_key, editor, title, year, publisher) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = (PreparedStatement) dbConnection.prepareStatement(insertSql);

			final int batchSize = 10000;
			int i=0;
			
			for(Book bookTag:bookTags) {

				String key = bookTag.getKey();
				List<String> editors = bookTag.getEditor();
				String title = bookTag.getTitle();
				String year = bookTag.getYear();
				String publisher = bookTag.getPublisher();
					
				if(key == null || key.isEmpty() || editors == null || editors.isEmpty() 
						|| title == null || title.isEmpty() || year == null || year.isEmpty()
						|| publisher == null || publisher.isEmpty()){
					continue;
				}
					
				if(!isUTF8MisInterpreted(title)){
					continue;
				}
					
				for(String editor:editors){
					if(editor == null || editor.isEmpty()){
						continue;
					}
	
					pstmt.setString(1, key); 
					pstmt.setString(2, editor);
					pstmt.setString(3, title);	
					pstmt.setString(4, year);
					pstmt.setString(5, publisher);
					
					pstmt.addBatch();
				}
				
				if(++i % batchSize == 0) {
					pstmt.executeBatch();
				}
				
			}
			pstmt.executeBatch();
			System.out.println("Records is inserted into Book table!");

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}

	private static void InsertIncollectionData(List<Incollection> incollectionTags){
		try {	
			
			if(incollectionTags == null || incollectionTags.isEmpty()){
				return;
			}
			
			String insertSql = "INSERT INTO incollection(incollection_key, author, title, year, book_title, crossref) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = (PreparedStatement) dbConnection.prepareStatement(insertSql);

			final int batchSize = 10000;
			int i=0;
			
			for(Incollection incollectionTag:incollectionTags) {

				String key = incollectionTag.getKey();
				List<String> authors = incollectionTag.getAuthor();
				String title = incollectionTag.getTitle();
				String year = incollectionTag.getYear();
				String bookTitle = incollectionTag.getBooktitle();
				String crossref = incollectionTag.getCrossref();
					
				if(key == null || key.isEmpty() || authors == null || authors.isEmpty() 
						|| title == null || title.isEmpty() || year == null || year.isEmpty()
						|| bookTitle == null || bookTitle.isEmpty() || crossref == null || crossref.isEmpty()){					
					continue;
				}
					
				if(!isUTF8MisInterpreted(title)){
					continue;
				}
					
				for(String author:authors){
					if(author == null || author.isEmpty()){
						continue;
					}							
						
					pstmt.setString(1, key); 
					pstmt.setString(2, author);
					pstmt.setString(3, title);	
					pstmt.setString(4, year);
					pstmt.setString(5, bookTitle);
					pstmt.setString(6, crossref);
					
					pstmt.addBatch();
				}
				
				if(++i % batchSize == 0) {
					pstmt.executeBatch();
				}
				
			}
			pstmt.executeBatch();
			System.out.println("Records is inserted into Incoolection table!");

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}
	
	private static void InsertPhdthesisData(List<PhdThesis> phdThesisTags){
		try {	
			
			if(phdThesisTags == null || phdThesisTags.isEmpty()){
				return;
			}
			
			String insertSql = "INSERT INTO phdthesis(phdthesis_key, author, title, year, school) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = (PreparedStatement) dbConnection.prepareStatement(insertSql);

			final int batchSize = 10000;
			int i=0;
			
			for(PhdThesis phdThesisTag:phdThesisTags) {

				String key = phdThesisTag.getKey();
				String author = phdThesisTag.getAuthor();
				String title = phdThesisTag.getTitle();
				String year = phdThesisTag.getYear();
				String school = phdThesisTag.getSchool();
					
				if(key == null || key.isEmpty() || author == null || author.isEmpty() 
						|| title == null || title.isEmpty() || year == null || year.isEmpty() 
						|| school == null || school.isEmpty()){
					//had school null
					continue;
				}

				pstmt.setString(1, key); 
				pstmt.setString(2, author);
				pstmt.setString(3, title);	
				pstmt.setString(4, year);
				pstmt.setString(5, school);
					
				pstmt.addBatch();
				
				if(++i % batchSize == 0) {
					pstmt.executeBatch();
				}
				
			}
			pstmt.executeBatch();
			System.out.println("Records is inserted into PdhThesis table!");

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}

	public static void InsertCommitteeData(List<CommitteeMember> committeeMembers) throws SQLException {

		try {
			if(committeeMembers == null || committeeMembers.isEmpty())
				return;
			
			try {
				Class.forName(DB_DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
    		
			statement = ((Connection) dbConnection).createStatement();
			
			String insertSql = "INSERT INTO committee_member(conf_name, year, member_name, member_position) VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt = (PreparedStatement) dbConnection.prepareStatement(insertSql);

			final int batchSize = 10000;
			int i=0;
			
			for(CommitteeMember committeeMember:committeeMembers) {

				String confName = committeeMember.getConfName();
				String year = committeeMember.getYear();
				String memberName = committeeMember.getMemberName();
				String memberPosition = committeeMember.getPosition();
				
				if(confName == null || confName.isEmpty() || year == null || year.isEmpty() 
						|| memberName == null || memberName.isEmpty()){
					//had school null
					continue;
				}

				pstmt.setString(1, confName); 
				pstmt.setString(2, year);
				pstmt.setString(3, memberName);	
				pstmt.setString(4, memberPosition);
					
				pstmt.addBatch();
				
				if(++i % batchSize == 0) {
					pstmt.executeBatch();
				}
				
			}
			pstmt.executeBatch();
			System.out.println("Records is inserted into committee_member table!");
						
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		finally {

			if (statement != null) {
				statement.close();
			}

			if (dbConnection != null) {
				((Connection) dbConnection).close();
			}

		}

	}

	
	private static boolean isUTF8MisInterpreted(String input) {
		String encoding ="Windows-1252";
		CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
		CharsetEncoder encoder = Charset.forName(encoding).newEncoder();
		ByteBuffer tmp;
		try {
			tmp = encoder.encode(CharBuffer.wrap(input));
		}

		catch(CharacterCodingException e) {
			return false;
		}

		try {
			decoder.decode(tmp);
			return true;
		}
		catch(CharacterCodingException e){
			return false;
		}     
	}

}