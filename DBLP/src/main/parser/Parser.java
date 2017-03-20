package parser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import parser.publicationRecord.CommitteeMember;
import parser.publicationRecord.DBLP;


public class Parser {
	private static Map<String, String> sMap = null;
	private static List<CommitteeMember> committeeMembers = new ArrayList<CommitteeMember>();

	public static DBLP XmlParser(String filePath){
		try {

			File file = new File(filePath);
			JAXBContext jaxbContext = JAXBContext.newInstance(DBLP.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			System.setProperty("javax.xml.accessExternalDTD", "all"); 
			System.setProperty("jdk.xml.maxGeneralEntitySizeLimit","0");
			System.setProperty("jdk.xml.entityExpansionLimit","0");

			DBLP dblpTag = (DBLP) jaxbUnmarshaller.unmarshal(file);

			return dblpTag;

		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<CommitteeMember> ParseFilesForFolder(final File folder) throws IOException {

		GetCodesToConvertToUTF_8();

		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				ParseFilesForFolder(fileEntry);
			} else {
				List<CommitteeMember> cmObj = ReadTxtFile(fileEntry);
				committeeMembers.addAll(cmObj);
			}
		}
		return committeeMembers;
	}

	public static List<CommitteeMember> ReadTxtFile(File fileEntry) throws IOException{

		String fileName = fileEntry.getAbsolutePath();
		String year = fileEntry.getName().replaceAll("\\D+","");
		String confName = fileEntry.getName().split("-")[0].replaceAll("[^A-Za-z]+","");
		String memberName = null;
		String memberPosition = null;

		BufferedReader br = new BufferedReader(new FileReader(fileName));

		List<CommitteeMember> cmObjList = new ArrayList<CommitteeMember>();

		try {
			String line = br.readLine();

			while (line != null) {
				Pattern p = Pattern.compile("\\&.*?\\;");
				Matcher m = p.matcher(line);
				while(m.find()){
					String unknownCode = m.group();
					String newChar = sMap.get(unknownCode);
					if(newChar == null || newChar.isEmpty())
						newChar = "";

					line = line.replace(unknownCode, newChar);
				}

				memberName = line;
				memberPosition = null;
				
				String[] memberData = line.split(":");
				if(memberData.length == 2){
					memberName = memberData[1];
					memberPosition = memberData[0];
				}

				CommitteeMember cmObj = new CommitteeMember(confName, year, memberName, memberPosition);
				cmObjList.add(cmObj);
				line = br.readLine();

			}
		} finally {
			br.close();
		}
		return cmObjList;
	}

	public static void GetCodesToConvertToUTF_8() throws IOException{
		
		BufferedReader br = new BufferedReader(new FileReader("./bin/Symbol_Conversion.txt"));
		sMap = new HashMap<String, String>();

		try {
			String line = br.readLine();
			while (line != null) {  	
				String[] key_value = line.split(" ");
				if(key_value.length == 2)
					sMap.put(key_value[0], key_value[1]);
				line = br.readLine();		        
			}
		} finally {
			br.close(); 
		}	

	}
}
