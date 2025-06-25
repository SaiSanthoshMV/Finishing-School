
// UML DIAGRAM-1

/*
Assume that you need to implement a class Milk. Its UML diagram is shown in Hint

This class definition in UML diagram is incomplete. Complete drawing this UML diagram and consider:
-Which attributes and methods could be public and which ones could be private?
-Which attributes could be constants?
-Which attributes and methods could be static?  

In addition, list which methods are accessors and which ones are mutators and provide explanations for 
your decision.  
*/

import java.util.*;

public class Milk{
    private String brand;
    private String flavour;
    private int size;
    private String bestBefore;
    private double healthStarRating;
    static double maxHealthStarRating = 5;
    Milk(String brand, String flavour, int size, String bestBefore, double healthStarRating){
        this.brand = brand;
        this.size = size;
        this.bestBefore = bestBefore;
        this.healthStarRating = healthStarRating;
    }
    public void showBrand(){
        System.out.println("Brand: " + this.brand);
    }
    public String getFlavour(){
        return this.flavour;
    }
    public void changeFlavour(String flavour){
        this.flavour = flavour;
    }
    public int getSize(){
        return this.size;
    }
    public void setSize(int size){
        this.size = size;
    }
    public String getBestBefore(){
        return bestBefore;
    }
    public void setStarRating(double healthStarRating){
        this.healthStarRating = healthStarRating;
    }
    public static void main(String []args){
        Milk m = new Milk("Sangam", "Vannila", 99, "99-99-9999", 4.8);
        m.showBrand();
        m.changeFlavour("White");
        m.setStarRating(4.9);
        m.setSize(999);
        System.out.println("Flavour : " + m.getFlavour());
        System.out.println("Size : " + m.getSize());
        System.out.println("BestBefore: " + m.getBestBefore());
    }
    
}
