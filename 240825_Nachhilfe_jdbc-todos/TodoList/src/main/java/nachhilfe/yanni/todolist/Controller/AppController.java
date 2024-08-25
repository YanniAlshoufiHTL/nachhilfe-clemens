package nachhilfe.yanni.todolist.Controller;

import nachhilfe.yanni.todolist.Model.Repository;
import nachhilfe.yanni.todolist.Model.Todo;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class AppController {

    private static AppController mAppController = null;

    private AppController() {}

    public static AppController getInstance() {
        if(mAppController == null) {
            mAppController = new AppController();
        }

        return mAppController;
    }

    public void addTodo(String shortDescription, String longDescription) throws SQLException {
        Repository.getInstance().addToTodos(false, shortDescription, longDescription, LocalDateTime.now());
    }

    public void updateTodo(int id, boolean isDone, String shortDescription, String longDescription) throws SQLException {
        Repository.getInstance().updateTodo(id, isDone, shortDescription, longDescription);
    }

    public void deleteTodo(int id) throws SQLException {
        Repository.getInstance().deleteTodo(id);
    }
}
