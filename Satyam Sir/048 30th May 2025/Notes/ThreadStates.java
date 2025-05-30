
class A implements Runnable {

	public void run()
	{
		try {
			Thread.sleep(5500);

		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
       
		 System.out.println("State of - "+Test.thread1.getName() +" in Run Method "+ Test.thread1.getState());
		 System.out.println("State of - "+Test.thread2.getName() +" in Run Method "+ Test.thread2.getState());
	}
}

 class Test  {
static A a1 ;
static A a2 ;
static Thread thread1;
static Thread thread2;
	Test()
	 {
	 
		  a1 = new A();
		  a2 = new A();

		   thread1 = new Thread(a1,"First Thread ");
           thread2 = new Thread(a2,"Second Thread ");
	 }

        public static void main(String[] args) throws Exception
	     {
			Test t = new Test();
		// thread1 created and is currently in the NEW state.
		    System.out.println("State of - "+thread1.getName() +" "+ thread1.getState());
			System.out.println("State of - "+thread2.getName() +" "+ thread2.getState());
		thread1.start();
		thread1.join();
        thread2.start();
       
		   // thread1 moved to Runnable state
	         System.out.println("State of - "+thread1.getName() +" "+ thread1.getState());
			System.out.println("State of - "+thread2.getName() +" "+ thread2.getState());

	}

	
	}
