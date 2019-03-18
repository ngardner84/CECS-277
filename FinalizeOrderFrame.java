
package project3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FinalizeOrderFrame extends JFrame {
    
    private CashRegister cashRegister = new CashRegister();
    private JLabel label, paymentLabel;
    private JTextField textfield;
    private JTextArea textArea;
    private JButton payButton, buttonToBeEnabled;
    private JPanel panel1;    
    
    private double amountDue;
    
    public FinalizeOrderFrame()
    {
        amountDue = 100.00;
        createComponents();
        this.setTitle("Finalize Order");
    }
    
    private void createComponents()
    {
        label = new JLabel("Amount Due:$" + amountDue);
        textArea = new JTextArea(20, 30); 
        JScrollPane scrollPane = new JScrollPane(textArea);
        textfield = new JTextField(10);  
        paymentLabel = new JLabel("Payment:$");
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
    
    public static void main(String[] args)
    {
        FinalizeOrderFrame finOrder = new FinalizeOrderFrame();
        finOrder.setSize(400,600);
        finOrder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finOrder.setVisible(true);
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
