package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CapGeminiTR {
    public static void main(String args[]) {
        List<String> list1 = Arrays.asList("A", "B", "C");
        List<String> list2 = Arrays.asList("D", "A", "C");
        List<String> list3 = list1.stream().filter(s -> list2.contains(s)).collect(Collectors.toList());
        System.out.println(list3);
    }
}
