package fr.univtln.m2dapm.boardgame.javaclient.mainmenu;

public class CreateGameController {

    private CreateGameView view;
    private CreateGameModel model;

    public CreateGameController(CreateGameView view) {
        this.view = view;
        this.model = new CreateGameModel();
        this.model.addObserver(this.view);
    }


    public void createGame(String name, String password, boolean isPrivate) {
        //TODO: Check values
        model.createGame(name, password, isPrivate);
    }
}
