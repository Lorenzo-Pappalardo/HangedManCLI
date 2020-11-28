package game_logic;

public abstract class Config {
    private static final String WORDLIST = "../wordlist.txt";

    public static String getWordlist() {
        return WORDLIST;
    }
}