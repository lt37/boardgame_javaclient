package fr.univtln.m2dapm.boardgame.javaclient.login;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;

import java.util.Observable;

public class LoginModel extends Observable {


    public void logIn(String userName, String password) {
        Player player = new Player();
        player.setLoginName(userName);
        setChanged();
        notifyObservers(player);
    }
}
