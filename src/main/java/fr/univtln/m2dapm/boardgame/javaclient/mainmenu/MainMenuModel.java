package fr.univtln.m2dapm.boardgame.javaclient.mainmenu;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class MainMenuModel extends Observable {

    private Player currentPlayer;

    public MainMenuModel(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public void createGame() {
        List args = new ArrayList();
        args.add("create");
        args.add(currentPlayer);
        setChanged();
        notifyObservers(args);
    }


    public void joinGame() {
        List args = new ArrayList();
        args.add("join");
        args.add(currentPlayer);
        setChanged();
        notifyObservers(args);
    }
}
