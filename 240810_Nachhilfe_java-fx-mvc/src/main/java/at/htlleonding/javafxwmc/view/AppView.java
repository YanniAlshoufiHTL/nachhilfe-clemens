package at.htlleonding.javafxwmc.view;

import javafx.stage.Stage;

import java.io.IOException;

public class AppView {
    // region Singleton
    private static AppView instance = null;

    public static AppView getInstance() {
        if (instance == null) {
            instance = new AppView();
        }

        return instance;
    }

    private AppView() {}
    // endregion

    private Stage mainStage = null;

    public void initialize(Stage stage) throws IOException {
        this.mainStage = stage;
        ViewHelpers.showView(stage, ViewMetaData.MAIN, null);
    }
}
