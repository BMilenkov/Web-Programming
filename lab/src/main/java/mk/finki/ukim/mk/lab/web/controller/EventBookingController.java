package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.service.EventBookingService;
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

    public EventBookingController(EventBookingService eventBookingService) {
        this.eventBookingService = eventBookingService;
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
        request.getSession().setAttribute("myBookings", this.eventBookingService.listAll());
        return "redirect:/eventBooking";
    }
}
