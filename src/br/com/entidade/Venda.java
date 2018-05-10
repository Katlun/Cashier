package br.com.entidade;

import java.util.ArrayList;
import java.util.Date;

import br.com.dao.ClienteDao;
import br.com.dao.ProdutoDao;
import br.com.dao.VendaDao;

public class Venda {
	
	private int id;
	private Date data;
	private String tipoPagamento;
	private int idCliente;
	private int idProduto;
	private Double valor_produto;
	private int quantidade_veiculos;
	private Double valor_total_vendas;
	public static int quantidade_veiculos_vendidos_dia = 0;
	
	public void viewVendaConsoleLine(){
		System.out.println("-----------------------------");
		System.out.println("Id: " + this.getId());
		System.out.println("Data da Venda: " + this.getData());
		System.out.println("Pagamento: " + this.getTipoPagamento());
		System.out.println("Id do cliente: " + this.getIdCliente());
		System.out.println("id do produto: " + this.getIdProduto());
		System.out.println("Valor produto: " + this.getValor_produto());
		System.out.println("Quantidade de produtos: " + this.getQuantidade_veiculos());
		System.out.println("Valor total: " + this.getValor_total_vendas());
	}
	
	public Double venda(int i, Double a){
		return valor_total_vendas = i * a;
	}
	
	public String getClienteName(){
		ClienteDao dao = new ClienteDao();
		Cliente cliente = new Cliente();
		cliente = dao.getClienteId(this.getIdCliente());
		return cliente.getNome();
	}
	
	public String getProdutoName(){
		ProdutoDao dao = new ProdutoDao();
		Produto produto = new Produto();
		produto = dao.getProdutoId(this.getIdProduto());
		return produto.getMarca();
	}
	
	
	public static Double getValorTotalVendasDia(){
		Double valor 			= 0.0;
		VendaDao dao 			= new VendaDao();
		ArrayList<Venda> vendas = new ArrayList<>();
		vendas 					= (ArrayList<Venda>) dao.getVendaData();
		int i = 0;
		while(vendas.size() -1 >= i){
			valor += vendas.get(i).getValor_produto();
			i++;
		}
		quantidade_veiculos_vendidos_dia = vendas.size();
		return valor;
	}
	
	
	//----------------------------------------------------------------------------------------
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
	
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidade_veiculos() {
		return quantidade_veiculos;
	}

	public void setQuantidade_veiculos(int quantidade_veiculos) {
		this.quantidade_veiculos = quantidade_veiculos;
	}

	public Double getValor_total_vendas() {
		return this.valor_total_vendas;
	}

	public void setValor_total_vendas(Double valor_total_vendas) {
		this.valor_total_vendas = valor_total_vendas;
	}

	public Double getValor_produto() {
		return valor_produto;
	}

	public void setValor_produto(Double valor_produto) {
		this.valor_produto = valor_produto;
	}
	
	
	
	
}
