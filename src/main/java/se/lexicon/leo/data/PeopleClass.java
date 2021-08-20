package se.lexicon.leo.data;

import se.lexicon.leo.db.MyConnection;
import se.lexicon.leo.model.Person;
import se.lexicon.leo.model.Todo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class PeopleClass implements People {

    private static Collection<Person> personList = new ArrayList<>();

    @Override
    public Person createNewPerson(int PERSONID, String firstName, String lastName) {
        Person person = new Person(PERSONID, firstName, lastName);
        personList.add(person);
        return person;
    }

    @Override
    public Collection<Person> findAll() {
        Collection<Person> foundPeople = new ArrayList<>();
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String findAll = "SELECT*FROM person";
            ResultSet rs = statement.executeQuery(findAll);

            while (rs.next()){
                Person person = new Person(rs.getInt(1), rs.getString(2), rs.getString(3));
                foundPeople.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundPeople;
    }

    @Override
    public Person findById(int personId) {
        String findByID ="SELECT*FROM person WHERE person_id = ?";
        Person person = null;

        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(findByID);
            preparedStatement.setInt(1, personId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                person = new Person(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return person;

    }

    @Override
    public Collection<Person> findByName(String personName){
        Collection<Person> foundNames = new ArrayList<>();
        String findByName ="SELECT*FROM person WHERE first_name = ?";

        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(findByName);
            preparedStatement.setString(1, personName);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Person person = new Person(rs.getInt(1), rs.getString(2), rs.getString(3));
                foundNames.add(person);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return foundNames;
    }

    @Override
    public Person update(Person person){
        findById(person.getPERSONID());
        personList.remove(person);
        createNewPerson(person.getPERSONID(), person.getFirstName(), person.getLastName());
        return person;
    }

    @Override
    public boolean deleteById(int personId) {
        personList.removeIf(person -> personId == person.getPERSONID());
        return true;
    }
}





