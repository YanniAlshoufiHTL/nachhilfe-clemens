package nachhilfe.yanni.todolist.View;

import javafx.scene.control.TableView;
import nachhilfe.yanni.todolist.Model.Todo;

public class UpsertView {

    private static UpsertView mUpsertView = null;
    private TableView<Todo> mTodosTableView = null;
    private Todo mCurrentTodo;

    private UpsertView() {}

    public static UpsertView getInstance() {
        if(mUpsertView == null) {
            mUpsertView = new UpsertView();
        }

        return mUpsertView;
    }


    public void setCurrentTodo(Todo isSelected) {
        mCurrentTodo = isSelected;
    }

    public Todo getCurrentTodo() {
        return mCurrentTodo;
    }

    public void setTodos(TableView<Todo> todos) {
        mTodosTableView = todos;
    }

    public TableView<Todo> getTodos() {
        return mTodosTableView;
    }
}
