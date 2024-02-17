package arraysprograms;

import java.util.Arrays;

public class ArrayRotation {
    public static void main(String args[]) {
        int[] arr = new int[]{1,2,3,4,5};
        int k = 3 ;
        rotate(arr, k);
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+ " ");
        }
    }

    private static void rotate(int[] arr, int k) {
         k = k%arr.length;
         if(k<0) {
           k = k + arr.length;
         }
         //using partitioning
         reverse(arr, 0, k-1);
         reverse(arr, k, arr.length-1);
         reverse(arr, 0, arr.length-1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start<end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
