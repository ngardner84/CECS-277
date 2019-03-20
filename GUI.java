package project3;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class GUI {

	public static CashRegister cash = new CashRegister();
	public static boolean hasItem = false;
	
	public static class MainMenu extends JFrame {
        private JLabel purchaseLabel;
        private JButton coffeeButton;
        private JButton teaButton;
        private JButton pastryButton, doneButton;
        protected JPanel panel = new JPanel();
    
	public MainMenu()
        {
            createComponents();
            this.setTitle("New Order");
            this.setSize(800, 500); 
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
	
        
        private void createComponents()
        {	
		//Creating components
        JTextArea receiptText = new JTextArea(25,50);
        JScrollPane receiptPane = new JScrollPane(receiptText);
        if(GUI.cash.drinkItems.size() > 0 || GUI.cash.pastryItems.size() > 0) {
        	hasItem = true;
        	receiptText.append("\n\t~~~~~~~~~~~~~~~~~~~~~~~~Current Order~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        	for(int i = 0;i < GUI.cash.drinkItems.size();i++) {
        		receiptText.append(GUI.cash.drinkItems.get(i).toString());
        	}
        	for(int j = 0;j < GUI.cash.pastryItems.size();j++) {
        		receiptText.append(GUI.cash.pastryItems.get(j).toString());
        	}
        }
        	
        purchaseLabel = new JLabel("Select an item to purchase: "); 
		coffeeButton = new JButton("Coffee"); 
        teaButton = new JButton("Tea"); 
        pastryButton = new JButton("Pastry"); 
        doneButton = new JButton("Done");
		
		ActionListener coffeeListener = new coffeeButtonListener();
		coffeeButton.addActionListener(coffeeListener);
                
        ActionListener teaListener = new teaButtonListener();
        teaButton.addActionListener(teaListener);
                
        ActionListener pastryListener = new pastryButtonListener();
		pastryButton.addActionListener(pastryListener);
                
        ActionListener doneListener = new doneButtonListener();
        doneButton.addActionListener(doneListener);
                
		//Adding the components to the panel
        panel.add(purchaseLabel);
		panel.add(coffeeButton);
        panel.add(teaButton);
        panel.add(pastryButton);
        if(hasItem == true) {
        	panel.add(receiptPane);
        	panel.add(doneButton);
        }
        
		//Add panel to frame
		this.add(panel);
	    }
        
        
        class doneButtonListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent click)
            {
                if(click.getSource() == doneButton)
                {
                	if(GUI.cash.drinkItems.size() == 0 && GUI.cash.pastryItems.size() == 0) {
                		System.exit(0);
                	}
                    boolean enable = click.getSource().equals(click);
                    doneButton.setEnabled(enable);
                    new FinalizeOrderFrame().setVisible(true);
                    dispose();
                }
                                
            }
        }
        
        
        class coffeeButtonListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent click) 
            {
                new NewCoffeeOrderFrame().setVisible(true); 
                dispose();
            }
        }
        
        class teaButtonListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent click) 
            {
                new NewTeaOrderFrame().setVisible(true);
                dispose();
            }
        }
        
        
        class pastryButtonListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent click) 
            {              
                new NewPastryOrderFrame().setVisible(true);
                dispose();
            }
            
            
        }
	}

	public static class NewCoffeeOrderFrame extends JFrame
	{
		private JLabel instructions;
		private JComboBox<String> sizeOptions;
		private JComboBox<String> sugarTsp;
		private JComboBox<String> baseOptions;
	    private JComboBox<String> flavorOptions;
	    private JComboBox<String> temperatureOptions;
	    private JTextField specialInstructions;
		private JButton save;
	    private JButton cancel;
		
		public NewCoffeeOrderFrame() {
			//create the components
			createComponents();
			
			//set frame properties
			this.setTitle("New Coffee Order");
			this.setSize(800, 400);
			//this hides the frame on close without terminating the program
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		
		private void createComponents() {
			//instantiate the components
			instructions = new JLabel("How would you like your coffee?: ");
			
			String[] sizes = {"S", "M", "L"};
			sizeOptions = new JComboBox<String>(sizes);
			
			String[] tsp = {"1", "2","3","4","5","6","7","8","9","10"};
			sugarTsp = new JComboBox<String>(tsp);
			
			String[] bases = {"Whole Milk", "Half and Half", "No Milk"};
			baseOptions = new JComboBox<String>(bases);
	                
	        String[] flavors = {"Regular", "Mocha", "Hazelnut", "Vanilla"};
	        flavorOptions = new JComboBox<String>(flavors);
	                
	        String[] temperature = {"Hot", "Iced", "Blended"};
	        temperatureOptions = new JComboBox<String>(temperature);
	                
	        specialInstructions = new JTextField(50);
	                
			
			save = new JButton("Save Order");
	        cancel = new JButton("Cancel");
			
			//creating the event listener object
			ActionListener saveListener = new SaveButtonListener();
			
			//using the listener object to define button reaction
			save.addActionListener(saveListener);
	                
	                
	        ActionListener cancelListener = new CancelButtonListener();
	        cancel.addActionListener(cancelListener);
	                
	                
			
			//Create the panel and add components
			JPanel panel = new JPanel();
			panel.add(instructions);
	        panel.add(new JLabel("Flavor: "));
	        panel.add(flavorOptions);
			panel.add( new JLabel("Size: "));
			panel.add(sizeOptions);
			panel.add(new JLabel("Sugar: "));
			panel.add(sugarTsp);
			panel.add(new JLabel("Milk: "));
			panel.add(baseOptions);
	        panel.add(new JLabel("Type: "));
	        panel.add(temperatureOptions);
	        panel.add(new JLabel("Special instructions: "));
	        panel.add(specialInstructions);
	 		panel.add(save);
	        panel.add(cancel);
			
			//Add panel to frame
			this.add(panel);
		}
		
		//INNER EVENT LISTENER CLASS FOR SAVE BUTTON
		class SaveButtonListener implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent click) {
	                    String c = click.getActionCommand();
	                    if(c.equals("Save Order"))
	                    {
	                       DrinkItem coffeeDrink = new CoffeeItem(sizeOptions.getSelectedItem().toString(),sugarTsp.getSelectedItem().toString(),
	                               flavorOptions.getSelectedItem().toString(),baseOptions.getSelectedItem().toString(),temperatureOptions.getSelectedItem().toString(),
	                               specialInstructions.getText());
	                      GUI.cash.addDrink(coffeeDrink);
	                    
	                    MainMenu mainMenu = new MainMenu();
	                    mainMenu.setVisible(true);
	                    dispose();
	                    }
	                        
	                        
			}
			
		}
	        
	        //INNER EVENT LISTENER CLASS FOR CANCEL BUTTON
		class CancelButtonListener implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent click) 
	                {
	                    String c = click.getActionCommand();
	                    if(c.equals("Cancel"))
	                    {
	                       MainMenu n = new MainMenu();
	                       n.setVisible(true);
	                       n.panel.add(new JButton("Done"));
	                       n.panel.revalidate();
	                       n.panel.repaint();
	                       
	                       dispose();
	                    }
	                    
	                    
			}
			
		}
	}
	
	public static class NewPastryOrderFrame extends JFrame {


        private String[] pastryType = {"Muffin", "Cookie", "Cheesecake Slice", "Danish"};
        private JComboBox<String> pastryTypeOptions;
        
        private String[] muffinType = {"Banana Nut", "Blueberry", "Chocolate Chip", "Coffee Cake"};
        private JComboBox muffinTypeOptions = new JComboBox<>(muffinType);
        
        private String[] cookieType = {"Oatmeal", "White Choco & Macadamias","Chocolate Chip","Double Fudge"};
        private JComboBox cookieTypeOptions = new JComboBox<>(cookieType);
        
        private String[] cheesecakeSliceType = {"Regular", "Cherry","Blueberry"};
        private JComboBox cheesecakeSliceTypeOptions = new JComboBox<>(cheesecakeSliceType);
        
        
        private String[] danishType = {"Apple Cinnamon", "Strawberry & Cheese","Double Cheese"};
        private JComboBox danishTypeOptions = new JComboBox<>(danishType);
        

        private JButton save;
        private JButton cancel;
        private Checkbox heatedCheckBox;
        private JLabel lblText = new JLabel();
        private JPanel panel = new JPanel();
        
    public NewPastryOrderFrame()
    {
        createComponents();
		
        //set frame properties
        this.setTitle("Pastry Order");
        this.setSize(800, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    private void createComponents() 
    {
        heatedCheckBox = new Checkbox();
        pastryTypeOptions = new JComboBox<>(pastryType);

        save = new JButton("Save");
        ActionListener saveListener = new NewPastryOrderFrame.SaveButtonListener();
        save.addActionListener(saveListener);
        
        cancel = new JButton("Cancel");
        ActionListener cancelListener = new NewPastryOrderFrame.CancelButtonListener();
        cancel.addActionListener(cancelListener);
        
        ActionListener pastryOptionListener = new NewPastryOrderFrame.pastryOptionListener();
        pastryTypeOptions.addActionListener(pastryOptionListener);
        
        panel.add(pastryTypeOptions);
        panel.add(cancel);
        this.add(panel);

    }

    
    class SaveButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent click) {

                    String c = click.getActionCommand();
                    if(c.equals("Save"))
                    {
                        switch (pastryType[pastryTypeOptions.getSelectedIndex()]) {
                            case "Muffin":
                                {
                                    String muffinOption = muffinType[pastryTypeOptions.getSelectedIndex()];
                                    PastryItem muffin = new PastryItem("Muffin",muffinOption,heatedCheckBox.getState());
                                    GUI.cash.pastryItems.add(muffin);
                                    break;
                                }
                            case "Cookie":
                                {
                                    String cookieOption = cookieType[cookieTypeOptions .getSelectedIndex()];
                                    PastryItem cookie = new PastryItem("Cookie",cookieOption,heatedCheckBox.getState());
                                    GUI.cash.pastryItems.add(cookie);
                                    break;
                                }
                            case "Cheesecake Slice":
                                {
                                    String cheeseCakeOption = cheesecakeSliceType[cheesecakeSliceTypeOptions.getSelectedIndex()];
                                    PastryItem cheeseCake = new PastryItem("Cheesecake Slice",cheeseCakeOption,heatedCheckBox.getState());
                                    GUI.cash.pastryItems.add(cheeseCake);
                                    break;
                                }
                            default:
                                {                                   
                                    String danishOption = danishType[danishTypeOptions.getSelectedIndex()];
                                    PastryItem danish = new PastryItem("Danish",danishOption,heatedCheckBox.getState());
                                    GUI.cash.pastryItems.add(danish);
                                    break;
                                }
                        }
                        new MainMenu().setVisible(true);                     
                        dispose();
                        
                      
                    }                                
                                 
		}
		
	}
    
    class CancelButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent click) 
                {
                    new MainMenu().setVisible(true);
                    dispose();
		}
		
	}
    
    class pastryOptionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == pastryTypeOptions)
            {
                switch (pastryTypeOptions.getSelectedIndex()) 
                {
                    case 0:
                        panel.add(muffinTypeOptions);
                        break;
                    case 1:
                        panel.add(cookieTypeOptions);
                        break;
                    case 2:
                        panel.add(cheesecakeSliceTypeOptions);
                        break;
                    case 3:
                        panel.add(danishTypeOptions);
                        break; 
                    default:
                        lblText.setText("Error!");
                        break;
                }
                
                panel.add(new JLabel("heated: "));
                panel.add(heatedCheckBox);
                panel.remove(cancel);
                panel.add(save);
                panel.add(cancel);
                panel.revalidate();
                panel.repaint();
                    
            }
        }
    }
	}
	
	public static class NewTeaOrderFrame extends JFrame
	{
	    private JLabel label;
		private JLabel instructions;
		private JComboBox<String> sizeOptions;
		private JComboBox<String> sweetnessOptions;
		private JComboBox<String> baseOptions;
	    private JComboBox<String> flavorOptions;
		private JButton save;
	    private JButton cancel;
	    private Checkbox topping1, topping2, topping3, topping4, topping5, topping6;
	    private JPanel panel; 
	    protected ArrayList<String> toppings;
		
		public NewTeaOrderFrame() {
			createComponents();
			this.setTitle("New Tea Order");
			this.setSize(800, 400);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		
		private void createComponents() {
			//instantiate the components
	        label = new JLabel("~~~~~~~~~~~~~");
			instructions = new JLabel("Specify the tea order: ");
			
			String[] sizes = {"S", "M", "L"};
			sizeOptions = new JComboBox<>(sizes);
			
			String[] sweetness = {"Full", "1/2 sweet","3/4 sweet","1/4 sweet","Unsweetened"};
			sweetnessOptions = new JComboBox<>(sweetness);
			
			String[] bases = {"whole milk", "hald-and-half", "No milk"};
			baseOptions = new JComboBox<>(bases);
	                
	        String[] flavors = {"Rose Tea", "Green Tea", "Black Tea", "Jasmine Green Tea","Oolong Tea"};
	        flavorOptions = new JComboBox<>(flavors);              
			
			save = new JButton("Save Order");
	        cancel = new JButton("Cancel");
	        
			ActionListener saveListener = new SaveButtonListener();
			
			save.addActionListener(saveListener);
	                
	                
	        ActionListener cancelListener = new CancelButtonListener();
	        cancel.addActionListener(cancelListener);
	                
	        topping1 = new Checkbox("boba");
	        topping2 = new Checkbox("popping boba");
	        topping3 = new Checkbox("grass jelly");
	        topping4 = new Checkbox("lychee jelly");
	        topping5 = new Checkbox("coconut jelly");
	        topping6 = new Checkbox("mini mochi");
	           		
			//Create the panel and add components
	        panel = new JPanel();
			panel.add(instructions);
	        panel.add(flavorOptions);
			panel.add(new JLabel("size: "));
			panel.add(sizeOptions);
			panel.add(new JLabel("sweetness: "));
			panel.add(sweetnessOptions);
			panel.add(new JLabel("milk: "));
			panel.add(baseOptions); 		
	        panel.add(save);
	        panel.add(cancel);
	        panel.add(topping1);
	        panel.add(topping2);
	        panel.add(topping3);
	        panel.add(topping4);
	        panel.add(topping5);
	        panel.add(topping6);


			
			//Add panel to frame
			this.add(panel);
		}
	        
		//INNER EVENT LISTENER CLASS FOR SAVE BUTTON
		class SaveButtonListener implements ActionListener
		{

			@Override
			public void actionPerformed(ActionEvent click) {
	                    String c = click.getActionCommand();
	                    

	                    if(c.equals("Save Order"))
	                    {
	                    TeaItem newTea = new TeaItem(sizeOptions.getSelectedItem().toString(), sweetnessOptions.getSelectedItem().toString(), flavorOptions.getSelectedItem().toString(), baseOptions.getSelectedItem().toString());
	                    if(topping1.getState() == true) {
	                    	newTea.addTopping("boba");
	                    }
	                    if(topping2.getState() == true) {
	                    	newTea.addTopping("popping boba");
	                    }
	                    if(topping3.getState() == true) {
	                    	newTea.addTopping("grass jelly");
	                    }
	                    if(topping4.getState() == true) {
	                    	newTea.addTopping("lychee jelly");
	                    }
	                    if(topping5.getState() == true) {
	                    	newTea.addTopping("coconut jelly");
	                    }
	                    if(topping6.getState() == true) {
	                    	newTea.addTopping("mini mochi");
	                    }
	                    GUI.cash.drinkItems.add(newTea);
	                    new MainMenu().setVisible(true);
	                    dispose();
	                    }
	                    panel.revalidate();
	                    panel.repaint();
	                        
	                        
			}
			
		}
	       
	        //INNER EVENT LISTENER CLASS FOR CANCEL BUTTON
		class CancelButtonListener implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent click) 
	                {
	                    String c = click.getActionCommand();
	                    if(c.equals("Cancel"))
	                    {
	                       dispose();
	                       new MainMenu().setVisible(true);
	                    }
	                                 
			}
			
		}
	}
	
	
	public static class FinalizeOrderFrame extends JFrame {
	   
	    private JLabel label, paymentLabel;
	    private JTextField textfield;
	    private JTextArea textArea;
	    private JButton payButton, exitButton;
	    private JPanel panel1;    
	    
	    private double amountDue;
	    
	    public FinalizeOrderFrame()
	    {
	        amountDue = cash.totalBeforeTax();
	        createComponents();
	        this.setTitle("Finalize Order");
	        this.setSize(800,500);
	    }
	    
	    private void createComponents()
	    {
	        label = new JLabel("Amount Due: $" + amountDue);
	        JTextArea receiptText = new JTextArea(25,50);
	        JScrollPane receiptPane = new JScrollPane(receiptText);
	        receiptText.append("\n\t~~~~~~~~~~~~~~~~~~~~~~~~Current Order~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	        for(int i = 0;i < GUI.cash.drinkItems.size();i++) {
	        	receiptText.append(GUI.cash.drinkItems.get(i).toString());
	        }
	        for(int j = 0;j < GUI.cash.pastryItems.size();j++) {
	        	receiptText.append(GUI.cash.pastryItems.get(j).toString());
	        }
	        textfield = new JTextField(10);  
	        paymentLabel = new JLabel("Payment: $");
	        payButton = new JButton("Pay");
	        ActionListener payB = new PayButtonListener();
	        payButton.addActionListener(payB);
	        exitButton = new JButton("Exit");
	        ActionListener Exit = new ExitButtonListener();
	        exitButton.addActionListener(Exit);
	        
	        
	        panel1 = new JPanel();
	        panel1.add(label);
	        panel1.add(receiptPane,BorderLayout.CENTER);
	        panel1.add(paymentLabel);       
	        panel1.add(textfield);  
	        panel1.add(payButton);
	        this.add(panel1);        
	    }
	    
	    class PayButtonListener implements ActionListener
	    {
	        @Override
	        public void actionPerformed(ActionEvent click)
	        {
	            double payment = Double.parseDouble(textfield.getText().trim());
	            
	            do{
	            {
	                if(amountDue == payment)
	                {
	                    label.setText("Thank you!");
	                    break;
	                }
	                else if(payment > amountDue)
	                {
	                     label.setText("Thank you!");
	                     panel1.add(exitButton);
	                     panel1.remove(payButton);
	                     panel1.remove(textfield);
	                     panel1.remove(paymentLabel);
	                     panel1.revalidate();
	                     panel1.repaint();
	                     
	                }
	                else
	                {
	                    amountDue -= payment;
	                    label.setText("Insufficient payment! Amount still due: $" + amountDue); 
	                }
	            }
	            }while(amountDue > payment);
	        }
	    }
	    
	    class ExitButtonListener implements ActionListener {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	        boolean enable = e.getSource().equals(e);
	        exitButton.setEnabled(enable);
	        if(e.getSource() == exitButton) {
	        	dispose();
	        	System.exit(0);
	        }
	        }
	    }
	    
	    
	}

	
	
	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
		mainMenu.setVisible(true);
	}
}
