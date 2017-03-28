package backend.parser;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import backend.parser.Parser;
import backend.parser.pubrec.CommitteeMember;

public class ParseFilesForFolderTest {

	@Test
	public void testForWrongFolderPath() {
		Object obj = Parser.ParseFilesForFolder(new File(""));
		assertEquals(obj, null);
	}
	
	@Ignore
	@Test
	public void testForRightFolderPath() {
		List<CommitteeMember> obj =  Parser.ParseFilesForFolder(new File("C:/Users/Harshil Vasani/Desktop/NEU/Sem - 3/MSD/Project/DATA/committees"));
		assertTrue(obj!= null && obj.size() > 0);
	}
}
