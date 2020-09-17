package sait.mms.problemdomain;

/**
The program reads in three values and calls various functions to 
manipulate them.

@author Hong and Kim
@version 1.0, May 17, 2020
*/
public class Movie {
	/**
	 * This is three private instance field.
	 */
	private int year; //Year of Movie published.
	private String movieName; // Name of Movie.
	private int duration; // Movie's duration.

	/**
	 * This is a Movie constructor.
	 * 
	 * @param duration - Get duration parameter from MovieMangementSystem class
	 * @param movieName - Get movieName parameter from MovieMangementSystem class
	 * @param year - Get year parameter from MovieMangementSystem class
	 */
	public Movie(int duration, String movieName, int year) {
		this.year = year;
		this.movieName = movieName;
		this.duration = duration;
	}

	// *******Accessor Methods**********
	/**
	 * The getYear method returns a Movie object's year.
	 * 
	 * @return year - Returns movie's year.
	 */
	public int getYear() {
		return year;
	}
	/**
	 * The getDuration method returns a Movie object's duration.
	 * 
	 * @return duration - Returns movie's duration.
	 */
	public int getDuration() {
		return duration;
	}

	@Override 
	/**
	 * The toString method returns local variable str.
	 * 
	 * @return str - Returns local variable str.
	 */
	public String toString() {
		String str = "";
		str += String.format("%-12d%-6d%s%n", duration, year, movieName);
		return str;
	}

}