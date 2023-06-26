package oops;

public class AppleProduct implements IPadMini, IPadPro{
    public static void main(String args[]){
        AppleProduct appleProduct = new AppleProduct();
        appleProduct.getColor();
    }


    @Override
    public void getColor() {
        IPadMini.super.getColor();
    }
}

interface IPadMini{
    default void getColor(){
        System.out.println("IPasMini color is red");
    }
}
interface IPadPro{
    default void getColor(){
        System.out.println("IPadPro in white color");
    }
}
