package fr.univtln.m2dapm.boardgame.javaclient.websocket;

import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;

@ClientEndpoint
public class WebsocketClientEndpoint {

    private static Session session;


    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Opening websocket");
        WebsocketClientEndpoint.session = session;
    }


    @OnMessage
    public void onMessage(Session session, String message) {
        System.out.println(message);
    }

    public void send(String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Closing websocket");
        WebsocketClientEndpoint.session = null;
    }


    public static Session getSession() {
        return session;
    }

    public void connect() {
        ClientManager client = ClientManager.createClient();
        try {
            client.connectToServer(WebsocketClientEndpoint.class, new URI("ws://localhost:8025/test"));

        } catch (DeploymentException | IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }


}
