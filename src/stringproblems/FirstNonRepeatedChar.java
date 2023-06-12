package stringproblems;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedChar {
    public static void main(String args[]){
        String str= "aaa";
        str=str.toLowerCase().replace(" ", "");
        char ch= firstNonRepeatedChar(str);
        System.out.println(ch);
    }

    private static char firstNonRepeatedChar(String str) {

        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0;i<str.length();i++) {
           char ch= str.charAt(i);
           if (map.containsKey(ch)){
               map.put(ch, map.getOrDefault(ch, 0)+1);
           } else {
               map.put(ch, 1);
           }
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return '\0';
    }
}
