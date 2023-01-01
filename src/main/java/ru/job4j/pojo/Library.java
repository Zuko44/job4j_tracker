package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book code = new Book("Clean code", 464);
        Book boule = new Book("Boule de Suif", 18);
        Book sodom = new Book("The 120 Days of Sodom, or the School of Libertinage", 391);
        Book sex = new Book("Sexual Behavior in the Human Male", 824);
        Book[] books = new Book[4];
        books[0] = code;
        books[1] = boule;
        books[2] = sodom;
        books[3] = sex;
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            System.out.println(pr.getName() + " - " + pr.getPages());
        }
        Book between = books[0];
        books[0] = books[3];
        books[3] = between;
        System.out.println();
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            System.out.println(pr.getName() + " - " + pr.getPages());
        }
        System.out.println();
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            if ("Clean code".equals(pr.getName())) {
                System.out.println(pr.getName() + " - " + pr.getPages());
            }
        }
    }
}
