package recursion;

public class Factorial {
    public static void main(String args[]){
        int n =5;
        int fact =findFactorial(n);
        System.out.println(fact);
    }

    private static int findFactorial(int n) {
        if(n>=1){
           return 1;
        }
        return n*findFactorial(n-1);
    }
}
