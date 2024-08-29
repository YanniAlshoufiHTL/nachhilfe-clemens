package nachhilfe.yanni.todolist.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import nachhilfe.yanni.todolist.Model.exceptions.CouldNotAddToDatabaseException;
import nachhilfe.yanni.todolist.Model.exceptions.CouldNotDeleteFromDatabaseException;
import nachhilfe.yanni.todolist.Model.exceptions.CouldNotUpdateInDatabaseException;
import nachhilfe.yanni.todolist.Model.exceptions.CouldShutdownDatabaseException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;

public class Repository {

    private static Repository mAppRepository = null;
    private final static String getConnectionToNewDb = "jdbc:h2:./db/database;INIT=RUNSCRIPT FROM './db/createdb.sql'";
    private final static String getConnectionToDb = "jdbc:h2:./db/database";
    private Connection mConnection;
    private final ObservableList<Todo> mList = FXCollections.observableArrayList();

    private Repository() {
    }

    public static Repository getInstance() {
        if (mAppRepository == null) {
            mAppRepository = new Repository();
        }

        return mAppRepository;
    }

    public void initialize() {
        try {
            mConnection = DriverManager.getConnection(Files.exists(Path.of("./db/database.mv.db")) ? getConnectionToDb : getConnectionToNewDb);
            setTodosFromDatabase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void shutdown() throws Exception {
        try {
            mConnection.close();
        } catch (SQLException e) {
            throw new CouldShutdownDatabaseException("Database could not be shutdown.");
        }
    }

    public ObservableList<Todo> getTodos() {
        return mList;
    }

    private void setTodosFromDatabase() throws SQLException {
        try (PreparedStatement preparedStatement = mConnection.prepareStatement("SELECT * FROM Todo")) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    mList.add(new Todo(
                            resultSet.getInt("id"),
                            resultSet.getString("shortdescription"),
                            resultSet.getString("longdescription"),
                            resultSet.getTimestamp("datecreated").toLocalDateTime(),
                            resultSet.getBoolean("isdone"))
                    );
                }
            }
        }
    }

    public void addToTodos(boolean isDone, String shortDescription, String longDescription, LocalDateTime dateOfCreation) throws CouldNotAddToDatabaseException {
        try (PreparedStatement preparedStatement = mConnection.prepareStatement(
                """
                            INSERT INTO Todo(shortdescription, longdescription, isdone, datecreated)
                            VALUES (?,?,?,?)
                        """, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, shortDescription);
            preparedStatement.setString(2, longDescription);
            preparedStatement.setBoolean(3, isDone);
            preparedStatement.setTimestamp(4, Timestamp.valueOf(dateOfCreation));

            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    mList.add(new Todo(
                            id,
                            shortDescription,
                            longDescription,
                            dateOfCreation,
                            isDone
                    ));
                }
            }

        } catch (SQLException e) {
            throw new CouldNotAddToDatabaseException("Todo could not be added to database.");
        }
    }

    public void updateTodo(Todo todo) throws CouldNotUpdateInDatabaseException {

        if (todo == null) {
            return;
        }

        try (PreparedStatement preparedStatement = mConnection.prepareStatement("""
                UPDATE Todo
                SET isdone=?, shortdescription=?, longdescription=?
                WHERE id=?
                """)) {

            preparedStatement.setBoolean(1, todo.isDone());
            preparedStatement.setString(2, todo.getShortDescription());
            preparedStatement.setString(3, todo.getLongDescription());
            preparedStatement.setInt(4, todo.getId());


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new CouldNotUpdateInDatabaseException("Todo could not be updated in database.");
        }
    }

    public void deleteTodo(Todo todo) throws CouldNotDeleteFromDatabaseException {

        if (todo == null) {
            return;
        }

        try (PreparedStatement preparedStatement = mConnection.prepareStatement("DELETE FROM Todo WHERE id=?")) {
            preparedStatement.setInt(1, todo.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new CouldNotDeleteFromDatabaseException("Todo could not be added to database.");
        }

        mList.remove(todo);
    }

    private <E extends Exception> void runUpdateQuery(String query, ThrowingSupplier<PreparedStatement, E> callback) throws E, SQLException {
        try (PreparedStatement preparedStatement = mConnection.prepareStatement(query)) {
            callback.supply(preparedStatement);
        }
    }

//    private <E extends Exception> void updateOrDelete(String query, ThrowingSupplier<ResultSet, E> callback) throws SQLException {
//        try (PreparedStatement preparedStatement = mConnection.prepareStatement(query)) {
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {

//                }
//            }
//        }
//    }
}
