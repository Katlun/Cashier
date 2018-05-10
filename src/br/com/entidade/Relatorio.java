package br.com.entidade;

import java.util.Date;

public class Relatorio {
	
	private int id;
	private Date data;
	private int quantidadeVeiculosVendidos;
	private Double valorTotal;
	
	
	public void viewRelatorioConsoleLine(){
		System.out.println("---------------------------------");
		System.out.println(this.getId());
		System.out.println(this.getData());
		System.out.println(this.getQuantidadeVeiculosVendidos());
		System.out.println(this.getValorTotal());
		System.out.println("---------------------------------");
	}
	
	
	//-------------------------------------------------------------------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getQuantidadeVeiculosVendidos() {
		return quantidadeVeiculosVendidos;
	}
	public void setQuantidadeVeiculosVendidos(int quantidadeVeiculosVendidos) {
		this.quantidadeVeiculosVendidos = quantidadeVeiculosVendidos;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	

}
