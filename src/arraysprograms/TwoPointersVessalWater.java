package arraysprograms;

public class TwoPointersVessalWater {
    public static void main(String args[]) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        int maxArea = highestWaterVessal(arr);
        System.out.println(maxArea);
    }

    private static int highestWaterVessal(int[] arr) {
        int maxArea = 0;
        int left = 0;
        int right = arr.length-1;
        while (left<right) {
            int minHeight  = Math.min(arr[left], arr[right]);
            int currentArea = (right-left)*minHeight;
            maxArea = Math.max(maxArea, currentArea);
            if(arr[left] < arr[right]) {
              left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
