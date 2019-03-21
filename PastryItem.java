/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.text.DecimalFormat;

public class PastryItem extends Item
{
    protected String flavor;
    protected boolean pastryHeated;
    final static double HEAT_PRICE = 0.25;
    public static DecimalFormat df = new DecimalFormat("0.00");
    
    /**
     * 
     * @param name
     * @param flavor
     * @param pastryHeated 
     */
    PastryItem(String name, String flavor, boolean heated)
    {
        super.setName(name);
        this.flavor = flavor;
        this.pastryHeated = heated;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public double calculateCost() 
    {
        double pastryCost;
        if(super.getName().equalsIgnoreCase("Muffin") && (!this.getFlavor().isEmpty()))
        {
            if(this.isHeated())
            {
                pastryCost = 2.00 + HEAT_PRICE;
                return pastryCost;
            }
            pastryCost = 2.00;
            return pastryCost;
        }
        else if(super.getName().equalsIgnoreCase("Cookie") && (!this.getFlavor().isEmpty()))
        {
            if(this.isHeated())
            {
            pastryCost = 1.50 + HEAT_PRICE;
            return pastryCost;
            }
            pastryCost = 1.50;
            return pastryCost;
            
        }
        else if(super.getName().equalsIgnoreCase("Danish") && (!this.getFlavor().isEmpty()))
        {
            if(this.isHeated())
            {
            pastryCost = 2.50 + HEAT_PRICE;
            return pastryCost;
            }
            pastryCost = 2.50;
            return pastryCost;
        }
        else if(super.getName().equalsIgnoreCase("Cheesecake Slice") && this.getFlavor().equalsIgnoreCase("Regular"))
        {
            if(this.isHeated())
            {
            pastryCost = 4.00 + HEAT_PRICE;
            return pastryCost;
            }
            pastryCost = 4.00;
            return pastryCost;
        }
        else if(super.getName().equalsIgnoreCase("Cheesecake Slice") && this.getFlavor().equalsIgnoreCase("Cherry"))
        {
            if(this.isHeated())
            {
            pastryCost = 4.50 + HEAT_PRICE;
            return pastryCost;
            }
            pastryCost = 4.50;
            return pastryCost;
        }
        else
        {
            if(this.isHeated())
            {
                pastryCost = 4.50 + HEAT_PRICE;
                return pastryCost;
            }
            pastryCost = 4.50;
            return pastryCost;
        }
        
    }
       
    /**
     * 
     * @return 
     */
    @Override
    public String toString()
    {
    	String heated = "";
    	if(isHeated()) {
    		heated = " (heated)";
    	}
    	else {
    		heated = "";
    	}
        return "\t--" + super.getName() + heated + "\t\t$" + df.format(calculateCost()) + "\n\t\t" + this.flavor + "\n\n";
    }

    /**
     * @return the flavor
     */
    public String getFlavor() 
    {
        return flavor;
    }

    /**
     * @param flavor the flavor to set
     */
    public void setFlavor(String flavor) 
    {
        this.flavor = flavor;
    }

    /**
     * @return the pastryHeated
     */
    public boolean isHeated() 
    {
        return pastryHeated;
    }

    /**
     * @param pastryHeated the pastryHeated to set
     */
    public void setpastryHeated(boolean pastryHeated) 
    {
        this.pastryHeated = pastryHeated;
    }
    
}
