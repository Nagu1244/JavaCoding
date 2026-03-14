package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CodingPro {
    public static void main(String args[]) {
        String str = "aaabbcccd";
        /**
         * Return ALL Max Frequency Characters //output a-3,c-3
         */
        Map<Character, Long> map = str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        //find max Value from map values()
        Long maxValue = map.values().stream()
                                    .sorted(Comparator.reverseOrder()).findFirst().get();
        //Long maxValue = Collections.max(map.values()); // This one also works
        Map<Character, Long> mostRepeatedCharMap = map.entrySet().stream()
                                                  .filter(entry -> entry.getValue() == maxValue)
                                                  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("max repeated characters are : " + mostRepeatedCharMap);

        /**
         * The first max repeated character;output:a-3
         */
        Character firstMostRepeatedChar = str.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).get();
        System.out.println("The first max repeated character : " + firstMostRepeatedChar);

        /**
         * First Non-Repeating Character, scenarios -> if there is no repeated character then return null value
         * If you don't use LinkedHashMap, the order won't be preserved
         */
        Character firstNonRepChar = str.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("First Non-Repeating Character : " +firstNonRepChar);

        /**
         * First Repeated Character , scenario:if all character unique then return null
         * String str = "abc" o/p -> null
         */
        String str1 = "programming";
        Character firstRepChar = str1.chars().mapToObj(c ->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 2)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("First repeated char : " +firstRepChar);
    }
}
