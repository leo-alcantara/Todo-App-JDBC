package se.lexicon.leo.model;

import se.lexicon.leo.data.PersonSequencer;

public class Person {


    public String firstName;
    public String lastName;
    private final int PERSONID;

    public Person (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.PERSONID = PersonSequencer.nextPersonId();
    }

    public int getPersonId() {
        return PERSONID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
