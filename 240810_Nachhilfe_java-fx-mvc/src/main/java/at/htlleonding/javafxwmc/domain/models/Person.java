package at.htlleonding.javafxwmc.domain.models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {
    private final SimpleStringProperty firstName = new SimpleStringProperty();
    private final SimpleStringProperty lastName = new SimpleStringProperty();
    private final SimpleIntegerProperty age = new SimpleIntegerProperty();
    private final SimpleStringProperty nickname = new SimpleStringProperty();

    public Person(String firstName, String lastName, int age, String nickname) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.age.set(age);
        this.nickname.set(nickname);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public int getAge() {
        return age.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public String getNickname() {
        return nickname.get();
    }

    public SimpleStringProperty nicknameProperty() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname.set(nickname);
    }

    @Override
    public String toString() {
        return "firstName='%s', lastName='%s', age=%d, nickname='%s'"
            .formatted(firstName.get(), lastName.get(), age.get(), nickname.get());
    }
}
