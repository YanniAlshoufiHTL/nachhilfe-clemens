module at.htlleonding.javafxwmc {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.htlleonding.javafxwmc to javafx.fxml;
    exports at.htlleonding.javafxwmc;
    exports at.htlleonding.javafxwmc.view;
    opens at.htlleonding.javafxwmc.view to javafx.fxml;
}