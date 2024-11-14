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
        locations.add(new Location((long) (Math.random() * 1000), "Wimbledon Grounds", "SW19, London, UK", "15,000", "Famous tennis stadium, home of Wimbledon Championships."));
        locations.add(new Location((long) (Math.random() * 1000), "Old Trafford Stadium", "Manchester, UK", "74,000", "Home of Manchester United Football Club."));
        locations.add(new Location((long) (Math.random() * 1000), "ICC Convention Center", "Hyderabad, India", "10,000", "Large convention center hosting international events."));
        locations.add(new Location((long) (Math.random() * 1000), "LA Convention Center", "Los Angeles, USA", "72,000", "Popular convention and exhibition venue."));
        locations.add(new Location((long) (Math.random() * 1000), "Madison Square Garden", "New York City, USA", "20,000", "World-renowned sports and entertainment venue."));
        locations.add(new Location((long) (Math.random() * 1000), "Louvre Museum", "Paris, France", "35,000", "The world's largest and most visited museum."));
        locations.add(new Location((long) (Math.random() * 1000), "Moscone Center", "San Francisco, USA", "80,000", "Major convention center in the heart of San Francisco."));
        locations.add(new Location((long) (Math.random() * 1000), "Tokyo Dome", "Tokyo, Japan", "55,000", "Iconic stadium, home of the Yomiuri Giants baseball team."));
        locations.add(new Location((long) (Math.random() * 1000), "Sydney Opera House", "Sydney, Australia", "5,000", "World-famous performing arts center."));
        locations.add(new Location((long) (Math.random() * 1000), "Colosseum", "Rome, Italy", "50,000", "Ancient Roman amphitheater and tourist attraction."));

        //Events
        events.add(new Event((long) (Math.random() * 1000),"Wimbledon", "Tennis tournament", 9, categories.get(2),locations.get(0),false,50));
        events.add(new Event((long) (Math.random() * 1000),"UCL", "Football tournament", 10, categories.get(2),locations.get(1),false,60));
        events.add(new Event((long) (Math.random() * 1000),"How to get Rich", "Conference", 8, categories.get(0),locations.get(2),false,50));
        events.add(new Event((long) (Math.random() * 1000),"How to make it from Macedonia", "Conference", 10, categories.get(0),locations.get(3),false,70));
        events.add(new Event((long) (Math.random() * 1000),"HelloWorld", "PodcastOpening", 7, categories.get(0),locations.get(4),false,60));
        events.add(new Event((long) (Math.random() * 1000),"Comic-Con", "Pop culture convention", 10, categories.get(3),locations.get(5),false,40));
        events.add(new Event((long) (Math.random() * 1000),"Tech Summit", "Technology conference", 9, categories.get(0),locations.get(6),false,60));
        events.add(new Event((long) (Math.random() * 1000),"Jazz Festival", "Music festival", 7, categories.get(1),locations.get(7),false,30));
        events.add(new Event((long) (Math.random() * 1000),"Art Expo", "Art exhibition", 8, categories.get(4),locations.get(8),false,50));
        events.add(new Event((long) (Math.random() * 1000),"Health & Wellness Fair", "Health awareness event", 6, categories.get(5),locations.get(9),false,40));
    }
}
