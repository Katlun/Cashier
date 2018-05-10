package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import br.com.entidade.Venda;
import br.com.persistencia.Persistencia;

public class RelatorioDao {

	Persistencia persistencia;
	private final String INSERT = "INSERT INTO RELATORIO(DATA_RELATORIO,QUANTIDADE_VEICULOS_VENDIDOS,VALOR_TOTAL_VEICULOS_VENDIDOS) VALUES (?,?,?)";
	
	public RelatorioDao() {
		this.persistencia = new Persistencia();
	}
	
	public RelatorioDao(Persistencia persistencia){
		this.persistencia = persistencia;
	}
	
	
	@SuppressWarnings("null")
	public void inserir(){
		ArrayList<Venda> vendas = new ArrayList<>();
		VendaDao dao = new VendaDao();
		
		PreparedStatement pstm = null;
		int quantidade_total = 0;
		Double valor_total = null;
		
		vendas = (ArrayList<Venda>) dao.getVendaData();
		
		for(Venda venda : vendas){
			venda.viewVendaConsoleLine();
			quantidade_total += venda.getQuantidade_veiculos();
			valor_total += venda.getValor_total_vendas();
		}
		System.out.println(quantidade_total);
		System.out.println(valor_total);
		try {
			pstm = persistencia.getConection().prepareStatement(INSERT);
			
			Date dataAtual = new Date(Calendar.getInstance().getTimeInMillis());  
			java.sql.Date d = new java.sql.Date(dataAtual.getTime());
			
			pstm.setDate(1, d);
			pstm.setInt(2, quantidade_total);
			pstm.setDouble(3, valor_total);
			
			System.out.println("Relatorio inserido com sucesso.");
		} catch (SQLException e) {
			System.err.println("Erro ao inserir relatorio.");
			e.printStackTrace();
		} finally {
			persistencia.fecharConexao();
		}
		
	}
	
	
	
	
}
