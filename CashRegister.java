/*
 * This class models a Cash register for drinks and desserts. 
 */
package project3;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dimithri_2
 */
public class CashRegister
{
   private double taxRate;
   private double purchase;
   private double taxablePurchase;
   private double payment;
  
   private List<String> salesDetails = new ArrayList<>();
   private ArrayList<CoffeeItem> coffeeDrink = new ArrayList<>();
   private ArrayList<TeaItem> teaDrink = new ArrayList<>();
   private ArrayList<PastryItem> desserts = new ArrayList<>();
   
   DecimalFormat df = new DecimalFormat("#,###,##0.00");
   
 
    
    //Constructs a cash register with no money in it. 
   //However, a tax rate has been set to model California state tax rate.

    /**
     *
     */
   
    public CashRegister()
    {
       
       taxRate = 0.09; //9%
       purchase = 0; 
       payment = 0;
       taxablePurchase = 0;
       
    }
   
    /**
     * This method adds a relevant user requested drink to the cashRegister drinks list
     * @param drink 
     */
    public void addCoffeeDrinkItem(CoffeeItem drink)
    {
        this.coffeeDrink.add(drink);
    }
    /**
     * 
     * @param drink 
     */
    public void addTeaDrinkItem(TeaItem drink)
    {
        this.teaDrink.add(drink);
    }
    /**
     * This method adds a relevant user requested dessert to the cashRegister dessert list
     * @param dessert 
     */
    public void addDessertItem(PastryItem dessert)
    {
        this.desserts.add(dessert);
    }
    
    // This method simply returns drink item

    /**
     *
     * @return
     */
    public List<CoffeeItem> getCoffeeDrinks()
    {
        return this.coffeeDrink;
    }
    
    public List<TeaItem> getTeaDrinks()
    {
        return this.teaDrink;
    }
    
    // This method returns the dessert item
    /**
     *
     * @return
     */
    public List<PastryItem> getDesserts()
    {
        return this.desserts;
    }


     /**
      Records the purchase price of an item.
      @param amount the price of the purchased item
   */
   private void recordPurchase(double amount)
   {
      purchase = purchase + amount;
   }
   
    /**
      Records the sale of a taxable item.
      @param amount the price of the item
   */
   private void recordTaxablePurchase(double amount)
   {
      taxablePurchase = taxablePurchase + amount;
   }
   
   /**
      Processes a payment received from the customer.
      @param amount the amount of the payment - Will include coupons also
   */
   public void receivePayment(double amount)
   {
      payment = amount;
   }
   
   

   
    /**
      Processes the sales tax due.
      @return the sales tax due
   */
    public double getSalesTax() {
        return taxablePurchase * taxRate;
    }
   
   /**
    * This method Clears the Cash Register and Resets the machine for the next customer.
    */
   public void clear() // reset method
   {
      this.getSalesDetails().add(this.toString());
      purchase = 0;
      payment = 0;
      taxablePurchase = 0;
      this.coffeeDrink.clear();
      this.teaDrink.clear();
      this.desserts.clear();

   }
     /**
      Computes the change due
      @return the change due to the customer
   */
   
   public double getChange()
   {
      return payment - getTotalAT();
   }
   
   
   // This method Computes sub total before tax and return sub total before tax

    /**
     *
     * @return
     */
   public double getsubTotalBT() // Total Before Tax
   {
       purchase = 0;
       
       for (CoffeeItem cdrink : coffeeDrink) 
       {
           this.recordPurchase(cdrink.getCost());
       }
       for (TeaItem tdrink : teaDrink) 
       {
           this.recordPurchase(tdrink.getCost());
       }
       for (PastryItem dessert : desserts) 
       {
           this.recordPurchase(dessert.getCost());
       }

       return purchase;
   }
   
    /**
      This method Computes the total items purchases and 
      @return the total items purchased by the customer
   */
   
    public int getTotalItems() {
        return this.coffeeDrink.size() +  this.teaDrink.size() + this.desserts.size();
    }
   
   /**
    * This method computes the discount value and if it is a drink coupon it will add the discount or
    * if it is a a dessert item the method will compute the discount for the dessert item and applies
    * it to the final cost due
     * @return 
    * @returns taxable purchase after tax and after the discount(coupon).
    */
    public double getTotalAT() {
        taxablePurchase = 0;

        for (CoffeeItem coffee : coffeeDrink) {
            double cost = coffee.getCost();
            this.recordTaxablePurchase(cost);
        }
        
        for(TeaItem tea : teaDrink)
        {
            double cost = tea.getCost();
            this.recordTaxablePurchase(cost);
        }

        for (PastryItem dessert : desserts) 
        {
            double cost = dessert.getCost();
            this.recordTaxablePurchase(cost);
        }
       

        return taxablePurchase + getSalesTax();
    }
     /**
     * @return the salesDetails
     */
    public List<String> getSalesDetails() 
    {
        return salesDetails;
    }

    
   /**
     * @return 
    * @returns a string representation of total items purchased, the sales items and the 
    * prints the total cost after tax.
    */
    
   @Override
    public String toString() {
        String str;

        str = "Here's your receipt:\nTotal Items purchased: "
                + getTotalItems()
                + "\nTotal cost after tax: " 
                + df.format(getTotalAT());
        return str;
    }

    
}
