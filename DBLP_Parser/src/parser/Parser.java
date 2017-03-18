package parser;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import publicationRecord.DBLP;

public class Parser {
	
	public static DBLP XmlParser(String fileUri){
		try {

			File file = new File("C:/Users/Harshil Vasani/Desktop/NEU/Sem - 3/MSD/Project/DATA/dblp.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(DBLP.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			System.setProperty("javax.xml.accessExternalDTD", "all"); 
			System.setProperty("jdk.xml.maxGeneralEntitySizeLimit","0");
			System.setProperty("jdk.xml.entityExpansionLimit","0");
			
			DBLP dblpTag = (DBLP) jaxbUnmarshaller.unmarshal(file);
			System.out.println("PhdThesis tags: " + dblpTag.getPhdthesis().size());

			return dblpTag;

		  } catch (JAXBException e) {
			e.printStackTrace();
			return null;
		  }
	}
}
