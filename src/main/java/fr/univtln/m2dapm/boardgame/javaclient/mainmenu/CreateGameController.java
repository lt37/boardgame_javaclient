package fr.univtln.m2dapm.boardgame.javaclient.mainmenu;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

public class CreateGameController {

    private CreateGameView view;
    private CreateGameModel model;

    public CreateGameController(CreateGameView view, Player currentPlayer) {
        this.view = view;
        this.model = new CreateGameModel(currentPlayer);
        this.model.addObserver(this.view);
    }


    public void createGame(String name, String password, boolean isPrivate) {
        //TODO: validate parameters
        model.createGame(name, password, isPrivate);
    }


    public void goBack() {
        model.goBack();
    }
}
