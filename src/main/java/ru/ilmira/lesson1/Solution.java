package ru.ilmira.lesson1;

import ru.ilmira.lesson1.task3.Apple;
import ru.ilmira.lesson1.task3.Box;
import ru.ilmira.lesson1.task3.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        // № 1
        System.out.println("Задание №1");

        String[] str = {"B", "A", "C", "D"};
        System.out.println("До: " + Arrays.toString(str));
        swap(str, 0, 1);

        Integer[] num = {1, 3, 2};
        System.out.println("До: " + Arrays.toString(num));
        swap(num, 1, 2);
        System.out.println();

        // № 2
        System.out.println("Задание №2");

        String[] arr = {"k", "i", "n", "g"};
        convertToArrayList(arr);

        String[] arr2 = {"AB", "CD", "EF"};
        convertToArrayList2(arr2);
        System.out.println();

        Integer[] arr3 = {1, 2, 3, 4};
        convertToArrayList3(arr3);
        System.out.println('\n');


        // № 3
        System.out.println("Задание №3");

        Box<Apple> appleBox1 = new Box<>();
        appleBox1.addFruits(new Apple[]{new Apple(), new Apple()});
        System.out.println("Вес коробки с яблоками: " + appleBox1.getWeight());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruits(new Apple[]{new Apple(), new Apple(), new Apple(), new Apple()});
        System.out.println("Вес коробки с яблоками: " + appleBox2.getWeight());
        System.out.println();

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.addFruits(new Orange[]{new Orange(), new Orange(), new Orange()});
        System.out.println("Вес первой коробки с апельсинами: " + orangeBox1.getWeight());

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox2.addFruits(new Orange[]{new Orange(), new Orange()});
        System.out.println("Вес второй коробки с апельсинами: " + orangeBox2.getWeight());
        System.out.println();

        // сравниваем
        System.out.println(appleBox1.compare(orangeBox1) ? "Вес коробок одинаковый" : "Вес коробок неодинаковый");
        System.out.println(appleBox1.compare(orangeBox2) ? "Вес коробок одинаковый" : "Вес коробок неодинаковый");
        System.out.println();

        // перекладываем
        appleBox1.passToBox(appleBox2);
        System.out.println("Вес первой коробки с яблоками: " + appleBox1.getWeight());
        System.out.println("Вес второй коробки с яблоками: " + appleBox2.getWeight());
        System.out.println();

        orangeBox2.passToBox(orangeBox1);
        System.out.println("Вес первой коробки с апельсинами: " + orangeBox1.getWeight());
        System.out.println("Вес второй коробки с апельсинами: " + orangeBox2.getWeight());

    }

    public static void swap(Object[] array, int a, int b) {
        Object tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
        System.out.println("Результат перестановки: " + Arrays.toString(array));

    }

    // Первый вариант к заданию №2,использование метода Arrays.asList ()
    public static <T> void convertToArrayList(T[] array) {
        ArrayList<T> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("Результат преобразования: " + list);

    }

    // Второй вариант к заданию №2, использование метода Arrays.stream.collect()
    public static <T> void convertToArrayList2(T[] arr) {
        ArrayList<T> list = (ArrayList<T>)
                Arrays.stream(arr)
                        .collect(Collectors.toList());
        System.out.print("Результат преобразования: " + list);
    }

    // Третий вариант к заданию №2, использование метода Collections.addAll()
    public static <T> void convertToArrayList3(T[] arr) {
        ArrayList<T> list = new ArrayList<>();
        Collections.addAll(list, arr);
        System.out.print("Результат преобразования: " + list);

    }
}
