package fr.univtln.m2dapm.boardgame.javaclient.mainmenu;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

public class JoinGameController {

    JoinGameView view;
    JoinGameModel model;


    public JoinGameController(JoinGameView view, Player currentPlayer) {
        this.view = view;
        this.model = new JoinGameModel(currentPlayer);
        model.addObserver(view);
    }


    public void joinGame(String name, String password) {
        //TODO: validate parameters
        model.joinGame(name, password);
    }


    public void goBack() {
        model.goBack();
    }
}
