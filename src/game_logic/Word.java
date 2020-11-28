package game_logic;

import java.io.*;
import java.util.*;

public class Word {
    private static List<String> wordlist = new ArrayList<>();

    public static String getWord() {
        Random rnd = new Random();
        if (wordlist.isEmpty())
            loadWords();
        return wordlist.get(rnd.nextInt(wordlist.size()));
    }

    private static BufferedReader loaddb() {
        try {
            return new BufferedReader(new FileReader(Config.getWordlist()));
        } catch (FileNotFoundException fnfe) {
            System.out.println("File non trovato.");
        }
        return null;
    }

    private static void loadWords() {
        BufferedReader br = loaddb();
        try {
            while (br.ready())
                wordlist.add(br.readLine());
        } catch (Exception e) {
            System.out.println("Errore caricando il db.");
        }
    }

    public static void test() {
        System.out.println("Testing file load..");
        loaddb();
        System.out.println("..file loading successful");
        System.out.println("Testing loading words from database...");
        loadWords();
        System.out.println("...database loading successful");
        System.out.println("Testing random word..");
        System.out.println(Word.getWord());
        System.out.println("...random word generation successful");
    }
}
