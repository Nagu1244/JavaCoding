package stringproblems;

public class LongestPalindromeSubString {
    private int start; // variable to store the starting index of the longest palindrome
    private int maxLength; // variable to store the length of the longest palindrome

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s; // if the string length is less than 2, it is already a palindrome
        }

        for (int i = 0; i < len; i++) {
            // Check for both odd and even length palindromes
            expandFromCenter(s, i, i); // odd length
            //expandFromCenter(s, i, i + 1); // even length
        }

        return s.substring(start, start+maxLength); // return the longest palindrome substring
    }


    private void expandFromCenter(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Update start and maxLength if a longer palindrome is found
        int currLength = right - left - 1;
        if (currLength >= maxLength) {
            maxLength = currLength;
            start = left + 1;
        }
    }

    public static void main(String[] args) {
        LongestPalindromeSubString solution = new LongestPalindromeSubString();

        String input = "babad"; //baab
        String longestPalindrome = solution.longestPalindrome(input);
        System.out.println("Longest Palindromic Substring: " + longestPalindrome);
    }
}

