package se.lexicon.leo.data;

import se.lexicon.leo.model.Person;

import java.util.ArrayList;
import java.util.Collection;

public class PeopleClass implements People {

    private static Collection<Person> personList = new ArrayList<>();

    @Override
    public Person createNewPerson(String firstName, String lastName) {
        Person person = new Person(firstName, lastName);
        personList.add(person);
        return person;
    }

    @Override
    public Collection<Person> findAll() {
        return personList;
    }

    @Override
    public Person findById(int personId) {
        for (Person p :
                personList) {
            if (p.getPersonId() == personId) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Collection<Person> findByName(String personName){
        Collection<Person> foundNames = new ArrayList<>();
        for (Person p:personList) {
            if (personName.trim().equalsIgnoreCase(p.getFirstName()+p.getLastName())){
                foundNames.add(p);
                return foundNames;
            }
        }
        return null;
    }

    @Override
    public Person update(Person person){
        findById(person.getPersonId());
        personList.remove(person);
        createNewPerson(person.firstName, person.lastName);
        return person;
    }

    @Override
    public boolean deleteById(int personId) {
        personList.removeIf(person -> personId == person.getPersonId());
        return true;
    }
}





