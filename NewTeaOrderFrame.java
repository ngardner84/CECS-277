package project3;

import java.awt.Component;
import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class NewTeaOrderFrame extends JFrame
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
	

	
	public static void main(String[] args) {
		NewTeaOrderFrame t = new NewTeaOrderFrame();
                //c.setSize(800, 400);
                //c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t.setVisible(true); // set it to be visible
                
	}

}
