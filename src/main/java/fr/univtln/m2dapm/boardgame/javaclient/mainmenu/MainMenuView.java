package fr.univtln.m2dapm.boardgame.javaclient.mainmenu;

import fr.univtln.m2dapm.boardgame.business.gameinfos.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import static fr.univtln.m2dapm.boardgame.javaclient.AppConstants.*;

public class MainMenuView implements Observer {

    private MainMenuController controller;

    private Stage stage;
    private Scene scene;
    private VBox mainPane;

    private Text gameTitle;
    private Button createButton;
    private Button joinButton;

    private final String CREATE = "Créer une partie";
    private final String JOIN = "Rejoindre une partie";
    private final String SCENE_TITLE = "Menu Principal";


    public MainMenuView(Stage stage, Player currentPlayer) {
        this.stage = stage;
        this.controller = new MainMenuController(this, currentPlayer);

        initializeElements();
        initializeMainPane();
        initializeScene();
        setListeners();

        stage.show();
    }


    private void initializeElements() {
        gameTitle = new Text(GAME_TITLE);
        createButton = new Button(CREATE);
        joinButton = new Button(JOIN);
    }


    private void initializeMainPane() {
        mainPane = new VBox();
        mainPane.setSpacing(SMALL_SPACING);
        mainPane.setAlignment(Pos.CENTER);
        mainPane.getChildren().addAll(gameTitle, createButton, joinButton);
    }


    private void initializeScene() {
        scene = new Scene(mainPane, MAIN_MENU_WIDTH, MAIN_MENU_HEIGHT);
        stage.setTitle(APP_TITLE + TITLE_SEPARATION + SCENE_TITLE);
        stage.setScene(scene);
    }


    private void setListeners() {
        createButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.createGame();
            }
        });

        joinButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.joinGame();
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        List args = (List) arg;
        if (args.get(0) == "create")
            new CreateGameView(stage, (Player)args.get(1));
        else if (args.get(0) == "join")
            new JoinGameView(stage, (Player)args.get(1));
    }
}
