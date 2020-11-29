package server_logic;

public class Lobby implements Runnable {
  private SharedMemory sharedMemory = SharedMemory.getInstance();

  private boolean begin = false;

  @Override
  public void run() {
    while (!(sharedMemory.gameStarted)) {
      for (Player player : sharedMemory.getPlayers()) {
        if (!(player.isReady()))
          break;
      }

      if (begin)
        sharedMemory.gameStarted = true;
    }
  }
}
