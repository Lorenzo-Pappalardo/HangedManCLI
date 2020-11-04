public class MenuHandler {
    public static void init(){
        Menu menu=new MainMenu();
        while(true){
            menu=menu.init();
        }
    }
}
