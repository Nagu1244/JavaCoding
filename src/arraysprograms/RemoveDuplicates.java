package arraysprograms;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String args[]) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        int length = removeDuplicates(arr);
        System.out.println(length);
    }

    private static int removeDuplicates(int[] arr) {
        int j;
        int index=0;
        for(int i=0;i<arr.length;i++) {
            for(j=0;j<i;j++) {
                if(arr[i]==arr[j]) {
                    break;
                }
            }
            if(i==j) {
                arr[index++] = arr[i];
            }
        }
        arr =Arrays.copyOf(arr, index);
        return arr.length;
    }
}
