package nachhilfe.yanni.todolist.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class Repository {

    private static Repository mAppRepository = null;
    private final static String getConnectionToNewDb = "jdbc:h2:./db/database;INIT=RUNSCRIPT FROM './db/createdb.sql'";
    private final static String getConnectionToDb = "jdbc:h2:./db/database";
    private Connection mConnection;
    private final ObservableList<Todo> mList = FXCollections.observableArrayList();

    private Repository() {
    }

    public static Repository getInstance() {
        if(mAppRepository == null) {
            mAppRepository = new Repository();
        }

        return mAppRepository;
    }

    public void initialize() throws SQLException {
        mConnection = DriverManager.getConnection(Files.exists(Path.of("./db/database.mv.db")) ? getConnectionToDb : getConnectionToNewDb);
        setTodosFromDatabase();
    }

    public void shutdown() throws SQLException {
        mConnection.close();
    }

    public ObservableList<Todo> getTodos() {
        return mList;
    }

    private void setTodosFromDatabase() throws SQLException {
        try(PreparedStatement preparedStatement = mConnection.prepareStatement("SELECT * FROM Todo")) {
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()) {
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

    public void addToTodos(boolean isDone, String shortDescription, String longDescription, LocalDateTime dateTimeOfCreation) throws SQLException {
        try(PreparedStatement preparedStatement = mConnection.prepareStatement(
                """
                        INSERT INTO Todo(shortdescription, longdescription, isdone, datecreated)
                        VALUES (?,?,?,?)
                    """, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, shortDescription);
            preparedStatement.setString(2, longDescription);
            preparedStatement.setBoolean(3, isDone);
            preparedStatement.setTimestamp(4, Timestamp.valueOf(dateTimeOfCreation));

            preparedStatement.executeUpdate();

            try(ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if(resultSet.next()) {
                    int id = resultSet.getInt("id");
                    mList.add(new Todo(id, shortDescription, longDescription, dateTimeOfCreation, isDone));
                }
                else {
                    throw new SQLException("id was not found");
                }
            }
        }
    }

    public void updateTodo(int id, boolean isDone, String shortDescription, String longDescription) throws SQLException {

        Optional<Todo> optionalTodo = mList.stream().filter(x -> x.getId() == id).findFirst();

        if(optionalTodo.isEmpty()) {
            return;
        }

        try(PreparedStatement preparedStatement = mConnection.prepareStatement("""
                UPDATE Todo
                SET isdone=?, shortdescription=?, longdescription=?
                WHERE id=?
                """)) {

            preparedStatement.setBoolean(1, isDone);
            preparedStatement.setString(2, shortDescription);
            preparedStatement.setString(3, longDescription);
            preparedStatement.setInt(4, id);


            preparedStatement.executeUpdate();
        }

        Todo todo = optionalTodo.get();

        todo.setShortDescription(shortDescription);
        todo.setLongDescription(longDescription);
        todo.setIsDone(isDone);

    }

    public void deleteTodo(int id) throws SQLException {

        Optional<Todo> optionalTodo = mList.stream().filter(x -> x.getId() == id).findFirst();

        if(optionalTodo.isEmpty()) {
            return;
        }

        try(PreparedStatement preparedStatement = mConnection.prepareStatement("DELETE FROM Todo WHERE id=?")) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        }

        Todo todo = optionalTodo.get();

        mList.remove(todo);

    }

//    private <T> List<T> runQuery(String query, Function<ResultSet, T> callback) throws SQLException {
//        try(PreparedStatement preparedStatement = mConnection.prepareStatement(query)) {
//            try(ResultSet resultSet = preparedStatement.executeQuery()) {
//                while (resultSet.next()) {
//
//                }
//            }
//        }
}
