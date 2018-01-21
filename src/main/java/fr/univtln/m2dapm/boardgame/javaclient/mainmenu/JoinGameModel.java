package fr.univtln.m2dapm.boardgame.javaclient.mainmenu;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Game;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import static fr.univtln.m2dapm.boardgame.javaclient.AppConstants.webResource;

public class JoinGameModel extends Observable {

    Player currentPlayer;

    public JoinGameModel(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public void joinGame(String name, String password) {
        //TODO: check password
        Game game = webResource.path("games/name/" + name).type(MediaType.APPLICATION_JSON).get(Game.class);
        System.out.println(game.getName());
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
