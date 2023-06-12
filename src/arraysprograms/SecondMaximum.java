package arraysprograms;

public class SecondMaximum {
    public static void main(String args[]){
        int[] arr = new int[]{13,12,12,10,23};//14,12,13
        int secondMax = findSecondMax(arr);
        System.out.println(secondMax);
    }

    private static int findSecondMax(int[] arr) {
        int firstMax = arr[0];
        int secondMax = arr[1];
        if(firstMax > secondMax){
            firstMax = arr[0];
            secondMax = arr[1];
        }
        else {
            firstMax = arr[1];
            secondMax = arr[0];
        }
        for (int i=2;i<arr.length;i++) {
            if(arr[i] > firstMax) {
                secondMax = firstMax;
                firstMax = arr[i];
            } else if(arr[i]< firstMax && arr[i]>secondMax) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }
}
