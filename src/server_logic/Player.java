package server_logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Player {
  private String name;
  private BufferedReader socketInput;
  private PrintWriter socketOutput;
  private boolean ready;

  public Player(InputStream socketInput, OutputStream socketOutput) {
    this.socketInput = new BufferedReader(new InputStreamReader(socketInput));
    this.socketOutput = new PrintWriter(new OutputStreamWriter(socketOutput), true);
    name = null;
    ready = false;
  }

  public String getName() {
    if (name == null) {
      socketOutput.println("Enter your name:");

      try {
        name = socketInput.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return name;
  }

  public void welcome() {
    socketOutput.println("Hi " + name + "!\n");
    socketOutput.println("You've joined the lobby");
    socketOutput
        .println("Currently there are other " + SharedMemory.getInstance().getPlayersCount() + " players in lobby");
    socketOutput.println("The game will start once all players in lobby will be ready\n");
  }

  public void readyUp() {
    socketOutput.println("Press \'R\' to ready up");
    try {
      if (socketInput.readLine().equalsIgnoreCase("r"))
        ready = true;
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean isReady() {
    return ready;
  }

  @Override
  public String toString() {
    return name;
  }
}
