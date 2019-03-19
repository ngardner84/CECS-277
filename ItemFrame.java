package project3;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Checkbox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ItemFrame extends JFrame{
	
	private JLabel pastryLabel;
	private JComboBox<String> pastryType;
	private JButton save;
	private JButton cancel;
	private JTextField textfield;

	public ItemFrame()
	{
		createComponents();
		this.setTitle("New pastry order");
		this.setSize(1024,768);
		
	}
	
	private void createComponents()
	{
		textfield = new JTextField("");
		String[] types = {"Muffin", "Cheesecake Slice", "Cookie", "Danish"};
		pastryType = new JComboBox<String>(types);
		cancel = new JButton("Cancel");
		pastryLabel = new JLabel("Pastry");
		save.addActionListener(new ButtonListener());
		
		
		JPanel panel = new JPanel();
		panel.add(pastryType);
		panel.add(cancel);
		panel.add(pastryLabel);
		this.add(panel);
	}
	
	class ButtonListener implements ActionListener{
		
		public void mainMenu() {
		ItemFrame frame = new ItemFrame();
		textfield = new JTextField("");
		String[] cookieType = {"Oatmeal", "White Choco & Macadamias", "Chocolate Chip", "Double Fudge"};
		JComboBox cookies = new JComboBox<String>(cookieType);
		String[] types = {"Muffin", "Cheesecake Slice", "Cookie", "Danish"};
		pastryType = new JComboBox<String>(types);
		save = new JButton("Save order");
		cancel = new JButton("Cancel");
		pastryLabel = new JLabel("Pastry");
		save.addActionListener(new ButtonListener());
		
		ItemFrame newFrame = new ItemFrame();
		newFrame.setVisible(true);
		newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		@Override
		public void actionPerformed(ActionEvent click) {
			JPanel newPanel = new JPanel();
			textfield = new JTextField("");
			String[] cookieType = {"Oatmeal", "White Choco & Macadamias", "Chocolate Chip", "Double Fudge"};
			JComboBox cookies = new JComboBox<String>(cookieType);
			String[] types = {"Muffin", "Cheesecake Slice", "Cookie", "Danish"};
			pastryType = new JComboBox<String>(types);
			save = new JButton("Save order");
			cancel = new JButton("Cancel");
			pastryLabel = new JLabel("Pastry");
			save.addActionListener(new ButtonListener());
			
			ItemFrame newFrame = new ItemFrame();
			newFrame.setVisible(true);
			newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	
	
	
	public static void main(String[] args) {
		ItemFrame a = new ItemFrame();
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setVisible(true);
	}

}