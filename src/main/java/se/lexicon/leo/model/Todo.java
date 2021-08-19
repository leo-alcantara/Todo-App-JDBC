package se.lexicon.leo.model;

import se.lexicon.leo.data.TodoSequencer;

import java.util.Date;

public class Todo {

    private final int TODOID;
    public String title;
    public String description;
    public Date deadline;
    private boolean done;
    public Person assignee;

    public Todo(String title, String description, Date deadline) {
        this.TODOID = TodoSequencer.nextTodoId();
        this.title = title;
        this.description = description;
        this.deadline = deadline;
    }

    public int getTODOID() {
        return TODOID;
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssigneeId(Person assigneeId) {
        this.assignee = assigneeId;
    }
}
