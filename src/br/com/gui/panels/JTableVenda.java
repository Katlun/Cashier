package br.com.gui.panels;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import br.com.dao.VendaDao;
import br.com.entidade.Venda;
import br.com.modelo.JTableModelVenda;

public class JTableVenda extends JPanel{

	private static final long serialVersionUID = 1L;
	public static List<Venda> vendas;
	private static JTable table;
	private JTableModelVenda modelo;
	private JScrollPane scrollPane;
	
	public JTableVenda() {
		this.setSize(700, 430);
		this.setVisible(true);
		
		GridLayout layout = new GridLayout();
		layout.setColumns(1);
		layout.setRows(1);
		this.setLayout(layout);
		
		criarJTable();
		criarScrolPane();
	}
	
	public void criarScrolPane(){
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);
	}
	
	public void criarJTable(){
		table = new JTable(modelo);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("consolas", Font.PLAIN, 11));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pesquisar();
	}
	
	public void pesquisar(){
		VendaDao dao = new VendaDao();
		vendas =  dao.getList();
		modelo = new JTableModelVenda(vendas);
		table.setModel(modelo);
	}
	
	
}
