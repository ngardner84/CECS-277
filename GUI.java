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

import project3.FinalizeOrderFrame.ExitButtonListener;
import project3.FinalizeOrderFrame.PayButtonListener;


public class GUI {

	public static CashRegister cash = new CashRegister();
	
	public static class NewOrderFrame extends JFrame {
        private JLabel itemToPurchaseLabel;
        private JButton coffeeButton;
        private JButton teaButton;
        private JButton pastryButton, doneButton;
        protected JPanel panel = new JPanel();
    
	public NewOrderFrame()
        {
            createComponents();
            this.setTitle("New Order");
            this.setSize(800, 400);
		    //this hides the frame on close without terminating the program
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
	
        
        private void createComponents()
        {	
		//Creating components
		itemToPurchaseLabel = new JLabel("Select an item to purchase: "); //text
		coffeeButton = new JButton("Coffee"); //button
        teaButton = new JButton("Tea"); //button
        pastryButton = new JButton("Pastry"); //button
        doneButton = new JButton("Done");
		
                
                //creating the event listener object
		ActionListener coffeeListener = new coffeeButtonListener();
		coffeeButton.addActionListener(coffeeListener);
                
        ActionListener teaListener = new teaButtonListener();
        teaButton.addActionListener(teaListener);
                
        ActionListener pastryListener = new pastryButtonListener();
		pastryButton.addActionListener(pastryListener);
                
        ActionListener doneListener = new doneButtonListener();
        doneButton.addActionListener(doneListener);
                
		//Adding the components to the panel
        panel.add(itemToPurchaseLabel);
		panel.add(coffeeButton);
        panel.add(teaButton);
        panel.add(pastryButton);
		//Add panel to frame
		this.add(panel);
	    }
        
        
        class doneButtonListener implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent click)
            {
                while(click.getSource() != "Done")
                {
                    boolean enable = click.getSource().equals(click);
                    doneButton.setEnabled(enable);
                    new FinalizeOrderFrame().setVisible(true);
                    
                }
                
                System.exit(0);
                                

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
		private JLabel label;
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
			instructions = new JLabel("Specify your coffee order: ");
			
			String[] sizes = {"S", "M", "L"};
			sizeOptions = new JComboBox<String>(sizes);
			
			String[] tsp = {"1", "2","3","4","5","6","7","8","9","10"};
			sugarTsp = new JComboBox<String>(tsp);
			
			String[] bases = {"whole milk", "hald-and-half", "No milk"};
			baseOptions = new JComboBox<String>(bases);
	                
	        String[] flavors = {"regular", "mocha", "hazelnut", "vanilla"};
	        flavorOptions = new JComboBox<String>(flavors);
	                
	        String[] temperature = {"hot", "iced", "blended"};
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
	        panel.add(new JLabel("flavor: "));
	        panel.add(flavorOptions);
			panel.add( new JLabel("size: "));
			panel.add(sizeOptions);
			panel.add(new JLabel("sugar: "));
			panel.add(sugarTsp);
			panel.add(new JLabel("milk: "));
			panel.add(baseOptions);
	        panel.add(new JLabel("type: "));
	        panel.add(temperatureOptions);
	        panel.add(new JLabel("special instructions: "));
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
	                       DrinkItem coffeeDrink = new CoffeeItem(sizeOptions.getName(),sugarTsp.getName(),
	                               flavorOptions.getName(),baseOptions.getName(),temperatureOptions.getName(),
	                               specialInstructions.getName());
	                       			coffeeDrink.toString();
	                    
	                    
	                  
	                    
	                    NewOrderFrame n = new NewOrderFrame();
	                    n.setVisible(true);
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
	                       NewOrderFrame n = new NewOrderFrame();
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
        
        //ItemListener heatedCheckBoxListener = new NewPastryOrderFrame.heatedCheckBoxListener();
        //heatedCheckBox.addItemListener(heatedCheckBoxListener);
        
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
                                    PastryItem m = new PastryItem("Muffin",muffinOption,heatedCheckBox.getState());
                                    m.calculateCost();
                                    break;
                                }
                            case "Cookie":
                                {
                                    String cookieOption = cookieType[cookieTypeOptions .getSelectedIndex()];
                                    PastryItem cookie = new PastryItem("Cookie",cookieOption,heatedCheckBox.getState());
                                    cookie.calculateCost();
                                    break;
                                }
                            case "Cheesecake Slice":
                                {
                                    String cheeseCakeOption = cheesecakeSliceType[cheesecakeSliceTypeOptions.getSelectedIndex()];
                                    PastryItem cheeseCake = new PastryItem("Cheesecake Slice",cheeseCakeOption,heatedCheckBox.getState());
                                    cheeseCake.calculateCost();
                                    break;
                                }
                            default:
                                {                                   
                                    String danishOption = danishType[danishTypeOptions.getSelectedIndex()];
                                    PastryItem danish = new PastryItem("Danish",danishOption,heatedCheckBox.getState());
                                    danish.calculateCost();
                                    break;
                                }
                        }                        
                        new NewOrderFrame().setVisible(true);                     
                        dispose();
                        
                      
                    }                                
                                 
		}
		
	}
    
    class CancelButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent click) 
                {
                    new NewOrderFrame().setVisible(true);
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
                        //lblText.setText("You have selected a Muffin pastry.");
                        panel.add(muffinTypeOptions);
                        break;
                    case 1:
                        //lblText.setText("You have selected a Cookie pastry.");
                        panel.add(cookieTypeOptions);
                        break;
                    case 2:
                        //lblText.setText("You have selected Cheesecake Slice pastry.");
                     
                        panel.add(cheesecakeSliceTypeOptions);
                        break;
                    case 3:
                        //lblText.setText("You have selected Danish pastry.");
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
	    private Checkbox toppingcheckBox1, toppingcheckBox2, toppingcheckBox3, toppingcheckBox4, toppingcheckBox5, toppingcheckBox6;
	    private JPanel panel; 
	    protected ArrayList<String> toppings;
		
		public NewTeaOrderFrame() {
			//create the components
			createComponents();
			
			//set frame properties
			this.setTitle("New Tea Order");
			this.setSize(800, 400);
			//this hides the frame on close without terminating the program
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
			
			//creating the event listener object
			ActionListener saveListener = new SaveButtonListener();
			
			//using the listener object to define button reaction
			save.addActionListener(saveListener);
	                
	                
	        ActionListener cancelListener = new CancelButtonListener();
	        cancel.addActionListener(cancelListener);
	                
	        //6 check boxes for toppings
	        toppingcheckBox1 = new Checkbox("boba");
	        toppingcheckBox2 = new Checkbox("popping boba");
	        toppingcheckBox3 = new Checkbox("grass jelly");
	        toppingcheckBox4 = new Checkbox("lychee jelly");
	        toppingcheckBox5 = new Checkbox("coconut jelly");
	        toppingcheckBox6 = new Checkbox("mini mochi");
	           		
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
	        panel.add(toppingcheckBox1);
	        panel.add(toppingcheckBox2);
	        panel.add(toppingcheckBox3);
	        panel.add(toppingcheckBox4);
	        panel.add(toppingcheckBox5);
	        panel.add(toppingcheckBox6);


			
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
	                    label.setText("~~~~~~~~~~~~~~Current Order~~~~~~~~~~~~~~~");

	                    
	                    new NewOrderFrame().setVisible(true);
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
	                       new NewOrderFrame().setVisible(true);
	                    }
	                                 
			}
			
		}
	}
	
	
	public static class FinalizeOrderFrame extends JFrame {
	   
	    private JLabel label, paymentLabel;
	    private JTextField textfield;
	    private JTextArea textArea;
	    private JButton payButton, buttonToBeEnabled;
	    private JPanel panel1;    
	    
	    private double amountDue;
	    
	    public FinalizeOrderFrame()
	    {
	        amountDue = cash.getsubTotalBT();
	        createComponents();
	        this.setTitle("Finalize Order");
	    }
	    
	    private void createComponents()
	    {
	        label = new JLabel("Amount Due: $" + amountDue);
	        textArea = new JTextArea(30, 7); 
	        JScrollPane scrollPane = new JScrollPane(textArea);
	        textfield = new JTextField(10);  
	        paymentLabel = new JLabel("Payment: $");
	        payButton = new JButton("Pay");
	        ActionListener payB = new PayButtonListener();
	        payButton.addActionListener(payB);
	        buttonToBeEnabled = new JButton("Exit");
	        ActionListener Exit = new ExitButtonListener();
	        buttonToBeEnabled.addActionListener(Exit);
	        
	        
	        panel1 = new JPanel();
	        panel1.add(label);
	        panel1.add(scrollPane,BorderLayout.CENTER);
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
	                     panel1.add(buttonToBeEnabled);
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
	        buttonToBeEnabled.setEnabled(enable);
	        }
	    }
	    
	    
	}

	
	
	public static void main(String[] args) {
		NewOrderFrame mainMenu = new NewOrderFrame();
		mainMenu.setVisible(true);
		System.out.println("Hello world");
	}
}
