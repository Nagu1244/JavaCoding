package stringproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
/*  Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
    Note that the same word in the dictionary may be reused multiple times in the segmentation.
    Example 1:

    Input: s = "leetcode", wordDict = ["leet","code"]
    Output: true
    Explanation: Return true because "leetcode" can be segmented as "leet code".*/
    public static void main(String args[]){
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
        wordBreak(s, wordDict);
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // Create a boolean array to store the results of subproblems
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Set the first element as true since an empty string can always be segmented

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }


}
