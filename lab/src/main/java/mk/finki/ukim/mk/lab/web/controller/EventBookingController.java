package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/eventBooking")
public class EventBookingController {
    private final EventBookingService eventBookingService;
    private final EventService eventService;

    public EventBookingController(EventBookingService eventBookingService, EventService eventService) {
        this.eventBookingService = eventBookingService;
        this.eventService = eventService;
    }

    @GetMapping
    private String getEventBookingPage(HttpServletRequest request, Model model) {
        String username = request.getRemoteUser();
        List<EventBooking> myBookings = this.eventBookingService.findByUser(username);
        model.addAttribute("myBookings", myBookings);
        return "bookingConfirmation";
    }

    @PostMapping("/book")
    private String bookEvent(@RequestParam String attName,
                             @RequestParam String event,
                             @RequestParam int numTickets,
                             HttpServletRequest request) {
        Event Event = null;
        if (eventService.findByName(event).isPresent())
            Event = eventService.findByName(event).get();

        assert Event != null;
        if (Event.getNumTickets() > numTickets) {
            String username = request.getRemoteUser();
            eventBookingService.placeBooking(username, event, attName, request.getRemoteAddr(), numTickets);
            eventService.reserveCard(Event.getId(), numTickets);
            return "redirect:/eventBooking";
        }
        return "redirect:/events?error=Not enough available tickets";
    }

    @GetMapping("/cancel/{id}")
    private String cancelEventBooking(@PathVariable Long id) {
        EventBooking eventBooking = this.eventBookingService.findById(id);
        Long numTickets = eventBooking.getNumberOfTickets();
        Optional<Event> event = this.eventService.findByName(eventBooking.getEventName());

        if (event.isPresent()) {
            Event ev = event.get();
            this.eventService.update(ev.getId(), ev.getName(), ev.getDescription(), ev.getPopularityScore(), ev.getCategory().getId()
                    ,ev.getLocation().getId(), (int) (ev.getNumTickets() + numTickets));
        }
        this.eventBookingService.deleteEventBooking(id);
        return "redirect:/eventBooking";
    }
}
