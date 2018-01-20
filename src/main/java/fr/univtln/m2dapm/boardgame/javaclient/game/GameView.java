package fr.univtln.m2dapm.boardgame.javaclient.game;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

import static fr.univtln.m2dapm.boardgame.javaclient.ViewConstants.*;

public class GameView implements Observer{

    private GameController controller;

    private Stage stage;
    private Scene scene;
    private VBox mainPane;

    private Canvas canvas;
    private GraphicsContext gc;


    public GameView(Stage stage) {
        this.stage = stage;
        this.controller = new GameController(this);

        initializeElements();
        drawBackground();
        initializeMainPain();
        initializeScene();

        stage.show();
    }


    private void initializeElements() {
        canvas = new Canvas(GAME_WIDTH, GAME_HEIGHT);
        gc = canvas.getGraphicsContext2D();
    }


    private void drawBackground() {
        gc.setLineWidth(BOARD_LINE_WIDTH);
        int boardX1 = (GAME_WIDTH - BOARD_SIDE)/2;
        int boardX2 = boardX1 + BOARD_SIDE;
        int boardY1 = (GAME_HEIGHT - BOARD_SIDE)/2;
        int boardY2 = boardY1 + BOARD_SIDE;

        //Draws the Board
        for(int i = 0; i <= SQUARE_AMOUNT; i++)
            gc.strokeLine(boardX1, boardY1 + i*SQUARE_SIDE, boardX2, boardY1 + i*SQUARE_SIDE);
        for(int i = 0; i <= SQUARE_AMOUNT; i++)
            gc.strokeLine(boardX1 + i*SQUARE_SIDE, boardY1, boardX1 + i*SQUARE_SIDE, boardY2);

        //Draws the Bridges
        int bridgeX = boardX1 - BRIDGE_WIDTH - 50;
        int bridgeY = boardY2 - BRIDGE_HEIGHT;
        int diceSize = BRIDGE_WIDTH/2 - 20;

        gc.strokeRect(bridgeX, bridgeY, BRIDGE_WIDTH, BRIDGE_HEIGHT);
        gc.setLineWidth(2d);
        gc.strokeRect(bridgeX + 10, bridgeY + BRIDGE_HEIGHT - BRIDGE_WIDTH + 10, BRIDGE_WIDTH - 20, BRIDGE_WIDTH - 20);
        gc.strokeRect(bridgeX + 10, bridgeY + 10, diceSize, diceSize);
        gc.strokeRect(bridgeX + BRIDGE_WIDTH/2 + 10, bridgeY + 10, diceSize, diceSize);
        gc.strokeRect(bridgeX + 10, bridgeY + BRIDGE_WIDTH/2 + 10, diceSize, diceSize);
        gc.strokeRect(bridgeX + BRIDGE_WIDTH/2 + 10, bridgeY + BRIDGE_WIDTH/2 + 10, diceSize, diceSize);

        bridgeX = boardX2 + 50;
        bridgeY = boardY1;
        gc.setLineWidth(4d);
        gc.strokeRect(bridgeX, bridgeY, BRIDGE_WIDTH, BRIDGE_HEIGHT);
        gc.setLineWidth(2d);
        gc.strokeRect(bridgeX + 10, bridgeY + 10, BRIDGE_WIDTH - 20, BRIDGE_WIDTH - 20);
        gc.strokeRect(bridgeX + 10, bridgeY + BRIDGE_HEIGHT/2 + 10,diceSize, diceSize);
        gc.strokeRect(bridgeX + BRIDGE_WIDTH/2 + 10, bridgeY + BRIDGE_HEIGHT/2 + 10, diceSize, diceSize);
        gc.strokeRect(bridgeX + 10, bridgeY + (BRIDGE_WIDTH + BRIDGE_HEIGHT)/2 + 10, diceSize, diceSize);
        gc.strokeRect(bridgeX + BRIDGE_WIDTH/2 + 10, bridgeY + (BRIDGE_WIDTH + BRIDGE_HEIGHT)/2 + 10, diceSize, BRIDGE_WIDTH/2 - 20);

        for(int i = 0; i < 9; i++) {
                gc.strokeRect(boardX1 + 10 + i * BOARD_SIDE/9, boardY2 + 10, diceSize, diceSize);
                gc.strokeRect(boardX2 + 10 - (i+1) * BOARD_SIDE/9, boardY1 - diceSize - 10, diceSize, diceSize);
        }
    }


    private void initializeMainPain() {
        mainPane = new VBox();
        mainPane.setSpacing(SMALL_SPACING);
        mainPane.setAlignment(Pos.CENTER);

        mainPane.getChildren().add(canvas);
    }


    private void initializeScene() {
        scene = new Scene(mainPane, GAME_WIDTH, GAME_HEIGHT);
        stage.setTitle(APP_TITLE);
        stage.setScene(scene);
    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
