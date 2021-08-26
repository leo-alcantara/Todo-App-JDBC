package se.lexicon.leo;

import se.lexicon.leo.data.PeopleDAOIMPL;
import se.lexicon.leo.data.TodoItemsDAOIMPL;
import se.lexicon.leo.model.Person;
import se.lexicon.leo.model.Todo;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        TodoItemsDAOIMPL todoItemsDAOIMPL = new TodoItemsDAOIMPL();
        PeopleDAOIMPL peopleDAOIMPL = new PeopleDAOIMPL();

        Person newPerson = new Person(0, "Maximus", "Decimus Miridius");
        Todo newTodo = new Todo(0,"Kill roman soldiers", "Cut off their heads", LocalDate.now(), false, peopleDAOIMPL.findById(109));


        //newTodo.setAssignee(newPerson);
        //System.out.println(peopleDAOIMPL.create(newPerson));
        System.out.println(todoItemsDAOIMPL.create(newTodo));




    }
}
