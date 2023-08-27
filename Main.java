package com.chat;

import java.text.Collator;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Map<Integer, List<User>> map = new HashMap<>();
        List<User> userList;
        String name;
        Integer age;

        for (int i = 1; i < 6; i++) {
            System.out.println("Введите имя " + i + "-го пользователя");
            name = in.nextLine();

            System.out.println("Введите возраст " + i + "-го пользователя");
            age = Integer.parseInt(in.nextLine());

            if (!map.containsKey(age)) {
                map.put(age, new ArrayList<User>());
            }

            userList = map.get(age);
            userList.add(new User(name, age));
            map.put(age, userList);
        }

        System.out.println("Введите желаемый возраст");
        age = Integer.parseInt(in.nextLine());

        if (map.containsKey(age)) {
            Comparator<User> comparator = (user1, user2) -> {
                Collator collator = Collator.getInstance(new Locale("ru","RU"));
                return collator.compare(user1.getName(), user2.getName());
            };
            map.get(age).sort(comparator);

            for (User user : map.get(age)) {
                System.out.println(user.toString());
            }
        } else {
            System.out.println("Такого возраста нет.");
        }
    }
}
