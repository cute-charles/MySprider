package edu.csuft.leb.MySprider;

public class Film {
    /**
     * БъЬт
     */
	String title;
	String info;
	Double rating;
	int num;
    int id;
    String poster;
    String quote;
    
    
	@Override
	public String toString() {
		return "Film [title=" + title + ", info=" + info + ", rating=" + rating + ", num=" + num + ", id=" + id
				+ ", poster=" + poster + ", quote=" + quote + "]";
	}
    
    
}
