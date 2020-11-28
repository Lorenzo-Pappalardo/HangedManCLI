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
  BufferedReader socketInput;
  PrintWriter socketOutput;

  public Player(InputStream socketInput, OutputStream socketOutput) {
    this.name = "";
    this.socketInput = new BufferedReader(new InputStreamReader(socketInput));
    this.socketOutput = new PrintWriter(new OutputStreamWriter(socketOutput), true);
  }

  public void getName() {
    socketOutput.println("Enter your name:");

    try {
      name = socketInput.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void sendGreetings() {
    socketOutput.println("You joined the lobby");
  }

  @Override
  public String toString() {
    return name;
  }
}
