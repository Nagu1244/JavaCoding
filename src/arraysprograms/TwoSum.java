package arraysprograms;

import java.util.Arrays;

public class TwoSum {
    public static void main(String args[]){
        int[] arr= new int[]{1,2,3,3};
        int targetSum = 6;
        int[] arr1 = twoSum(arr, targetSum);
        System.out.println(Arrays.toString(arr1));

    }

    private static int[] twoSum(int[] arr, int targetSum) {
        for(int i=0;i<arr.length;i++){
            for(int j= i+1;j<arr.length;j++){
                if(arr[i]+arr[j] == targetSum) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
