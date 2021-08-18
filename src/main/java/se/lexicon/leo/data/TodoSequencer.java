package se.lexicon.leo.data;

public class TodoSequencer {

    private static int todoId;
    private static int sequencer = 0;

    public static int nextTodoId() {
        return ++sequencer;
    }

    public static int reset() {
        todoId = 0;
        return todoId;
    }
}
