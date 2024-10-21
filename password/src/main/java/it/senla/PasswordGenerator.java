package it.senla;

import java.util.Scanner;

import static it.senla.Password.generatePassword;

/**
 * Password generator class
 */
public class PasswordGenerator {

    /**
     * Main method
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length;
        while (true) {
            System.out.print("Введите длину пароля (от 8 до 12): ");
            if (scanner.hasNextInt()) {
                length = scanner.nextInt();
                if (length >= 8 && length <= 12) {
                    break;
                } else {
                    System.out.println("Ошибка: Длина должна быть от 8 до 12 символов.");
                }
            } else {
                System.out.println("Ошибка: Введите целое числовое значение.");
                scanner.next();
            }
        }

        String password = generatePassword(length);
        System.out.println("Сгенерированный пароль: " + password);

        scanner.close();
    }
}