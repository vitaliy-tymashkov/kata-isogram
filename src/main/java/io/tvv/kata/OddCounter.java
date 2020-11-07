package io.tvv.kata;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Given an array of integers, find the one that appears an odd number of times.

There will always be only one integer that appears an odd number of times.
*/
public class OddCounter {
    public static void main(String[] args) throws Exception {
        int[] input = new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5};

        System.out.println(method1(input));
        System.out.println(method2(input));
        System.out.println(method3(input));
        System.out.println(method4(input));
        System.out.println(method5(input));
    }

    private static Integer method5(int[] input) {
        return Arrays.stream(input)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() % 2 == 1)
                .mapToInt(e -> e.getKey())
                .findFirst()
                .getAsInt();
    }


    private static Integer method4(int[] input) {
        int odd=0;
        for (int item: input)
        {
            // XOR will cancel out everytime you XOR with the same number
            // so 1^1=0 but 1^1^1=1 so every pair should cancel out leaving the odd number out
            odd = odd ^ item;
        }

        return odd;
    }

    private static Integer method3(int[] input) {
        int xor = 0;
        for (int value : input) {
            xor ^= value;
        }
        return xor;
    }

    private static Integer method2(int[] input) {
        return Arrays.stream(input).reduce(0, (x, y) -> x ^ y);
    }

    private static Integer method1(int[] input) throws Exception {
        Optional<Integer> result = Optional.empty();
        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int i : input) {
            if (counterMap.containsKey(i)) {
                Integer value = counterMap.get(i);
                counterMap.put(i, ++value);
            } else {
                counterMap.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                result = Optional.ofNullable(entry.getKey());
                break;
            }
        }

        return result.orElseThrow(() -> new Exception("Null result"));
    }
}
