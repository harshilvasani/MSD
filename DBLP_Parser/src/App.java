import java.sql.SQLException;

import mySqlDatabase.Database;
import parser.Parser;
import publicationRecord.DBLP;

public class App {

	private static String fileUri = "C:/Users/Harshil Vasani/Desktop/NEU/Sem - 3/MSD/Project/DATA/dblp.xml";
	
	public static void main(String[] args) throws SQLException {
	
		DBLP dblpTag = Parser.XmlParser(fileUri);
	
		Database.insertDblpData(dblpTag);
	}
}
