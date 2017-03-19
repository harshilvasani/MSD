import java.sql.SQLException;
import parser.mySqlDatabase.Database;
import parser.Parser;
import parser.publicationRecord.DBLP;
import resources.HibernateCRUD;

public class App {

	private static String fileUri = "C:/Users/Harshil Vasani/Desktop/NEU/Sem - 3/MSD/Project/DATA/dblp.xml";
	
	public static void main(String[] args) throws SQLException {
		
		//ParseXMLAndInsertData();
		DatabaseReadUsingHibernate();
	}
	
	private static void DatabaseReadUsingHibernate() {

		HibernateCRUD.readTopXArticleRows(10);
		HibernateCRUD.readTopXBookRows(10);
		HibernateCRUD.readTopXIncollectionRows(10);
		HibernateCRUD.readTopXInproceedingRows(10);
		HibernateCRUD.readTopXPhdThesisRows(10);
		HibernateCRUD.readTopXProceedingRows(10);
	}

	@SuppressWarnings("unused")
	private static void ParseXMLAndInsertData() throws SQLException{
		
		DBLP dblpTag = Parser.XmlParser(fileUri);
		
		Database.insertDblpData(dblpTag);
	}
}
