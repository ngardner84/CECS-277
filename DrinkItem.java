/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;


public class DrinkItem extends Item {
    protected String size;
    protected String flavor;
    protected String sweetness;
    protected String milk;
    
    /**
     * The default constructor creates the default drink
     */
    public DrinkItem()
    {
        this.size = "Small";
        this.flavor = "Green Tea";
        this.sweetness = "full";
        this.milk = "Whole Milk";
    }
    /**
     * This constructor creates a user defined custom drink
     * @param drinkName
     * @param drinkSize
     * @param drinkFlavor
     * @param drinkSweetness
     * @param drinkMilk 
     */
    public DrinkItem(String drinkName, String drinkSize, String drinkFlavor, 
            String drinkSweetness, String drinkMilk)
    {
        super.setName(drinkName);
        this.flavor = drinkFlavor;
        this.size = drinkSize;
        this.sweetness = drinkSweetness;
        this.milk = drinkMilk;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return the flavor
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * @param flavor the flavor to set
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     * @return the sweetness
     */
    public String getSweetness() {
        return sweetness;
    }

    /**
     * @param sweetness the sweetness to set
     */
    public void setSweetness(String sweetness) {
        this.sweetness = sweetness;
    }

    /**
     * @return the milk
     */
    public String getMilk() {
        return milk;
    }

    /**
     * @param milk the milk to set
     */
    public void setMilk(String milk) {
        this.milk = milk;
    }
    /**
     * 
     * @return 
     */
    @Override
    public double calculateCost()
    {
        return this.getCost();
    }
    /**
     * 
     * @return 
     */
    @Override
    public String toString()
    {
        return "-"+super.getName()+"\n\t"+ getCost();
    }
    
}
