package arraysprograms;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String args[]) {
        int arr[] = new int[]{0, 1, 0, 3, 12};
        arr = moveZerosToLast(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] moveZerosToLast(int[] arr) {
        int left = 0;
        int right = 0;
        while (right < arr.length) {
            if (arr[right] != 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
            right++;
        }
        return arr;
    }
}
