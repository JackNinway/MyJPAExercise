package com.example.myjpaexercise.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
public class ToDoItem {
    @Id
    @GeneratedValue
    private UUID toDoId;
    private String title;
    private String description;
    private LocalDateTime deadline;
    private boolean done = false;

    public ToDoItem(String title, String description, LocalDateTime deadline) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    protected ToDoItem() {
    }

    public UUID getToDoId() {
        return toDoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void toggleDone(boolean done) {
        this.done = !done;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "toDoId='" + toDoId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoItem toDoItem = (ToDoItem) o;
        return done == toDoItem.done && toDoId.equals(toDoItem.toDoId) && title.equals(toDoItem.title) && description.equals(toDoItem.description) && deadline.equals(toDoItem.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toDoId, title, description, deadline, done);
    }
}
