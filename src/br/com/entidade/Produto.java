package br.com.entidade;

import java.util.Date;

public class Produto {

	private int id;
	private String modelo;
	private String marca;
	private String cor;
	private int ano;
	private Double valor;
	private Date entrada;
	private int quantidade;
	protected Double valor_total;
	
	
	public void viewProdutoConsoleLine(){
		System.out.println("----------------------------------");
		System.out.println("IdProduto: " + this.getId());
		System.out.println("Modelo_Produto: " + this.getModelo());
		System.out.println("Marca_Produto: " + this.getMarca());
		System.out.println("Cor_Produto: " + this.getCor());
		System.out.println("Ano_Produto: " + this.getAno());
		System.out.println("Valor_Produto: "+ this.getValor());
		System.out.println("Entrada no Estoque: " + this.getEntrada());
		System.out.println("Quantidade Veiculos no Estoque:" + this.getQuantidade());
		System.out.println("Valor total do produto no estoque: " + this.valor_total_produto());
	}
	
	public Double valor_total_produto(){
		return valor_total = this.getValor() * this.getQuantidade();
	}
	
	
	//-----------------------------------------------------------------------------------------
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getAno() {
		return ano;
	}
	
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Date getEntrada() {
		return entrada;
	}
	
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}