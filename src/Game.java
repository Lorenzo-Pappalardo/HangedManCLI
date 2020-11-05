package src;

import java.util.*;

public class Game {
    private List<String> letters;
    private List<String> usedLetters;
    private String word;
    private int nT;
    private boolean gameEnd = false;
    private HiddenWord hw;

    Game(String word) {
        this.word = word;
        hw = new HiddenWord(word);
        this.nT = 5;
        this.gameEnd = false;
        letters = new ArrayList<>();
        usedLetters = new ArrayList<>();
        char entry = 'a';
        for (int i = 0; i < 26; i++) {
            letters.add(Character.toString(entry));
            entry++;
        }
    }

    public void play() {
        while (!gameEnd) {
            // System.out.println("debug ON: word: " + this.word);
            printHeader();
            System.out.println(hw);
            System.out.print("\n");
            printLetters();
            printUsedLetters();
            askForInput();
            checkEsit();
        }
    }

    private void printLetters() {
        System.out.print("Lettere: ");
        for (int i = 0; i < letters.size(); i++)
            System.out.print(letters.get(i) + " ");
        System.out.print("\n");
    }

    private void printUsedLetters() {
        System.out.print("Lettere usate: ");
        for (int i = 0; i < usedLetters.size(); i++)
            System.out.print(usedLetters.get(i) + " ");
        System.out.print("\n");
    }

    private void printHeader() {
        System.out.println("HangerGames - tentativi rimasti: " + nT);
    }

    private void askForInput() {
        char input = Inputchecker.getLetter();
        int indexOnList = letters.indexOf(Character.toString(input));
        if (indexOnList == -1) {
            System.out.println("Lettera già utilizzata.");
        } else {
            if (hw.checkLetter(input) == 0)
                nT--;
            letters.remove(indexOnList);
            usedLetters.add(Character.toString(input));
        }
    }

    private void checkEsit() {
        if (this.nT <= 0) {
            System.out.println("Che sfortuna. Hai perso!");
            System.out.println("La parola era: " + word);
            gameEnd = true;
        }
        if (hw.cleared()) {
            System.out.println("Complimenti! Hai vinto.");
            System.out.println("Hai indovinato la parola: " + word);
            gameEnd = true;
        }
    }
}
