package br.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.entidade.Cliente;
import br.com.persistencia.Persistencia;

public class ClienteDao {

	protected Persistencia persistencia;
	private final String SELECT_ID = "SELECT * FROM CLIENTE WHERE ID = ?";
	
	
	public ClienteDao() {
		this.persistencia = new Persistencia();
	}
	
	public ClienteDao(Persistencia persistencia){
		this.persistencia = persistencia;
	}
	
	public Cliente getClienteId(int id){
		Cliente cliente        = new Cliente();
		PreparedStatement pstm = null;
		ResultSet rs 		   = null;
		try {
			pstm = persistencia.getConection().prepareStatement(SELECT_ID);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()){
				cliente.setId(rs.getInt("ID"));
				cliente.setNome(rs.getString("NOME_CLIENTE"));
				cliente.setDataNascimento(rs.getDate("DATA_NASCIMENTO"));
				cliente.setRg(rs.getString("RG"));
				cliente.setCpf(rs.getString("CPF"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			persistencia.fecharConexao();
		}
		return cliente;
	}
	
	
	
	
	
}
