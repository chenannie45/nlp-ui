

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class CenterPanel extends JPanel {
	
	/*
	 * north panel
	 */
	JPanel northPanel = new JPanel();
	JLabel iterLabel = new JLabel("Iteration #:");
	JTextField iterTextField = new JTextField();
	
	Font ftlabel = new Font("Default",Font.BOLD,18);
	Font ftContent = new Font("Default",Font.PLAIN,18);
	
	/*
	 * center panel
	 */
	JPanel centerPanel = new JPanel();
	
	ListPanel pSeedListPanel = new ListPanel("Positive Seed");
	ListPanel nSeedListPanel = new ListPanel("Negative Seed");
	
	JPanel rightPanel = new JPanel();
	ListPanel topRankListPanel = new ListPanel("Top Rank Named Entities");
	
	JPanel rightBottomPanel = new JPanel();
	JLabel precisionLabel = new JLabel("Precision:");
	JTextField precisionField = new JTextField();
	JButton restartButton = new JButton("Restart");
	
	
	
	public CenterPanel(){
		
		setupNorthPanel();
		setupCenterPanel();
		
		this.setLayout(new BorderLayout());
		this.add(northPanel, BorderLayout.NORTH);
		this.add(centerPanel,BorderLayout.CENTER);
		
		setActionListener();
	}

	private void setupNorthPanel() {
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
		northPanel.add(iterLabel);
		northPanel.add(iterTextField);
		iterLabel.setFont(ftlabel);
		iterTextField.setFont(ftContent);
	}
	
	public void setIter(String iter){
		this.iterTextField.setText(iter);
	}


	private void setupCenterPanel() {
		
		GridLayout gridLayout = new GridLayout(1, 3);
		gridLayout.setHgap(10);
		
		
		centerPanel.setLayout(gridLayout);
		centerPanel.add(pSeedListPanel);
		centerPanel.add(nSeedListPanel);
		centerPanel.add(rightPanel);
		
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(topRankListPanel, BorderLayout.CENTER);
		rightPanel.add(rightBottomPanel, BorderLayout.SOUTH);
	
		
		JPanel precisionPanel = new JPanel();
		precisionPanel.setLayout(new BoxLayout(precisionPanel, BoxLayout.Y_AXIS));
		precisionPanel.add(precisionLabel);
		precisionPanel.add(precisionField);
		rightBottomPanel.setLayout(new BorderLayout());
		rightBottomPanel.add(precisionPanel, BorderLayout.CENTER);
		JPanel restartPanel = new JPanel();
		restartPanel.setLayout(new BorderLayout());
		restartPanel.add(restartButton, BorderLayout.SOUTH);	
		rightBottomPanel.add(restartPanel, BorderLayout.EAST);
		
		restartButton.setFont(ftlabel);
		precisionField.setFont(ftContent);
		precisionLabel.setFont(ftlabel);
	}


	private void setActionListener() {
		restartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				activeLearning_and_RF_multiplesRuns.deadFlag = true;
				activeLearning_and_RF_multiplesRuns.restartSettings();
				activeLearning_and_RF_multiplesRuns.mainFrame.setVisible(false);
				activeLearning_and_RF_multiplesRuns.mainFrame = null;
				MainFrame mainFrame = new MainFrame();
				activeLearning_and_RF_multiplesRuns.mainFrame = mainFrame;
				mainFrame.setVisible(true);
				
			}
		});
	}

	
}
