package nachhilfe.yanni.todolist.Controller;

import nachhilfe.yanni.todolist.Model.Repository;
import nachhilfe.yanni.todolist.Model.Todo;
import nachhilfe.yanni.todolist.Model.exceptions.CouldNotAddToDatabaseException;
import nachhilfe.yanni.todolist.Model.exceptions.CouldNotDeleteFromDatabaseException;
import nachhilfe.yanni.todolist.Model.exceptions.CouldNotUpdateInDatabaseException;
import nachhilfe.yanni.todolist.View.AppView;

import java.time.LocalDateTime;

public class AppController {

    private static AppController mAppController = null;

    private AppController() {
    }

    public static AppController getInstance() {
        if (mAppController == null) {
            mAppController = new AppController();
        }

        return mAppController;
    }

    public void addTodo(String shortDescription, String longDescription) {
        try {
            Repository.getInstance().addToTodos(false, shortDescription, longDescription, LocalDateTime.now());
        } catch (CouldNotAddToDatabaseException e) {
            handleException(e);
        }
    }

    public void updateTodo(Todo todo) {
        try {
            Repository.getInstance().updateTodo(todo);
        } catch (CouldNotUpdateInDatabaseException e) {
            handleException(e);
        }
    }

    public void deleteTodo(Todo todo) {
        try {
            Repository.getInstance().deleteTodo(todo);
        } catch (CouldNotDeleteFromDatabaseException e) {
            handleException(e);
        }
    }

    public <E extends Exception> void handleException(E exception) {
        AppView.getInstance().alertOfException(exception);
    }
}
