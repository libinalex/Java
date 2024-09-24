/* 
- A thread is a light weight process under execution within a process
- Multithreading is used to increase the performance of application.

Creating Threads:

#1: By creating a class which extends Thread class
    - Thread is a concrete class, i.e. fully implemented, not abstract (does not have any abstract methods)
    - Therefore, we need not override any method compulsarily
    - But as a programmer, we have to override the run() method, and ther we have to specify the logic of the thread.
    - We can invoke the run() method by creating an object of the MyThread class and invoke it using obj.start() method
    - So, by using the start() method, the object will become a thread and internally invoke run() method.


State Transition Diagram of a thread:

                           New {MyThread t = new MyThread}
                            |      \
                            |          \
                            |start()      \ stop()
                            |                \
                            |                   \           
              run()         \/         stop()      \
Running <--------------- Runnable ----------------> Dead
                          /\  |                       /
     After I/O operations |   | I/O operations     /
            After sleep() |   | sleep()         /
   notify() / notifyAll() |   | wait()      / stop()
                          |   |        /              
                          |   \/   /
                         Blocked



*/

/*
class MyThread extends Thread { 
    public void run() {
        System.out.println("I am a thread");
    }
}

public class Basics {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start(); // creates a thread and invokes run()
    }
}
*/



/* 

#2- By creating a class which implements Runnable interface

- When we wish to extend a class and also make it as Thread to perform Multithreading, we need to implement Runnable interface, as java doesn't support multiple inheritance directly.

- Once we implement Runnable, it is mandatory to override run() method, {when we extend Thread class it was optional to override run() method}

- If we invoke method using start(), the Thread_R doesn't have start() method, So create object of Thread class, and invoke start() method using Thread class onject.

- To the constructor of Thread class, pass your Runnable object as argument.

- Now since t is referring to t1 onject as memory, t.start() will go to run() method of Thread_R
*/

class Thread_R implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
    }
}

public class Basics {
    public static void main(String[] args) {
        Thread_R t1 = new Thread_R();
        Thread t = new Thread(t1);
        t.start();
    }
}
