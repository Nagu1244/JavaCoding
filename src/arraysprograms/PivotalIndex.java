package arraysprograms;

import java.util.Arrays;

public class PivotalIndex {
    public static void main(String args[]){
        int arr[] = new int[]{1, 7, 3, 6, 5, 6};//28
        //int arr[] = new int[]{1,0,1};
        int pivotIndex = findPivotIndex(arr);
        System.out.println(pivotIndex);
    }

    private static int findPivotIndex(int[] arr) {
        int leftSum = 0;
        int rightSum = Arrays.stream(arr).sum();
        for(int i=0;i<arr.length;i++) {
            rightSum = rightSum - arr[i];
            if(leftSum == rightSum) {
                return i;
            }
            leftSum = leftSum + arr[i];
        }
        return -1;

    }
}
