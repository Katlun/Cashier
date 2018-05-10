package br.com.gui.panels;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import br.com.dao.ProdutoDao;
import br.com.entidade.Produto;
import br.com.modelo.JTableModelProduto;
import javax.swing.ScrollPaneConstants;
//import javax.swing.table.TableColumn;

public class JTableProduto extends JPanel{

	private static final long serialVersionUID = 1L;
	public static List<Produto> produtos;
	private static JTable table;
	private JTableModelProduto modelo;
	private JScrollPane scrollPane;
	//private TableColumn personalizar;
	
	public JTableProduto(){
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
		ProdutoDao dao = new ProdutoDao();
		produtos =  dao.getList();
		modelo = new JTableModelProduto(produtos);
		table.setModel(modelo);
	}
	
	
}
