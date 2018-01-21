package fr.univtln.m2dapm.boardgame.javaclient.game;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Game;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;
import fr.univtln.m2dapm.boardgame.javaclient.websocket.WebsocketClientEndpoint;

import java.util.Observable;

public class GameModel extends Observable {

    private Game game;
    private Player player1, player2;

    public GameModel(Game game) {
        this.game = game;
        new WebsocketClientEndpoint().connect();
    }
}
