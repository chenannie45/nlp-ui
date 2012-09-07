

import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class TopPanel extends JPanel {
	Font ftFont = new Font("Default",Font.BOLD,18);
	Font ftText = new Font("Default",Font.PLAIN,18);
	
	JLabel label = new JLabel("Number of Seeds:");
	JTextField textField = new JTextField();
	JButton button = new JButton("Confirm");
	
	
	
	public TopPanel(){
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(label);
		this.add(textField);
		this.add(button);
		
		setComponentsSize();
		setActionListener();
	}

	private void setActionListener() {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SeedInputFrame seedInputFrame = new SeedInputFrame(Integer.valueOf(textField.getText()));
			}
		});
	}

	private void setComponentsSize() {
		label.setSize(300, 100);
		textField.setSize(300, 100);
		button.setSize(300, 100);
		
		label.setFont(ftFont);
		textField.setFont(ftText);
		button.setFont(ftFont);
	}
}
