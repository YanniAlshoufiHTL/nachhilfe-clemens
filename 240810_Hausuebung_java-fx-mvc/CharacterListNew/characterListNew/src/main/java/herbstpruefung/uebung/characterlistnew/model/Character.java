package herbstpruefung.uebung.characterlistnew.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Character {

    private final SimpleStringProperty mFirstName = new SimpleStringProperty();
    private final SimpleStringProperty mLastName = new SimpleStringProperty();
    private final SimpleIntegerProperty mAge = new SimpleIntegerProperty();

    public Character(String mFirstName, String mLastName, int mAge) {
        this.mFirstName.set(mFirstName);
        this.mLastName.set(mLastName);
        this.mAge.set(mAge);
    }

    public String getFirstName() {
        return mFirstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName.set(mFirstName);
    }

    public int getAge() {
        return mAge.get();
    }

    public SimpleIntegerProperty ageProperty() {
        return mAge;
    }

    public void setAge(int mAge) {
        this.mAge.set(mAge);
    }

    public String getLastName() {
        return mLastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName.set(mLastName);
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " (" + getAge() + ")";
    }
}
