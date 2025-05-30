public class ProducerConsumerTest 
 {
    public static void main(String[] args) 
{
        CubbyHole c = new CubbyHole();
        Producer p1 = new Producer(c, 1);
        Consumer c1 = new Consumer(c, 1);
		Thread producerThread=new Thread(p1);
		Thread consumerThread=new Thread(c1);
        producerThread.start();
		consumerThread.start();
   }
}