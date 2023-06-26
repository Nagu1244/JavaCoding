package oops;

//method overloading null check
class A{
    public Object getValue(Object o) {
      return "Bye";
    }
    public String getValue(String s){
        return "Hi";
    }
}
public class NullCheck {
    public static void main(String args[]){
        A a = new A();
        System.out.println(a.getValue(null));
    }
}
