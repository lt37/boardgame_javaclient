package fr.univtln.m2dapm.boardgame.javaclient.mainmenu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

import static fr.univtln.m2dapm.boardgame.javaclient.ViewConstants.*;

public class CreateGameView implements Observer {

    private CreateGameController controller;

    private Stage stage;
    private Scene scene;
    private VBox mainPane;

    private Text fleetCommanderTitle;
    private Text name;
    private Text password;
    private Text test;

    private TextField nameField;
    private TextField passwordField;
    private CheckBox privateCheck;

    private Button okButton;
    private Button backButton;

    private final String NAME = "Nom de la partie :";
    private final String PASSWORD = "Mot de passe :";
    private final String PRIVATE = "Partie privée";
    private final String SCENE_TITLE = "Créer une partie";


    public CreateGameView(Stage stage) {
        this.stage = stage;
        this.controller = new CreateGameController(this);

        initializeElements();
        initializeMainPain();
        initializeScene();
        setListeners();

        stage.show();
    }


    private void initializeElements() {
        fleetCommanderTitle = new Text(GAME_TITLE);
        name = new Text(NAME);
        password = new Text(PASSWORD);
        test = new Text();

        nameField = new TextField();
        passwordField = new PasswordField();

        privateCheck = new CheckBox(PRIVATE);

        okButton = new Button(OK_BUTTON);
        backButton = new Button(BACK_BUTTON);
    }


    private void initializeMainPain() {
        mainPane = new VBox();
        mainPane.setSpacing(SMALL_SPACING);
        mainPane.setAlignment(Pos.CENTER);

        HBox nameBox = new HBox();
        HBox passwordBox = new HBox();
        HBox buttonBox = new HBox();
        nameBox.setSpacing(SMALL_SPACING);
        passwordBox.setSpacing(SMALL_SPACING);
        buttonBox.setSpacing(SMALL_SPACING);
        nameBox.setAlignment(Pos.CENTER);
        passwordBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);

        nameBox.getChildren().addAll(name, nameField);
        passwordBox.getChildren().addAll(password, passwordField);
        buttonBox.getChildren().addAll(okButton, backButton);

        mainPane.getChildren().addAll(fleetCommanderTitle, nameBox, passwordBox, privateCheck, buttonBox, test);
    }


    private void initializeScene() {
        scene = new Scene(mainPane, MAIN_MENU_WIDTH, MAIN_MENU_HEIGHT);
        stage.setTitle(APP_TITLE + TITLE_SEPARATION + SCENE_TITLE);
        stage.setScene(scene);
    }


    private void setListeners() {
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.createGame(nameField.getText(), passwordField.getText(), privateCheck.isSelected());
            }
        });

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new MainMenuView(stage);
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        test.setText("New Game!");
    }
}
