package br.com.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.com.entidade.Venda;

public class JTableModelVenda extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private List<Venda> vendas;
	private String[] colunas = {"ID","DATA DA VENDA","PAGAMENTO","CLIENTE","PRODUTO","QUANTIDADE VEICULOS VENDIDOS","VALOR TOTAL"};
	
	private static final int COL_ID = 0;
	private static final int COL_DATA = 1;
	private static final int COL_PAGAMENTO = 2;
	private static final int COL_CLIENTE = 3;
	private static final int COL_PRODUTO = 4;
	private static final int COL_QUANTIDADE = 5;
	private static final int COL_VALOR_TOTAL = 6;
	
	public JTableModelVenda() {
	
	}
	
	public JTableModelVenda(List<Venda> venda){
		this.vendas = venda;
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.vendas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Venda venda = vendas.get(rowIndex);
		
		if(columnIndex == COL_ID){
			return venda.getId();
		}else if(columnIndex == COL_DATA){
			return venda.getData();
		}else if(columnIndex == COL_PAGAMENTO){
			return venda.getTipoPagamento();
		}else if(columnIndex == COL_CLIENTE){
			return venda.getClienteName();
		}else if(columnIndex == COL_PRODUTO){
			return venda.getProdutoName();
		}else if(columnIndex == COL_QUANTIDADE){
			return venda.getQuantidade_veiculos();
		}else if(columnIndex == COL_VALOR_TOTAL){
			return venda.getValor_total_vendas();
		}
		return null;
	}
	
	public String getColumnName(int columnsIndex){
		return this.colunas[columnsIndex];
	}
	
	public void setListaVenda(ArrayList<Venda> vendas){
		this.vendas = vendas;
	}
	
	public String[] getColunas(){
		return this.colunas;
	}
	
	public void setColunas(String[] colunas){
		this.colunas = colunas;
	}
	
	
}
