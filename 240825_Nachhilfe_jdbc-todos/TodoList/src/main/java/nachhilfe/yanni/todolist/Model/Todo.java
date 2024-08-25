package nachhilfe.yanni.todolist.Model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDateTime;

public class Todo {
    private final int mId;
    private final SimpleStringProperty mShortDescription = new SimpleStringProperty();
    private final SimpleStringProperty mLongDescription = new SimpleStringProperty();
    private final SimpleBooleanProperty mIsDone = new SimpleBooleanProperty();
    private final SimpleObjectProperty<LocalDateTime> mDateCreated = new SimpleObjectProperty<>();

    public Todo(int id, String shortDescription, String longDescription, LocalDateTime dateCreated, boolean isDone) {
        mId = id;
        mShortDescription.set(shortDescription);
        mLongDescription.set(longDescription);
        mDateCreated.set(dateCreated);
        mIsDone.set(isDone);
    }

    public int getId() {
        return mId;
    }

    public String getShortDescription() {
        return mShortDescription.get();
    }

    public SimpleStringProperty shortDescriptionProperty() {
        return mShortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.mShortDescription.set(shortDescription);
    }

    public String getLongDescription() {
        return mLongDescription.get();
    }

    public SimpleStringProperty longDescriptionProperty() {
        return mLongDescription;
    }

    public void setLongDescription(String longDescription) {
        this.mLongDescription.set(longDescription);
    }

    public boolean isDone() {
        return mIsDone.get();
    }

    public SimpleBooleanProperty isDoneProperty() {
        return mIsDone;
    }

    public void setIsDone(boolean isDone) {
        this.mIsDone.set(isDone);
    }

    public LocalDateTime getDateCreated() {
        return mDateCreated.get();
    }

    public SimpleObjectProperty<LocalDateTime> dateCreatedProperty() {
        return mDateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.mDateCreated.set(dateCreated);
    }
}
