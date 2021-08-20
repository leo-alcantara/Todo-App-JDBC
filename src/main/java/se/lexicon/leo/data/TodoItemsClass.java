package se.lexicon.leo.data;

import se.lexicon.leo.db.MyConnection;
import se.lexicon.leo.model.Person;
import se.lexicon.leo.model.Todo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class TodoItemsClass implements TodoItems{

    private static Collection<Todo> todoList = new ArrayList<>();

    @Override
    public Todo create(Todo todo) {
        String createTodo = "INSERT INTO todo_item (title, description, deadline, done, assignee_id) VALUES ( ?, ?, ?, ?, ?)";
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement preparedstatement = connection.prepareStatement(createTodo);
            preparedstatement.setString(1, todo.title);
            preparedstatement.setString(2, todo.description);
            preparedstatement.setDate(3, todo.deadline.);
            preparedstatement.setBoolean(4,todo.done);
            preparedstatement.setInt(5, todo.assignee.getPERSONID());
            preparedstatement.executeUpdate(createTodo);

            ResultSet rs = preparedstatement.getResultSet();

               todo = new Todo(rs.getInt(1),rs.getString(2), rs.getString(3),
                        rs.getDate(4).toLocalDate(), rs.getBoolean(5), null);
                return todo;
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        String findByID ="SELECT*FROM todo_item WHERE todo_id = ?";
        Todo todo = null;

        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(findByID);
            preparedStatement.setInt(1, todoId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                todo = new Todo(rs.getInt(1),rs.getString(2), rs.getString(3),
                        rs.getDate(4).toLocalDate(), rs.getBoolean(5), null);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return todo;
    }

    @Override
    public Collection<Todo> findByDoneStatus(boolean doneStatus) {
        Collection<Todo> doneTodos = new ArrayList<>();
        String findDoneStatus ="SELECT*FROM todo_item WHERE done = ?";

        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(findDoneStatus);
            preparedStatement.setBoolean(1, doneStatus);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Todo todo = new Todo(rs.getInt(1),rs.getString(2), rs.getString(3),
                        rs.getDate(4).toLocalDate(), rs.getBoolean(5), null);
                doneTodos.add(todo);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return doneTodos;
    }

    @Override
    public Collection<Todo> findByAssignee(int personId) {
        Collection<Todo> assigneeIdMatches = new ArrayList<>();
        String findByAssigneeId ="SELECT*FROM todo_item WHERE assignee_id = ?";
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(findByAssigneeId);
            preparedStatement.setInt(1, personId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Todo todo = new Todo(rs.getInt(1),rs.getString(2), rs.getString(3),
                        rs.getDate(4).toLocalDate(), rs.getBoolean(5), null);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return assigneeIdMatches;
    }

    @Override
    public Collection<Todo> findByAssignee(Person assignee) {
        Collection<Todo> assigneeMatches = new ArrayList<>();
        String findByAssigneeObject ="SELECT*FROM todo_item WHERE assignee_id = ?";
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(findByAssigneeObject);
            preparedStatement.setObject(1, assignee);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Todo todo = new Todo(rs.getInt(1),rs.getString(2), rs.getString(3),
                        rs.getDate(4).toLocalDate(), rs.getBoolean(5), null);
                assigneeMatches.add(todo);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return assigneeMatches;
    }

    @Override
    public Collection<Todo> findUnassignedTodoItems() {
        Collection<Todo> unassignedTodo = new ArrayList<>();
        String findUnassignedTodos ="SELECT*FROM todo_item WHERE assignee_id Is null";
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(findUnassignedTodos);

            while (rs.next()){
                Todo todo = new Todo(rs.getInt(1),rs.getString(2), rs.getString(3),
                        rs.getDate(4).toLocalDate(), rs.getBoolean(5), null);
                unassignedTodo.add(todo);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return unassignedTodo;
    }

    @Override
    public Todo update(Todo todo) {
        //String sql="update  todo_item set name='GFG' where id=2";
        //String updateTodo = "update todo_item set ";

        /*String updateTodo ="SELECT*FROM todo_item  WHERE ";
        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(updateTodo);
            //preparedStatement.setObject();
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                todo = new Todo(rs.getInt(1),rs.getString(2), rs.getString(3),
                        rs.getDate(4).toLocalDate(), rs.getBoolean(5), null);

            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }*/
        return todo;
    }

    @Override
    public boolean deleteById(int todoId) {
        String deleteTodoByID ="DELETE FROM todo_item WHERE todo_id = ?";

        try {
            Connection connection = MyConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteTodoByID);
            preparedStatement.setInt(1, todoId);
            int deletedRows = preparedStatement.executeUpdate(deleteTodoByID);
            //IF Statement
            if(deletedRows==1){
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return false;
    }


}
