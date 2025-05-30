import java.util.*;
 
class  Thread1 extends Thread {
    public void run()
    {
        System.out.println("Thread is running ");
    }
    public static void main(String[] args)
    {
        Thread1 g1 = new Thread1();
          g1.start();
    }
}