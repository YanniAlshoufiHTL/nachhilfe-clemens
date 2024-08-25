package nachhilfe.yanni.todolist.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nachhilfe.yanni.todolist.App;

import java.io.IOException;

public class ViewHelper {

    public static void showWindow(Stage stage, ViewMetaData metaData, Stage parentStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(metaData.getFileName()));
        Scene scene = new Scene(fxmlLoader.load(), metaData.getWidth(), metaData.getHeight());

        if(parentStage != null) {
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(parentStage);
        }

        stage.setTitle(metaData.getTitle());
        stage.setScene(scene);
        stage.show();
    }

    public static Stage getStage(ActionEvent event) {
        Node source = (Node) event.getSource();
        return (Stage) source.getScene().getWindow();
    }
}
