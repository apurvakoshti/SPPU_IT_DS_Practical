package server;

// server/GameServer.java
import java.io.*;
import java.net.*;
import java.util.*;

public class GameServer {
    private static final int PORT = 5000;
    static int targetNumber = new Random().nextInt(10) + 1;
    static List<PlayerHandler> players = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("🎯 Server started. Waiting for players to connect...");

            while (true) {
                Socket socket = serverSocket.accept();
                PlayerHandler player = new PlayerHandler(socket);
                players.add(player);
                new Thread(player).start();
            }
        }
    }

    public static void broadcast(String message) {
        for (PlayerHandler p : players) {
            p.sendMessage(message);
        }
    }
}
