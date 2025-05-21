class FactTest
{
	public static void main(String[] args) 
	{
		long M = 1000000007;
		long N= 100;
       long fact = 1;
    for (long i = 1; i <= N; i++)
        fact = (fact*i) % M;  

		System.out.println(fact);
	}
}
