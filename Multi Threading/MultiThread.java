/*
class MyThread extends Thread {
    public void run() {
        // System.out.println("I am a Thread");
        Thread t = Thread.currentThread();
        System.out.println(t); 
    }
}

public class MultiThread {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        MyThread t2 = new MyThread();
        t2.start();
        // 2 Threads pushed into runnable state, anyone could be executed first and go
        // into running state
        t1.run();
        t2.run();
        // If we invoke the run() method directly, it is not multithreading, so only one
        // main thread is formed and acts as ordinary program, so one statement will
        // execute after completion of prior statement
    }
}
*/

class Thread_X extends Thread {
    public void run() {
        Thread t = Thread.currentThread();
        t.setName("Thread_X");
        for (int i = 0; i < 10; i++) {
            System.out.println(t.getName() + ": " + i);

            try {
                Thread.sleep(1000); // 1000 milli seconds (1 second)
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Thread_Y extends Thread {
    public void run() {
        Thread t = Thread.currentThread();
        t.setName("Thread_Y");
        for (int i = 11; i < 20; i++) {
            System.out.println(t.getName() + ": " + i);
            
            try{
                Thread.sleep(1000); // 
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}



public class MultiThread {
    public static void main(String[] args) {
        Thread_X t1 = new Thread_X();
        t1.start();
        Thread_Y t2 = new Thread_Y();
        t2.start();
        System.out.println();

        // t1.run();
        // t2.run();
    }
    
}

/* 
When we do t1.start(), and t2.start(), We're getting output like:
Thread_X: 0
Thread_X: 1
Thread_Y: 11
Thread_Y: 12
Thread_Y: 13
Thread_X: 2
Thread_X: 3
Thread_X: 4
Thread_X: 5
Thread_Y: 14
Thread_X: 6
Thread_Y: 15
Thread_X: 7
Thread_Y: 16
Thread_Y: 17
Thread_X: 8
Thread_Y: 18
Thread_Y: 19
Thread_X: 9

i.e. Both threads are running simultaneously, as soon as CPU is free, it runs another thread, comes out of one method and allocates time to another. 
So full CPU utilization, as CPU doesn't sit idle

But when we do t1.run() and t2.run(), we get:
Thread_X: 0
Thread_X: 1
Thread_X: 2
Thread_X: 3
Thread_X: 4
Thread_X: 5
Thread_X: 6
Thread_X: 7
Thread_X: 8
Thread_X: 9
Thread_Y: 11
Thread_Y: 12
Thread_Y: 13
Thread_Y: 14
Thread_Y: 15
Thread_Y: 16
Thread_Y: 17
Thread_Y: 18
Thread_Y: 19
It works as an ordinary program, where when we call a method, untill the method is complete, CPU doesn't give time to other method.

When sleep() is invoked on a thread, the current thread will go to block state for the given interval of time.

To make a thread go to block state, we use sleep()
*/