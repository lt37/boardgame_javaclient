package fr.univtln.m2dapm.boardgame.javaclient.login;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import static fr.univtln.m2dapm.boardgame.javaclient.AppConstants.webResource;

public class LoginModel extends Observable {


    public void logIn(String userName, String password) {
        Player player = webResource.path("players/login/" + userName).type(MediaType.APPLICATION_JSON).get(Player.class);

        List args = new ArrayList();
        if (player.getEncryptedPassword().equals(password)) {
            args.add("password ok");
            args.add(player);
        }

        else {
            args.add("password not ok");
        }

        setChanged();
        notifyObservers(args);
    }
}
