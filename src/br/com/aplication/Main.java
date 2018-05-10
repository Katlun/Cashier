package br.com.aplication;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.com.dao.ClienteDao;
import br.com.dao.ProdutoDao;
import br.com.dao.RelatorioDao;
import br.com.dao.VendaDao;
import br.com.entidade.Cliente;
import br.com.entidade.Produto;
import br.com.entidade.Venda;
import br.com.enumeracao.TipoPagamento;
import br.com.gui.JFrameProduto;
import br.com.gui.JFrameVenda;
import br.com.modelo.JTableModelProduto;

public class Main {

	public static void main(String[] args) {
		
		JFrameVenda venda = new JFrameVenda();
		JFrameProduto teste = new JFrameProduto();
		
		System.out.println(Venda.getValorTotalVendasDia());
		System.out.println(Venda.quantidade_veiculos_vendidos_dia);
//		RelatorioDao dao = new RelatorioDao();
//		dao.inserir();
		
		
//		ClienteDao dao = new ClienteDao();
//		Cliente cliente = dao.getClienteId(1);
//		cliente.viewClientConsoleLine();
		
		/**
		 * Teste feito para realizar uma venda.
		 * Funfando.
		 */
//		Venda venda = new Venda();
//		venda.setIdCliente(1);
//		venda.setIdProduto(1);
//		venda.setQuantidade_veiculos(2);
//		venda.setValor_produto(22450.00);
//		venda.setTipoPagamento(TipoPagamento.DINHEIRO.name());
//		
//		VendaDao dao1 = new VendaDao();
//		dao1.inserirVenda(venda);

		/**
		 * Teste para visualizar uma lista de vendas.
		 * Funfando.
		 */
//		ArrayList<Venda> vendas = new ArrayList<>();
//		
//		VendaDao dao = new VendaDao();
//		vendas = dao.getList();
//		
//		for(Venda venda : vendas){
//			venda.viewVendaConsoleLine();
//		}
		
		/**
		 * Teste Para visualizar uma lista de produtos no estoque.
		 * Fundando.
		 */
//		ArrayList<Produto> produtos = new ArrayList<>();
//		
//		ProdutoDao dao = new ProdutoDao();
//		produtos = dao.getList();
//		
//		for (Produto produto : produtos) {
//			produto.viewProdutoConsoleLine();
//		}
		
		/**
		 * 
		 */
//		ArrayList<Venda> vendas = new ArrayList<>();
//		
//		VendaDao dao = new VendaDao();
//		vendas = (ArrayList<Venda>) dao.getList();
//		
//		for(Venda venda1 : vendas){
//			venda1.viewVendaConsoleLine();
//		}
		
//		ArrayList<Venda> vendas = new ArrayList<>();
//		VendaDao daoVenda = new VendaDao();
//		
//		vendas = (ArrayList<Venda>) daoVenda.getVendaData();
//		
//		for(Venda venda: vendas){
//			venda.viewVendaConsoleLine();
//		}
		
		/**
		 * Teste para a incerção de um produto no banco.
		 * Funfando.
		 */
//		Produto produto = new Produto();
//		produto.setModelo("Ferrari");
//		produto.setMarca("FORD");
//		produto.setCor("Preto");
//		produto.setAno(2016);
//		produto.setValor(500000.00);
//		produto.setQuantidade(3);
//		dao.insert(produto);
		
	}

}
