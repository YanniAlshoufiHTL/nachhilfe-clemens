package herbstpruefung.uebung.characterlistnew.controller;

import herbstpruefung.uebung.characterlistnew.model.AppModel;
import herbstpruefung.uebung.characterlistnew.model.Character;
import herbstpruefung.uebung.characterlistnew.view.ViewHelper;


public class AppController {

    private static AppController mAppController;

    private AppController() {
    }

    public static AppController getInstance() {
        if (mAppController == null) {
            mAppController = new AppController();
        }

        return mAppController;
    }

    public void addCharacter(String firstName, String lastName, String age) {

        int intAge;

        try {
            intAge = Integer.parseInt(age);

        } catch (NumberFormatException e) {
            throwException(e);
            return;
        }

        AppModel.getInstance().getObservableList().add(new Character(firstName, lastName, intAge));

    }

    public void updateCharacter(Character character, String firstName, String lastName, String age) {

        int intAge;

        try {
            intAge = Integer.parseInt(age);

        } catch (NumberFormatException e) {
            throwException(e);
            return;
        }

        character.setFirstName(firstName);
        character.setLastName(lastName);
        character.setAge(intAge);
    }

    public <E extends Exception> void throwException(E e) {
        ViewHelper.showException(e);
    }
}
