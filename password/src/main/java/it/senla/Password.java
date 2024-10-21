package it.senla;

import java.security.SecureRandom;

/**
 * Password class for password generator
 */
public class Password {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{};:,.<>?";

    /**
     * Generate password with given length
     * @param length length of password
     * @return generated password
     */
    public static String generatePassword(final int length) {
        String allChars = UPPERCASE + LOWERCASE + NUMBERS + SPECIAL_CHARS;
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        password.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));

        for (int i = 4; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        return shuffleString(password.toString(), random);
    }

    /**
     * Shuffle string
     * @param input input string
     * @param random random
     * @return shuffled string
     */
    private static String shuffleString(final String input, final SecureRandom random) {
        char[] characters = input.toCharArray();
        for (int i = characters.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
    }
}
