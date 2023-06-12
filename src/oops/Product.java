package oops;

class Mac{
     private static int a;
     protected static int doSomething() {
        return a = 19;
    }
}
class Ipad extends Mac{
    /* Access modifiers order in overrding public<protected<default<private */
    public static int doSomething(){
        return 0;
    }
}
public class Product {
    public static void main(String args[]) throws Exception {
        Ipad mac = new Ipad();
        //Method hiding
            int c= mac.doSomething();
            System.out.println(c);
    }
}
