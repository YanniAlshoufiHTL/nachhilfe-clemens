package nachhilfe.yanni.todolist.View;

import javafx.stage.Stage;
import nachhilfe.yanni.todolist.Controller.AppController;

import java.io.IOException;

public class AppView {
    private static AppView mAppView = null;

    private AppView() {}

    public static AppView getInstance() {
        if(mAppView == null) {
            mAppView = new AppView();
        }

        return mAppView;
    }

    public void initialize(Stage stage) throws IOException {
        ViewHelper.showWindow(stage, ViewMetaData.MAINVIEW, null);
    }
}
