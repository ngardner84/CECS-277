/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;


public class CoffeeItem extends DrinkItem 
{
    
    protected String temperature;
    protected String specialInstructions;
    
    /**
     * The default constructor creates a Hot small coffee 
     */
    public CoffeeItem()
    { 
       this.size = "Small";       
       this.sweetness = "1";
       this.flavor = "regular";
       this.milk = "No milk";
       this.temperature = "Hot";
       this.specialInstructions = "decaf";
    }
    
    /**
     * 
     * @param coffSize
     * @param coffSwtns
     * @param coffFlav
     * @param coffMilk
     * @param coffTemp
     * @param coffSpInstrn 
     */
    public CoffeeItem(String coffSize, String coffSwtns, String coffFlav, String coffMilk, 
            String coffTemp, String coffSpInstrn)
    {
        this.size = coffSize;
        this.sweetness = coffSwtns;
        this.flavor = coffFlav;
        this.milk = coffMilk;
        this.temperature = coffTemp;
        this.specialInstructions = coffSpInstrn;       
    }

    /**
     * @return the temperature
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    /**
     * @return the specialInstructions
     */
    public String getSpecialInstructions() {
        return specialInstructions;
    }

    /**
     * @param specialInstructions the specialInstructions to set
     */
    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString()
    {
        
        return "\t\t~~~~~~~~~~~~~~~~~~~~~~Current Order~~~~~~~~~~~~~~~~~~~~~~~~~\n"+"The coffee drink:\n\tFlavor: " + super.getFlavor() + " " + super.getName() +" "+ super.getSize() 
                +" "+ getTemperature() + "\nSweetness: " + Integer.parseInt(getSweetness());
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public double calculateCost()
    {
        double coffCost;
        //while((!super.getMilk().isEmpty()))
        if(this.getTemperature().equalsIgnoreCase("Blended") && this.getSize().equalsIgnoreCase("Small") && 
                (this.getMilk().equalsIgnoreCase("whole milk") || this.getMilk().equalsIgnoreCase("half-and-half")))
        {
            coffCost = 1.25 + 0.25;
            return coffCost;
        }
        else if(this.getTemperature().equalsIgnoreCase("Blended") && this.getSize().equalsIgnoreCase("Medium") && 
                (this.getMilk().equalsIgnoreCase("whole milk") || this.getMilk().equalsIgnoreCase("half-and-half")))
        {
            coffCost = 1.75 + 0.25;
            return coffCost;
        }
        else if(this.getTemperature().equalsIgnoreCase("Blended") && this.getSize().equalsIgnoreCase("Large") && 
                (this.getMilk().equalsIgnoreCase("whole milk") || this.getMilk().equalsIgnoreCase("half-and-half")))
        {
            coffCost = 2.25 + 0.25;
            return coffCost;
        }
        
        else if((this.getTemperature().equalsIgnoreCase("Hot") || this.getTemperature().equalsIgnoreCase("Iced")) 
                && this.getSize().equalsIgnoreCase("Small") && 
                (this.getMilk().equalsIgnoreCase("whole milk") || this.getMilk().equalsIgnoreCase("half-and-half")))
        {
            coffCost = 1.00 + 0.25;
            return coffCost;
        }
        else if((this.getTemperature().equalsIgnoreCase("Hot") || this.getTemperature().equalsIgnoreCase("Iced")) 
                && this.getSize().equalsIgnoreCase("Medium") &&  
                (this.getMilk().equalsIgnoreCase("whole milk") || 
                this.getMilk().equalsIgnoreCase("half-and-half")))
        {
            coffCost = 1.50 + 0.25;
            return coffCost;
        }
        else if((this.getTemperature().equalsIgnoreCase("Hot") || this.getTemperature().equalsIgnoreCase("Iced")) 
                && this.getSize().equalsIgnoreCase("Large") &&  
                (this.getMilk().equalsIgnoreCase("whole milk") || this.getMilk().equalsIgnoreCase("half-and-half")))
        {
            coffCost = 2.00 + 0.25;
            return coffCost;
        }
        else if((this.getTemperature().equalsIgnoreCase("Hot") || this.getTemperature().equalsIgnoreCase("Iced")) 
                && this.getSize().equalsIgnoreCase("Small"))
        {
            coffCost = 1.00;
            return coffCost;
        }
        else if((this.getTemperature().equalsIgnoreCase("Hot") || this.getTemperature().equalsIgnoreCase("Iced")) 
                && this.getSize().equalsIgnoreCase("Medium"))
        {
            coffCost = 1.50;
            return coffCost;
        }
        else
        {
          coffCost = 2.00;
          return coffCost;
        }
    }
}
