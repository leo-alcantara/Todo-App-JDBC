package se.lexicon.leo.model;

import se.lexicon.leo.data.PersonSequencer;

public class Person {

    private final int PERSONID;
    public String firstName;
    public String lastName;


    public Person (String firstName, String lastName){
        this.PERSONID = PersonSequencer.nextPersonId();
        this.firstName = firstName;
        this.lastName = lastName;

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
