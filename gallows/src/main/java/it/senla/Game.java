package it.senla;

import java.util.Scanner;

import static it.senla.Hangman.MAX_LIVES;
import static it.senla.Hangman.ANSI_RED;
import static it.senla.Hangman.ANSI_CYAN;
import static it.senla.Hangman.ANSI_GREEN;
import static it.senla.Hangman.ANSI_RESET;

/**
 * Main class for Hangman game
 */
public class Game {

    /**
     * Main method
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {

        Scanner scanner = new Scanner(System.in);
        Words words = new Words();
        String randomWord = words.getRandomWord();
        Hangman hangman = new Hangman(randomWord, MAX_LIVES);

        System.out.println("Добро пожаловать в игру " + ANSI_CYAN +
                "Виселица" + ANSI_RESET + "! Угадайте слово.");

        while (!hangman.isGameOver()) {
            System.out.println("Текущее состояние слова: " + hangman.getCurrentProgress());
            char guessedLetter;

            while (true) {
                System.out.print("Введите букву: ");
                String input = scanner.nextLine().toLowerCase();

                if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                    guessedLetter = input.charAt(0);
                    break;
                } else {
                    System.out.println("Введите " + ANSI_CYAN + "одну русскую букву" + ANSI_RESET + ", если не сложно.");
                }
            }

            hangman.guess(guessedLetter);
        }

        if (hangman.isWordGuessed()) {
            System.out.println(ANSI_GREEN + "Поздравляем!" + ANSI_RESET +
                    " Вы угадали слово: " + hangman.getWord());
        } else {
            System.out.println("Вы " + ANSI_RED + "проиграли." + ANSI_RESET
                    + " Загаданное слово: " + hangman.getWord());
        }

        scanner.close();
    }
}
