package persistence;

import java.util.List;

import resources.publicationrecord.*;

public class Data {

	private static List<Article> articles;
	private static List<Proceeding> proceedings;
	private static List<Inproceeding> inproceedings;
	private static List<Book> books;
	private static List<Incollection> incollections;
	private static List<PhdThesis> phdtheses;
	private static List<CommitteeMember> committeeMembers;

	
	public static List<Article> getArticles() {
		return articles;
	}
	public static void setArticles(List<Article> articles) {
		if (Data.articles == null)
			Data.articles = articles;
	}
	
	public static List<Proceeding> getProceedings() {
		return proceedings;
	}
	public static void setProceedings(List<Proceeding> proceedings) {
		if (Data.proceedings == null)
			Data.proceedings = proceedings;
	}
	
	public static List<Inproceeding> getInproceedings() {
		return inproceedings;
	}
	public static void setInproceedings(List<Inproceeding> inproceedings) {
		if (Data.inproceedings == null)
			Data.inproceedings = inproceedings;
	}
	
	public static List<Book> getBooks() {
		return books;
	}
	public static void setBooks(List<Book> books) {
		if (Data.books == null)
			Data.books = books;
	}
	
	public static List<Incollection> getIncollections() {
		return incollections;
	}
	public static void setIncollections(List<Incollection> incollections) {
		if (Data.incollections == null)
			Data.incollections = incollections;
	}
	
	public static List<PhdThesis> getPhdtheses() {
		return phdtheses;
	}
	public static void setPhdtheses(List<PhdThesis> phdtheses) {
		if (Data.phdtheses == null)
			Data.phdtheses = phdtheses;
	}
	
	public static List<CommitteeMember> getCommitteeMembers() {
		return committeeMembers;
	}
	public static void setCommitteeMembers(List<CommitteeMember> committeeMembers) {
		if (Data.committeeMembers == null)
			Data.committeeMembers = committeeMembers;
	}

}
