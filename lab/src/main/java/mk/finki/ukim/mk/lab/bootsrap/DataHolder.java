package mk.finki.ukim.mk.lab.bootsrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DataHolder {
    public static final List<Event> events = new ArrayList<>(10);

    public DataHolder() {
        events.add(new Event("Wimbledon", "Tennis tournament", 9));
        events.add(new Event("UCL", "Football tournament", 10));
        events.add(new Event("How to get Rich", "Conference", 8));
        events.add(new Event("How to make it from Macedonia", "Conference", 10));
        events.add(new Event("HelloWorld", "PodcastOpening", 7));
    }
}
