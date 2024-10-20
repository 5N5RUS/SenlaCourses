package it.senla;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Hangman {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final int MAX_LIVES = 6;
    private final String word;
    private final Set<Character> guessedLetters = new HashSet<>();
    private int lives;

    public Hangman(String word, int lives) {
        this.word = word;
        this.lives = lives;
    }

    public boolean isGameOver() {
        return lives <= 0 || isWordGuessed();
    }

    public boolean isWordGuessed() {
        for (char c : word.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean guess(char letter) {

        if (guessedLetters.contains(letter)) {
            System.out.println("Якубович: Так эту букву вы уже угадали, назовите другую. Оставшихся жизней: " + lives);
            printHangman();
            return false;
        }

        guessedLetters.add(letter);

        if (word.indexOf(letter) < 0) {
            lives--;
            System.out.println("Якубович: Это одна из немногих букв, которых тут " + ANSI_RED + "нет " + ANSI_RESET + ":) Оставшихся жизней: " + lives);
            printHangman();
            return false;
        }

        System.out.println("Якубович: " + ANSI_GREEN + "Откройте!" + ANSI_RESET + " Оставшихся жизней: " + lives);
        printHangman();
        return true;
    }

    public String getCurrentProgress() {
        StringBuilder progress = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (guessedLetters.contains(c)) {
                progress.append(c).append(' ');
            } else {
                progress.append("_ ");
            }
        }
        return progress.toString().trim();
    }

    public void printHangman() {
        String[] hangmanStages = {
                """
               +---+
               |   |
                   |
                   |
                   |
                   |
             ========""",
                """
               +---+
               |   |
               O   |
                   |
                   |
                   |
             ========""",
                """
               +---+
               |   |
               O   |
               |   |
                   |
                   |
             ========""",
                """
               +---+
               |   |
               O   |
              /|   |
                   |
                   |
             ========""",
                """
               +---+
               |   |
               O   |
              /|\\  |
                   |
                   |
             ========""",
                """
               +---+
               |   |
               O   |
              /|\\  |
              /    |
                   |
             ========""",
                """
               +---+
               |   |
               O   |
              /|\\  |
              / \\  |
                   |
             ========"""
        };
        System.out.println(hangmanStages[MAX_LIVES - lives]);
    }
}
