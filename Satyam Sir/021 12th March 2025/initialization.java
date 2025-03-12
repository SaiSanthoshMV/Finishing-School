
class Init {
  Init(int x) { System.out.println("1-arg const"); }
  Init() { System.out.println("no-arg const"); }
  static { System.out.println("1st static init"); }
  { System.out.println("1st instance init"); }
  { System.out.println("2nd instance init"); }
  static { System.out.println("2nd static init"); }

  public static void main(String [] args) {
    new Init();
    new Init(7);
}
}














// Initialization blocks run when the class is first loaded (a static  initialization block) or 
// or when an instance is created (an instance  initialization block). 

// A static initialization block runs once, when the class is first loaded. 

// An instance initialization block runs once every time a new instance is created.





/*
1st static init
2nd static init
1st instance init
2nd instance init
no-arg const
1st instance init
2nd instance init
1-arg const



*/