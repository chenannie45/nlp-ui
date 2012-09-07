
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainPanel extends JPanel {
	private JLabel numberJLabel = new JLabel("SeedNumber:");
	private JPanel jTextPanel = new JPanel();
	private JTextField number = new JTextField();
	private JButton numberSetButton = new JButton("go!");
	
	public MainPanel(){
		setActionListener();
		numberJLabel.setSize(100,300);
		numberJLabel.setSize(800,300);
		numberSetButton.setSize(100, 300);
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(numberJLabel);
		this.add(number);
		this.add(numberSetButton);
		this.setSize(1000,200);
		this.setVisible(true);
		
	}
	
	private void setActionListener() {
		numberSetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				numberInputed();
			}


		});
	}
	
	private void numberInputed() {
		Integer num = Integer.valueOf((String)number.getText());
		
	}

	public static void main(String [] args){
		JFrame mainFrame = new JFrame("ActiveLearning");
		MainPanel mainPanel = new MainPanel();
		mainFrame.getContentPane().add(mainPanel, BorderLayout.NORTH);
		mainFrame.getContentPane().add(new JPanel(),BorderLayout.SOUTH);
		mainFrame.pack();
		mainFrame.setSize(800,100);
		mainFrame.setVisible(true);

	}
}
