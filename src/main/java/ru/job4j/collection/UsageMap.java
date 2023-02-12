package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("kuryanov.vlad@yandex.ru", "Kuryanov Vladislav");
        map.put("timon@yandex.ru", "Timon");
        map.put("pumba@yandex.ru", "Pumba");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println("key - " + key + ", value - " + value);
        }
        System.out.println("");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("kuryanov.vlad@yandex.ru", "Kuryanov Vladislav");
        map2.put("timon@yandex.ru", "Timon");
        map2.put("pumba@yandex.ru", "Pumba");
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key - " + key + ", value - " + value);
        }
    }
}
