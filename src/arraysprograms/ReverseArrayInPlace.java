package arraysprograms;

import java.util.Arrays;

public class ReverseArrayInPlace {
    public static void main(String args[]) {
        int[] arr = new int[]{1,2,3,4,5};//output {5,4,3,2,1}
        arr = swapArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] swapArray(int[] arr) {
        int start =0;
        int end = arr.length-1;
        while (start<end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
        return arr;
    }
}
