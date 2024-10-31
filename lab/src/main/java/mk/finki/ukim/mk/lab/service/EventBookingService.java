package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;

import java.util.List;

public interface EventBookingService {
    EventBooking placeBooking(String eventName, String attendeeName, String attendeeAddress, int numberOfTickets);
    List<EventBooking> listAll();
    List<EventBooking> searchEvents(String text);
}
