package server_logic;

public class SharedMemory {
  private static SharedMemory instance;
  public static final int PORT = 8080;

  private SharedMemory() {
  }

  public static SharedMemory getInstance() {
    if (instance == null)
      instance = new SharedMemory();
    return instance;
  }
}
