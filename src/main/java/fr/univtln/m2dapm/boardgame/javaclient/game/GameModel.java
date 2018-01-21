package fr.univtln.m2dapm.boardgame.javaclient.game;

import fr.univtln.m2dapm.boardgame.business.board.Board;
import fr.univtln.m2dapm.boardgame.business.bridgedices.Bridge;
import fr.univtln.m2dapm.boardgame.business.dices.Dice;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Game;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

import java.util.List;
import java.util.Observable;

public class GameModel extends Observable {

    private Game game;
    private Player player1, player2;

    public GameModel(Game game) {
        this.game = game;
        System.out.println(game.getPlayers().get(0).getLoginName());
    }
}
