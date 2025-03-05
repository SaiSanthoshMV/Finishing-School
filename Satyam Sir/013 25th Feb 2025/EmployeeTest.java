class Employee
{
	String ename;
	int eno;
	Employee(String ename,int eno)
	{
		this.ename = ename;
		this.eno = eno;
	}
	public boolean equals(Object o)
	{
	  if(o instanceof Employee)
		{
				Employee e=(Employee)o;
				if(this.eno == e.eno && this.ename.equals(e.ename))
					return true;
		}
		return false;
		}
}

class EmployeeTest 
{
	public static void main(String[] args) 
	{
			Employee e1 =new Employee("Satyam",100);
			Employee e2=new Employee("Satyam",100);
			System.out.println(e1==e2);
			System.out.println(e1.equals(e2));

		
		}
}
