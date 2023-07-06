package stringproblems;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    public static void main(String args[]){
        String str = "abc";
        List<String> list =findAllPermutations(str.toCharArray());
        System.out.println(list);
    }

    private static List<String> findAllPermutations(char[] charArr) {
        List<String> permutation = new ArrayList<>();
        backTrack(charArr, 0, permutation);
        return permutation;
    }

    private static void backTrack(char[] charArr, int fixedIndex, List<String> permutation) {
        if(fixedIndex == charArr.length-1){
          permutation.add(String.valueOf(charArr));
          return;
        }
        for(int i=fixedIndex; i<charArr.length;i++){
          swap(charArr, fixedIndex, i);
          backTrack(charArr, fixedIndex+1, permutation);
          swap(charArr, fixedIndex, i);
        }
    }

    private static void swap(char[] chars, int fixedIndex, int i) {
        char temp = chars[i];
        chars[i] = chars[fixedIndex];
        chars[fixedIndex]= temp;
    }
}