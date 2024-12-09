package mk.finki.ukim.mk.lab.web.controller;

import jakarta.servlet.http.HttpSession;
import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.service.CategoryService;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final LocationService locationService;
    private final CategoryService categoryService;

    public EventController(EventService eventService,
                           LocationService locationService,
                           CategoryService categoryService) {
        this.eventService = eventService;
        this.locationService = locationService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error,
                                @RequestParam(required = false) Long searchByCategory,
                                @RequestParam(required = false) Long searchByLocation,
                                Model model, HttpSession session) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("events", eventService.findByLocationAndCategory(searchByLocation, searchByCategory));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("locations", locationService.findAll());
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "listEvents";
    }

    @GetMapping("/add-form")
    public String getAddEventPage(Model model) {
        List<Location> locations = locationService.findAll();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("locations", locations);
        model.addAttribute("categories", categories);
        return "add-event";
    }

    @PostMapping("/add")
    public String saveEvent(@RequestParam(required = false) Long eventId,
                            @RequestParam String name,
                            @RequestParam String description,
                            @RequestParam Long categoryId,
                            @RequestParam double popularityScore,
                            @RequestParam Long locationId,
                            @RequestParam int numTickets) {
        this.eventService.save(name, description, popularityScore, categoryId, locationId, numTickets);
        return "redirect:/events";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditEventForm(@PathVariable Long id, Model model) {
        if (eventService.findById(id).stream().findFirst().isPresent()) {
            Event event = eventService.findById(id).stream().findFirst().get();
            List<Location> locations = locationService.findAll();
            List<Category> categories = categoryService.findAll();
            model.addAttribute("locations", locations);
            model.addAttribute("categories", categories);
            model.addAttribute("event", event);
            return "add-event";
        }
        return "redirect:/events?error=Event not found";
    }

    @PostMapping("/edit/{eventId}")
    public String editEvent(@PathVariable Long eventId,
                            @RequestParam String name,
                            @RequestParam String description,
                            @RequestParam Long categoryId,
                            @RequestParam double popularityScore,
                            @RequestParam Long locationId,
                            @RequestParam int numTickets) {
        if (eventId != null) {
            this.eventService.update(eventId, name, description, popularityScore, categoryId, locationId, numTickets);
        } else {
            this.eventService.save(name, description, popularityScore, categoryId, locationId, numTickets);
        }
        return "redirect:/events";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        if (eventService.findById(id).isPresent()) {
            this.eventService.deleteById(id);
            return "redirect:/events";
        } else return "redirect:/events?error=Event not found";
    }

    @PostMapping("/search")
    public String getSearchedEvents(@RequestParam String searchByCategory,
                                    @RequestParam String searchByLocation) {
        String url = UriComponentsBuilder.fromPath("/events")
                .queryParam("searchByCategory", searchByCategory)
                .queryParam("searchByLocation", searchByLocation)
                .toUriString();
        return "redirect:" + url;
    }

    @GetMapping("/details/{id}")
    public String getDetails(@PathVariable Long id, Model model) {
        Event event = null;
        if (eventService.findById(id).isPresent())
            event = eventService.findById(id).get();
        model.addAttribute("event", event);
        return "details";
    }
}
