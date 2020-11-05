package src;

public class GameMenu extends Menu {
    public void printHeader() {
        System.out.println("Nuova Partita");
    }

    public Menu changeMenu() {
        System.out.println("Selezione: ");
        int sel = Inputchecker.getLetter();
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
        Game gm = new Game(Word.getWord());
        gm.play();
        return new MainMenu();
    }
}
