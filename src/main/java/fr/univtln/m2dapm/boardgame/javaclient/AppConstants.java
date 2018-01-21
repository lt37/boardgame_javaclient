package fr.univtln.m2dapm.boardgame.javaclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

public abstract class AppConstants {

    /*
     * REST
     */
    public static WebResource webResource;

    static {
        ClientConfig cc = new DefaultClientConfig();
        cc.getClasses().add(JacksonJsonProvider.class);
        Client c = Client.create(cc);
        webResource = c.resource("http://localhost:8080/fleetcommander/rest");
    }

    /*
     * View
     */
    public static final String APP_TITLE = "Fleet Commander";
    public static final String GAME_TITLE = "FLEET COMMANDER";
    public static final String TITLE_SEPARATION = " - ";

    public static final String OK_BUTTON = "Valider";
    public static final String BACK_BUTTON = "Annuler";

    public static final int LOGIN_WIDTH = 300;
    public static final int LOGIN_HEIGHT = 250;
    public static final int MAIN_MENU_WIDTH = 300;
    public static final int MAIN_MENU_HEIGHT = 250;
    public static final int GAME_WIDTH = 1200;
    public static final int GAME_HEIGHT = 900;

    public static final double BOARD_LINE_WIDTH = 4d;
    public static final int BOARD_SIDE = GAME_HEIGHT - GAME_HEIGHT/4;
    public static final int SQUARE_AMOUNT = 5;
    public static final int SQUARE_SIDE = BOARD_SIDE/SQUARE_AMOUNT;
    public static final int BRIDGE_WIDTH = SQUARE_SIDE-5;
    public static final int BRIDGE_HEIGHT = BRIDGE_WIDTH*2;

    public static final int GENERAL_SPACING = 20;
    public static final int SMALL_SPACING = 10;
}
