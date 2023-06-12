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

    private static void backTrack(char[] charArr, int index, List<String> permutation) {
        if(index == charArr.length-1){
          permutation.add(String.valueOf(charArr));
          return;
        }
        for(int i=index; i<charArr.length;i++){
          swap(charArr, index, i);
          backTrack(charArr, index+1, permutation);
          swap(charArr, index, i);
        }
    }

    private static void swap(char[] chars, int start, int i) {
        char temp = chars[i];
        chars[i] = chars[start];
        chars[start]= temp;
    }
}