package recursion;

public class RecursionDemo {
    public static void main(String args[]) {
        int n = 5;
        function(5);
    }

    private static void function(int n) {
        if (n == 0) {
            return;
        }
        function(n - 1);
        System.out.println(n);
    }
}
