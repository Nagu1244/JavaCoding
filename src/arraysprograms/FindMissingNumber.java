package arraysprograms;

import java.util.ArrayList;
import java.util.List;

public class FindMissingNumber {
    public static void main(String args[]) {
        int arr[] = new int[]{1,3,5,7,9,10};
        List<Integer> missingNumber = findMissingNumber(arr);
        System.out.println(missingNumber);
    }

    private static List<Integer> findMissingNumber(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<10;i++) {
            boolean found = false;
            for(int n : arr) {
                if(i==n) {
                   found = true;
                   break;
                }
            }
            if(!found) {
              list.add(i)  ;
            }

        }
       return list;
    }
}
