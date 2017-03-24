package parser;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import frontEnd.parser.Parser;
import frontEnd.parser.publicationRecord.DBLP;

public class XmlParserTest {

	@Test
	public void testForWrongXMLFilePath() {
		Object obj = Parser.XmlParser("");
		assertEquals(obj, null);
	}
	
	@Ignore
	@Test
	public void testForRightXMLFilePath() {
		String fileUri = "C:/Users/Harshil Vasani/Desktop/NEU/Sem - 3/MSD/Project/DATA/dblp.xml";
		Object obj = Parser.XmlParser(fileUri);
		assertTrue(obj instanceof DBLP);
	}

}
