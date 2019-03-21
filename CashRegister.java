package project3;
import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 * this class models a register object that handles all of the sales for the
 * tea shop
 * @author Nathan Gardner
 * @since 2019-02-26
 * 
 * **/

public class CashRegister {
	DecimalFormat df = new DecimalFormat("0.00");
	ArrayList<Double> receiptPrices = new ArrayList<Double>();
	ArrayList<DrinkItem> drinkItems = new ArrayList<DrinkItem>();
	ArrayList<PastryItem> pastryItems = new ArrayList<PastryItem>();
	public double tax;
	public double total;
	public double totalWithTax;
	public double payment;
	
	/**
	 * constructs a default register with a value for tax
	 * **/
	public CashRegister() {
		tax = .08;
	}
	
	/**
	 * uses the interface of BobaLounge to return the cost of an item
	 * @param item - item given to get the cost from
	 * @return cost of the item as a double
	 * **/
	public static double getCost(Item item) {
		return item.getCost();
	}
	
	/**
	 * adds a drink to the drinkItems arraylist of the order
	 * @param newDrink - drink to be added to the list
	 * **/
	public void addDrink(DrinkItem newDrink) {
		this.drinkItems.add(newDrink);
	}
	
	/**
	 * adds a dessert to the pastryItems arraylist of the order
	 * @param newDessert - dessert to be added to the list
	 * **/
	public void addDessert(PastryItem newPastry) {
		this.pastryItems.add(newPastry);
	}
	
	
	/**
	 * returns the change owed to a customer from their payment
	 * @param payment - money given by a customer
	 * @return money owed to customer as a string
	 * **/
	public String giveChange(double payment) {
		return df.format(payment - totalWithTax);
	}
	
	/**
	 * gives the total amount of items being purchased at the register
	 * @return the size of both the drinkItems arraylist and pastryItems
	 * arraylist as an int
	 * **/
	public int totalItems() {
		return this.drinkItems.size() + this.pastryItems.size();
	}
	
	/**
	 * gets the total before tax is applied
	 * @return the total of the purchase before tax as a double
	 * **/
	public double totalBeforeTax() {
		return total;
	}
	
	/**
	 * sets the total according to the items in the register
	 */
	public void setTotal() {
		total = 0.0;
		for(DrinkItem drink : drinkItems) {
			total += drink.calculateCost();
		}
		for(PastryItem pastry : pastryItems) {
			total += pastry.calculateCost();
		}
	}
	
	public void updateTotal(double newTotal) {
		total = newTotal;
	}
	/**
	 * gets the total after tax is applied
	 * @return the total of the purchase as a double
	 * **/
	public double totalAfterTax() {
		return total + (total * tax);
	}
	
	/**
	 * gives a string of the receipt when a coupon is not used
	 * @return receipt string of the customer order
	 * **/
	public String returnReceipt() {
		String items = "";
		for(int i = 0;i < drinkItems.size();i++) {
			DrinkItem tempDrink = drinkItems.get(i);
			items += tempDrink.toString() + "\n";
		}
		for(int i = 0;i < pastryItems.size();i++) {
			PastryItem tempDessert = pastryItems.get(i);
			items += tempDessert.toString() + "\n";
		}
		String receipt = "Receipt for order:\n" + items + "Subtotal before tax: $" + df.format(totalBeforeTax()) + 
				"\nTax: $" + df.format(total * tax) + "\nTotal cost: $" + df.format(totalAfterTax()) + "\n";
		receiptPrices.add(totalAfterTax());
		return receipt;
	}
	
	
	/**
	 * returns a string representation of the register that reads
	 * 'Receipt for order:
	 *  Subtotal before tax: $<totalBeforeTax>
	 *  Tax: $<tax>
	 *  Total cost: $<totalAfterTax>'
	 * **/
	public String toString() {
		String receipt = "Receipt for order:\nSubtotal before tax: $" + totalBeforeTax() + 
				"\nTax: $" + df.format(total * tax) + "\nTotal cost: $" + totalAfterTax();
		return receipt;
	}

}
