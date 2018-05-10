package br.com.gui;

import java.awt.GridLayout;
import javax.swing.JFrame;
import br.com.gui.panels.JTableVenda;

public class JFrameVenda extends JFrame{

	private static final long serialVersionUID = 1L;

	public JFrameVenda() {
		addComponentes();
		definirJanela();
	}
	
	public void definirJanela(){
		this.setTitle("Total de Vendas Realizadas.");
		this.setSize(700, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		GridLayout layout = new GridLayout();
		layout.setColumns(1);
		layout.setRows(1);
		this.getContentPane().setLayout(layout);
		
	}
	
	public void addComponentes(){
		JTableVenda tableVenda = new JTableVenda();
		this.getContentPane().add(tableVenda);
	}
}
