package fr.univtln.m2dapm.boardgame.javaclient.game;

public class GameController {

    private GameView view;
    private GameModel model;

    public GameController(GameView view) {
        this.view = view;
        this.model = new GameModel();
        model.addObserver(view);
    }
}
