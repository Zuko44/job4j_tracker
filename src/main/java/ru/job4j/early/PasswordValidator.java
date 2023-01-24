package ru.job4j.early;

public class PasswordValidator {
    public static boolean isUpper(String word) {
        boolean flag = false;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean isLower(String word) {
        boolean flag = false;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean isDigit(String word) {
        boolean flag = false;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean isSpecialCharacters(String word) {
        boolean flag = false;
        for (int i = 0; i < word.length(); i++) {
            int asciiVal = word.charAt(i);
            if ((asciiVal >= 32 && asciiVal <= 47) || (asciiVal >= 58 && asciiVal <= 64)
                    || (asciiVal >= 91 && asciiVal <= 96) || (asciiVal >= 123 && asciiVal <= 126)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean checkSubstring(String word) {
        boolean flag = false;
        String[] substrings = {"qwerty", "12345", "password", "admin", "user"};
        String low = word.toLowerCase();
        for (String substr : substrings) {
            if (low.contains(substr)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (!(password.length() >= 8 && password.length() <= 32)) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (!isUpper(password)) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!isLower(password)) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!isDigit(password)) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!isSpecialCharacters(password)) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        if (checkSubstring(password)) {
            throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
        }
        return password;
    }
}
