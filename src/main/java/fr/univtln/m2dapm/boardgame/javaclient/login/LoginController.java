package fr.univtln.m2dapm.boardgame.javaclient.login;

public class LoginController {

    LogInView view;
    LoginModel model;

    public LoginController(LogInView view) {
        this.view = view;
        model = new LoginModel();
        model.addObserver(view);
    }


    public void logIn(String userName, String password) {
        //TODO: validate parameters
        model.logIn(userName, password);
    }
}
