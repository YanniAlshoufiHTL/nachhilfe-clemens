package at.htlleonding.javafxwmc.view;

import at.htlleonding.javafxwmc.controller.AppController;
import at.htlleonding.javafxwmc.domain.models.Person;
import at.htlleonding.javafxwmc.domain.repos.AppRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AppViewCtrl {
    @FXML
    private ListView<Person> peopleListView;

    public void initialize() {
        peopleListView.setItems(AppRepository.getInstance().getPeople());
    }

    public void addPerson() {
        AppController.getInstance().addPerson();
    }
}