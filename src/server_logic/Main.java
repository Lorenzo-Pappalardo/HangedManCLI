package server_logic;

public class Main {
  private final SharedMemory sharedMemory = SharedMemory.getInstance();

  public static void main(String[] args) {
    System.out.println("Server started");

    Thread listener = new Thread(new Listener());
    Thread lobby = new Thread(new Lobby());

    listener.start();
    lobby.start();

    try {
      listener.join();
      lobby.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
      Thread.currentThread().interrupt();
    }
  }
}
