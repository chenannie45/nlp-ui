

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
	
	private JPanel panel = new JPanel();
	private TopPanel topPanel = new TopPanel();
	private CenterPanel centerPanel = new CenterPanel();
	
		
		BorderLayout panelManager = new BorderLayout();
		public MainFrame(){
		panelManager.setVgap(15);
		panel.setLayout(panelManager);
		this.getContentPane().add(panel);
		
		panel.add(topPanel, BorderLayout.NORTH);
		panel.add(centerPanel,BorderLayout.CENTER);
		
		this.setSize(1000,600);
	}
	
	public void setPositiveSeedList(List<String> list){
		this.centerPanel.pSeedListPanel.setList(list);
	}
	
	public void setNegaiveSeedList(List<String> list){
		this.centerPanel.nSeedListPanel.setList(list);
	}
	
	public void setTopRankSeedList(List<String> list){
		this.centerPanel.topRankListPanel.setList(list);
	}
	
	public void setPrecision(String precision){
		this.centerPanel.precisionField.setText(precision);
	}
	
	public void setIter(String iter){
		centerPanel.setIter(iter);
	}
	
	public static void main(String[] args) {
		activeLearning_and_RF_multiplesRuns.loadFiles();
		MainFrame mainFrame = new MainFrame();
		activeLearning_and_RF_multiplesRuns.mainFrame = mainFrame;
		mainFrame.setVisible(true);
	}
}
