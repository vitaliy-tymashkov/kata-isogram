package io.tvv.kata;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/*
Given an array of integers, find the one that appears an odd number of times.

There will always be only one integer that appears an odd number of times.
*/
public class OddCounter {
    public static void main(String[] args) {
        Optional<Integer> result = Optional.empty();
        int[] input = new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5};

        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int i : input){
            if (counterMap.containsKey(i)){
                Integer value = counterMap.get(i);
                counterMap.put(i, ++value);
            } else {
                counterMap.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()){
            if (entry.getValue()%2 != 0) {
                result = Optional.ofNullable(entry.getKey());
                break;
            }
        }

        Objects.requireNonNull(result).ifPresent(System.out::println);
    }
}
