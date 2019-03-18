/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Dimithri_2
 */
public class NewPastryOrderFrame extends JFrame {


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
	//this hides the frame on close without terminating the program
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
    
    public static void main(String[] args) {
		NewPastryOrderFrame p = new NewPastryOrderFrame();
                //c.setSize(800, 400);
                p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setVisible(true); // set it to be visible
                
	}
}
