package br.com.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Persistencia {

	private Connection conection;
	
	private String host;
	private String database;
	private String username;
	private String password;
	
	
	public Persistencia(){
		this.host = "localhost";
		this.database = "FOURCAR";
		this.username = "root";
		this.password = "passwordmysql";
	}
	
	public Persistencia(String database,String username, String password){
		this.host = "localhost";
		this.database = database;
		this.username = username;
		this.password = password;
	}
	
	public Persistencia(String host,String database, String username,String password){
		this.host = host;
		this.database = database;
		this.username = username;
		this.password = password;
	}
	
	
	public Connection getConection(){
		try {
			conection = DriverManager.getConnection("jdbc:mysql://" + this.getHost()+ "/"+ this.getDatabase(), this.getUsername(), this.getPassword());
			System.out.println("Conectado com sucesso.");
		} catch (SQLException e) {
			System.err.println("Erro ao conectar banco.");
			e.printStackTrace();
		}
		return conection;
	}
	
	
	public Boolean fecharConexao(){
		try {
			conection.close();
			System.out.println("Conexao Fechada!");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Erro ao fechar conexao!");
			return false;
		}
	}

//------------------------------------------------------------------------------------------------------------------------
	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public String getDatabase() {
		return database;
	}


	public void setDatabase(String database) {
		this.database = database;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setConection(Connection conection) {
		this.conection = conection;
	}
}
