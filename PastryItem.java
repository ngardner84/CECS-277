/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

public class PastryItem extends Item
{
    protected String flavor;
    protected boolean isHeated;
    final static double HEAT_PRICE = 0.25;
    
    /**
     * 
     * @param name
     * @param flavor
     * @param isHeated 
     */
    PastryItem(String name, String flavor, boolean isHeated)
    {
        super.setName(name);
        this.flavor = flavor;
        this.isHeated = true;
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
            if(this.isIsHeated())
            {
                pastryCost = 2.00 + HEAT_PRICE;
                return pastryCost;
            }
            pastryCost = 2.00;
            return pastryCost;
        }
        else if(super.getName().equalsIgnoreCase("Cookie") && (!this.getFlavor().isEmpty()))
        {
            if(this.isIsHeated())
            {
            pastryCost = 1.50 + HEAT_PRICE;
            return pastryCost;
            }
            pastryCost = 1.50;
            return pastryCost;
            
        }
        else if(super.getName().equalsIgnoreCase("Danish") && (!this.getFlavor().isEmpty()))
        {
            if(this.isIsHeated())
            {
            pastryCost = 2.50 + HEAT_PRICE;
            return pastryCost;
            }
            pastryCost = 2.50;
            return pastryCost;
        }
        else if(super.getName().equalsIgnoreCase("Cheesecake Slice") && this.getFlavor().equalsIgnoreCase("Regular"))
        {
            if(this.isIsHeated())
            {
            pastryCost = 4.00 + HEAT_PRICE;
            return pastryCost;
            }
            pastryCost = 4.00;
            return pastryCost;
        }
        else if(super.getName().equalsIgnoreCase("Cheesecake Slice") && this.getFlavor().equalsIgnoreCase("Cherry"))
        {
            if(this.isIsHeated())
            {
            pastryCost = 4.50 + HEAT_PRICE;
            return pastryCost;
            }
            pastryCost = 4.50;
            return pastryCost;
        }
        else
        {
            if(this.isIsHeated())
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
        return "-"+super.getName()+"\n\tCost: "+ this.calculateCost() + "\n\tFlavor: " + this.getFlavor();
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
     * @return the isHeated
     */
    public boolean isIsHeated() 
    {
        return isHeated;
    }

    /**
     * @param isHeated the isHeated to set
     */
    public void setIsHeated(boolean isHeated) 
    {
        this.isHeated = isHeated;
    }
    
}
