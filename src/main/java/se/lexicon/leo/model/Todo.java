package se.lexicon.leo.model;

import se.lexicon.leo.data.TodoSequencer;

public class Todo {

    private final int TODOID;
    public String description;
    private boolean done;
    public Person assignee;



    public Todo(String description){
        this.TODOID = TodoSequencer.nextTodoId();
        this.description = description;

    }

    public int getTodoId() {
        return TODOID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }





}
