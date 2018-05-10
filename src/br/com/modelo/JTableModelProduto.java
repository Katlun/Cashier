package br.com.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.com.entidade.Produto;

public class JTableModelProduto extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Define a posicao onde serao armazanados os valores da coluna.
	 */
	private static final int COL_ID = 0;
	private static final int COL_MODELO = 1;
	private static final int COL_MARCA = 2;
	private static final int COL_COR = 3;
	private static final int COL_ANO = 4;
	private static final int COL_VALOR = 5;
	private static final int COL_DATA = 6;
	private static final int COL_QUANTIDADE = 7;
	//Indica as posicoes da coluna na tabela.
	private String[] colunas = {"ID","MODELO","MARCA","COR","ANO","VALOR","ENTRADA NO ESTOQUE","QUANTIDADE"};
	
	List<Produto> linha;
	
	public JTableModelProduto(List<Produto> produto) {
		this.linha = new ArrayList<>(produto);
	}
	
	
	
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.linha.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Produto produto = linha.get(rowIndex);
		
		if(columnIndex == COL_ID){
			return produto.getId();
		}else if(columnIndex == COL_MODELO){
			return produto.getModelo();
		}else if(columnIndex == COL_MARCA){
			return produto.getMarca();
		}else if(columnIndex == COL_COR){
			return produto.getCor();
		}else if(columnIndex == COL_ANO){
			return produto.getAno();
		}else if(columnIndex == COL_VALOR){
			return "R$ " + produto.getValor();
		}else if(columnIndex == COL_DATA){
			return produto.getEntrada();
		}else if(columnIndex == COL_QUANTIDADE){
			return produto.getQuantidade();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int columnIndex){
		return this.colunas[columnIndex];
	}

	public void setListaProduto(ArrayList<Produto> produtos){
		this.linha = produtos;
	}
	
	public String[] getColunas(){
		return this.colunas;
	}
	
	public void setColunas(String[] colunas){
		this.colunas = colunas;
	}
	
}
