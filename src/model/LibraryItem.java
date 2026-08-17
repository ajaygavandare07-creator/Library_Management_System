package model;

import java.io.Serializable;

public abstract class LibraryItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String id;
    private String title;

    public LibraryItem(String id, String title) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Item ID cannot be empty.");
        }

        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }

        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }

        this.title = title;
    }

    public abstract String getItemType();

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title;
    }
}