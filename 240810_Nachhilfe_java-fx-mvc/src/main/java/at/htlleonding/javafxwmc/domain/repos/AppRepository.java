package at.htlleonding.javafxwmc.domain.repos;

import at.htlleonding.javafxwmc.domain.models.Person;
import javafx.beans.property.ReadOnlyListWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.LinkedList;
import java.util.List;

public class AppRepository {
    // region Singleton
    private static AppRepository instance = null;

    public static AppRepository getInstance() {
        if (instance == null) {
            instance = new AppRepository();
        }

        return instance;
    }

    private AppRepository() {
        people.add(new Person("Yanni", "Alshoufi", 19, "Hi"));
        people.add(new Person("Clemens", "Gugerbauer", 19, "Gugi"));
        people.add(new Person("Matthias", "Gugerbauer", 99, "Random Person"));
    }
    // endregion

    private final ObservableList<Person> people = FXCollections.observableArrayList();

    public ObservableList<Person> getPeople() {
        return people;
    }

    public void addPerson(String firstName, String lastName, int age, String nickname) {
        people.add(new Person(firstName, lastName, age, nickname));
    }
}
