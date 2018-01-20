package fr.univtln.m2dapm.boardgame.javaclient;


import fr.univtln.m2dapm.boardgame.javaclient.login.LogInView;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        Application.launch();
    }


    public void start(Stage primaryStage) throws Exception {
        LogInView loginScreen = new LogInView(primaryStage);
    }
}
