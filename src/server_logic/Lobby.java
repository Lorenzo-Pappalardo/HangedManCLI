package server_logic;

import java.net.ServerSocket;
import java.net.Socket;

public class Lobby implements Runnable {
  private final SharedMemory sharedMemory = SharedMemory.getInstance();

  @Override
  public void run() {
    System.out.println("Lobby started");

    while (!sharedMemory.gameStarted) {
      try (ServerSocket socket = new ServerSocket(8080); Socket newPlayerSocket = socket.accept();) {
        System.out.println(
            "Connection from " + newPlayerSocket.getInetAddress() + ':' + newPlayerSocket.getPort() + " accepted");

        Player newPlayer = new Player(newPlayerSocket.getInputStream(), newPlayerSocket.getOutputStream());
        newPlayer.getName();
        sharedMemory.addPlayer(newPlayer);
        newPlayer.sendGreetings();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
