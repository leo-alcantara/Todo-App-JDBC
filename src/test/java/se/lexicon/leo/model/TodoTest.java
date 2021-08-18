package se.lexicon.leo.model;

import org.junit.Test;
import se.lexicon.leo.data.TodoSequencer;

import static org.junit.Assert.assertEquals;

public class TodoTest {

    @Test
    public void createTodo() {
        //Arrange
        int sequencer = 0;

        String expectedDescription = "Sort People";
        int expectedTODOID = ++sequencer;
        //Act

        Todo sortPeople = new Todo(expectedDescription);

        //Assert
        assertEquals(expectedTODOID, TodoSequencer.nextTodoId());
        assertEquals(expectedDescription, sortPeople.getDescription());

    }
}