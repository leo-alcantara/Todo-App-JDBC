package se.lexicon.leo;

import se.lexicon.leo.data.TodoItemsClass;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        TodoItemsClass todoItemsClass = new TodoItemsClass();

        todoItemsClass.findAll().forEach(System.out::println);




    }
}
