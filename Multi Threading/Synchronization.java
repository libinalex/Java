/* 
Suppose, in a bank, X and Y have a joint account. and currently they have Rs. 5000 balance

X--> 5000 <--Y

at time t1: X checks balance: Rs. 5000
at time t2: X withdraws Rs. 1000
at time t3: Y checks balance: Rs. 4000
at time t4: Y withdraws Rs. 1000
                ...
                ...
at time t8: X checks balance: Rs. 1000
at time t9: Y checks balance: Rs. 1000
at time t10: X withdraws Rs. 1000
at time t11: Y withdraws Rs. 1000 -> Insufficient Balance. {Concurrency Problem}

When Y checked balance, it showed Rs.1000, but when he tried to withdraw, he got error of insuffient balance.

- When two or more threads access the same resource then there is a chance of getting concurrency problems
- Synchronization is used to avoid concurrency problems.
- 'synchronized' keyword is used for Synchronization.
- synchronized keyword can be used for a method or block of statements only.
- In a synchronized context(method/block), only one thread will be running which degrades the performance of application.
*/


/* 
Inter Thread Communication
- If Thread1 is doing a task, and it's result is to be used in Thread2 for another task.
- If before the completion of task by Thread1, if Thread2 executes its task, we will not geti correct result. 
- So, they need to communicate between themselves: Thread1 has to tell Thread2 to wait untill it is doing its task, and once it finishes it's task, it will notify Thread2 that it can execute now.

- This is achieved using: wait(), notify(), and notifyAll() methods.
- These methods belongs to Object class.

- When wait() method is invoked on a thread, the other threads will go to block state until notified using notify()/notifyAll() methods.
- If there is only one thread in block state, then we can use notify() method.
- If there are one or multiple threads in block state, we have to use notifyAll() method.
- These methods need to be used in synchronized context only, else it will throw "IllegalMonitorStateException"


class ThreadSum extends Thread {
    int sum;

    public void run() {
        for (int i = 1; i <= 100; i++) {
            sum = sum + i;
        }
    }
}

public class Synchronization {
    public static void main(String[] args) {
        ThreadSum ts = new ThreadSum();
        ts.start();
        System.out.println("Sum = " + ts.sum); // 0
    }
}
*/

/* 
Here, ts Thread is doing the task and main Thread is printing the result.
In output, we see sum = 0, but the sum should be 5050.
This is because, when we execute the program, the main Thread goes to Runnable state first. Then when ts.start() is executed, ts Thread will also go to Runnable state.
Now out the two Threads in Runnable state, we cannot guarentee which Thread will execute first. So, if CPU allocated time to main Thread first, it prints sum, which takes its defaut value 0, so we get 0 as output.
Now we want the sout() of main Thread should not be executed until for loop of ts Thread is executed, for this we have to send main thread to Block state by using wait() method{it throws checked Exceptin, so include 'throws InterruptedException' in method declaration}, also use these methods in synchronized context, to avoid getting IllegalMonitorStateException
*/

class ThreadSum extends Thread {
    int sum;

    public void run() {
        for (int i = 1; i <= 100; i++) {
            sum = sum + i;
        }
        synchronized (this) {
            notify();
        }
    }
}

public class Synchronization {
    public static void main(String[] args) throws  InterruptedException {
        ThreadSum ts = new ThreadSum();
        ts.start();
        synchronized (ts) {
            ts.wait();
        }
        System.out.println("Sum = " + ts.sum); // 5050
    }
}