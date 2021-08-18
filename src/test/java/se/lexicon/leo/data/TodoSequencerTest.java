package se.lexicon.leo.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TodoSequencerTest {

    @Test
    public void nextTodoId() {

        //Arrange
        int todoId;

        //Act
        todoId = TodoSequencer.nextTodoId();
        //Assert
        assertEquals(+ 1, todoId);

    }

    @Test
    public void reset() {

        //Arrange
        int todoId = 20;
        //int sequencer = 0;
        //Act
        todoId = TodoSequencer.reset();
        //Assert
        assertEquals(0, todoId);

    }
}