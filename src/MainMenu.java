package src;

public class MainMenu extends Menu {
    public void printHeader() {
        System.out.println("Benvenuto giocatore!\n");
        System.out.println("1) Nuova partita");
        System.out.println("2) Esci");
    }

    public Menu changeMenu() {
        System.out.print("Selezione: ");
        int sel = Inputchecker.getNumber();
        switch (sel) {
            case 1:
                return new GameMenu();
            case 2:
                exit();
            default:
                System.out.println("Scelta non valida");
        }
        return this;
    }

    public Menu init() {
        printHeader();
        return changeMenu();
    }
}
