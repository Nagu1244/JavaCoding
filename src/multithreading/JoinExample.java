package multithreading;

public class JoinExample {
    public static void main(String args[]) {
        Thread thread1 = new Thread(new MyRunnable(), "Thread1");
        Thread thread2 = new Thread(new MyRunnable(), "Thread2");
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " Thread is running");
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+ " is running");
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+ " is completed");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
