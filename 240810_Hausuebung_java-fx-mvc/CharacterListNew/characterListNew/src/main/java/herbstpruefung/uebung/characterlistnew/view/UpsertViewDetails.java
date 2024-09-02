package herbstpruefung.uebung.characterlistnew.view;

import herbstpruefung.uebung.characterlistnew.model.Character;
import javafx.scene.control.ListView;

public class UpsertViewDetails {

    private static UpsertViewDetails mUpsertViewDetails;
    private Character mSelectedCharacter;
    private ListView<Character> mCharacterListView;

    private UpsertViewDetails() {
    }

    public static UpsertViewDetails getInstance() {
        if (mUpsertViewDetails == null) {
            mUpsertViewDetails = new UpsertViewDetails();
        }

        return mUpsertViewDetails;
    }

    public void setCharacter(Character character) {
        this.mSelectedCharacter = character;
    }

    public Character getSelectedCharacter() {
        return mSelectedCharacter;
    }

    public ListView<Character> getCharacterListView() {
        return mCharacterListView;
    }

    public void setCharacterListView(ListView<Character> mCharacterListView) {
        this.mCharacterListView = mCharacterListView;
    }
}
