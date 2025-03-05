import java.util.*; 
public class hashcode 
{ 
  private String first, last; 
  public hashcode(String first, String last) 
  { 
    this.first = first; 
    this.last = last; 
  } 

  public boolean equals(Object o) 
  { 
    if (!(o instanceof hashcode)) 
      return false; 
    hashcode n = (hashcode)o; 
    return n.first.equals(first) && n.last.equals(last); 
  } 

  // Comment and see the behavior
  public String toString()
  {
    return first + " " + last;
  }

  // Comment and see the behavior
  public int hashCode() {
    return first.hashCode() + last.hashCode();
  }

  public static void main(String[] args) 
  { 
    Set<hashcode> s = new HashSet<hashcode>(); 
    hashcode obj1 = new hashcode("Venkat", "Reddy");
    hashcode obj2 = new hashcode("Venkat", "Reddy");
    System.out.println(obj1.equals(obj2));
    s.add(obj1); 
    s.add(obj2);
    System.out.println(s);
    System.out.println(s.contains(new hashcode("Venkat", "Reddy"))); 
  } 
} 