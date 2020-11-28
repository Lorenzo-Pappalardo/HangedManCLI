package server_logic;

import java.net.ServerSocket;

public class Main {
  private final SharedMemory sharedMemory = SharedMemory.getInstance();

  public static void main(String[] args) {
    while (true) {
      try (ServerSocket socket = new ServerSocket(SharedMemory.PORT)) {
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
