package edu.csuft.leb.MySprider;

public class Film implements Comparable<Film>{
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
    
    public String toCSV() {
    	return String.format("%d,%s,%d,%.1f\n", id,title,num,rating);
    }
    
	@Override
	public String toString() {
		return "Film [title=" + title + ", info=" + info + ", rating=" + rating + ", num=" + num + ", id=" + id
				+ ", poster=" + poster + ", quote=" + quote + "]";
	}

	@Override
	public int compareTo(Film o) {
		// TODO Auto-generated method stub
		return id - o.id;
	}
    
    
}
