package week7.Cinema;

import java.util.Iterator;
import java.util.Set;

public class Showtime {
    private volatile Set<Seat> freeSeats;
    private Object lock = new Object();

    // возвращает набор мест, доступных для бронирования
    // на текущий сеанс
    public Set<Seat> getFreeSeats() {
        synchronized (lock) {
            return freeSeats;
        }
    }

    // бронирует место на текущий сеанс;
    // возвращает true, если место успешно забронировано
    // или false, если бронирование не удалось
    // (кто-то успел раньше)
    public boolean bookSeat(Seat seat) {
        synchronized (lock) {
        Iterator<Seat> it = freeSeats.iterator();
            while (it.hasNext())
                if (it.next().equals(seat)) {
                    it.remove();
                    return true;
                }
            return false;
        }
    }

    public Showtime(Set<Seat> allSeats) {
        this.freeSeats = allSeats;
    }
}