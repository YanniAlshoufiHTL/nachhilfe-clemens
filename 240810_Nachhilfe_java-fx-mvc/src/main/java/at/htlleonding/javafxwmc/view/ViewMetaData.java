package at.htlleonding.javafxwmc.view;

public enum ViewMetaData {
    MAIN("Main View", 500, 340, "app-view.fxml"),
    EDIT("Edit View", 200, 150, "edit-view.fxml"),
    ;
    private final String title;
    private final int width;
    private final int height;
    private final String nameOfFile;

    ViewMetaData(String title, int width, int height, String nameOfFile) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.nameOfFile = nameOfFile;
    }

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getNameOfFile() {
        return nameOfFile;
    }
}
