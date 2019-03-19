/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.util.ArrayList;

/**
 *
 */
public class TeaItem extends DrinkItem 
{
    protected ArrayList<String> toppings;
    final static double TOPPING_PRICE = 0.25;
    
    /**
     * Default constructor
     */
    public TeaItem()
    {
       this.size = "Small";       
       this.sweetness = "full";
       this.flavor = "green tea";
       this.milk = "No milk";
       toppings = new ArrayList<>();
       toppings.add("boba");
    }
    /**
     * 
     * @param teaSize
     * @param teaSwtns
     * @param teaFlav
     * @param teaMilk 
     */
    public TeaItem(String teaSize, String teaSweetness, String teaFlavor, String teaMilk)
    {
        this.size = teaSize;
        this.sweetness = teaSweetness;
        this.flavor = teaFlavor;
        this.milk = teaMilk;
        toppings = new ArrayList<>();
    }
    
    /**
     * 
     * @param topping 
     */
    public void addTopping(String topping)
    {
        toppings.add(topping);
    }
    /**
     * 
     * @return 
     */
    @Override
    public double calculateCost()
    {
       double teaCost;
       if(this.getSize().equalsIgnoreCase("Small") && 
               (this.getMilk().equalsIgnoreCase("whole milk") || this.getMilk().equalsIgnoreCase("half-and-half")) 
               && (!toppings.isEmpty()))
       {
           teaCost = 2.50 + 0.25 + (toppings.size() * TOPPING_PRICE);
           return teaCost;
       }
       else if(this.getSize().equalsIgnoreCase("Medium") && 
               (this.getMilk().equalsIgnoreCase("whole milk") || this.getMilk().equalsIgnoreCase("half-and-half")) 
               && (!toppings.isEmpty()))
       {
           teaCost = 3.00 + 0.25 + (toppings.size() * TOPPING_PRICE);
           return teaCost;
       }
        else if(this.getSize().equalsIgnoreCase("Large") && 
               (this.getMilk().equalsIgnoreCase("whole milk") || this.getMilk().equalsIgnoreCase("half-and-half")) 
               && (!toppings.isEmpty()))
       {
           teaCost = 3.50 + 0.25 + (toppings.size() * TOPPING_PRICE);
           return teaCost;
       }
       else if(this.getSize().equalsIgnoreCase("Small") && 
               (this.getMilk().equalsIgnoreCase("whole milk") || this.getMilk().equalsIgnoreCase("half-and-half")) 
               && (toppings.isEmpty()))
       {
           teaCost =  2.50 + 0.25;
           return teaCost;
       }
        else if(this.getSize().equalsIgnoreCase("Medium") && 
               (this.getMilk().equalsIgnoreCase("whole milk") || this.getMilk().equalsIgnoreCase("half-and-half")) 
               && (toppings.isEmpty()))
       {
           teaCost =  3.00 + 0.25;
           return teaCost;
       }
        else if(this.getSize().equalsIgnoreCase("Large") && 
               (this.getMilk().equalsIgnoreCase("whole milk") || this.getMilk().equalsIgnoreCase("half-and-half")) 
               && (toppings.isEmpty()))
       {
           teaCost =  3.50 + 0.25;
           return teaCost;
       }
        else if(this.getSize().equalsIgnoreCase("Small") && (this.getMilk().equalsIgnoreCase("no milk")) 
               && (!toppings.isEmpty()))
       {
           teaCost =  2.50 + (toppings.size() * TOPPING_PRICE);
           return teaCost;
       }
        else if(this.getSize().equalsIgnoreCase("Medium") && (this.getMilk().equalsIgnoreCase("no milk")) 
               && (!toppings.isEmpty()))
       {
           teaCost =  3.00 + (toppings.size() * TOPPING_PRICE);
           return teaCost;
       }
       else if(this.getSize().equalsIgnoreCase("Large") && (this.getMilk().equalsIgnoreCase("no milk")) 
               && (!toppings.isEmpty()))
       {
           teaCost =  3.50 + (toppings.size() * TOPPING_PRICE);
           return teaCost;
       }
       else if(this.getSize().equalsIgnoreCase("Small") && (toppings.isEmpty()))
       {
           teaCost =  2.50;
           return teaCost;
       }
       else if(this.getSize().equalsIgnoreCase("Medium") && (toppings.isEmpty()))
       {
           teaCost =  3.00;
           return teaCost;
       }
       else
       {
           teaCost =  3.50;
           return teaCost;
       }
      
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString()
    {
    	String totalToppings = "";
    	for(int i = 0;i < toppings.size();i++) {
    		totalToppings += toppings.get(i) + " | ";
    	}
        return "\t-- " + super.getFlavor() + "(" + super.getSize() + "):\t\t$" + calculateCost() + "\n\t\tSweetness: " + super.getSweetness() + "\n\t\tMilk: " + 
        super.getMilk() + "\n\t\tToppings: " + totalToppings + "\n\n";
    }
    
    
}
