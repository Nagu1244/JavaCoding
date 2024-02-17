package arraysprograms;

import java.util.Arrays;
import java.util.Collections;

public class FirstMaximumNumber {
    public static void main(String args[]) {
        int[] arr = new int[]{12,34,23,56,78,2};
        //Java8
        int max = Arrays.stream(arr)
                .boxed().sorted(Collections.reverseOrder()).findFirst().get();
        System.out.println(max);
        int secondMax = Arrays.stream(arr)
                .boxed().sorted(Collections.reverseOrder()).skip(1).findFirst().get();
        System.out.println(secondMax);

        int maxNumber = getMaximumNumber(arr);
        System.out.println(maxNumber);
    }

    private static int getMaximumNumber(int[] arr) {
        int n= arr.length;
        int firstMax = arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>firstMax){
                firstMax = arr[i];
            }
        }
        return firstMax;
    }
}
