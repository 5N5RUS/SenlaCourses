package it.senla;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

import static it.senla.Colors.*;

/**
 * Class for Hangman
 */
@Getter
public class Hangman {
    public static final int MAX_LIVES = 6;
    private final String word;
    private final Set<Character> guessedLetters = new HashSet<>();
    private int lives;

    /**
     * Constructor for Hangman
     *
     * @param word  word
     * @param lives lives
     */
    public Hangman(String word, int lives) {
        this.word = word;
        this.lives = lives;
    }

    /**
     * Checks if game is over
     *
     * @return true if game is over
     */
    public boolean isGameOver() {
        return lives <= 0 || isWordGuessed();
    }

    /**
     * Checks if word is guessed
     *
     * @return true if word is guessed
     */
    public boolean isWordGuessed() {
        for (char c : word.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Guesses letter
     *
     * @param letter letter
     * @return true if letter is guessed
     */
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

    /**
     * Gets current word progress
     *
     * @return current word progress
     */
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

    /**
     * Prints hangman stage
     */
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
