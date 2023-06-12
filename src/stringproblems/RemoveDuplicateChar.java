package stringproblems;

import java.util.Arrays;

public class RemoveDuplicateChar {
    public static void main(String args[]) {
        String str = "java programming";
        str = str.toLowerCase().replace(" ", "");
        char[] ch = removeDuplicates(str.toCharArray());
        System.out.println(ch);
    }

    private static char[] removeDuplicates(char[] ch) {
        int index = 0;
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
        return String.valueOf(Arrays.copyOf(ch, index)).toCharArray();
    }
}
