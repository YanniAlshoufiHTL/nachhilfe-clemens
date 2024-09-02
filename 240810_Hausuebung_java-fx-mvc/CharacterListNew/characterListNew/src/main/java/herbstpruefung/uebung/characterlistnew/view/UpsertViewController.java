package herbstpruefung.uebung.characterlistnew.view;

import herbstpruefung.uebung.characterlistnew.controller.AppController;
import herbstpruefung.uebung.characterlistnew.model.AppModel;
import herbstpruefung.uebung.characterlistnew.model.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpsertViewController {



    @FXML
    private TextField mFirstName;
    @FXML
    private TextField mLastName;
    @FXML
    private TextField mAge;

    public void initialize() {
        Character character = UpsertViewDetails.getInstance().getSelectedCharacter();

        if(character != null) {
            mFirstName.setText(character.getFirstName());
            mLastName.setText(character.getLastName());
            mAge.setText(String.valueOf(character.getAge()));
        }
    }

    public void submit(ActionEvent actionEvent) {

        Character character = UpsertViewDetails.getInstance().getSelectedCharacter();

        if(character != null) {
            AppController.getInstance().updateCharacter(character, mFirstName.getText(), mLastName.getText(), mAge.getText());
            UpsertViewDetails.getInstance().setCharacter(null);
        }
        else {
            AppController.getInstance().addCharacter(mFirstName.getText(), mLastName.getText(), mAge.getText());
        }

        if(UpsertViewDetails.getInstance().getCharacterListView() != null) {
            //WIESO??
            UpsertViewDetails.getInstance().getCharacterListView().refresh();
        }

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
