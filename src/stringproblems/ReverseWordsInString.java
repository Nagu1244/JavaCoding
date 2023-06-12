package stringproblems;

public class ReverseWordsInString {
    public static void main(String args[]) {
        String s = "  Java programming language ";
        /*To remove trailing spaces or multiple spaces between words*/
        s = s.trim();
        String[] strArr = s.split(" ");
        s = reverseWords(strArr);
        System.out.println(s);
    }

    private static String reverseWords(String[] strArr) {
        StringBuilder builder = new StringBuilder(strArr.length);
        for (int i = strArr.length - 1; i >= 0; i--) {
            String currentString = strArr[i];
            if (currentString.length() != 0) {
                if (builder.length() != 0) {
                    builder.append(" ");
                }
                builder.append(strArr[i]);
            }
        }
        return builder.toString();
    }
}
