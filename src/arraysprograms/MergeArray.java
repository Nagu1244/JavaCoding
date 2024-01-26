package arraysprograms;

import java.util.Arrays;

public class MergeArray {
    public static void main(String args[]) {
        int arr1[] = new int[]{1,2,3};
        int arr2[] = new int[]{2,5,6};
        int mergeArr[] = new int[arr1.length+arr2.length];
        //System.out.println(Arrays.toString(mergeArr));
        mergeArr = getMergeArray(arr1, arr2, mergeArr);
        System.out.println(Arrays.toString(mergeArr));

    }

    private static int[] getMergeArray(int[] arr1, int[] arr2, int[] mergeArr) {
        int i=0, j=0, k=0;
        while (i<arr1.length && j<arr2.length) {
            if(arr1[i]<arr2[j]) {
                mergeArr[k++] = arr1[i++];
            } else {
                mergeArr[k++] = arr2[j++];
            }
        }
        //copy the remaining elements
        while (i<arr1.length) {
            mergeArr[k++] = arr1[i++];
        }
        while (j<arr2.length) {
            mergeArr[k++] = arr2[j++];
        }
        return mergeArr;
    }
}
