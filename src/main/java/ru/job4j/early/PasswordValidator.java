package ru.job4j.early;

public class PasswordValidator {
    @SuppressWarnings("checkstyle:MethodLength")
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        boolean haveUpper = false;
        boolean haveLower = false;
        boolean haveDigit = false;
        boolean haveSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                haveUpper = true;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                haveLower = true;
            }
            if (Character.isDigit(password.charAt(i))) {
                haveDigit = true;
            }
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                haveSpecial = true;
            }
            if (haveSpecial && haveUpper && haveDigit && haveLower) {
                break;
            }
        }
        if (!haveUpper) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }
        if (!haveLower) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }
        if (!haveDigit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }
        if (!haveSpecial) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }
        String[] substrings = {"qwerty", "12345", "password", "admin", "user"};
        for (String word : substrings) {
            if (password.toLowerCase().contains(word)) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        return password;
    }
}
