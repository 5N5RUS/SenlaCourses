package it.senla;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;
import java.util.Random;

public class Words {
    private List<String> words;
    private static final String WORDS_FILE = "words.txt";

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

    public String getRandomWord() {
        if (words.isEmpty()) {
            throw new IllegalStateException("Список слов пуст, загадывать нечего :(");
        }
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}
