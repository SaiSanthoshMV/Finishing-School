import java.io.*;
import java.util.*;
 
public class Thread2 implements Runnable {
    
    public void run()
    {
        System.out.println("Thread is Running");
    }
 
    public static void main(String[] args)
    {
        Thread2 g1 = new Thread2();
        Thread t1 = new Thread(g1);
        t1.start();
    }
}