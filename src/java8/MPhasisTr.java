package java8;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MPhasisTr {
    public static void main(String args[]){
        //if i have a list of student objects,
        // from that can you create hashmap object containing id as key and name as value using stream api in java.
        String str = "AABBCDEE";
        Map<Character, Long> map=str.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

    }
}
