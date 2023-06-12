package stringproblems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCharactersCount {
    public static void main(String args[]){
        String str = "abcdabc";
        countDuplicates(str);
    }

    private static void countDuplicates(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i=0;i<str.length();i++){
            char ch =str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            } else {
                map.put(ch, 1);
            }
        }
        Set<Character> charSet = map.keySet();
        for (Character currentChar:charSet){
            if(map.get(currentChar)>1) {
                System.out.println(currentChar + " is repeated " + map.get(currentChar) + " times");
            }
        }
    }
}
