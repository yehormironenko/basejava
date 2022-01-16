package ru.javawebinar.basejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainStreams {
    public static void main(String[] args) {

        int[] arr = new int[]{2, 4, 1, 1, 8, 2, 2, 4, 5};

        // System.out.println(minValue(arr));

        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 6, 7, 3, 4, 5));

        System.out.println(oddOrEven(integers));
    }


    public static int minValue(int[] values) {

        IntStream intStream = Arrays.stream(values);
        String result = intStream.sorted().distinct().mapToObj(i -> ((Integer) i).toString()).collect(Collectors.joining());

        return Integer.parseInt(result);
    }

    public static List<Integer> oddOrEven(List<Integer> integers) {

        int sumOfEven = integers.stream().map(i -> i % 2 == 1 ? i : 0).reduce(0, Integer::sum);
        System.out.println(sumOfEven);


        if (sumOfEven % 2 == 0) {
            return integers.stream().filter(i -> i % 2 == 1).collect(Collectors.toList());
        } else {
            return integers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        }

    }


}
