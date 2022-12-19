package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("active is " + active);
        System.out.println("status is " + status);
        System.out.println("message is " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error error2 = new Error(true, 11, "error2");
        Error error3 = new Error(true, 22, "error3");
        Error error4 = new Error(true, 33, "error4");
        error.printInfo();
        System.out.println();
        error2.printInfo();
        System.out.println();
        error3.printInfo();
        System.out.println();
        error4.printInfo();
    }
}
