package stringproblems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MostRepeatedChar {
    public static void main(String args[]) {
        String str = "abcaabcb";
        Character ch = findMostRepeatedCharacter(str);
        System.out.println(ch);
    }

    private static char findMostRepeatedCharacter(String str) {
        char mostRepeatedChar = 0;
        int maxCharCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            } else {
                map.put(ch, 1);
            }
        }
       Set<Character> charSet = map.keySet();
       Iterator<Character> itr = charSet.iterator();
       while (itr.hasNext()){
          char ch = itr.next();
          if(map.get(ch)>maxCharCount) {
              mostRepeatedChar = ch ;
              maxCharCount = map.get(ch);
          }
       }
      return mostRepeatedChar;
    }
}
