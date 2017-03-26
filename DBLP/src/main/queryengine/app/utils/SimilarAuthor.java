package queryengine.app.utils;

public class SimilarAuthor implements Comparable{

	private String name;
	private Integer score;

	public SimilarAuthor(String name, Integer score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}

	public Integer getScore() {
		return score;
	}

	@Override
	public int compareTo(Object arg0) {
		if (arg0 instanceof SimilarAuthor) {
			SimilarAuthor s = (SimilarAuthor) arg0;
			if (this.score < s.score) {
				return -1;
			}
			else if (this.score > s.score) {
				return 1;
			}
		}
		return 0;
	}
}
