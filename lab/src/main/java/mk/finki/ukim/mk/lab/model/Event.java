package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; //canChange
    private String description; //canChange
    private double popularityScore;

    @ManyToOne
    private Category category; //canChange

    @ManyToOne
    private Location location; //canChange
    private int numTickets;

    public Event(String name, String description, double popularityScore,
                 Category category, Location location, int numTickets) {
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.category = category;
        this.location = location;
        this.numTickets = numTickets;
    }
}
