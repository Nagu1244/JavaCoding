package datastructure;


public class BinarySearch {
    public static int binarySearch(int[] num, int target){
        int start = 0;
        int end = num.length-1;
        while(start<=end){
            int mid = (start + end)/2;
            if(num[mid] == target){
                return mid;
            }
            if(target>num[mid]){
                start = mid + 1;
            }
            else if(target < num[mid]){
                end = mid - 1;
            }

        }
        return -1;
    }
    public static void main(String args[]){
      int[] arr = {1,3,4,5,6};
      int target = 4;
      int searchedIndex = binarySearch(arr, target);
      System.out.println("Target element found at index postion:"+searchedIndex);
    }
}
