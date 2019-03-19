
package project3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class NewOrderFrame extends JFrame {
        private JLabel itemToPurchaseLabel;
        private JButton coffeeButton;
        private JButton teaButton;
        private JButton pastryButton, doneButton;
        protected JPanel panel = new JPanel();
        
        public CashRegister cash = new CashRegister();
    
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
                    dispose();
                }
                
                new FinalizeOrderFrame().setVisible(true);
                dispose();

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
        
        /*
        public static void main(String[] args)
        {
            NewOrderFrame o = new NewOrderFrame();
            o.setVisible(true);
            
        }
        */

}

