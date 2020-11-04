public class GameMenu implements Menu {
    public void printHeader() {
        System.out.println("Nuova Partita");
    }

    public Menu init(){
        Game gm = new Game(Word.getWord());
        gm.play();
        return new MainMenu();
    }

    public Menu changeMenu() {
        System.out.println("Selezione: ");
        int sel = Inputchecker.getLetter();
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
    
}
