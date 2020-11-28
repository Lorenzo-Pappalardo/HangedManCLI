package game_logic;

public abstract class Menu {
    abstract void printHeader();

    abstract Menu changeMenu();

    abstract Menu init();

    boolean gameEnd = false;

    void exit() {
        System.out.println("Grazie per aver giocato.");
        gameEnd = true;
        System.exit(0);
    }
}
