package br.com.aplication;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class Fourcar extends javax.swing.JFrame{

	private static final long serialVersionUID = 1L;

	
	public Fourcar() {
		setTitle("Foucar");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(23, 42, 180, 112);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
	
	}
}
