package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();

    Page<Event> findPage(Long categoryId, Long locationId, Integer pageNum, Integer pageSize);

    Optional<Event> findById(Long id);

    Optional<Event> findByName(String name);

    List<Event> searchEvents(String text);

    List<Event> findByLocationAndCategory(Long location, Long categoryId);

    void save(String name, String description, double popularityScore, Long categoryId, Long locationId, int numTickets);

    void update(Long eventId, String name, String description, double popularityScore, Long categoryId, Long locationId, int numTickets);

    void deleteById(Long id);

    void reserveCard(Long id, int numTickets);
}
