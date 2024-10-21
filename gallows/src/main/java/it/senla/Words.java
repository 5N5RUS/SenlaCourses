package it.senla;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;
import java.util.Random;

/**
 * Class for words
 */
public class Words {
    private List<String> words;
    private static final String WORDS_FILE = "words.txt";

    /**
     * Constructor for Words
     */
    public Words() {
        try {
            words = Files.readAllLines(Path.of(WORDS_FILE))
                    .stream()
                    .map(String::trim)
                    .filter(word -> !word.isEmpty())
                    .toList();
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Gets random word
     *
     * @return random word
     */
    public String getRandomWord() {
        if (words.isEmpty()) {
            throw new IllegalStateException("Список слов пуст, загадывать нечего :(");
        }
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}
