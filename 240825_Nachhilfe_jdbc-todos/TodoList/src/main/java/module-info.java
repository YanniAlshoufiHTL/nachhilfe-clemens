module nachhilfe.yanni.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens nachhilfe.yanni.todolist to javafx.fxml;
    exports nachhilfe.yanni.todolist;
    exports nachhilfe.yanni.todolist.View;
    opens nachhilfe.yanni.todolist.View to javafx.fxml;
    opens nachhilfe.yanni.todolist.Model;
}