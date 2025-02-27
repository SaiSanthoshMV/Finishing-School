import java.util.*;

class arrayList7 {
  public static void main(String args[]) {
    String[] array = { "kmit", "ngit" };
    List<String> list1 = Arrays.asList(array);;
    System.out.println(list1.size());

    list1.set(1, "genesis");
    array[0] = "india";
	list1.add("cbit");
    list1.add("vasavi");
    for (String str : array) 
      System.out.println(str + " "); 
    
    list1.remove(0);
    System.out.println(list1);
  }
}