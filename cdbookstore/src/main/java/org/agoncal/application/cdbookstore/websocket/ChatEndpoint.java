package org.agoncal.application.cdbookstore.websocket;

import javax.inject.Inject;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@ServerEndpoint("/chat")
public class ChatEndpoint {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private Logger logger;

    // ======================================
    // =          Business methods          =
    // ======================================

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("######################");
        System.out.println("######################");
        System.out.println("######################");
        // ...
    }

        @OnMessage
    public void message(String message, Session client) throws Exception {
            System.out.println("######################");
            System.out.println("######################");
            System.out.println("######################");
        logger.info("message: " + message);
        for (Session peer : client.getOpenSessions()) {
            peer.getBasicRemote().sendText(message);
        }
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("######################");
        System.out.println("######################");
        System.out.println("######################");
    }

    @OnError
    public void onError(Throwable t) {
        System.out.println("######################");
        System.out.println("######################");
        System.out.println("######################");
    }
}
