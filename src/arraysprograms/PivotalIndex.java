package arraysprograms;

public class PivotalIndex {
    public static void main(String args[]){
        int arr[] = new int[]{1, 7, 3, 6, 5, 6};
        int pivotIndex= findPivotIndex(arr);
        System.out.println(pivotIndex);
    }

    private static int findPivotIndex(int[] arr) {
        int leftSum =0;
        int rightSum=0;
        for (int i:arr) {
         rightSum = rightSum + arr[i];
        }
        for (int i=0;i<arr.length;i++) {
           leftSum = leftSum + arr[i];
           if (leftSum == rightSum) {
               return i;
           }
           rightSum = rightSum-arr[i];
        }
        return -1;
    }
}
