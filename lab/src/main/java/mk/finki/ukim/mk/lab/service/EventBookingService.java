package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.User;

import java.util.List;

public interface EventBookingService {

    void placeBooking(User user, String eventName, String attendeeName, String attendeeAddress, int numberOfTickets);
    List<EventBooking> listAll();
    List<EventBooking> searchEvents(String text);
    List<EventBooking> findByUser(String username);
}
