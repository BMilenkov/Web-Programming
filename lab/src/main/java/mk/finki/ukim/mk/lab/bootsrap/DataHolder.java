package mk.finki.ukim.mk.lab.bootsrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Component
public class DataHolder {
    public static final List<Event> events = new ArrayList<>(10);
    public static final List<EventBooking> MyBookings = new ArrayList<>();
    public static final List<Category> categories = new ArrayList<>();
    public static final List<Location> locations = new ArrayList<>();

    public DataHolder() {
        //Categories
        categories.add(new Category((long) (Math.random() * 1000),"Tech"));
        categories.add(new Category((long) (Math.random() * 1000),"Music"));
        categories.add(new Category((long) (Math.random() * 1000),"Sport"));
        categories.add(new Category((long) (Math.random() * 1000),"Conference"));
        categories.add(new Category((long) (Math.random() * 1000),"Art"));
        categories.add(new Category((long) (Math.random() * 1000),"Health"));
        //Locations
        locations.add(new Location((long) (Math.random() * 1000),"Wimbledon Grounds"));
        locations.add(new Location((long) (Math.random() * 1000),"Old Trafford Stadium"));
        locations.add(new Location((long) (Math.random() * 1000),"ICC Convention Center"));
        locations.add(new Location((long) (Math.random() * 1000),"LA Convention Center"));
        locations.add(new Location((long) (Math.random() * 1000),"Madison Square Garden"));
        locations.add(new Location((long) (Math.random() * 1000),"Louvre Museum"));
        locations.add(new Location((long) (Math.random() * 1000),"Moscone Center"));
        locations.add(new Location((long) (Math.random() * 1000),"Tokyo Dome"));
        locations.add(new Location((long) (Math.random() * 1000),"Sydney Opera House"));
        locations.add(new Location((long) (Math.random() * 1000),"Colosseum"));
        //Events
        events.add(new Event((long) (Math.random() * 1000),"Wimbledon", "Tennis tournament", 9, categories.get(2),locations.get(0)));
        events.add(new Event((long) (Math.random() * 1000),"UCL", "Football tournament", 10, categories.get(2),locations.get(1)));
        events.add(new Event((long) (Math.random() * 1000),"How to get Rich", "Conference", 8, categories.get(0),locations.get(2)));
        events.add(new Event((long) (Math.random() * 1000),"How to make it from Macedonia", "Conference", 10, categories.get(0),locations.get(3)));
        events.add(new Event((long) (Math.random() * 1000),"HelloWorld", "PodcastOpening", 7, categories.get(0),locations.get(4)));
        events.add(new Event((long) (Math.random() * 1000),"Comic-Con", "Pop culture convention", 10, categories.get(3),locations.get(5)));
        events.add(new Event((long) (Math.random() * 1000),"Tech Summit", "Technology conference", 9, categories.get(0),locations.get(6)));
        events.add(new Event((long) (Math.random() * 1000),"Jazz Festival", "Music festival", 7, categories.get(1),locations.get(7)));
        events.add(new Event((long) (Math.random() * 1000),"Art Expo", "Art exhibition", 8, categories.get(4),locations.get(8)));
        events.add(new Event((long) (Math.random() * 1000),"Health & Wellness Fair", "Health awareness event", 6, categories.get(5),locations.get(9)));
    }
}
