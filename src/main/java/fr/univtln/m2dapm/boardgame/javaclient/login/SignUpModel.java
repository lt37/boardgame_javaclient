package fr.univtln.m2dapm.boardgame.javaclient.login;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

import java.util.Observable;

public class SignUpModel extends Observable {

    public SignUpModel(){}


    public void signUp(String userName, String password) {
        //TODO: encrypt password
        Player player = new Player();
        player.setLoginName(userName);
        player.setEncryptedPassword(password);

        //TODO: send player into database
    }
}
