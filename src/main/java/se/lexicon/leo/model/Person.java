package se.lexicon.leo.model;

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


}
