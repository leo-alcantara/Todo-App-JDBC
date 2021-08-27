package se.lexicon.leo;

import se.lexicon.leo.data.PeopleDAOIMPL;
import se.lexicon.leo.data.TodoItemsDAOIMPL;
import se.lexicon.leo.model.Person;
import se.lexicon.leo.model.Todo;

import java.time.LocalDate;


public class App {
    public static void main(String[] args) {

        TodoItemsDAOIMPL todoItemsDAOIMPL = new TodoItemsDAOIMPL();
        PeopleDAOIMPL peopleDAOIMPL = new PeopleDAOIMPL();

        Person newPerson = new Person("Maximus", "Decimus Miridius");

        Todo newTodo = new Todo("Shoot the bandits", "Shoot them all", LocalDate.now(), false, null);
        //todoItemsDAOIMPL.create(newTodo);

        todoItemsDAOIMPL.findAll().forEach(System.out::println);

       // System.out.println(peopleDAOIMPL.findById(200));


        //newTodo.setAssignee(newPerson);
        //System.out.println(peopleDAOIMPL.create(newPerson));


    }
}
