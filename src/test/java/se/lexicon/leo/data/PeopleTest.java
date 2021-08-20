package se.lexicon.leo.data;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.leo.model.Person;

import java.util.Collection;

import static org.junit.Assert.assertEquals;


public class PeopleTest {

    private PeopleClass myPeople;
    String firstName = "John";
    String lastName = "Doe";

    @Before
    public void before() {
        myPeople = new PeopleClass();
    }


    @Test
    public void test_findAllTest_Successful() {
        //Arrange
        Collection<Person> personList;

        //Act
        //myPeople.createNewPerson(firstName, lastName);
        personList = myPeople.findAll();

        //Assert
        assertEquals(1, personList.size());

    }

    @Test
    public void test_findByIdTest_Successful() {
        //Arrange
        Person newPerson;
        //Act
        newPerson = myPeople.findById(1);

        //Assert
        assertEquals(null, newPerson);

    }

    @Test
    public void findByIdReturn() {
        //Arrange
        Person newPerson;

        //Act
        //newPerson = myPeople.createNewPerson(firstName, lastName);
        //myPeople.findById(newPerson.getPersonId());

         //Assert
        //assertEquals(newPerson, newPerson);
    }


    @Test
    public void createNewPersonTest() {
        //Arrange
        Person newPerson;

        //Act
        //newPerson = myPeople.createNewPerson(firstName, lastName);

        //Assert
        //assertEquals(firstName, newPerson.getFirstName());
        //assertEquals(lastName, newPerson.getLastName());
        //assertEquals(1, myPeople.size());
    }

    @Test
    public void clearTest() {
        //Arrange
        //myPeople.createNewPerson(firstName, lastName);
        //Act
        //myPeople.clear();
        //Assert
        //assertEquals(0, myPeople.size());
    }

    @Test
    public void removeTest() {
        //Arrange
        //Person newPerson = myPeople.createNewPerson(firstName, lastName);

        //Act
        //myPeople.remove(newPerson);
        //myPeople.size();
        //Assert
        //assertEquals(0, myPeople.size());
        //assertEquals();
    }

    @Test
    public void removeTestNewArray(){
        //Arrange

        //Act

        //Assert


    }
}