
// Java Design-1


/*
Wirte Java Code for the below one 

Car Insurance Company and insurance policies. 

Car has these attributes:
-	String model;
-	CarType type; // CarType is an enum { SUV,SED,LUX,HATCH,etc}
-	intManufacturingYear;
-	double price;

There are two different types of InsurancePolicies: ThirdPartyPolicy and ComprehensivePolicy.

All Policies have the following attributes in common (The parent class: InsurancePolicy):
    -String policyHolderName;  
    -int id; 
    -Car car; 
    -intnumberOfClaims; 

ThirdPartyPolicy class has the following additional attributes:
    -Sting comments;

ComprehensivePolicyclass has the following additional attributes:
   -intdriverAge; 
   -int level;

The premiums for each policy is calculated as follow: 
•	Third Party Premium = CarPrice/100+numberOfClaims x 200+flatRate
•	Comprehensive Premium = CarPrice/50+numberOfClaims x 200+flatRate
	If the driverAge is less than 30 then add (30-driverAge) x 50 to the comprehensive premium 

The flatRate will be set by the manager and will be sent to the calculation from outside as a parameter (currently from test code in main).

1- Write the Java code to define the class Car as well as enumCarType. 

2- Write an abstract base class called InsurancePolicy for the above scenario. This class supports the common features of all policies.

4- Write two sub classes called ThirdPartyPolicy and ComprehensivePolicy for the scenario. 

5- Write a print method for these classes. Use super.print ( ) in children classes.  

5- Override the calcPayment method based on the description for Premium Payment. 

6- Add toString() to all classes. 

7- Write a test code that creates a mixture of ThirdPartyPolicy and ComprehensivePolicy objects, then places them in a single list of policies,
print all the policies in the list by using print method and then by using toString method. 

Then calculates their total premium payments and finally prints the total with user friendly prompts.

Note that the flatRate should be stored as a constant in your test code and then is sent it to the methods as a parameter. 
*/


import java.util.*;
enum CarType{
    SUV,SED,LUX,HATCH
}
class Car{
    private String model;
    private CarType type;
    private int ManufacturingYear;
    private double price;
    public Car(String model,CarType type,int ManufacturingYear,double price){
        this.model=model;
        this.type=type;
        this.ManufacturingYear=ManufacturingYear;
        this.price=price;
    }
    public double getPrice(){
        return price;
    }
    public String toString(){
        return "Model:"+model+"Type:"+type+"Year:"+ManufacturingYear+"Price:"+price;
    }
    public void print(){
        System.out.println(toString());
    }
}
abstract class InsurancePolicy{
    protected String policyHolderName;
    protected int id;
    protected Car car;
    protected int numberOfClaims;
    public InsurancePolicy(String policyHolderName, int id, Car car, int numberOfClaims){
        this.policyHolderName = policyHolderName;
        this.id = id;
        this.car = car;
        this.numberOfClaims = numberOfClaims;
    }
    public abstract double calcPayment(double flatRate);
    public void print(){
        System.out.println("Policy ID: " + id);
        System.out.println("Policy Holder: " + policyHolderName);
        System.out.println("Number of Claims: " + numberOfClaims);
        System.out.println("Car Details:");
        car.print();
    }
    public String toString(){
        return "Policy ID: " +id+",Holder: " + policyHolderName + ", Claims: " + numberOfClaims + "\nCar: " + car;
    }
}
class ThirdPartyPolicy extends InsurancePolicy{
    private String comments;
    public ThirdPartyPolicy(String policyHolderName, int id, Car car, int numberOfClaims, String comments){
        super(policyHolderName, id, car, numberOfClaims);
        this.comments = comments;
    }
    public double calcPayment(double flatRate){
        return car.getPrice() / 100 + numberOfClaims * 200 + flatRate;
    }
    public void print(){
        super.print();
        System.out.println("Policy Type: Third Party");
        System.out.println("Comments: " + comments);
    }
    public String toString(){
        return super.toString() + "\nType: Third Party, Comments: " + comments;
    }
}
class ComprehensivePolicy extends InsurancePolicy{
    private int driverAge;
    private int level;
    public ComprehensivePolicy(String policyHolderName, int id, Car car, int numberOfClaims, int driverAge, int level){
        super(policyHolderName, id, car, numberOfClaims);
        this.driverAge = driverAge;
        this.level = level;
    }
    public double calcPayment(double flatRate){
        double premium=car.getPrice()/50+numberOfClaims*200+flatRate;
        if (driverAge < 30){
            premium += (30 - driverAge) * 50;
        }
        return premium;
    }
    public void print(){
        super.print();
        System.out.println("Policy Type: Comprehensive");
        System.out.println("Driver Age: " + driverAge + ", Level: " + level);
    }
    public String toString(){
        return super.toString() + "\nType: Comprehensive, Age: " + driverAge + ", Level: " + level;
    }
}


