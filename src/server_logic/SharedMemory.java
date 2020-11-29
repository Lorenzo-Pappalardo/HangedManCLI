package server_logic;

import java.util.ArrayList;
import java.util.List;

public class SharedMemory {
  private static SharedMemory instance;
  public Boolean gameStarted = false;
  private final List<Player> players = new ArrayList<>();

  private SharedMemory() {
  }

  public static SharedMemory getInstance() {
    if (instance == null)
      instance = new SharedMemory();
    return instance;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public int getPlayersCount() {
    return players.size();
  }

  public void addPlayer(Player newPlayer) {
    players.add(newPlayer);
  }
}
