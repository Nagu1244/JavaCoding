package stringproblems;

import java.util.*;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args) {
        String s = "abcabcd";
        Map<Character, Integer> map = lengthOfLongestSubstring(s);
        String subString = "";
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            subString = subString + entry.getKey();
        }
        System.out.println(subString);
    }

    private static Map<Character, Integer> lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        while (right<s.length() && left<=right){
            char currentChar= s.charAt(right);
            if (charMap.containsKey(currentChar)) {
                left = charMap.get(currentChar) + 1;
            }
            maxLength = Math.max(maxLength, right-left+1);
            charMap.put(currentChar, right);
            right++;
        }

        return charMap;
    }
}