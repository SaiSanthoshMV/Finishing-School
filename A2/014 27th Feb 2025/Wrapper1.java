import java.util.Date;

class wrapper1
{
  	public static void main(String [] args) {
      Object obj = new Object();
      System.out.println("getClass " + obj.getClass());
      System.out.println("string representation = " + obj.toString());

      Double d1 = new Double("3.0");
      Integer i1 = new Integer(3); 
      if ( d1.equals(i1) )
         System.out.println("wrappers are equal"); 
      else
         System.out.println("wrappers not equal");

      Double d2 = d1.valueOf("3.0d"); 
      if (d1.equals(d2))
         System.out.println("Doubles are equal"); 
      else
         System.out.println("Doubles are not equal");

      if (d1 == d2)
         System.out.println("Doubles are =="); 
      else
         System.out.println("Doubles are !=");
  	}
}
