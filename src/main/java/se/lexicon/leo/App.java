package se.lexicon.leo;

import se.lexicon.leo.data.PeopleClass;
import se.lexicon.leo.data.TodoItemsClass;
import se.lexicon.leo.model.Todo;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        TodoItemsClass todoItemsClass = new TodoItemsClass();
        PeopleClass peopleClass = new PeopleClass();

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


        todoItemsClass.create(new Todo(0,"Gardening", "Fix garden", LocalDate.parse("2021-10-10"), false, null));
        todoItemsClass.findAll().forEach(System.out::println);





    }
}
