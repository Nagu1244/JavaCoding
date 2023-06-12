package datastructure;

public class BinarysearchWithRecursion {
    public static void main(String args[]){
        int[] arr = new int[]{1,2,3,4,5,6,7};
        int searchTarget = 7;
        int targetIndex = binarySearch(arr,0, arr.length-1, searchTarget);
        System.out.println(targetIndex);
    }

    private static int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (target < arr[mid]) {
                return binarySearch(arr, start, mid - 1, target);
            } else {
                return binarySearch(arr, mid + 1, end, target);
            }
        }
        return -1;
    }
}
