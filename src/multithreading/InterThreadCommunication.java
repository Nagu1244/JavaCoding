package multithreading;

import java.util.LinkedList;
import java.util.Queue;

class Producer implements Runnable {
    private final Queue<Integer> queue;
    private final int maxSize;

    public Producer(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        int value = 0;
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        queue.wait(); // Wait if the queue is full
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Producer produced: " + value);
                queue.add(value++);
                queue.notifyAll(); // Notify consumer threads
            }
        }
    }
}

class Consumer implements Runnable {
    private final Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait(); // Wait if the queue is empty
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int value = queue.poll();
                System.out.println("Consumer consumed: " + value);
                queue.notifyAll(); // Notify producer threads
            }
        }
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 5;

        Thread producerThread = new Thread(new Producer(queue, maxSize));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();
    }
}

