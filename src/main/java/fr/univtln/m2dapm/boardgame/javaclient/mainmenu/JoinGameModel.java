package fr.univtln.m2dapm.boardgame.javaclient.mainmenu;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Game;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class JoinGameModel extends Observable {

    Player currentPlayer;

    public JoinGameModel(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public void joinGame(String name, String password) {
        //TODO: fetch game from database
        Game game = new Game();
        List args = new ArrayList();
        args.add("join");
        args.add(game);
    }


    public void goBack() {
        List args = new ArrayList();
        args.add("back");
        args.add(currentPlayer);

        setChanged();
        notifyObservers(args);
    }
}
