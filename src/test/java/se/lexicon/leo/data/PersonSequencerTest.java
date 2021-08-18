package se.lexicon.leo.data;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonSequencerTest {

    @Test
    public void nextPersonId() {

        //Arrange
        int nextPersonId;

        //Act
        nextPersonId = PersonSequencer.nextPersonId();

        //Assert
        assertEquals(+ 1, nextPersonId);
    }

    @Test
    public void reset() {

        //Arrange
        int personId = 20;
        //int sequencer = 0;
        //Act
        personId = PersonSequencer.reset();
        //Assert
        assertEquals(0, personId);
    }
}