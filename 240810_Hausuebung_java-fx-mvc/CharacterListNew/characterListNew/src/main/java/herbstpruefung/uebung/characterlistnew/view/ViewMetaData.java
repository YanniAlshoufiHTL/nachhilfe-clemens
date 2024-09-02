package herbstpruefung.uebung.characterlistnew.view;

public enum ViewMetaData {

    LISTVIEW(400, 350, "list-view.fxml", "Character list"),
    UPSERTVIEW(320, 240, "upsert-view.fxml", "Add/Edit"),

    ;

    private final int mWidth;
    private final int mHeight;
    private final String mNameOfFile;
    private final String mTitle;


    ViewMetaData(int width, int height, String nameOfFile, String title) {
        this.mWidth = width;
        this.mHeight = height;
        this.mTitle = title;
        this.mNameOfFile = nameOfFile;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    public String getNameOfFile() {
        return mNameOfFile;
    }

    public String getTitle() {
        return mTitle;
    }
}
