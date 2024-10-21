package it.senla;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for convert currencies
 */
public class Currency {

    /**
     * Map for exchange rates
     */
    public static final Map<String, Double> exchangeRates = new HashMap<>();

    /**
     * Initialize exchange rates
     */
    public static void initializeExchangeRates() {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.94);
        exchangeRates.put("RUB", 98.57);
        exchangeRates.put("CNY", 7.31);
        exchangeRates.put("MXN", 18.24);
    }

    /**
     * Show all conversions
     *
     * @param fromCurrency from currency
     * @param amount       amount
     */
    public static void showAllConversions(final String fromCurrency, final double amount) {
        System.out.println("\nКонвертация из " + fromCurrency + ":");
        for (String currency : exchangeRates.keySet()) {
            if (!currency.equals(fromCurrency)) {
                double convertedAmount = convertCurrency(fromCurrency, currency, amount);
                System.out.printf("%s: %.2f\n", currency, convertedAmount);
            }
        }
    }

    /**
     * Convert single currency
     *
     * @param fromCurrency from currency
     * @param toCurrency   to currency
     * @param amount       amount
     */
    public static void convertSingleCurrency(final String fromCurrency, final String toCurrency, final double amount) {
        double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount);
        System.out.printf("\nРезультат: %.2f %s = %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
    }

    /**
     * Convert currency
     *
     * @param fromCurrency from currency
     * @param toCurrency   to currency
     * @param amount       amount
     * @return converted amount
     */
    public static double convertCurrency(final String fromCurrency, final String toCurrency, final double amount) {
        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);
        return (amount / fromRate) * toRate;
    }
}
