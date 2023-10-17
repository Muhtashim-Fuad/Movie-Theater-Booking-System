package movie.theater.booking.system;

import java.sql.Time;
import java.util.*;

public class Showtime
{
    private final int schedule;
    private int availableSeatCount = 75;
    
    public Showtime(int schedule)
    {
        this.schedule = schedule >= 0 & schedule < 24? schedule : 0;
    }
    
    public String getSchedule() { return schedule + ":00"; }
    public int getAvailableSeatCount() { return availableSeatCount; }
    
    public boolean bookSeat(int seatsToBook)
    {
        if (availableSeatCount < seatsToBook) return false;
        availableSeatCount--;
        return true;
    }
}
