public class MenuHandler {
    private MenuHandler() {
    }

    public static void init() {
        Menu menu = new MainMenu();
        while (menu.gameEnd==false) {
            System.out.println("\n");
            menu = menu.init();
        }
    }
}
