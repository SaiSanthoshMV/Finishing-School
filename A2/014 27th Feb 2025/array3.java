class circle {
  static double radius;
  circle() {
    radius++;
  }
  double getRadius() {
    return radius;
  }
}

class array3 {
	public static void main(String []args) 
	{
    circle [] obj = new circle[3];
    //obj[0].getRadius();
    
    for(int i = 0; i < obj.length; i++) {
      obj[i] = new circle();
      System.out.println(obj[i].radius);
    }
  }
}