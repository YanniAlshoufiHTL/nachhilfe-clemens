package herbstpruefung.uebung.characterlistnew.view;

import herbstpruefung.uebung.characterlistnew.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHelper {

    public static void showStage(Stage stage, ViewMetaData viewMetaData, Stage parentStage) throws IOException {

        if (stage == null || viewMetaData == null) {
            return;
        }

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(viewMetaData.getNameOfFile()));
        Scene scene = new Scene(fxmlLoader.load(), viewMetaData.getWidth(), viewMetaData.getHeight());

        if(parentStage != null) {
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(parentStage);
        }

        stage.setTitle(viewMetaData.getTitle());
        stage.setScene(scene);
        stage.show();
    }

    public static void showException(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }

    public static Stage getStage(ActionEvent actionEvent) {
        Node Node = (Node) actionEvent.getSource();
        return (Stage) Node.getScene().getWindow();
    }
}
