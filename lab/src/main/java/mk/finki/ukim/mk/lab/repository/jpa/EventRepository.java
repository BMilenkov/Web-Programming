package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EventRepository extends JpaSpecificationRepository<Event, Long> {

    Optional<Event> findByName(String name);

    List<Event> findAllByLocation_Id(Long locationId);

    List<Event> findAllByCategory_Id(Long categoryId);

    List<Event> findAllByNameLike(String name);

    List<Event> findAllByLocation_IdAndCategory_Id(Long locationId, Long categoryId);

    @Modifying
    @Query("UPDATE Event e" +
            " SET e.numTickets = e.numTickets - :numTickets " +
            "WHERE e.id = :eventId AND e.numTickets >= :numTickets")
    void reserveTickets(@Param("eventId") Long eventId, @Param("numTickets") int numTickets);
}
