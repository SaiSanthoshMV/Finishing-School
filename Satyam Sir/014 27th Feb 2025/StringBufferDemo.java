class StringBufferDemo 
{
  public static void main(String [] args) {
    StringBuffer sb1 = new StringBuffer("Java"); 
    StringBuffer sb2 = sb1;   	
    System.out.println("sb1 = " + sb1);
    System.out.println("sb2 = " + sb2);
    sb1.append(" Bean"); 	
    System.out.println("sb1 = " + sb1);
    System.out.println("sb2 = " + sb2);

    sb1.insert(4, "**");
    System.out.println("sb1 = " + sb1);
    System.out.println("sb2 = " + sb2);

    StringBuffer sb3 = new StringBuffer("Genesis");
    StringBuffer sb4 = sb3; 

    System.out.println("sb3 reverse = " + sb3.reverse());
    System.out.println("sb3 = " + sb3);
    System.out.println("sb4 = " + sb4);
    System.out.println("sb4 string representation = " + sb4.toString());

    sb3.append(" ").append(true).append(" ").append("kmit").append(10);
    System.out.println("sb4 = " + sb4);
  }
}
