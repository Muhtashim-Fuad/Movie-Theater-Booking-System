package movie.theater.booking.system;

public class Movie 
{
    private final String title;
    private final double ticketPrice;
    private Showtime[] showTimes;
    
    public Movie(String title)
    {
        this.title = title;
        this.ticketPrice = 15.00;
        
        setShowTimes();
    }
    
    public Movie(String title, double ticketPrice)
    {
        this.title = title;
        this.ticketPrice = ticketPrice;
        setShowTimes();
    }
    
    
    
    public String getTitle() { return title; }
    public double getTicketPrice() { return ticketPrice; }
    public Showtime[] getShowTimes() { return showTimes; }
    
    private void setShowTimes()
    {
        showTimes = new Showtime[5];
        
        showTimes[0] = new Showtime(11);
        showTimes[1] = new Showtime(14);
        showTimes[2] = new Showtime(17);
        showTimes[3] = new Showtime(20);
        showTimes[4] = new Showtime(23);
    }
}
