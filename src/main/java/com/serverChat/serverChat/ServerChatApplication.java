package com.serverChat.serverChat;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerChatApplication {
 final static    Logger logger = Logger.getLogger(ServerChatApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ServerChatApplication.class, args);
        logger.info("=================================================================");

    }
}
