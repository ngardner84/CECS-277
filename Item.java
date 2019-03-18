/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;


public abstract class Item {
    public CashRegister cashR = new CashRegister();
    private String name;
    private double cost;
    /**
     * Default constructor
     */
    public Item()
    { 
        this.name = "Coffee";
        this.cost = 0.99;
    }
    /**
     * 
     * @param name
     * @param cost 
     */
    public Item(String name, double cost)
    {
        this.name = name;
        this.cost = cost;
    }
    /**
     * 
     * @param name 
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * 
     * @param cost 
     */
    public void setCost(double cost)
    {
        this.cost = cost;
    }
    /**
     * 
     * @return 
     */
    public double getCost()
    {
        return this.cost;
    }

    /**
     * @return the name
     */
    public String getName() 
    {
        return name;
    }
    /**
     * No implementation here, please note all implementations are in the subclasses.
     * @return 
     */
    public abstract double calculateCost();
    
}
