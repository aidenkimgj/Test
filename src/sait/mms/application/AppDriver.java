package sait.mms.application;

/**
 * import libraries and package. 
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import sait.mms.managers.MovieMangementSystem;
import sait.mms.problemdomain.Movie;

/**
 * This program is that in order to register and find movie information.
 * 
 * @author Hong and Kim
 * @version 1.0, May 17, 2020
 */
public class AppDriver {

   public static void main(String[] args) throws IOException {
	  // Create ArrayList with Movie class type.
      ArrayList<Movie> movies = new ArrayList<Movie>();
      // Create Scanner object.
      Scanner in = new Scanner(System.in);
      // Create MovieMangementSystem class object.
      MovieMangementSystem magntSys = new MovieMangementSystem();
      // Invoke loadMovieList method with parameter.
      magntSys.loadMovieList(movies);
      
      int select;
      int duration;
      String movieName;
      int year;
      int numberOfMovie;
      // Invoke displayMenu method with parameter.
      select = magntSys.displayMenu(in);

      while (select != 0) {
    	  // Use switch statement for option number.
         switch (select) {
         case 1:

            System.out.print("Enter duration: ");
            duration = in.nextInt();
            // Remove a line break
            in.nextLine();
            
            System.out.print("Enter movie title: ");
            movieName = in.nextLine();
            
            System.out.print("Enter year: ");
            year = in.nextInt();
            // Invoke  addMovie method with parameters
            magntSys.addMovie(movies, duration, movieName, year);

            System.out.println("Saving movies...");
            System.out.println("Added movie to the data file.");

            break;

         case 2:

            System.out.print("Enter in year: ");
            year = in.nextInt();
            
            System.out.println();
            // Invoke generateMoveListInYear method from magntSys
            magntSys.generateMoveListInYear(movies, year);

            break;

         case 3:

            System.out.print("Enter number of movies: ");
            numberOfMovie = in.nextInt();// Input number(integer type)

            System.out.println();
            // Invoke generateRandomMovieList method with parameters from MovieMangementSystem class.
            magntSys.generateRandomMovieList(movies, numberOfMovie);

            break;

         case 4:
            // Exit
            System.exit(0);

         default:
        	// Display Invalid option. 
            System.out.println("Invalid option");

            break;

         }
         System.out.println();
         // Display menu again.
         select = magntSys.displayMenu(in);
      }
   }

}