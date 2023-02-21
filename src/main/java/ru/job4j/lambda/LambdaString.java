package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaString {
    public static void main(String[] args) {
        String[] strings = {
                "image 1",
                "image 33",
                "image 222"
        };
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Comparator<String> cmpDescSize = (left, right) -> Integer.compare(right.length(), left.length());
        Arrays.sort(strings, cmpText);
        for (String str : strings) {
            System.out.println(str);
        }
        System.out.println();
        Arrays.sort(strings, cmpDescSize);
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
