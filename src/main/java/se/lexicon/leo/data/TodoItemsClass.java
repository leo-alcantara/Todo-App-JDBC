package se.lexicon.leo.data;

import se.lexicon.leo.model.Person;
import se.lexicon.leo.model.Todo;

import java.util.ArrayList;
import java.util.Collection;

public class TodoItemsClass implements TodoItems{

    private static Collection<Todo> todoList = new ArrayList<>();

    @Override
    public Todo createNewTodo(String description) {
        Todo todo = new Todo(description);
        todoList.add(todo);
        return todo;
    }

    @Override
    public Collection<Todo> findAll() {
        return todoList;
    }

    @Override
    public Todo findById(int todoId) {
        for (Todo todo :
                todoList) {
            if (todo.getTodoId() == todoId) {
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
            if (todo.getAssignee().getPersonId() == personId) {
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
        findById(todo.getTodoId());
        todoList.remove(todo);
        return createNewTodo(todo.description);
    }

    @Override
    public boolean deleteById(int todoId) {
        todoList.removeIf(todo -> todoId == todo.getTodoId());
        return true;
    }


}
