package fr.univtln.m2dapm.boardgame.javaclient.mainmenu;

import fr.univtln.m2dapm.boardgame.business.board.Board;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Game;
import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import static fr.univtln.m2dapm.boardgame.javaclient.AppConstants.webResource;

public class CreateGameModel extends Observable {

    private String texte;
    private Player currentPlayer;

    public CreateGameModel(Player currentPlayer){
        this.currentPlayer = currentPlayer;
    }


    public void createGame(String name, String password, boolean isPrivate) {
        List players = new ArrayList();
        players.add(currentPlayer);

        Game game = new Game.Builder().setName(name).setPassword(password).setaPrivate(isPrivate).setBoard(new Board())
                .setMaxPlayers(2).setMaxArmyClassValue(8).setPlayers(players).build();
        
        webResource.path("games").type(MediaType.APPLICATION_JSON).post(game);

        List args = new ArrayList();
        args.add("create");
        args.add(game);
        setChanged();
        notifyObservers(args);
    }


    public void goBack() {
        List args = new ArrayList();
        args.add("back");
        args.add(currentPlayer);
        setChanged();
        notifyObservers(args);
    }
}
