package mk.finki.ukim.mk.lab.bootsrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.*;
import mk.finki.ukim.mk.lab.repository.jpa.CategoryRepository;
import mk.finki.ukim.mk.lab.repository.jpa.EventRepository;
import mk.finki.ukim.mk.lab.repository.jpa.LocationRepository;
import mk.finki.ukim.mk.lab.repository.jpa.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DataHolder {
    public static List<Event> events = null;
    public static List<EventBooking> MyBookings = null;
    public static List<Category> categories = null;
    public static List<Location> locations = null;
    public static List<User> users = null;

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final EventRepository eventRepository;

    public DataHolder(CategoryRepository categoryRepository, UserRepository userRepository,
                      LocationRepository locationRepository, EventRepository eventRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
        this.eventRepository = eventRepository;
    }


    @PostConstruct
    public void init() {
        //Categories
        categories = new ArrayList<>();
        if (this.categoryRepository.count() == 0) {
            categories.add(new Category("Tech"));
            categories.add(new Category("Music"));
            categories.add(new Category("Sport"));
            categories.add(new Category("Conference"));
            categories.add(new Category("Art"));
            categories.add(new Category("Health"));
            this.categoryRepository.saveAll(categories);
        }
        //Locations
        locations = new ArrayList<>();
        if (this.locationRepository.count() == 0) {
            locations.add(new Location("Wimbledon Grounds", "SW19, London, UK", "15,000", "Famous tennis stadium, home of Wimbledon Championships."));
            locations.add(new Location("Old Trafford Stadium", "Manchester, UK", "74,000", "Home of Manchester United Football Club."));
            locations.add(new Location("ICC Convention Center", "Hyderabad, India", "10,000", "Large convention center hosting international events."));
            locations.add(new Location("LA Convention Center", "Los Angeles, USA", "72,000", "Popular convention and exhibition venue."));
            locations.add(new Location("Madison Square Garden", "New York City, USA", "20,000", "World-renowned sports and entertainment venue."));
            locations.add(new Location("Louvre Museum", "Paris, France", "35,000", "The world's largest and most visited museum."));
            locations.add(new Location("Moscone Center", "San Francisco, USA", "80,000", "Major convention center in the heart of San Francisco."));
            locations.add(new Location("Tokyo Dome", "Tokyo, Japan", "55,000", "Iconic stadium, home of the Yomiuri Giants baseball team."));
            locations.add(new Location("Sydney Opera House", "Sydney, Australia", "5,000", "World-famous performing arts center."));
            locations.add(new Location("Colosseum", "Rome, Italy", "50,000", "Ancient Roman amphitheater and tourist attraction."));
            this.locationRepository.saveAll(locations);
        }
        //Events
        events = new ArrayList<>();
        if (this.eventRepository.count() == 0) {
            events.add(new Event("Wimbledon", "Tennis tournament", 9, categories.get(2), locations.get(0), 50));
            events.add(new Event("UCL", "Football tournament", 10, categories.get(2), locations.get(1), 60));
            events.add(new Event("How to get Rich", "Conference", 8, categories.get(0), locations.get(2), 50));
            events.add(new Event("How to make it from Macedonia", "Conference", 10, categories.get(0), locations.get(3), 70));
            events.add(new Event("HelloWorld", "PodcastOpening", 7, categories.get(0), locations.get(4), 60));
            events.add(new Event("Comic-Con", "Pop culture convention", 10, categories.get(3), locations.get(5), 40));
            events.add(new Event("Tech Summit", "Technology conference", 9, categories.get(0), locations.get(6), 60));
            events.add(new Event("Jazz Festival", "Music festival", 7, categories.get(1), locations.get(7), 30));
            events.add(new Event("Art Expo", "Art exhibition", 8, categories.get(4), locations.get(8), 50));
            events.add(new Event("Health & Wellness Fair", "Health awareness event", 6, categories.get(5), locations.get(9), 40));
            this.eventRepository.saveAll(events);
        }
        //Users
        users = new ArrayList<>();
        if (this.userRepository.count() == 0) {
            users.add(new User("branko.milenkov", "bm", "Branko", "Milenkov"));
            users.add(new User("vase.lazarev", "vazna", "Vase", "Lazarev"));
            users.add(new User("hristijan.stoimilov", "produkcija", "Hristijan", "Stoimilov"));
            this.userRepository.saveAll(users);
        }
    }
}
