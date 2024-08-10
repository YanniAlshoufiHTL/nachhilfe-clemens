package at.htlleonding.javafxwmc.controller;

import at.htlleonding.javafxwmc.domain.repos.AppRepository;

public class AppController {
    // region Singleton
    private static AppController instance = null;

    public static AppController getInstance() {
        if (instance == null) {
            instance = new AppController();
        }

        return instance;
    }

    private AppController() {}
    // endregion

    public void addPerson() {
        AppRepository.getInstance().addPerson("Katherina", "Minihuber", 17, "Kate");
    }
}
