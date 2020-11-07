package io.tvv.kata;

import java.util.Set;
import java.util.stream.Collectors;

/**
An isogram is a word that has no repeating letters, consecutive or non-consecutive.
Implement a function that determines whether a string that contains only letters is an isogram.
Assume the empty string is an isogram. Ignore letter case.

isIsogram "Dermatoglyphics" == true
isIsogram "aba" == false
isIsogram "moOse" == false -- ignore letter case
*/
public class App {
    public static void main(String[] args) {
        String str = "Dermatoglyphics";

        Set<Character> charsSet = str.toLowerCase()
                .chars()
                .mapToObj(e -> (char)e)
                .collect(Collectors.toSet());
        boolean result = (charsSet.size() == str.length());

        System.out.println(result);
    }
}
