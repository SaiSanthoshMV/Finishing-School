public class boxunbox1 
{
	public static void main(String [] args) 
	{
    // Prior to Java 5 version
    Integer x = new Integer(123); 
    int y = x.intValue();   
    y++;  
    x = new Integer(y);   
    System.out.println("x = " + x); 

    // Java 5 onwards
    Integer m = 123; 
    m++;
    System.out.println("m = " + m); 
  }
}