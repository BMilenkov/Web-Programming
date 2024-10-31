package mk.finki.ukim.mk.lab.bootsrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DataHolder {
    public static final List<Event> events = new ArrayList<>(10);
    public static final List<EventBooking> MyBookings = new ArrayList<>();
    public static final List<Category> categories = new ArrayList<>();

    public DataHolder() {
        categories.add(new Category("Tech"));
        categories.add(new Category("Music"));
        categories.add(new Category("Sport"));
        categories.add(new Category("Conference"));
        categories.add(new Category("Art"));
        categories.add(new Category("Health"));
        events.add(new Event("Wimbledon", "Tennis tournament", 9, categories.get(2)));
        events.add(new Event("UCL", "Football tournament", 10, categories.get(2)));
        events.add(new Event("How to get Rich", "Conference", 8, categories.get(0)));
        events.add(new Event("How to make it from Macedonia", "Conference", 10, categories.get(0)));
        events.add(new Event("HelloWorld", "PodcastOpening", 7, categories.get(0)));
        events.add(new Event("Comic-Con", "Pop culture convention", 10, categories.get(3)));
        events.add(new Event("Tech Summit", "Technology conference", 9, categories.get(0)));
        events.add(new Event("Jazz Festival", "Music festival", 7, categories.get(1)));
        events.add(new Event("Art Expo", "Art exhibition", 8, categories.get(4)));
        events.add(new Event("Health & Wellness Fair", "Health awareness event", 6, categories.get(5)));
    }
}
