
package com.learn.datastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FindNonRepetitiveCharacterInAString {
    public static void main(String[] args) {
        String input = "ABCDDEFGHHIJKLLMNNOPQPR";
        List<Character> list = new ArrayList<>();
        char ch = 'A';
        list.add('A');
        list.add('C');
        list.add('D');
        list.add('E');
        list.remove((Character) ch);//here ch should be converted to Character object, otherwise ch asci value would be replaced
        // and searching with that value.

        // nonRepetitive(input);//o(n2)
        nonRepeatingChar(input);


    }

    /*public static char firstNonRepeatingChar(String word) {
        Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (repeating.contains(letter)) {
                continue;
            }
            if (nonRepeating.contains(letter)) {
                nonRepeating.remove((Character) letter);
                repeating.add(letter);
            } else {
                nonRepeating.add(letter);
            }
        }
        return nonRepeating.get(2);
    }*/
    private static void nonRepeatingChar(String input) {
        Set<Character> repetative = new HashSet<>();
        List<Character> nonRepeative = new ArrayList<Character>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (repetative.contains(ch)) {
                continue;
            }
            if (nonRepeative.contains(ch)) {
                //System.out.println("ch==" + (Character) ch);
                nonRepeative.remove((Character) ch);
                repetative.add(ch);
    
            } else {
                nonRepeative.add(ch);
            }
        }
        System.out.println(">>" + nonRepeative.get(2));
    }

    private static void nonRepetitive(String input) {
        //time space is o(n2) which is not acceptable
        int count = 0;
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < input.length() - 1; i++) {
            if (map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
            } else {
                map.put(input.charAt(i), 1);
            }
        }
        for (Entry<Character, Integer> s : map.entrySet()) {
            if (s.getValue() == 1 && count <= 8) {
                count++;

            }
            if (count == 8) {
                System.out.println(s.getKey());
                break;
            }
        }
    }

}
