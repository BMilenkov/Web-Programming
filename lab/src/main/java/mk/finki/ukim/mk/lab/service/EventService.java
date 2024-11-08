package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();

    Optional<Event> findById(Long id);

    Optional<Event> findByName(String name);

    List<Event> searchEvents(String text);

    List<Event> searchByCategory(String category);

    Optional<Event> save(String name, String description, double popularityScore, Long categoryId, Long locationId);

    void deleteById(Long id);

}
