package se.lexicon.leo.model;

import java.util.Objects;

public class Person {

    private final int PERSONID;
    public String firstName;
    public String lastName;

    public Person(int PERSONID, String firstName, String lastName) {
        this.PERSONID = PERSONID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getPERSONID() {
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

    @Override
    public String toString() {
        return "Person{" +
                "PERSONID=" + PERSONID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getPERSONID() == person.getPERSONID() && getFirstName().equals(person.getFirstName()) && getLastName().equals(person.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPERSONID(), getFirstName(), getLastName());
    }
}
