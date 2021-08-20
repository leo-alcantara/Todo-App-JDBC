package se.lexicon.leo.data;

import se.lexicon.leo.db.MyConnection;
import se.lexicon.leo.model.Person;
import se.lexicon.leo.model.Todo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class TodoItemsClass implements TodoItems{

    private static Collection<Todo> todoList = new ArrayList<>();

    @Override
    public Todo createNewTodo(int TODOID, String title, String description, LocalDate deadline, boolean done, Person assignee) {
        Todo todo = new Todo(TODOID, title, description, deadline, done, assignee);
        todoList.add(todo);
        return todo;
    }

    @Override
    public Collection<Todo> findAll() {
        Collection<Todo> foundTodos = new ArrayList<>();
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String findAll = "SELECT*FROM todo_item";
            ResultSet rs = statement.executeQuery(findAll);

            while (rs.next()){
                Todo todo = new Todo(rs.getInt(1),rs.getString(2), rs.getString(3),
                        rs.getDate(4).toLocalDate(), rs.getBoolean(5), null);
                foundTodos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundTodos;
    }

    @Override
    public Todo findById(int todoId) {
        for (Todo todo :
                todoList) {
            if (todo.getTODOID() == todoId) {
                return todo;
            }
        }
        return null;
    }

    @Override
    public Collection<Todo> findByDoneStatus(boolean doneStatus) {
        Collection<Todo> doneTodos = new ArrayList<>();
        for (Todo todo : todoList) {
            if (todo.isDone() == doneStatus) {
                doneTodos.add(todo);
            }
        }
        return doneTodos;
    }

    @Override
    public Collection<Todo> findByAssignee(int personId) {
        Collection<Todo> assigneeIdMatches = new ArrayList<>();
        for (Todo todo : todoList) {
            if (todo.getAssignee().getPERSONID() == personId) {
                assigneeIdMatches.add(todo);
            }
        }
        return assigneeIdMatches;
    }

    @Override
    public Collection<Todo> findByAssignee(Person assignee) {
        Collection<Todo> assigneeIdMatches = new ArrayList<>();
        for (Todo todo : todoList) {
            if (todo.getAssignee() == assignee) {
                assigneeIdMatches.add(todo);
            }
        }
        return assigneeIdMatches;
    }

    @Override
    public Collection<Todo> findUnassignedTodoItems() {
        Collection<Todo> unassignedTodo = new ArrayList<>();
        for (Todo todo : todoList) {
            if (todo.getAssignee() == null) {
                unassignedTodo.add(todo);
            }
        }
        return unassignedTodo;
    }

    @Override
    public Todo update(Todo todo) {
        findById(todo.getTODOID());
        todoList.remove(todo);
        return createNewTodo(todo.TODOID, todo.title, todo.description, todo.deadline, todo.isDone(), todo.assignee);
    }

    @Override
    public boolean deleteById(int todoId) {
        todoList.removeIf(todo -> todoId == todo.getTODOID());
        return true;
    }


}
