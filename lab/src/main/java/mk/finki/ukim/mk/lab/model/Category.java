package mk.finki.ukim.mk.lab.model;

import lombok.Data;

public class Category {
    private String category;

    public Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
