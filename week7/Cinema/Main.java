package week7.Cinema;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Seat> all = new HashSet<Seat>(
                Arrays.asList(
                        new Seat(1,1), new Seat(1,2), new Seat(1,3),
                        new Seat(2,1), new Seat(2,2), new Seat(2,3),
                        new Seat(3,1), new Seat(3,2), new Seat(3,3)
                ));

        Showtime showtime = new Showtime(all);

        Thread t1 = new Thread(() -> {
            String myname = "1st thread";
            showtime.getFreeSeats();
            Seat wanna = new Seat(2,3);
            System.out.println(myname + " " + showtime.bookSeat(wanna));
        });
        Thread t2 = new Thread(() -> {
            String myname = "2st thread";
            showtime.getFreeSeats();
            Seat wanna = new Seat(2,3);
            System.out.println(myname + " " + showtime.bookSeat(wanna));
        });
        t1.start();t2.start();
    }
}
