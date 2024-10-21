package it.senla;

import java.util.Scanner;

import static it.senla.Currency.initializeExchangeRates;
import static it.senla.Currency.showAllConversions;
import static it.senla.Currency.convertSingleCurrency;
import static it.senla.Currency.exchangeRates;

/**
 * Main class for exchanger
 */
public class Exchanger {

    /**
     * Main method for exchanger
     *
     * @param args args
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в конвертер валют!");
        initializeExchangeRates();
        System.out.println("Доступные валюты: USD - доллары, EUR - евро, " +
                "RUB - рубли, CNY - юани, MXN - песо.");

        String fromCurrency;
        while (true) {
            System.out.print("Введите валюту, которую хотите обменять: ");
            fromCurrency = scanner.nextLine().toUpperCase();
            if (exchangeRates.containsKey(fromCurrency)) {
                break;
            }
            System.out.println("Ошибка: Неверная валюта. Попробуйте снова.");
        }

        double amount;
        while (true) {
            System.out.print("Введите количество " + fromCurrency + ": ");
            if (scanner.hasNextDouble()) {
                amount = scanner.nextDouble();
                if (amount > 0) {
                    break;
                } else {
                    System.out.println("Ошибка: Количество должно быть " +
                            "положительным и больше нуля.");
                }
            } else {
                System.out.println("Ошибка: Введите целое числовое значение.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();

        String toCurrency;
        while (true) {
            System.out.print("Введите валюту для обмена(USD - доллары, EUR - евро, RUB - рубли, " +
                    "CNY - юани, MXN - песо) или 'ALL' для просмотра всех: ");
            toCurrency = scanner.nextLine().toUpperCase();
            if (toCurrency.equals("ALL") || exchangeRates.containsKey(toCurrency)) {
                break;
            }
            System.out.println("Ошибка: Введен неверный параметр. Попробуйте снова.");
        }

        if (toCurrency.equals("ALL")) {
            showAllConversions(fromCurrency, amount);
        } else {
            convertSingleCurrency(fromCurrency, toCurrency, amount);
        }
        scanner.close();

    }
}
