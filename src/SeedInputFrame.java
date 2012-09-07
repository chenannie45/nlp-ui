

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



class SeedInputFrame extends JFrame {
	JFrame mySelf;

	JPanel panel = new JPanel();
	List<TextPanel> textPanels = new ArrayList<TextPanel>();
	JButton confirmButton = new JButton("        GO        ");
	
	Font ftlabel = new Font("Default",Font.BOLD,18);
	Font ftContent = new Font("Default",Font.PLAIN,18);
	
	public SeedInputFrame(int seedNum){
		mySelf = this;
		this.getContentPane().add(panel);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		for(int i = 0; i < seedNum; i++){
			TextPanel newTextPanel = new TextPanel(i+1);
			textPanels.add(newTextPanel);
			panel.add(newTextPanel);
		}
		panel.add(confirmButton);
		
		setActionListener();
		
		confirmButton.setFont(ftlabel);
		
		this.setSize(300, 40*(seedNum+1));
		this.setVisible(true);
	}
	
	private void setActionListener() {
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				final List<String> strings = new ArrayList<String>();
				for(TextPanel p : textPanels){
					strings.add(p.textField.getText());
				}
				Thread nThread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						String[] args = new String[strings.size()+1];
						args[0] = String.valueOf(strings.size());
						int num = 1;
						for(String s : strings){
							args[num] = s;
							num++;
						}
						try {
							activeLearning_and_RF_multiplesRuns.main(args);
						} 
						catch (InterruptedException e){
							e.printStackTrace();
						}
						catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
							
					}
				});
				nThread.start();
				
				WindowEvent wev = new WindowEvent(mySelf, WindowEvent.WINDOW_CLOSING);
				Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);
			}
		});
	}

//	public static void main(String[] args) {
//		SeedInputFrame seedInputFrame = new SeedInputFrame(5);
//		seedInputFrame.setVisible(true);
//	}
	
	class TextPanel extends JPanel{
		
		public JLabel label = new JLabel();
		public JTextField textField = new JTextField();
		
		Font ftlabel = new Font("Default",Font.BOLD,18);
		Font ftContent = new Font("Default",Font.PLAIN,18);
		
		public TextPanel(int num){
			this.label.setText("Seed #" + String.valueOf(num) + " :");
			this.label.setSize(100,60);
			this.textField.setSize(200,60);
			
			label.setFont(ftlabel);
			textField.setFont(ftContent);
			
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			this.add(label);
			this.add(textField);
			
		}
	}

}
