package se.lexicon.leo.data;

import se.lexicon.leo.model.Person;

import java.util.Collection;

public interface People {

    Person createNewPerson(String firstName, String lastName);

    Collection<Person> findAll();

    Person findById(int personId);

    Collection<Person> findByName(String personName);

    Person update(Person person);

    boolean deleteById(int personId);
}
