package nachhilfe.yanni.todolist.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import nachhilfe.yanni.todolist.App;
import nachhilfe.yanni.todolist.Controller.AppController;
import nachhilfe.yanni.todolist.Model.Repository;
import nachhilfe.yanni.todolist.Model.Todo;
import nachhilfe.yanni.todolist.View.exceptions.NothingSelectedException;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TodosController {
    @FXML
    private TableColumn<Todo, Boolean> mIsDone;
    @FXML
    private TableColumn<Todo, String> mShortDescription;
    @FXML
    private TableColumn<Todo, LocalDateTime> mDateUpsterted;
    @FXML
    private TableView<Todo> mTodos;

    @FXML
    public void initialize() {
        mShortDescription.setCellValueFactory(new PropertyValueFactory<Todo, String>("shortDescription"));
        mDateUpsterted.setCellValueFactory(new PropertyValueFactory<Todo, LocalDateTime>("dateCreated"));
        mIsDone.setCellValueFactory(new PropertyValueFactory<Todo, Boolean>("isDone"));

        mTodos.setItems(Repository.getInstance().getTodos());
    }

    @FXML
    private void showEditView(ActionEvent event) throws IOException {

        var isSelected = mTodos.getSelectionModel().getSelectedItem();
        UpsertView.getInstance().setTodos(mTodos);

        Stage stage = ViewHelper.getStage(event);

        if(isSelected != null) {
            UpsertView.getInstance().setCurrentTodo(isSelected);
            ViewHelper.showWindow(new Stage(), ViewMetaData.UPSERTVIEW, stage);
        }
        else {
            AppController.getInstance().handleException(new NothingSelectedException("There is no selected todo."));
        }
    }

    @FXML
    private void showAddView(ActionEvent event) throws IOException {
        UpsertView.getInstance().setTodos(mTodos);
        Stage stage = ViewHelper.getStage(event);

        ViewHelper.showWindow(new Stage(), ViewMetaData.UPSERTVIEW, stage);
    }

    @FXML
    private void deleteTodo(ActionEvent actionEvent) throws SQLException {
        Todo todo = mTodos.getSelectionModel().getSelectedItem();

        if(todo == null) {
            AppController.getInstance().handleException(new NothingSelectedException("There is no selected todo."));
        }

        AppController.getInstance().deleteTodo(todo);
        Repository.getInstance().getTodos().remove(todo);
    }
}