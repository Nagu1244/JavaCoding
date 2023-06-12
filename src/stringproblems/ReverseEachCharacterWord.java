package stringproblems;

public class ReverseEachCharacterWord {
    public static void main(String args[]){
        String str = "Java programming language";
        str =reverseWordChar(str);
        System.out.println(str);
    }

    private static String reverseWordChar(String str) {
        StringBuilder builder = new StringBuilder();
        String[] strArr=str.split(" ");

        for (int i=0;i< strArr.length;i++) {
            String  reverseWordChar = "";
            String word = strArr[i];
            for (int j=word.length()-1;j>=0;j--) {
                reverseWordChar = reverseWordChar+word.charAt(j);
            }
            if(builder.length()!=0) {
                builder.append(" ");
            }
            builder.append(reverseWordChar);
        }
        return builder.toString();
    }
}
