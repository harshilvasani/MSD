package parser;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import frontEnd.parser.Parser;
import frontEnd.parser.publicationrecord.CommitteeMember;

public class ParseFilesForFolderTest {

	@Test
	public void testForWrongFolderPath() {
		Object obj = Parser.ParseFilesForFolder(new File(""));
		assertEquals(obj, null);
	}
	
	@Test
	public void testForRightFolderPath() {
		List<CommitteeMember> obj =  Parser.ParseFilesForFolder(new File("C:/Users/Harshil Vasani/Desktop/NEU/Sem - 3/MSD/Project/DATA/committees"));
		assertTrue(obj.size() > 0);
	}
}
