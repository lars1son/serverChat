package com.serverChat.serverChat.service;

import com.serverChat.serverChat.api.ChatEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Артем on 04.08.2018.
 */
@Service
public class RoomService {
    private static HashMap<String, List<Session>> chatSessions
            = new LinkedHashMap<String, List<Session>>();

    @Autowired
    RoomService() {
    }

    public void createRoom(String roomName, Session session) {
        List<Session> listSessions = null;
        if (chatSessions.containsKey(roomName)) {

            listSessions = chatSessions.get(roomName);
            listSessions.add(session);

            chatSessions.replace(roomName,listSessions);

        } else {
            listSessions = new ArrayList<>();
            listSessions.add(session);

            chatSessions.put(roomName,listSessions);
        }


    }
}
