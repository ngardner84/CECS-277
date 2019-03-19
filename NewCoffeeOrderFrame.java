package project3;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class NewCoffeeOrderFrame extends JFrame
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
                       /*DrinkItem coffeeDrink = new CoffeeItem(sizeOptions.getName(),sugarTsp.getName(),
                               flavorOptions.getName(),baseOptions.getName(),temperatureOptions.getName(),
                               specialInstructions.getName());
                       coffeeDrink.toString();
                    */
                    
                  
                    
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
	

	
	public static void main(String[] args) {
		NewCoffeeOrderFrame c = new NewCoffeeOrderFrame();
                //c.setSize(800, 400);
                //c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setVisible(true); // set it to be visible
                
	}

}
