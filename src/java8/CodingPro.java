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
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey).findFirst().get();
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
         * Second highest number
         */
        List<Integer> integerList = List.of(1,2,3,4,5);
        int secondMaxNumber = integerList.stream().sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(secondMaxNumber);

        int listSum = integerList.stream()
                .mapToInt(Integer::intValue).sum();
        System.out.println(listSum);

        List<Integer> intList = Arrays.asList(22,12,15,124,34,9);
        //get the numbers which starts from 1
        List<Integer> listWith1 = intList.stream().map(n -> n + "").filter(s -> s.startsWith("1")).map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(listWith1);

        //get common elements from list
        List<String> list1 = Arrays.asList("A", "B", "C");
        List<String> list2 = Arrays.asList("D", "A", "C");
        List<String> list3 = list1.stream().filter(s -> list2.contains(s)).collect(Collectors.toList());
        System.out.println(list3);

        /**
         * Find longest string in list
         */
        List<String> list = Arrays.asList("Java","SpringBoot","Microservices");
        String longestStr = list.stream().sorted(Comparator.comparingInt(String::length).reversed()).findFirst().orElse(null);
        System.out.println(longestStr);

        /**
         * find duplicate elements in list
         * remove deplicate elements just remove ! in !hashset.add
         */
        List<Integer> listInt = Arrays.asList(12,12,23,13,23);
        Set<Integer> hashSet = new HashSet<>();
        List<Integer> duplicateNumbers = listInt.stream().filter( n -> !hashSet.add(n)).collect(Collectors.toList());
        System.out.println(duplicateNumbers);

        /**
         * Find the sum of elements
         */
        List<Integer> list4 = Arrays.asList(1,2,3,4,5,6);
        int sumList = list4.stream()
                .mapToInt(Integer::intValue).sum();
        System.out.println(sumList);

        /**
         * find sum of even numbers
         */
        int evenNumbersSum = list4.stream().filter(n -> n%2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println(evenNumbersSum);

        /**
         * Partitioning even and odd
         */
        Map<Boolean, List<Integer>> evenOddList = list4.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(evenOddList);
    }
}
