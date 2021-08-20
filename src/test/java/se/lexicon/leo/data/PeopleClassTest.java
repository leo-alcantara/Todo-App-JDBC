package se.lexicon.leo.data;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import se.lexicon.leo.model.Person;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class PeopleClassTest extends TestCase {

    PeopleClass peopleClass = new PeopleClass();
    String lastName = "Doe";
    String firstName = "John";
    //Person person = peopleClass.createNewPerson(firstName, lastName);
    Collection<Person> personList = new ArrayList<>();

    @Before
    public void before(){
        personList.clear();
    }


    public void test_CreateNewPerson_Successful() {
        //Arrange
        //String expectedFirstName = person.getFirstName();
        //String expectedLastName = person.getLastName();
        //Act

        //Assert
        //assertEquals(expectedFirstName, firstName);
        //assertEquals(expectedLastName, lastName);
    }

    public void test_FindAll_Successful() {
        //Arrange

        //Act
        //peopleClass.createNewPerson(firstName, lastName);
        personList = peopleClass.findAll();

        //Assert
        assertEquals(1, personList.size());
    }

    public void testFindById() {
        //Arrange



        //Act


        //Assert
    }

    public void testFindByName() {
        //Arrange


        //Act


        //Assert
    }

    public void testUpdate() {
        //Arrange


        //Act


        //Assert
    }

    public void testDeleteById() {
        //Arrange


        //Act


        //Assert
    }

    @After
    public void afterEach(){
        personList.clear();

    }
}