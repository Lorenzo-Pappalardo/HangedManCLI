package src;

public class MenuHandler {
    private MenuHandler() {
    }

    public static void init() {
        Menu menu = new MainMenu();
        while (!menu.gameEnd) {
            System.out.println("\n");
            menu = menu.init();
        }
    }
}
