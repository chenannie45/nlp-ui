

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

class ListPanel extends JPanel {
	
	JLabel jlabel = new JLabel();
	JList jlist = new JList();
	DefaultListModel model = new DefaultListModel();
	
	Font ftlabel = new Font("Default",Font.BOLD,18);
	Font ftContent = new Font("Default",Font.PLAIN,15);
	
	public ListPanel(String label){
		
		this.setLayout(new BorderLayout());
		jlabel.setText(label);
		this.add(jlabel,BorderLayout.NORTH);
		this.add(jlist,BorderLayout.CENTER);
		jlabel.setFont(ftlabel);
		jlist.setFont(ftContent);
		
		jlist.setModel(model);
		jlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	}
	
	public void setList(List<String> lists){
		model.clear();
		for(String string : lists){
			model.addElement(string);
		}
	}
}
