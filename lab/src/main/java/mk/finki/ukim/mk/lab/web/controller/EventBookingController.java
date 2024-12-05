package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
        User user = (User) request.getSession().getAttribute("user");
        List<EventBooking> myBookings = this.eventBookingService.findByUser(user.getUsername());
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
            User user = (User) request.getSession().getAttribute("user");
            eventBookingService.placeBooking(user, event, attName, request.getRemoteAddr(), numTickets);
            eventService.reserveCard(Event.getId(), numTickets);
            return "redirect:/eventBooking";
        }
        return "redirect:/events?error=Not enough available tickets";
    }
}
