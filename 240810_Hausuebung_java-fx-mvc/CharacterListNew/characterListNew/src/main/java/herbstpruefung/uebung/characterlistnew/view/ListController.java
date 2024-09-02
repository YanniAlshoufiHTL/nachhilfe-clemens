package herbstpruefung.uebung.characterlistnew.view;

import herbstpruefung.uebung.characterlistnew.controller.AppController;
import herbstpruefung.uebung.characterlistnew.model.AppModel;
import herbstpruefung.uebung.characterlistnew.model.Character;
import herbstpruefung.uebung.characterlistnew.view.exceptions.NothingIsSelectedException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class ListController {

    @FXML
    private ListView<Character> mListView;

    @FXML
    private void openAddView(ActionEvent actionEvent) throws IOException {
        ViewHelper.showStage(new Stage(), ViewMetaData.UPSERTVIEW, ViewHelper.getStage(actionEvent));
    }

    @FXML
    private void openEditView(ActionEvent actionEvent) throws IOException {
        Character character = mListView.getSelectionModel().getSelectedItem();

        if (character == null) {
            AppController.getInstance().throwException(new NothingIsSelectedException("Nothing is selected."));
        }

        UpsertViewDetails.getInstance().setCharacter(character);
        UpsertViewDetails.getInstance().setCharacterListView(mListView);


        ViewHelper.showStage(new Stage(), ViewMetaData.UPSERTVIEW, ViewHelper.getStage(actionEvent));

    }

    @FXML
    private void deleteCharacter(ActionEvent actionEvent) {
        Character character = mListView.getSelectionModel().getSelectedItem();

        if (character == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("No character selected");
            alert.showAndWait();
        }

        AppModel.getInstance().getObservableList().remove(character);
    }

    public void initialize() {
        mListView.setItems(AppModel.getInstance().getObservableList());
    }

}