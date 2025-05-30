import java.io.*;
import java.util.*;
 
class Thread3 {
    public static void main(String args[])
    {
        // Thread object created
        // and initiated with data
        Thread t = new Thread("First Thread");
 
        // Thread gets started
        t.start();
 
        // getting data of
        // Thread through String
        String s = t.getName();
        System.out.println(s);
    }
}