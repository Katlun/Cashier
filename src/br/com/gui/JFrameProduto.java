package br.com.gui;

import javax.swing.JFrame;
import java.awt.GridLayout;
import br.com.gui.panels.JTableProduto;

public class JFrameProduto extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public JFrameProduto() {
		addComponentes();
		definirJanela();
	}
	
	public void definirJanela(){
		this.setTitle("Lista de Produtos no Estoque");
		this.setSize(813, 619);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		GridLayout layout = new GridLayout();
		layout.setColumns(2);
		layout.setRows(1);
		this.getContentPane().setLayout(layout);
		
	}
	
	public void addComponentes(){
		JTableProduto tableProduto = new JTableProduto();
		this.getContentPane().add(tableProduto);
	}

	
}
