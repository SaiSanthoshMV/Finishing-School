class string2 {
	public static void main(String[] args) 	{
    String s1 = "Hello";
    String s2 = "Hello";
    String s3 = "Hello".intern();
    String s4 = new String("Hello");
    String s5 = new String("Hello").intern();

    if (s1 == s2)
    {
      System.out.println("s1 and s2 are same");  
    }

    if (s1 == s3)
    {
      System.out.println("s1 and s3 are same" );  
    }

    if (s1 == s4)
    {
      System.out.println("s1 and s4 are same" );  
    }

    if (s1 == s5)
    {
      System.out.println("s1 and s5 are same" );  
    }
  }
}