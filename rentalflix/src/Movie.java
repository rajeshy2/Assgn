import java.util.concurrent.atomic.AtomicInteger;

/**
 * Entity representing a movie.
 * Fields: id, title, year, language
 */
public class Movie {
	int id;
	String title;
	int year;
	String language;
	private AtomicInteger counter = new AtomicInteger();
	boolean movieRented;
	
	
	public Movie(String title, int year, String language)
	{
		this.id = counter.getAndIncrement();
		this.title = title;
		this.year = year;
		this.language = language;
		this.movieRented = false;
	}
	
	
	public boolean isMovieRented() {
		return movieRented;
	}


	public void setMovieRented(boolean movieRented) {
		this.movieRented = movieRented;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}
