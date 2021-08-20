package se.lexicon.leo;

import se.lexicon.leo.data.PeopleClass;
import se.lexicon.leo.data.TodoItemsClass;

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
        System.out.println(peopleClass.findById(2));*/

        System.out.println();
        peopleClass.findByName("john").forEach(System.out::println);
        System.out.println(peopleClass.findByName("john"));





    }
}
