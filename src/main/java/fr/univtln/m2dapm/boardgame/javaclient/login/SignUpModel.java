package fr.univtln.m2dapm.boardgame.javaclient.login;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

import javax.ws.rs.core.MediaType;
import java.util.Observable;

import static fr.univtln.m2dapm.boardgame.javaclient.AppConstants.webResource;

public class SignUpModel extends Observable {

    public SignUpModel(){}


    public void signUp(String userName, String password) {
        //TODO: encrypt password
        //TODO: existing player
        Player player = new Player();
        player.setLoginName(userName);
        player.setEncryptedPassword(password);

        webResource.path("players").type(MediaType.APPLICATION_JSON).post(player);
    }
}
