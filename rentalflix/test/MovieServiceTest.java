import static org.junit.Assert.*;

import java.util.List;
import java.util.Vector;

import org.junit.Test;

/**
 * JUnit test cases for MovieService
 */

public class MovieServiceTest {
	
	Movie movie1 = new Movie("title1", 2016, "language1");
	Movie movie2 = new Movie("title2", 2015, "language2");
	Movie movie3 = new Movie("title1", 2013, "language2");
	
	
	@Test
	public void findAllTest()
	{
		MovieService obj = new MovieService();
		obj.create(movie1);
		obj.create(movie2);
		List<Movie> expected = new Vector<>();
		expected.add(movie1);
		expected.add(movie2);
		List<Movie> actual = obj.findAll();
		assertEquals(expected,actual);
	}
	
	@Test
	public void findByNameTest1()
	{
		MovieService obj = new MovieService();
		obj.create(movie1);
		obj.create(movie3);
		List<Movie> expected = new Vector<>();
		expected.add(movie1);
		expected.add(movie3);
		List<Movie> actual = obj.findByName("title1");
		assertEquals(expected, actual);
	}
	
	@Test
	public void findByNameTest2()
	{
		MovieService obj = new MovieService();
		obj.create(movie1);
		obj.create(movie3);
		List<Movie> expected = new Vector<>();
		List<Movie> actual = obj.findByName("title");
		assertEquals(expected, actual);
	}
	
	@Test
	public void createTest()
	{
		MovieService obj = new MovieService();
		Movie expected = obj.create(movie1);
		Movie actual = obj.create(movie1);
		assertEquals(expected, actual);
	}

	@Test
	public void updateTest1()
	{
		MovieService obj = new MovieService();
		obj.create(movie1);
		Movie movie4 = new Movie("title4", 2016, "language4");
		movie4.setId(0);
		Movie expected = movie4;
		Movie actual = obj.update(movie4);
		assertTrue(expected.id == actual.id && expected.language.equals(actual.language)
				&& expected.title.equals(actual.title) && expected.year == actual.year
				&& expected.movieRented == actual.movieRented);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void updateException() {
		MovieService obj = new MovieService();
		Movie movie4 = new Movie("title4", 2000, "language");
		obj.update(movie4);
	}
	
	@Test
	public void deleteTest1()
	{
		MovieService obj = new MovieService();
		obj.create(movie1);
		Movie expected = movie1;
		Movie actual = obj.delete(0);
		assertTrue(expected.id == actual.id && expected.language.equals(actual.language)
				&& expected.title.equals(actual.title) && expected.year == actual.year
				&& expected.movieRented == actual.movieRented);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void deleteException() {
		MovieService obj = new MovieService();
		obj.delete(4);
	}
	
	@Test
	public void rentMovieTest1()
	{
		MovieService obj = new MovieService();
		obj.create(movie1);
		boolean expected = true;
		boolean actual = obj.rentMovie(0, "Abc");
		assertEquals(expected, actual);
	}
	
	@Test
	public void rentMovieTest2()
	{
		MovieService obj = new MovieService();
		obj.create(movie1);
		movie1.setMovieRented(true);
		boolean expected = false;
		boolean actual = obj.rentMovie(0, "Abc");
		assertEquals(expected, actual);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void rentMovieException()
	{
		MovieService obj = new MovieService();
		obj.rentMovie(0, "Abc");
	}
	
}
