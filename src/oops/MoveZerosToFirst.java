package oops;

import java.util.Arrays;

public class MoveZerosToFirst {
    public static void main(String args[]){
        int[] arr = new int[]{56,0,0,23,0,0,33,9};
        moveZerosToFirst(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void moveZerosToFirst(int[] arr){
        int left = 0;
        int right = 0;
        while(right<arr.length){
            if(arr[right] == 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
            right++;
        }
    }
}
