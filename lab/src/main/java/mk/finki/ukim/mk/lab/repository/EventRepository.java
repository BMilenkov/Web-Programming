package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootsrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class EventRepository {

    public EventRepository() {
    }

    public List<Event> findAll() {
        return DataHolder.events.stream().toList();
    }

    public List<Event> searchEvents(String text) {
        List<Event> initial = DataHolder.events.stream().filter(e -> e.getName().contains(text) || e.getDescription().contains(text))
                .toList();
        if (initial.isEmpty()) {
            initial = DataHolder.events.stream().filter(e -> e.getPopularityScore() >= Double.parseDouble(text))
                    .toList();
        }
        return initial;
    }
    public List<Category> findCategories(){
        return DataHolder.categories;
    }

    public List<Event> searchCategory(String text){
        return DataHolder.events.stream().filter(event -> event.getCategory().getCategory().equals(text)).collect(Collectors.toList());
    }
}
