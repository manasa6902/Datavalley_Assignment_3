/*2. Write a java program to implement synchronization, write clear java coding steps how to do synchronization with java thread objects. */

class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int getCount() {
        return count;
    }
}

class Incrementer implements Runnable {
    private Counter counter;

    public Incrementer(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

class Decrementer implements Runnable {
    private Counter counter;

    public Decrementer(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.decrement();
        }
    }
}

public class SynchronizationExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread incrementThread = new Thread(new Incrementer(counter));
        Thread decrementThread = new Thread(new Decrementer(counter));

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}
