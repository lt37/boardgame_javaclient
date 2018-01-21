package fr.univtln.m2dapm.boardgame.javaclient.game;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Game;

public class GameController {

    private GameView view;
    private GameModel model;

    public GameController(GameView view, Game game) {
        this.view = view;
        this.model = new GameModel(game);
        model.addObserver(view);
    }
}
