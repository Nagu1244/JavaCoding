package java8;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CodeDecode {
    public static void main(String args[]){
        String str = "Java Developer";
        //most repeated character
        str =str.toLowerCase().replace(" ", "");
        Character ch =str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())//.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())
                .map( Map.Entry::getKey)
                .orElse('\0');
        System.out.println(ch);

        //Sort list in descending order of length
        List<String> list = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        list = list.stream().sorted((s1, s2) -> Integer.compare(s2.length(), s1.length())).collect(Collectors.toList());
        System.out.println(list);

        //Second highest value in array
        int[] arr = new int[]{12,1,20,23,34};
        int secondMaxValue = Arrays.stream(arr)
                .boxed()
                .sorted((a1, a2)-> a2.compareTo(a1))
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(secondMaxValue);
        //First max value
        int firstMax = Arrays.stream(arr)
                .boxed()
                .sorted((n1, n2)-> n2.compareTo(n1))
                .findFirst()
                .orElse(null);
        System.out.println(firstMax);

        //remove duplicates from list
        List<Integer> intList = Arrays.asList(1,1,2,3,2);
        intList = intList.stream().distinct().collect(Collectors.toList());
        System.out.println(intList);

        //using set we can remove duplicates
        intList = intList.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());

        //remove null values
        List<String> listCities = Arrays.asList("Hyderabad", "Manglore", null, null);
        listCities =listCities.stream().filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println(listCities);

        //checking substring present in list
        List<String> fruitsList = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        String subString = "ana";
        boolean isPresent = fruitsList.stream().anyMatch(word -> word.contains(subString));
        System.out.println(isPresent);

        //Maximum Salary in Map
        Map<String, Double> map = new HashMap<>();
        map.put("A", 25000.00);
        map.put("B", 30000.00);
        map.put("C", 45000.00);
        map.put("D", 25000.00);
        Double maxSalary = map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder((v1, v2)-> v1.getValue().compareTo(v2.getValue())))
                        .findFirst().orElse(null).getValue();
        System.out.println(maxSalary);

        //Second max salary
        Double secondMaxSalary =map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .skip(1)
                .findFirst().orElse(null).getValue();
        System.out.println(secondMaxSalary);

        //get the name of employees who has max salary
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("anil", 1000);
        map2.put("ankit", 1200);
        map2.put("bhavna", 1200);
        map2.put("james", 1200);
        map2.put("micael", 1000);
        map2.put("tom", 1300);
        map2.put("daniel", 1300);

        Map.Entry<Integer, List<String>> maxSalaryNames = map2.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted((k1, k2) -> k2.getKey().compareTo(k1.getKey())) // .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList()).get(0);

        System.out.println(maxSalaryNames);

        // Duplicate chars and it's count
        String str1 = "abcabcd"; //a->2, b->2,c->2
        Map<Character, Long> duplicateCharCount =str1.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue()>1)
                .collect(Collectors.toMap(entry-> entry.getKey(), entry->entry.getValue()));
        System.out.println(duplicateCharCount);
        //First non repeated char
        String str2= "abcabcd";
        Map<Character, Integer> firstNonRepeatedChar = new HashMap<>();
        str2.chars().mapToObj(c-> (char)c)
                .forEach(c -> firstNonRepeatedChar.put(c, firstNonRepeatedChar.getOrDefault(c, 0)+1));
        System.out.println(firstNonRepeatedChar);

        //first non repeated character in a String
        Character firstNonReapeatedChar= str1.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue()==1)
                .map(Map.Entry::getKey).findFirst().orElse('\0');
        System.out.println(firstNonReapeatedChar);
    }
}
