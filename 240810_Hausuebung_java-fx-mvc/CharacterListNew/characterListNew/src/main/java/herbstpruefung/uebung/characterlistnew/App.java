package herbstpruefung.uebung.characterlistnew;

import herbstpruefung.uebung.characterlistnew.controller.AppController;
import herbstpruefung.uebung.characterlistnew.model.AppModel;
import herbstpruefung.uebung.characterlistnew.view.AppView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AppModel.getInstance().initialize();
        AppController.getInstance();
        AppView.getInstance().initialize(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}