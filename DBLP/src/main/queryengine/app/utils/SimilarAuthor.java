package queryengine.app.utils;

import resources.person.IPerson;

public class SimilarAuthor implements Comparable, IPerson{

	private String name;
	private long score;

	public SimilarAuthor(String name, long score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}

	public long getScore() {
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

	@Override
	public String getPersonName() {
		return this.name;
	}

	@Override
	public void setPersonName(String name) {
		this.name = name;
	}
}
