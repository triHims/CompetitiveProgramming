import java.util.List;
import java.util.ArrayList;
import java.lang.Thread;
import java.lang.Runnable;
class MyThread extends Thread {
    MyThread(){}
    MyThread(Runnable r){super(r);}
    public void run(){

        System.out.println("Inside thread");
    }
}

/**
 * Runnable
 */
 class MyRunnable implements Runnable {

    public void run(){
        System.out.println("Inside runnable");
    }
}
public class boka {
    public static void main(String[] args) {

        new MyThread().start();
        new MyThread(new MyRunnable()).start();
    }
}