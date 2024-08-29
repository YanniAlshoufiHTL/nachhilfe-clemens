package nachhilfe.yanni.todolist.View;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.LocalDateTimeStringConverter;
import nachhilfe.yanni.todolist.Controller.AppController;
import nachhilfe.yanni.todolist.Model.Todo;

import javax.swing.text.View;
import javax.xml.transform.Source;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.function.BiConsumer;

public class UpsertController {


    @FXML
    private CheckBox mIsDone;
    @FXML
    private TextField mShortDescription;
    @FXML
    private TextField mLongDescription;
    @FXML
    private TextField mUpsertedLast;


    @FXML
    private void onSubmitBtnClick(ActionEvent event) throws SQLException {

        Todo currentTodo = UpsertView.getInstance().getCurrentTodo();

        if(currentTodo == null) {
            AppController.getInstance().addTodo(mShortDescription.getText(), mLongDescription.getText());
        } else {
            AppController.getInstance().updateTodo(currentTodo);
        }

        UpsertView.getInstance().setCurrentTodo(null);
        UpsertView.getInstance().getTodos().refresh();

        Stage stage = ViewHelper.getStage(event);
        stage.close();
    }

    public void initialize() {
        Todo currentTodo = UpsertView.getInstance().getCurrentTodo();

        if(currentTodo != null) {
            mIsDone.selectedProperty().bindBidirectional(currentTodo.isDoneProperty());
            mShortDescription.textProperty().bindBidirectional(currentTodo.shortDescriptionProperty());
            mLongDescription.textProperty().bindBidirectional(currentTodo.longDescriptionProperty());
            mUpsertedLast.textProperty().bindBidirectional(currentTodo.dateCreatedProperty(), new LocalDateTimeStringConverter());
        }
        else {
            mIsDone.setVisible(false);
            mUpsertedLast.setVisible(false);
        }
    }
}
