package com.serverChat.serverChat.api;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

@ServerEndpoint(value = "/chat/{room}")
public class ChatEndpoint {

    private Session session;
    private static HashMap<String, ChatEndpoint> chatEndpoints
            = new LinkedHashMap<>();
    private static HashMap<String, String> users = new HashMap<>();

    @OnOpen
    public void onOpen(
            Session session,
            @PathParam("room") String room) throws IOException {


        this.session = session;
//        chatEndpoints.add(this);
//        users.put(session.getId(), username);

        Message message = new Message();
//        message.setFrom(username);
        message.setContent("Connected!");
//        broadcast(message);
    }

    @OnMessage
    public void onMessage(Session session)
            throws IOException {


    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {

        chatEndpoints.remove(this);
        Message message = new Message();
        message.setFrom(users.get(session.getId()));
        message.setContent("Disconnected!");
        broadcast(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }

    private static void broadcast(Message message)
            throws IOException, EncodeException {

//        chatEndpoints.forEach(endpoint -> {
//            synchronized (endpoint) {
//                try {
//                    endpoint.session.getBasicRemote().
//                            sendObject(message);
//                } catch (IOException | EncodeException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }
}