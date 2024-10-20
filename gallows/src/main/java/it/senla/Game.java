package it.senla;

import java.util.Scanner;

import static it.senla.Hangman.*;

public class Game {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Words words = new Words();
        String randomWord = words.getRandomWord();
        Hangman hangman = new Hangman(randomWord, MAX_LIVES);

        System.out.println("Добро пожаловать в игру " + ANSI_CYAN + "Виселица" + ANSI_RESET + "! Угадайте слово.");

        while (!hangman.isGameOver()) {
            System.out.println("Текущее состояние слова: " + hangman.getCurrentProgress());
            System.out.print("Введите букву: ");
            char guessedLetter = scanner.nextLine().toLowerCase().charAt(0);
            hangman.guess(guessedLetter);
        }

        if (hangman.isWordGuessed()) {
            System.out.println(ANSI_GREEN + "Поздравляем!" + ANSI_RESET + " Вы угадали слово: " + hangman.getWord());
        } else {
            System.out.println("Вы " + ANSI_RED + "проиграли." + ANSI_RESET + " Загаданное слово: " + hangman.getWord());
        }

        scanner.close();
    }
}
