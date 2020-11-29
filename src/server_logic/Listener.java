package server_logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener implements Runnable {
  private final SharedMemory sharedMemory = SharedMemory.getInstance();

  @Override
  public void run() {
    System.out.println("Listener started");

    while (!sharedMemory.gameStarted) {
      try (ServerSocket socket = new ServerSocket(8080); Socket newPlayerSocket = socket.accept();) {
        System.out.println("Connection from " + newPlayerSocket + " accepted");

        Player newPlayer = new Player(newPlayerSocket.getInputStream(), newPlayerSocket.getOutputStream());
        sharedMemory.addPlayer(newPlayer);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    while (sharedMemory.gameStarted) {
      try (ServerSocket socket = new ServerSocket(8080);
          Socket clientSocket = socket.accept();
          BufferedReader socketInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
          PrintWriter socketOutput = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);) {
        socketOutput.println("Game has already started. Please try again later.");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
