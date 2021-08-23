package se.lexicon.leo;

import javafx.util.converter.PercentageStringConverter;
import se.lexicon.leo.data.PeopleDAOIMPL;
import se.lexicon.leo.data.TodoItemsDAOIMPL;
import se.lexicon.leo.model.Person;
import se.lexicon.leo.model.Todo;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        TodoItemsDAOIMPL todoItemsClass = new TodoItemsDAOIMPL();
        PeopleDAOIMPL peopleClass = new PeopleDAOIMPL();
        Person newPerson = peopleClass.findById(2);

        /*todoItemsClass.findAll().forEach(System.out::println);

        System.out.println();
        System.out.println(todoItemsClass.findById(2));

        System.out.println();
        todoItemsClass.findUnassignedTodoItems().forEach(System.out::println);
        System.out.println();

        peopleClass.findAll().forEach(System.out::println);

        System.out.println();
        System.out.println(peopleClass.findById(2));

        System.out.println();
        peopleClass.findByName("john").forEach(System.out::println);
        System.out.println(peopleClass.findByName("john"));*/

        //todoItemsClass.deleteById(3);


        //todoItemsClass.create(new Todo(0,"Gardening", "Fix garden", LocalDate.parse("2021-10-10"), false, null));
        //todoItemsClass.findAll().forEach(System.out::println);

        Todo todo = todoItemsClass.findById(18);
        todo.setAssignee(newPerson);
        todo.setTitle("Cut the Tress");
        System.out.println(todoItemsClass.update(todo));





    }
}
