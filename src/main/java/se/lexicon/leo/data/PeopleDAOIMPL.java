package se.lexicon.leo.data;

import se.lexicon.leo.db.MyConnection;
import se.lexicon.leo.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class PeopleDAOIMPL implements PeopleDAO {

    private static Collection<Person> personList = new ArrayList<>();

    @Override
    public Person create(Person person) {

       String create = "INSERT INTO person (first_name, last_name) VALUES (?, ?)";
       Connection connection = null;
       PreparedStatement preparedStatement = null;
       ResultSet rs = null;

       connection = MyConnection.getInstance().getConnection();
        try {
            preparedStatement = connection.prepareStatement(create);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.executeUpdate();

            rs = preparedStatement.getResultSet();

            person = new Person(rs.getInt(1), rs.getString(2), rs.getString(3));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Collection<Person> findAll() {

        Collection<Person> foundPeople = new ArrayList<>();
        String findAll = "SELECT*FROM person";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = MyConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(findAll);

            rs = preparedStatement.executeQuery();

            while (rs.next()){
                foundPeople.add(new Person(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundPeople;
    }

    @Override
    public Person findById(int personId) {

        Person person = null;
        String findByID ="SELECT*FROM person WHERE person_id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = MyConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(findByID);
            preparedStatement.setInt(1, personId);
            rs = preparedStatement.executeQuery();

            if (rs.next()){
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
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            connection = MyConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(findByName);
            preparedStatement.setString(1, personName);
            rs = preparedStatement.executeQuery();

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
        int numberOfRowsAffected = 0;
        String updatePerson = "UPDATE person SET first_name = ?, last_name = ? WHERE person_id = ? ";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MyConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(updatePerson);
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, person.getPERSONID());

            numberOfRowsAffected = preparedStatement.executeUpdate();

            if(numberOfRowsAffected >= 1) {
                return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deleteById(int personId) {
        String deletePersonByID = "DELETE FROM person WHERE person_id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MyConnection.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(deletePersonByID);
            preparedStatement.setInt(1, personId);
            int deletedRows = preparedStatement.executeUpdate();

            if (deletedRows >= 1) {
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }
}





