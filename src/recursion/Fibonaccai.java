package recursion;

public class Fibonaccai {
    public static void main(String args[]){
        int n= 5;
        fibonaccai(n);
    }

    private static void fibonaccai(int n) {
        for(int i=0;i<n;i++){
           int number = fibonaccaiSeries(i);
           System.out.print(number+ " ");
        }
    }

    private static int fibonaccaiSeries(int n) {
        if(n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
       return fibonaccaiSeries(n-1)+ fibonaccaiSeries(n-2);
    }
}
