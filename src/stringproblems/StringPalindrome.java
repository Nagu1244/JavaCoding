package stringproblems;

public class StringPalindrome {
    public static void main(String args[]) {
        final String str = "racecar";
        boolean status = isPalindrome(str);
        System.out.println("IsPalindrome:"+status);
    }
    private static boolean isPalindrome(String str) {
        boolean isPalindrome = true;
        int start =0;
        int end = str.length()-1;
        if(str ==null || str.length()==1) {
           return true;
        }
        while (start<end) {
            if (str.charAt(start) != str.charAt(end)){
                isPalindrome=false;
                break;
            }
            else {
                start++;
                end--;
            }
        }
        return isPalindrome;
    }
}
