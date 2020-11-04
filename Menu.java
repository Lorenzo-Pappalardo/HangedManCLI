public abstract class Menu {
    abstract void printHeader();

    abstract Menu changeMenu();

    abstract Menu init();

    void exit() {
        System.out.println("Grazie per aver giocato.");
        System.exit(0);
    }
}
