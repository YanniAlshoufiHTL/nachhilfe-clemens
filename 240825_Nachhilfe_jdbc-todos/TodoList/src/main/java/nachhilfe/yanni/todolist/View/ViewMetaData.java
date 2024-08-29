package nachhilfe.yanni.todolist.View;

public enum ViewMetaData {
    MAINVIEW("Todos", 500, 500, "todos-view.fxml"),
    UPSERTVIEW("Add/Edit", 400, 400, "upsert-view.fxml")
    ;

    private final String mTitle;
    private final int mWidth;
    private final int mHeight;
    private final String mFileName;

    ViewMetaData(String title, int width, int height, String filename) {
        mTitle = title;
        mWidth = width;
        mHeight = height;
        mFileName = filename;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    public String getFileName() {
        return mFileName;
    }
}
