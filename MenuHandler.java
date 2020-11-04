public class MenuHandler {
    private MenuHandler() {
    }

    public static void init() {
        Menu menu = new MainMenu();
        while (true) {
            System.out.println("\n");
            menu = menu.init();
            //TODO
            //interrompere il ciclo utilizzando una variabile
        }
    }
}
