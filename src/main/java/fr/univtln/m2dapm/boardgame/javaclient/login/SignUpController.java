package fr.univtln.m2dapm.boardgame.javaclient.login;

public class SignUpController {

    SignUpView view;
    SignUpModel model;

    public SignUpController(SignUpView view) {
        this.view = view;
        this.model = new SignUpModel();
        model.addObserver(this.view);
    }
}
