package herbstpruefung.uebung.characterlistnew.view;

import javafx.stage.Stage;

import java.io.IOException;

public class AppView {

    private static AppView mAppView;

    private AppView() {
    }

    public static AppView getInstance() {
        if (mAppView == null) {
            mAppView = new AppView();
        }

        return mAppView;
    }

    public void initialize(Stage stage) throws IOException {
        ViewHelper.showStage(stage, ViewMetaData.LISTVIEW, null);
    }
}
