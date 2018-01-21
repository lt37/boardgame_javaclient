package fr.univtln.m2dapm.boardgame.javaclient.login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

import static fr.univtln.m2dapm.boardgame.javaclient.ViewConstants.*;

public class SignUpView implements Observer {

    private SignUpController controller;

    private Stage stage;
    private Scene scene;
    private VBox mainPane;

    private Text user;
    private TextField userField;
    private Text password;
    private TextField passwordField;
    private Text confirmPassword;
    private TextField confirmPasswordField;
    private Button okButton;
    private Button loginButton;

    private final String USER_NAME = "Pseudo :";
    private final String PASSWORD = "Mot de Passe :";
    private final String CONFIRM_PASSWORD = "Confirmer Mot de Passe :";
    private final String SCENE_TITLE = "Inscription";
    private final String LOG_IN = "Se Connecter";



    public SignUpView(Stage stage) {
        this.stage = stage;
        this.controller = new SignUpController(this);

        initializeElements();
        initializeMainPane();
        initializeScene();
        setListeners();

        stage.show();
    }


    private void initializeElements() {
        user = new Text(USER_NAME);
        password = new Text(PASSWORD);
        confirmPassword = new Text(CONFIRM_PASSWORD);

        userField = new TextField();
        passwordField = new PasswordField();
        confirmPasswordField = new TextField();

        okButton = new Button(OK_BUTTON);
        loginButton = new Button(LOG_IN);
    }


    private void initializeMainPane() {
        mainPane = new VBox();
        mainPane.setSpacing(SMALL_SPACING);
        mainPane.setAlignment(Pos.CENTER);

        HBox userBox = new HBox();
        HBox passwordBox = new HBox();
        HBox confirmPasswordBox = new HBox();
        HBox buttonBox = new HBox();

        userBox.setSpacing(SMALL_SPACING);
        passwordBox.setSpacing(SMALL_SPACING);
        confirmPasswordBox.setSpacing(SMALL_SPACING);
        buttonBox.setSpacing(SMALL_SPACING);

        userBox.setAlignment(Pos.CENTER);
        passwordBox.setAlignment(Pos.CENTER);
        confirmPasswordBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);

        userBox.getChildren().addAll(user, userField);
        passwordBox.getChildren().addAll(password, passwordField);
        confirmPasswordBox.getChildren().addAll(confirmPassword, confirmPasswordField);
        buttonBox.getChildren().addAll(okButton, loginButton);

        mainPane.getChildren().addAll(userBox, passwordBox, confirmPasswordBox, buttonBox);
    }


    private void initializeScene() {
        scene = new Scene(mainPane, LOGIN_WIDTH, LOGIN_HEIGHT);
        stage.setTitle(APP_TITLE + TITLE_SEPARATION + SCENE_TITLE);
        stage.setScene(scene);
    }


    private void setListeners() {
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new LogInView(stage);
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
