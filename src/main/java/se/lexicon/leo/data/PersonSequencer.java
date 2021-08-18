package se.lexicon.leo.data;

public class PersonSequencer {

    private static int personId;
    private static int sequencer = 0;

    public static int nextPersonId(){
        return ++sequencer;
    }

    public static int reset(){
        personId = 0;
        return personId;
    }




}
