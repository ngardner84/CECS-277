/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author Dimithri_2
 */
public class ItemTester {

    public static void main(String[] args) {
        
        DrinkItem coffee = new CoffeeItem("Medium","2","Mocha","half-and-half","Hot","Decaf");
        System.out.println("New Coffee Drink is: " + coffee.calculateCost());
        System.out.println(coffee.toString());
        
        PastryItem pastry = new PastryItem("Muffin", "Banana Nut", true);
        System.out.println(pastry.toString());
        
        PastryItem pastry1 = new PastryItem("Cheesecake Slice", "Regular", true);
        System.out.println(pastry1.toString());
        
    }
    
}
