package server;

// server/PlayerHandler.java
import java.io.*;
import java.net.*;

public class PlayerHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public PlayerHandler(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            sendMessage("Welcome! Try guessing the number (1 to 10).");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        out.println(msg);
    }

    @Override
    public void run() {
        try {
            String input;
            while ((input = in.readLine()) != null) {
                int guess;
                try {
                    guess = Integer.parseInt(input.trim());
                } catch (NumberFormatException e) {
                    sendMessage("❌ Invalid input. Please enter a number.");
                    continue;
                }

                if (guess < GameServer.targetNumber) {
                    GameServer.broadcast("Player guessed " + guess + ": Too Low!");
                } else if (guess > GameServer.targetNumber) {
                    GameServer.broadcast("Player guessed " + guess + ": Too High!");
                } else {
                    GameServer.broadcast("🎉 Player guessed correctly! The number was " + guess);
                    break;
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
