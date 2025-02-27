class arrayMulti
{
	public static void main(String []args) 
	{
    int[][] array = new int[3][];
    array[0] = new int[2];
    array[0][0] = 1;
    array[0][1] = 2;
    array[1] = new int[3];
    array[1][0] = 3;
    array[1][1] = 4;
    array[1][2] = 5;
    System.out.println("value " + array[1][2]);
    System.out.println("value " + array[2][1]);
  }
}