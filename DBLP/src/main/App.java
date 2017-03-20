import java.io.*;
import java.sql.SQLException;
import java.util.*;
import parser.mySqlDatabase.Database;
import parser.Parser;
import parser.publicationRecord.*;
import resources.HibernateCRUD;

public class App {

	private static String fileUri = "C:/Users/Harshil Vasani/Desktop/NEU/Sem - 3/MSD/Project/DATA/dblp.xml";
	final static File folder = new File("C:/Users/Harshil Vasani/Desktop/NEU/Sem - 3/MSD/Project/DATA/committees");
	
	public static void main(String[] args) throws SQLException, IOException {
		
		//ParseXMLAndInsertData();
		//TextParser(folder);
		DatabaseReadUsingHibernate();
	}
	
	private static void DatabaseReadUsingHibernate() {

		HibernateCRUD.readTopXArticleRows(10);
		HibernateCRUD.readTopXBookRows(10);
		HibernateCRUD.readTopXIncollectionRows(10);
		HibernateCRUD.readTopXInproceedingRows(10);
		HibernateCRUD.readTopXPhdThesisRows(10);
		HibernateCRUD.readTopXProceedingRows(10);
		HibernateCRUD.readTopXCommitteeMemberRows(10);
	}

	@SuppressWarnings("unused")
	private static void ParseXMLAndInsertData() throws SQLException{
		
		DBLP dblpTag = Parser.XmlParser(fileUri);
		
		Database.InsertDblpData(dblpTag);
	}
	
	public static void TextParser(File folder) throws IOException, SQLException{

		List<CommitteeMember> committeeMembers = Parser.ParseFilesForFolder(folder);
		System.out.println(committeeMembers.size());
		Database.InsertCommitteeData(committeeMembers);
	}
}
