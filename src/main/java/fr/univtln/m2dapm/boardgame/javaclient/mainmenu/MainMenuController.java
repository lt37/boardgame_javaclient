package fr.univtln.m2dapm.boardgame.javaclient.mainmenu;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

public class MainMenuController {

    MainMenuView view;
    MainMenuModel model;

    public MainMenuController(MainMenuView view, Player currentPlayer) {
        this.view = view;
        this.model = new MainMenuModel(currentPlayer);
        model.addObserver(view);
    }


    public void createGame() {
        model.createGame();
    }

    public void joinGame() {
        model.joinGame();
    }
}
