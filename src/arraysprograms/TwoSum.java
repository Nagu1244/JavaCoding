package arraysprograms;

import java.util.Arrays;

public class TwoSum {
    public static void main(String args[]){
        int[] arr= new int[]{3,2,4};
        int targetSum = 6;
        int[] arr1 = twoSum(arr, targetSum);
        System.out.println(Arrays.toString(arr1));

    }

    private static int[] twoSum(int[] arr, int targetSum) {
        int left = 0;
        int right = arr.length-1;
        while (left<right) {
            int currentSum = arr[left] + arr[right];
            if(currentSum == targetSum) {
                return new int[]{left, right};
            } else if (targetSum>currentSum) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1,-1};
    }
}
