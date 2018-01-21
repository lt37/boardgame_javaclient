package fr.univtln.m2dapm.boardgame.javaclient.login;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;
import fr.univtln.m2dapm.boardgame.javaclient.ViewConstants;
import fr.univtln.m2dapm.boardgame.javaclient.mainmenu.MainMenuView;
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
import static fr.univtln.m2dapm.boardgame.javaclient.ViewConstants.SMALL_SPACING;

public class LogInView implements Observer {

    private LoginController controller;

    private Stage stage;
    private Scene scene;
    private VBox mainPane;

    private Text user;
    private TextField userField;
    private Text password;
    private TextField passwordField;
    private Button okButton;
    private Button signUpButton;

    private final String USER_NAME = "Pseudo :";
    private final String PASSWORD = "Mot de Passe :";
    private final String SCENE_TITLE = "Connexion";
    private final String SIGN_UP = "S'inscrire";



    public LogInView(Stage stage) {
        this.stage = stage;
        this.controller = new LoginController(this);

        initializeElements();
        initializeMainPane();
        initializeScene();
        setListeners();

        stage.show();
    }


    private void initializeElements() {
        user = new Text(USER_NAME);
        password = new Text(PASSWORD);

        userField = new TextField();
        passwordField = new PasswordField();

        okButton = new Button(ViewConstants.OK_BUTTON);
        signUpButton = new Button(SIGN_UP);
    }


    private void initializeMainPane() {
        mainPane = new VBox();
        mainPane.setSpacing(SMALL_SPACING);
        mainPane.setAlignment(Pos.CENTER);

        HBox userBox = new HBox();
        HBox passwordBox = new HBox();
        HBox buttonBox = new HBox();

        userBox.setSpacing(SMALL_SPACING);
        passwordBox.setSpacing(SMALL_SPACING);
        buttonBox.setSpacing(SMALL_SPACING);

        userBox.setAlignment(Pos.CENTER);
        passwordBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);

        userBox.getChildren().addAll(user, userField);
        passwordBox.getChildren().addAll(password, passwordField);
        buttonBox.getChildren().addAll(okButton, signUpButton);

        mainPane.getChildren().addAll(userBox, passwordBox, buttonBox);
    }


    private void initializeScene() {
        scene = new Scene(mainPane, LOGIN_WIDTH, LOGIN_HEIGHT);
        stage.setTitle(APP_TITLE + TITLE_SEPARATION + SCENE_TITLE);
        stage.setScene(scene);
    }


    private void setListeners() {
        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new SignUpView(stage);
            }
        });

        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            //TODO: validate parameters
            public void handle(ActionEvent event) {
                controller.logIn(userField.getText(), passwordField.getText());
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        stage.close();
        new MainMenuView(new Stage(), (Player)arg);
    }
}
