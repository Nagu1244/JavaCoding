package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalDemo {

    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1,11,21,32);
        List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctList);

        List<Integer> evenIntList = list.stream().filter(n -> n%2 ==0).collect(Collectors.toList());
        System.out.println(evenIntList);

        List<String> list1 =list.stream().map(n -> n+"").filter(number -> number.startsWith("1")).collect(Collectors.toList());
        System.out.println(list1);
    }
}
