package nachhilfe.yanni.todolist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nachhilfe.yanni.todolist.Controller.AppController;
import nachhilfe.yanni.todolist.Model.Repository;
import nachhilfe.yanni.todolist.View.AppView;

import java.io.IOException;
import java.sql.SQLException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        Repository.getInstance().initialize();
        AppController.getInstance();
        AppView.getInstance().initialize(stage);
    }

    @Override
    public void stop() throws Exception {
        Repository.getInstance().shutdown();
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}