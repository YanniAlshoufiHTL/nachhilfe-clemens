package at.htlleonding.javafxwmc.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHelpers {
    public static void showView(Stage stage, ViewMetaData viewMetaData, Stage mainStage) throws IOException {
        if (stage == null || viewMetaData == null) {
            throw new IllegalArgumentException("Please provide a valid stage and valid view meta data.");
        }

        FXMLLoader fxmlLoader = new FXMLLoader(AppView.class.getResource(viewMetaData.getNameOfFile()));
        Scene scene = new Scene(fxmlLoader.load(), viewMetaData.getWidth(), viewMetaData.getHeight());
        if (mainStage != null) {
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(mainStage);
        }
        stage.setTitle(viewMetaData.getTitle());
        stage.setScene(scene);
        stage.show();
    }
}
