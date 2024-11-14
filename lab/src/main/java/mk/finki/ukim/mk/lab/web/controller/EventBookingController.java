package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private String getEventBookingPage() {
        //there is no need of model and request
//        model.addAttribute("state", request.getSession().getAttribute("myBookings"));
        return "bookingConfirmation";
    }

    @PostMapping("/book")
    private String bookEvent(@RequestParam String attName,
                             @RequestParam String event,
                             @RequestParam int numTickets,
                             HttpServletRequest request) {
        EventBooking booking = eventBookingService.placeBooking(event, attName, request.getRemoteAddr(), numTickets);
        Event Event = eventService.findByName(event).get();
        if (Event.getNumTickets() > numTickets) {
            eventService.reserveCard(Event, numTickets);
            request.getSession().setAttribute("myBookings", this.eventBookingService.listAll());
            return "redirect:/eventBooking";
        }
        return "redirect:/events?error=Not enough available tickets";
    }
}
