package arraysprograms;

public class SubArrayMaxSum {
    public static void main(String args[]) {
        int[] arr= new int[]{1,2,3,4,5,6,7,8,9,10};
        int k=4; //window size
        int maxSum = subStringMaxSum(arr, k);
        System.out.println(maxSum);
    }

    private static int subStringMaxSum(int[] arr, int k) {
        int maxSum=0;
        for(int i=0;i<k;i++){
            maxSum+=arr[i];
        }
        //Sliding window technque;
        int windowSum = maxSum;
        for(int i=k;i<arr.length;i++){
            //update next window as current window and substract previous windows
           windowSum = windowSum+arr[i]-arr[i-k] ;
           maxSum = Math.max(windowSum, maxSum);
        }
        return maxSum;
    }
}
