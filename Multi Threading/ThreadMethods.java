/* 

Methods of Thread class:

void run():                     is used to perform action for a thread.
void start():                   starts the execution of the thread.JVM calls the run() method on the thread.
void sleep(long miliseconds):   Causes the currently executing thread to sleep (temporarily cease execution) for the specified number of milliseconds.
void join():                    waits for a thread to die.
void join(long miliseconds):    waits for a thread to die for the specified miliseconds.
int getPriority():              returns the priority of the thread.
int setPriority(int priority):  changes the priority of the thread.
String getName():               returns the name of the thread.
void setName(String name):      changes the name of the thread.
Thread currentThread():         returns the reference of currently executing thread.
int getId():                    returns the id of the thread. // depriciated after java 19
int threadId():                 returns the id of the thread. 
Thread.State getState():        returns the state of the thread.
boolean isAlive():              tests if the thread is alive.
void yield():                   causes the currently executing thread object to temporarily pause and allow other threads to execute.
void suspend():                 is used to suspend the thread(depricated).
void resume():                  is used to resume the suspended thread(depricated).
void stop():                    is used to stop the thread(depricated).
boolean isDaemon():             tests if the thread is a daemon thread.
void setDaemon(boolean b):      marks the thread as daemon or user thread.
void interrupt():               interrupts the thread.
boolean isInterrupted():        tests if the thread has been interrupted.
static boolean interrupted():   tests if the current thread has been interrupted.
String toString():              Returns a string representation of this thread, including the thread’s name, priority, and thread group
*/

/* 
// Behind the scene of Thread:

interface Runnable {
    abstract void run();
}

public class Thread implements Runnable {
    public static final MIN_PRIORITY = 1;
    public static final NORM_PRIORITY = 5;
    public static final MAX_PRIORITY = 10;

    public void run(){} // empty method
    public void start() {
        ...
        ...
        run();
    }
    ...
    ...
}
*/

/* 
Thread[#22,Thread-0,5,main] : 
22 => Thread ID
Thread-0 => Name of the thread (default name)
5 => Priority of the thread (default priority)
main => Thread group


- If the priority <1 or >10 then it will throw IllegalArgumentException
- IllegalArgumentException is a subclass of RuntimeException class and categorized as Unchecked Exception
- If start() is invoked multiple times by the same thread class object then it throws "IllegalThreadStateException"
  

*/

class MyThread extends Thread {
    public void run() {
        System.out.println("I am a Thread");
        Thread t = Thread.currentThread();

        System.out.println(t); // Thread[#22,Thread-0,5,main] 
        t.setName("MyThread");
        System.out.println("\nThread after changing name: " + t); // Thread[#22,MyThread,5,main]
        System.out.println("Name: " + t.getName()); // MyThread

        t.setPriority(8);
        System.out.println("\nThread after changing priority: " + t); // Thread[#22,MyThread,8,main]
        System.out.println("Priority: " + t.getPriority()); //  8

        System.out.println("\nID: " + t.threadId()); // 22

        System.out.println("\nIs the thread Alive? : " + t.isAlive()); // true
        System.out.println("\nThe current state of thread is : " + t.getState()); // RUNNABLE
    }
}

public class ThreadMethods {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}
