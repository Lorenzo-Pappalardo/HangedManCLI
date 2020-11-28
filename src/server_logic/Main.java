package server_logic;

public class Main {
  private final SharedMemory sharedMemory = SharedMemory.getInstance();

  public static void main(String[] args) {
    System.out.println("Server started");

    Thread lobby = new Thread(new Lobby());

    lobby.start();

    try {
      lobby.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
      Thread.currentThread().interrupt();
    }
  }
}
