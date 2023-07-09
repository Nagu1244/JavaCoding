package arraysprograms;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {0}; // Sorted array 1 with extra space
        int[] nums2 = {1}; // Sorted array 2
        int m = 0; // Number of elements in array 1 (excluding extra space)
        int n = 1; // Number of elements in array 2

        merge(nums1, m, nums2, n);

        // Print the merged array
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for nums1
        int j = n - 1; // Pointer for nums2
        int k = m + n - 1; // Pointer for merged array

        while (i >= 0 && j >= 0) {
            // Compare elements from both arrays and place the larger element in the merged array
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are any remaining elements in nums2, copy them to the merged array
        /*while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }*/
    }
}

