package movie.theater.booking.system;

public class MovieDatabase
{
    public Movie[] getMovieList()
    {
        return new Movie[]
        {
            new Movie("Insidious: The Red Door", 24),
            new Movie("Heart of Stone", 15),
            new Movie("Ballerina", 12),
            new Movie("Awareness", 10),
            new Movie("Nowhere", 18)
        };
    }
    
    
}
