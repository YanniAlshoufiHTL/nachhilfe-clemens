package herbstpruefung.uebung.characterlistnew.model;

import herbstpruefung.uebung.characterlistnew.view.ViewHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class AppModel {

    private static AppModel mAppModel;
    private final ObservableList<Character> mCharacterList = FXCollections.observableList(new ArrayList<Character>());

    private final static String mConnectionToNewDb = "jdbc:h2:./db/database;INIT=RUNSCRIPT FROM './db/createdb.sql'";
    private final static String mConnectionToDb = "jdbc:h2:./db/database";
    private Connection mConnection;

    private AppModel() {
        mCharacterList.add(new Character("asdf", "jklö", 10));
    }

    public static AppModel getInstance() {
        if (mAppModel == null) {
            mAppModel = new AppModel();
        }

        return mAppModel;
    }

    public ObservableList<Character> getObservableList() {
        return mCharacterList;
    }

    public void initialize() {
        try {
            mConnection = DriverManager.getConnection(
                    Files.exists(Path.of("./db/database.mv.db"))
                            ? mConnectionToDb
                            : mConnectionToNewDb
            );
            setCharactersFromDatabase();
        } catch (SQLException e) {
            ViewHelper.showException(e);
        }
    }

    private void setCharactersFromDatabase() {
        throw new RuntimeException("not implemented yet");
    }
}