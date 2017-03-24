package backend.parser.pubrec;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class DBLP {

	private List<Article> article;
	private List<Proceeding> proceedings;
	private List<Inproceeding> inproceedings;
	private List<Book> book;
	private List<Incollection> incollection;
	private List<PhdThesis> phdthesis;
	
	public DBLP(){
		
	}
	
	public DBLP(List<Article> article, List<Proceeding> proceedings, List<Inproceeding> inproceedings, List<Book> book, List<Incollection> incollection, List<PhdThesis> phdthesis){
		super();
		setArticle(article);
		setProceedings(proceedings);
		setInproceedings(inproceedings);
		setBook(book);
		setIncollection(incollection);
		setPhdthesis(phdthesis);
	}
	
	@XmlElement
	public List<Article> getArticle() {
		return article;
	}
	public void setArticle(List<Article> article) {
		this.article = article;
	}

	@XmlElement
	public List<Proceeding> getProceedings() {
		return proceedings;
	}
	public void setProceedings(List<Proceeding> proceedings) {
		this.proceedings = proceedings;
	}

	@XmlElement
	public List<Inproceeding> getInproceedings() {
		return inproceedings;
	}
	public void setInproceedings(List<Inproceeding> inproceedings) {
		this.inproceedings = inproceedings;
	}

	@XmlElement
	public List<Book> getBook() {
		return book;
	}
	public void setBook(List<Book> book) {
		this.book = book;
	}

	@XmlElement
	public List<Incollection> getIncollection() {
		return incollection;
	}

	public void setIncollection(List<Incollection> incollection) {
		this.incollection = incollection;
	}
	
	@XmlElement
	public List<PhdThesis> getPhdthesis() {
		return phdthesis;
	}

	public void setPhdthesis(List<PhdThesis> phdthesis) {
		this.phdthesis = phdthesis;
	}
}
