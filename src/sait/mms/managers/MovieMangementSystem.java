
package sait.mms.managers;

/**
 * import libraries and package. 
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import sait.mms.problemdomain.Movie;

/**
 * The program has five methods to connect to AppDriver class and Movie class.
 * 
 * @author Hong and Kim
 * @version 1.0, May 17, 2020
 */
public class MovieMangementSystem {

	/**
	 * Two private instance fields.
	 */
	private static final String FILENAME = "res//movies.txt"; // The File path.
	private Movie mv; // The Movie class instance call by mv.

	/**
	 * The displayMenu method shows main program menu.
	 * 
	 * @param in - Scanner object attached to the keyboard.
	 * @return selection - returns the user's selection as an integer.
	 */
	public int displayMenu(Scanner in) {

		int selection = 0;
		// Print out menu.
		System.out.println("Movie Management system");
		System.out.println("1     Add New Movie and Save");
		System.out.println("2     Generate List of Movies Released in a Year");
		System.out.println("3     Generate List of Random Movies");
		System.out.println("4     Exit");
		System.out.println("");
		System.out.print("Enter an option: ");
		// Print in menu number.
		selection = in.nextInt();
		// Make a new line.
		System.out.println("");

		return selection;
	}

	/**
	 * This method receives parameters from AppDriver, stores them in the ArrayList, 
	 * and passes the factor to Movie class.
	 * 
	 * @param movies - Movies list ArrayList of Movie.
	 * @param duration - To add movie's duration.
	 * @param movie - To add movies's title.
	 * @param year - To add movies's published year.
	 * @throws IOException - When there's error the method throws exception. 
	 */
	public void addMovie(ArrayList<Movie> movies, int duration, String movie, int year) throws IOException {
		
		String durationToStr = Integer.toString(duration); // In order to store movie's duration in the file.
		String yearToStr = Integer.toString(year); // In order to store movie's year in the file.
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(new File(FILENAME), true)); // Write data into the file with check file existence.

		bWriter.newLine();
		bWriter.write(durationToStr);
		bWriter.write(",");
		bWriter.write(movie);
		bWriter.write(",");
		bWriter.write(yearToStr);
		bWriter.close();
		// Create Movie object.
		mv = new Movie(duration, movie, year);
		// Store mv into ArrayList.
		movies.add(mv);
	}
	
	/**
	 * The generateMoveListInYear method receives a specific year and prints out the title, length, 
	 * and year of the movie corresponding to it.
	 * 
	 * @param movies - Movies list ArrayList of Movie.
	 * @param year - To generate movies's published year.
	 * @throws IOException - When there's error the method throws exception.
	 */
	public void generateMoveListInYear(ArrayList<Movie> movies, int year) throws IOException {

		int totalDuration = 0;

		System.out.println("Movie List");
		System.out.printf("%-12s%-6s%s%n", "Duration", "Year", "Title");
		// This block operates to find movie with condition and display movie information from ArrayList.
		for (int i = 0; i < movies.size(); i++) {
			if (movies.get(i).getYear() == year) {
				System.out.print(movies.get(i).toString());
				// The sum of the running hours of a film that meets the conditions.
				totalDuration += movies.get(i).getDuration(); 
			}
		}
		System.out.printf("%n%s%d%s%n", "Total duration: ", totalDuration, " minutes");
	}
	
	/**
	 * The generateRandomMovieList method generates to pick random data using object's methods shuffle. 
	 * 
	 * @param movies - Movies list ArrayList of Movie.
	 * @param number - Receive number by user's input. 
	 * @throws IOException - When there's error the method throws exception.
	 */
	public void generateRandomMovieList(ArrayList<Movie> movies, int number) throws IOException {

		int totalDuration = 0;
		// Shuffle movies.
		Collections.shuffle(movies);

		System.out.println("Movie List");
		System.out.printf("%-12s%-6s%s%n", "Duration", "Year", "Title");
		// Print out toString method in Movie class and calculated duration by number from parameter.
		for (int i = 0; i < number; i++) {
			System.out.print(movies.get(i).toString());
			totalDuration += movies.get(i).getDuration();
		}
		System.out.printf("%n%s%d%s%n", "Total duration: ", totalDuration, " minutes");
	}
	
	/**
	 * The loadMovieList method operates that open and read the file and then
	 * store into ArrayList. 
	 * 
	 * @param movies - Movies list ArrayList of Movie.
	 * @throws IOException - When there's error the method throws exception.
	 */
	public void loadMovieList(ArrayList<Movie> movies) throws IOException {

		String movieInfo = "";
		String [] line;
		// Read file.
		Scanner inFile = new Scanner(new File(FILENAME));
		
		while (inFile.hasNext()) {

			movieInfo = inFile.nextLine();
			line = movieInfo.split(",");
			// Create Movie class object and send parameters in the Movie class.
			mv = new Movie(Integer.parseInt(line[0]),line[1],Integer.parseInt(line[2]));
			movies.add(mv);

		}
		inFile.close();

	}
}