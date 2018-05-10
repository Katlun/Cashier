package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.entidade.Venda;
import br.com.persistencia.Persistencia;

public class VendaDao {
	
	Persistencia persistencia;
	
	public VendaDao(){
		this.persistencia = new Persistencia();
	}
	
	public VendaDao(Persistencia p){
		this.persistencia = p;
	}
	
	private final String SELECT = "SELECT * FROM VENDA";
	private final String INSERT = "INSERT INTO VENDA(DATA_VENDA,TIPO_PAGAMENTO,ID_PRODUTO,ID_CLIENTE,VALOR_PRODUTO,QUANTIDADE_VEICULOS) VALUES (?,?,?,?,?,?)";
	
	private final String SELECTDATA = "SELECT * FROM VENDA WHERE DATA_VENDA = ?";
	
	
	public List<Venda> getList(){
		ArrayList<Venda> vendas = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs 		   = null;
		try {
			pstm = persistencia.getConection().prepareStatement(SELECT);
			rs = pstm.executeQuery();
			while(rs.next()){
				Venda venda = new Venda();
				venda.setId(rs.getInt("ID"));
				venda.setData(rs.getDate("DATA_VENDA"));
				venda.setTipoPagamento(rs.getString("TIPO_PAGAMENTO"));
				venda.setIdProduto(rs.getInt("ID_PRODUTO"));
				venda.setIdCliente(rs.getInt("ID_CLIENTE"));
				venda.setValor_produto(rs.getDouble("VALOR_PRODUTO"));
				venda.setQuantidade_veiculos(rs.getInt("QUANTIDADE_VEICULOS"));
				venda.venda(rs.getInt("QUANTIDADE_VEICULOS"), rs.getDouble("VALOR_PRODUTO"));
				vendas.add(venda);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar a lista de Vendas.");
			e.printStackTrace();
		} finally {
			persistencia.fecharConexao();
		}
		return vendas;
	}
	
	
	public Boolean inserirVenda(Venda venda){
		Boolean inserido = null;
		PreparedStatement pstm = null;
		ProdutoDao dao = new ProdutoDao();
		try {
			pstm = persistencia.getConection().prepareStatement(INSERT);
			
			Date dataAtual = new Date(Calendar.getInstance().getTimeInMillis());  
			java.sql.Date d = new java.sql.Date(dataAtual.getTime());
			
			pstm.setDate(1, d);
			pstm.setString(2, venda.getTipoPagamento());
			pstm.setInt(3, venda.getIdProduto());
			pstm.setInt(4, venda.getIdCliente());
			pstm.setDouble(5, venda.getValor_produto());
			pstm.setInt(6, venda.getQuantidade_veiculos());
			pstm.execute();
			dao.updateQuantidadeVeiculos(venda.getIdProduto(), venda.getQuantidade_veiculos());
			JOptionPane.showMessageDialog(null,"Venda concluida com sucesso.");
			inserido = null;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"A venda nao pode ser concluida.");
			e.printStackTrace();
			inserido = false;
		}
		return inserido;
	}
	
	
	public List<Venda> getVendaData(){
		ArrayList<Venda> vendas = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = persistencia.getConection().prepareStatement(SELECTDATA);
			
			Date dataAtual = new Date(Calendar.getInstance().getTimeInMillis());  
			java.sql.Date d = new java.sql.Date(dataAtual.getTime());			
			pstm.setDate(1, d);
			
			rs = pstm.executeQuery();
			while(rs.next()){
				Venda venda = new Venda();
				
				venda.setId(rs.getInt("ID"));
				venda.setData(rs.getDate("DATA_VENDA"));
				venda.setTipoPagamento(rs.getString("TIPO_PAGAMENTO"));
				venda.setIdProduto(rs.getInt("ID_PRODUTO"));
				venda.setIdCliente(rs.getInt("ID_CLIENTE"));
				venda.setValor_produto(rs.getDouble("VALOR_PRODUTO"));
				venda.setQuantidade_veiculos(rs.getInt("QUANTIDADE_VEICULOS"));
				venda.venda(rs.getInt("QUANTIDADE_VEICULOS"), rs.getDouble("VALOR_PRODUTO"));
				vendas.add(venda);
			}
		} catch (SQLException e) {
			System.err.println("Erro ao encontar venda pela sua data.");
			e.printStackTrace();
		} finally {
			persistencia.fecharConexao();
		}
		return vendas;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
