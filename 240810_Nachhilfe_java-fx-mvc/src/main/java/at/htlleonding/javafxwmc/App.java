package at.htlleonding.javafxwmc;

import at.htlleonding.javafxwmc.controller.AppController;
import at.htlleonding.javafxwmc.domain.repos.AppRepository;
import at.htlleonding.javafxwmc.view.AppView;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AppRepository.getInstance();
        AppView.getInstance().initialize(stage);
        AppController.getInstance();
    }
}