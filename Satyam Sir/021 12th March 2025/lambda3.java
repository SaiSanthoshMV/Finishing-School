class lambda3 {
   public static void main(String args[]){
      // without parenthesis
      Greetings person1 = message -> System.out.println("Hi " + message);
		
      // with parenthesis
      Greetings person2 = (message) -> System.out.println("Hi " + message);
		
      person1.greet("Subbu");
      person2.greet("Satyam");
   }	
}

interface Greetings {
  void greet(String message);
}