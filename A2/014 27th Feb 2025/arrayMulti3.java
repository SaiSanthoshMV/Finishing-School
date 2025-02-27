class arrayMulti3 
{
	public static void main(String []args) 
	{
    int[][] arr2d = new int[2][2];
    for (int i = 0; i < arr2d.length; i++) {
      for (int j = 0; j < arr2d[i].length; j++)
      {
        arr2d[i][j] = i * j;
        System.out.print(arr2d[i][j] + " "); 
      }
      System.out.println(); 
    }

    for (int[] inner : arr2d) {
      for (int num : inner)
        System.out.print(num + " ");
      System.out.println();
    }
  }
}