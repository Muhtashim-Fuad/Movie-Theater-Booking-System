package movie.theater.booking.system;

import java.sql.Time;
import java.util.*;

public class AppData
{
    public static void main(String[] args) 
    {
        try 
            {
                MovieDatabase movieDatabase = new MovieDatabase();
                Scanner scanner = new Scanner(System.in);

                displayMovieList(movieDatabase);
                System.out.print("Enter Movie Index: ");
                int userChoice = scanner.nextInt(); 
                if (!(userChoice > 0 && userChoice <= movieDatabase.getMovieList().length)) throw new InputMismatchException();

                Movie movie = movieDatabase.getMovieList()[userChoice-1];
                displayShowtimes(movie);
                System.out.print("Enter your preferred showtime for selected movie: ");
                userChoice = scanner.nextInt();
                if (!(userChoice > 0 && userChoice <= movie.getShowTimes().length)) throw new InputMismatchException();

                Showtime showtime = movie.getShowTimes()[userChoice - 1];
                System.out.print("Enter number of seats you would like to book: ");
                userChoice = scanner.nextInt();
                if (showtime.bookSeat(userChoice))
                {
                    double totalCost = userChoice * movie.getTicketPrice();
                    System.out.println("Seat Booking Successful!");
                    System.out.println("------------------------");
                    System.out.println("Selected Movie: " + movie.getTitle());
                    System.out.println("Selected Schedule: " + showtime.getSchedule());
                    System.out.println("Seat Count: " + userChoice);
                    System.out.println("Total Cost: $" + String.format("%.2f", totalCost));
                    System.out.println("------------------------");
                    System.out.print("Would you like to confirm? (Y/N): ");
                    String confirmResponse = scanner.next();
                    if (!confirmResponse.equals("Y")) return;
                    confirmResponse = scanner.nextLine();
                    System.out.println("Thank You for the reservation! Enjoy your movie!");
                }
                else System.out.println("Seats unavailable! Please choose a different schedule!");

                scanner.close();
            }
            catch (InputMismatchException ex)
            {
                System.out.println("Invalid Choice!");
            }
    }
    
    private static void displayShowtimes(Movie movie)
    {
        System.out.println("----------------------------------");
        System.out.println("Available Showtimes for " + movie.getTitle());
        Showtime[] showtimes = movie.getShowTimes();
        for (int i=0; i < showtimes.length; i++)
        {
            System.out.println("#" + 
                    (i+1) + ". Showtime: " +
                    showtimes[i].getSchedule() + 
                    " (Available Seats: " + showtimes[i].getAvailableSeatCount() + ")");
        }
        System.out.println("----------------------------------");
    }
    
    private static void displayMovieList(MovieDatabase movieDatabase)
    {
        Movie[] movies = movieDatabase.getMovieList();
        
        System.out.println("----------------------------------");
        for(int i=0; i<movies.length; i++)
        {
            System.out.println("#" +
                    (i+1) + ". " + movies[i].getTitle()+ " [Ticket Price: $" +
                    String.format("%.2f", movies[i].getTicketPrice()) + "]");
        }
        System.out.println("----------------------------------");
    }
}
