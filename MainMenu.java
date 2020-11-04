public class MainMenu implements Menu {
    public void printHeader() {
        System.out.println("1) Nuova partita");
        System.out.println("2) Esci");
    }

    public Menu changeMenu() {
        System.out.println("Selezione: ");
        int sel = Inputchecker.getNumber();
        switch (sel) {
            case 1:
                return new GameMenu();
            case 2:
                Inputchecker.exitGame();
                break;
            default:
                System.out.println("Scelta non valida");
        }
        return this;
    }

    public Menu init(){
        printHeader();
        return changeMenu();
    }
}
