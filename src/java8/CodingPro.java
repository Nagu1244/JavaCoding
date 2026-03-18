package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println("First repeated char : " +firstRepChar);

        /**
         * Reverse a String using java8
         * spaces considered as a character o/p->margorp avaJ
         */
        String str3 = "Java program";
        String reverseStr = IntStream.range(0, str3.length())
                .mapToObj(i -> str3.charAt(str3.length()-1-i))
                .map(c -> String.valueOf(c))
                .collect(Collectors.joining());
        System.out.println(reverseStr);

        //We can use reduce method also to reverse the string
        String reversed = Arrays.stream(str3.split(""))
                .reduce("", (a, b) -> b + a);
        System.out.println(reversed);

        /**
         * Reverse a word in a sentence, o/p->language Programming Java
         */
        String str11 = "Java Programming language";
        String[] words = str11.split(" ");
        String reverseWordsSentence = IntStream.range(0, words.length)
                .mapToObj(i -> words[words.length-1-i])
                .collect(Collectors.joining(" "));
        System.out.println(reverseWordsSentence);

        /**
         * Reverse each word but keep order :o/p->avaJ gnimmargorp egaugnal
         */
        String str6 = "Java programming language";
        String revSentStr = Arrays.stream(str6.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println(revSentStr);

        /**
         * Find Duplicate characters in String
         */
        String str4 = "programming";
        List<Character> duplicateList = str4.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(duplicateList);

        /**
         * Second highest number
         */
        List<Integer> integerList = List.of(1,2,3,4,5);
        int secondMaxNumber = integerList.stream().sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(secondMaxNumber);


    }
}
