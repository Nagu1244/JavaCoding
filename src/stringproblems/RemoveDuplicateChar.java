package stringproblems;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateChar {
    public static void main(String args[]) {
        String str = "java programming";
        str = str.toLowerCase().replace(" ", "");
        String uniqueString = removeDuplicates(str.toCharArray());
        System.out.println(uniqueString);
    }

    private static String removeDuplicates(char[] ch) {
        /*int index = 0;
        for (int i = 0; i < ch.length; i++) {
            int j;
            for (j = 0; j < i; j++) {
                if (ch[i] == ch[j]) {
                    break;
                }
            }
            if (i == j) {
                ch[index++] = ch[i];
            }
        }
        return String.valueOf(Arrays.copyOf(ch, index)).toCharArray();*/
        StringBuilder builder = new StringBuilder();
        Set<Character> set = new LinkedHashSet<>();
        for (int i=0;i<ch.length;i++) {
            set.add(ch[i]);
        }

        for (Character character : set) {
            builder.append(character);
        }
        return builder.toString();
    }
}
