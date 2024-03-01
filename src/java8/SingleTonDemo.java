package java8;

public class SingleTonDemo {
    public static void main(String args[]){
        Thread t1 = new Thread(()->{
            AppleStoreApp app =AppleStoreApp.getInstance();
        });

        Thread t2 = new Thread(()->{
            AppleStoreApp app =AppleStoreApp.getInstance();
        });
        t1.start();
        t2.start();

    }
}

class AppleStoreApp {
    private static AppleStoreApp appleStoreApp ;

    private AppleStoreApp() {
        System.out.println("Only one instance is created");
    }

    public static AppleStoreApp getInstance() {
        if(appleStoreApp == null) {
            synchronized (AppleStoreApp.class){
                if(appleStoreApp == null) {
                   appleStoreApp = new AppleStoreApp();
                }
            }
        }
        return appleStoreApp;
    }
}