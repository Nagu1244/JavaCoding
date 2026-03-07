package arraysprograms;

public class SlidingWindowMaxSum {
    public static void main(String args[]){
        int[] arr = new int[]{2,9,31,-4,21,7};
        /**
         * first window from 0 to 2 index sum = 42
         * 3 index->move one window and add that window and subtract earlier window from current window sum
         *
         */
        int k = 3;
        int maxWindowSum = getMaximumWindowSize(arr, k);
        System.out.println("Maximum window with size" + k + "sum is :" +maxWindowSum);
    }

    private static int getMaximumWindowSize(int[] arr, int k) {
        int wSum = 0;
        int mSum = Integer.MIN_VALUE;
        for(int i=0;i<k;i++) {
           wSum = wSum + arr[i];
        }
        for(int i=k;i<arr.length;i++) {
            wSum = wSum - arr[i-k]+arr[i];
            mSum = Math.max(wSum, mSum);
        }
        return mSum;
    }
}
