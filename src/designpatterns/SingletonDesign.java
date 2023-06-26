package designpatterns;

public class SingletonDesign {
    public static void main(String args[]){
        Thread t1= new Thread(() -> {
            AppleStoreApp app = AppleStoreApp.getInstance();
        });

        Thread t2= new Thread(() -> {
            AppleStoreApp app = AppleStoreApp.getInstance();
        });
        t1.start();
        t2.start();
    }
}

class AppleStoreApp {
    //static AppleStoreApp appleStoreApp = new AppleStoreApp();//This eagarly instantiating the object
    static AppleStoreApp app;
    private AppleStoreApp() {
        System.out.println("One instance created");
    }
   public  static AppleStoreApp getInstance() {
        if(app == null) {
            synchronized (AppleStoreApp.class){ //Double checking locking
                if (app == null){
                    app = new AppleStoreApp();
                }
            }
        }
        return app;
    }
}