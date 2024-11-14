package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Event {
    private Long Id;
    private String name; //canChange
    private String description; //canChange
    private double popularityScore;
    private Category category; //canChange
    private Location location; //canChange
    private boolean isClicked;
    private int numTickets;
}
