package se.lexicon.leo.data;

import se.lexicon.leo.model.Person;

import java.util.Collection;

public interface PeopleDAO {

    Person create(Person person);

    Collection<Person> findAll();

    Person findById(int personId);

    Collection<Person> findByName(String personName);

    Person update(Person person);

    boolean deleteById(int personId);
}
