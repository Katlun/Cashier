package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.entidade.Produto;
import br.com.persistencia.Persistencia;

public class ProdutoDao {
	
	Persistencia persistencia = new Persistencia();
	
	private final String SELECT = "SELECT * FROM PRODUTO"; 
	private final String INSERT = "INSERT INTO PRODUTO(MODELO,MARCA,COR,ANO,VALOR,DATA_ENTRADA_ESTOQUE,QUANTIDADE_VEICULOS) VALUES (?,?,?,?,?,?,?)";
	private final String UPDATE = "UPDATE PRODUTO SET QUANTIDADE_VEICULOS = ? WHERE ID = ?";
	
	private final String SELECTBYID = "SELECT * FROM PRODUTO WHERE ID = ?";
	
	/*
	 * @return uma lista de produtos do estoque.
	 */
	public List<Produto> getList(){
		ArrayList<Produto> produtos = new ArrayList<>();
		PreparedStatement pstm      = null;
		ResultSet rs                = null;
		try {
			pstm = persistencia.getConection().prepareStatement(SELECT);
			rs = pstm.executeQuery();
			while(rs.next()){
				Produto produto = new Produto();
				produto.setId(rs.getInt("ID"));
				produto.setModelo(rs.getString("MODELO"));
				produto.setMarca(rs.getString("MARCA"));
				produto.setCor(rs.getString("COR"));
				produto.setAno(rs.getInt("ANO"));
				produto.setValor(rs.getDouble("VALOR"));
				produto.setEntrada(rs.getDate("DATA_ENTRADA_ESTOQUE"));
				produto.setQuantidade(rs.getInt("QUANTIDADE_VEICULOS"));
				produtos.add(produto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			persistencia.fecharConexao();
		}
		return produtos;
	}
	
	
	public Produto getProdutoId(int id){
		Produto produto = new Produto();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = persistencia.getConection().prepareStatement(SELECTBYID);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()){
				produto.setId(rs.getInt("ID"));
				produto.setModelo(rs.getString("MODELO"));
				produto.setMarca(rs.getString("MARCA"));
				produto.setCor(rs.getString("COR"));
				produto.setAno(rs.getInt("ANO"));
				produto.setValor(rs.getDouble("VALOR"));
				produto.setEntrada(rs.getDate("DATA_ENTRADA_ESTOQUE"));
				produto.setQuantidade(rs.getInt("QUANTIDADE_VEICULOS"));
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao encontrar produto pelo seu Id.");
			e.printStackTrace();
		} finally {
			persistencia.fecharConexao();
		}
		return produto;
	}
	
	
	public void insert(Produto produto){
		PreparedStatement pstm = null;
		try {
			pstm = persistencia.getConection().prepareStatement(INSERT);
			
			pstm.setString(1, produto.getModelo());
			pstm.setString(2, produto.getMarca());
			pstm.setString(3, produto.getCor());
			pstm.setInt(4, produto.getAno());
			pstm.setDouble(5, produto.getValor());
			
			Date dataAtual = new Date(Calendar.getInstance().getTimeInMillis());  
			java.sql.Date d = new java.sql.Date(dataAtual.getTime());
			
			pstm.setDate(6,d);
			pstm.setInt(7, produto.getQuantidade());
			pstm.execute();
			
			JOptionPane.showMessageDialog(null,"Produto inserido com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			persistencia.fecharConexao();
		}
	}
	
	
	public void updateQuantidadeVeiculos(int idProduto, int quantidadeVeiculos){
		PreparedStatement pstm = null;
		try {
			pstm = persistencia.getConection().prepareStatement(UPDATE);
			
			pstm.setInt(1, quantidadeVeiculos);
			pstm.setInt(2, idProduto);
			pstm.execute();
			System.out.println("Tabela produto atualizada com sucesso.");
		} catch (SQLException e) {
			System.err.println("Erro ao realizar update na table do produto no estoque.");
			e.printStackTrace();
		} finally {
			persistencia.fecharConexao();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
