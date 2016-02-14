import java.util.List;
import java.util.Vector;

/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */
public class MovieService implements IFlix {
	
	Vector<Movie> listOfMovies = new Vector<>();
	
	@Override
	public List<Movie> findAll() {
		return listOfMovies;
	}

	@Override
	public List<Movie> findByName(String name) {
		Vector<Movie> listOfMoviesWithProvidedName = new Vector<>();
		for(Movie movie : listOfMovies)
		{
			if((movie.title).toLowerCase().equals(name.toLowerCase()))
			{
				listOfMoviesWithProvidedName.add(movie);
			}
		}
		return listOfMoviesWithProvidedName;
		
	}
		
	@Override
	public Movie create(Movie movie) {
		listOfMovies.add(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		Movie movieToReturn = null;
		boolean foundMovie = false;
		for(Movie movieInStore : listOfMovies)
		{
			if(movie.id == movieInStore.id)
			{
				movieInStore.setLanguage(movie.language);
				movieInStore.setTitle(movie.title);
				movieInStore.setYear(movie.year);
				movieToReturn =  movieInStore;
				foundMovie = true;
			}
		}
		if(foundMovie) return movieToReturn;
		else throw new IllegalArgumentException();
	}

	@Override
	public Movie delete(int id) {
		Movie movieToReturn = null;
		boolean foundMovie = false;
		for(Movie movieInStore : listOfMovies)
		{
			if(id == movieInStore.id)
			{
				movieToReturn =  movieInStore;
				foundMovie = true;
				break;
			}
		}
		listOfMovies.remove(movieToReturn);
		if(foundMovie) return movieToReturn;
		else throw new IllegalArgumentException();
	}

	@Override
	public boolean rentMovie(int movieId, String user) {
		boolean foundMovie = false;
		boolean rentMovie = false;
		for(Movie movieInStore : listOfMovies)
		{
			if(movieId == movieInStore.id)
			{
				if(movieInStore.movieRented == false)
				{
					movieInStore.movieRented = true;
					rentMovie = true;
					foundMovie = true;
				}
				else{
					foundMovie = true;
				}
			}
		}
		if(foundMovie) return rentMovie;
		else throw new IllegalArgumentException();
	}
	
	

}
