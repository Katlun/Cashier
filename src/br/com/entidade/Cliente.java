package br.com.entidade;

import java.sql.Date;

public class Cliente {

	private int id;
	private String nome;
	private Date dataNascimento;
	private String rg;
	private String cpf;
	
	
	
	
	public void viewClientConsoleLine(){
		System.out.println("----------------------------");
		System.out.println(this.getId());
		System.out.println(this.getNome());
		System.out.println(this.getDataNascimento());
		System.out.println(this.getRg());
		System.out.println(this.getCpf());
		System.out.println("----------------------------");
	}
	
	
	
	
	
	//--------------------------------------------------------------------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	
	
	
	
}
