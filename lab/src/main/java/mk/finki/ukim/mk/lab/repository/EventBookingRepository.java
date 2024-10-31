package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootsrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EventBookingRepository {
    public EventBookingRepository() {
    }

    public void addBooking(EventBooking booking) {
        DataHolder.MyBookings.add(booking);
    }

    public List<EventBooking> listMyBookings() {
        return DataHolder.MyBookings.stream().toList();
    }

    public List<EventBooking> searchEvents(String text) {
        return DataHolder.MyBookings.stream().filter(e -> e.getEventName().contains(text)).toList();
    }
}
