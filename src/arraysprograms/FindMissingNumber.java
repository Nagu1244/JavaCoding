package arraysprograms;

public class FindMissingNumber {
    public static void main(String args[]) {
        int arr[] = new int[]{1,2,3,4,5};
        int missingNumber = findMissingNumber(arr);
        System.out.println(missingNumber);
    }

    private static int findMissingNumber(int[] arr) {
        int left = 0;
        int right =1;
        while (right<arr.length) {
           int diff =arr[right]-arr[left];
           if(arr[left]<arr[right] && diff==1) {
               left++;
               right++;
           } else {
               return arr[left]+1;
           }
        }
        return 0;
    }
}
