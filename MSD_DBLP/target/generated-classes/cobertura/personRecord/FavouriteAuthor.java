package resources.personrecord;

public class FavouriteAuthor {
	
	private int id;
	private String authorName;
	private String username;
	
	public FavouriteAuthor(){
		
	}
	
	public FavouriteAuthor(int id, String authorName, String username) {
		this.id = id;
		this.authorName = authorName;
		this.username = username;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
