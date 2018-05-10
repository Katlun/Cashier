package br.com.gui.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import br.com.enumeracao.Cor;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

public class JPanelAddProduto extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JPanel pnlLogo;
	
	
	private JTextField txtMarca;
	private JTextField txtModelo;
	
	
	public JPanelAddProduto() {
		setLayout(new BorderLayout(0,0));
		
		pnlLogo = new JPanel();
		pnlLogo.setBackground(new Color(255, 0, 255));
		add(pnlLogo, BorderLayout.NORTH);
		pnlLogo.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblLogo = new JLabel("Adicionar Novo Produto ao Estoque");
		lblLogo.setFont(new Font("Abyssinica SIL", Font.BOLD, 20));
		lblLogo.setBackground(Color.BLUE);
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		pnlLogo.add(lblLogo);
		
		JPanel pnlCentro = new JPanel();
		pnlCentro.setBackground(new Color(255, 228, 225));
		add(pnlCentro, BorderLayout.CENTER);
		pnlCentro.setLayout(null);
		
		JLabel lblCores = new JLabel("Cores Disponiveis");
		lblCores.setBounds(24, 33, 155, 15);
		pnlCentro.add(lblCores);
		
		JComboBox<Object> cbxCores = new JComboBox<>(Cor.values());
		cbxCores.setBounds(24, 60, 180, 25);
		pnlCentro.add(cbxCores);
		
		JLabel lblQuantidade = new JLabel("Quantidade de Veiculo");
		lblQuantidade.setBounds(458, 116, 170, 15);
		pnlCentro.add(lblQuantidade);
		
		JSpinner txtQuantidade = new JSpinner();
		txtQuantidade.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		txtQuantidade.setBounds(525, 145, 103, 25);
		pnlCentro.add(txtQuantidade);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(229, 33, 70, 15);
		pnlCentro.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(229, 60, 180, 25);
		pnlCentro.add(txtMarca);
		txtMarca.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(458, 33, 70, 15);
		pnlCentro.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(458, 60, 180, 25);
		pnlCentro.add(txtModelo);
		txtModelo.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(24, 116, 70, 15);
		pnlCentro.add(lblValor);
		
		JFormattedTextField txtValor = new JFormattedTextField();
		txtValor.setBounds(24, 144, 180, 25);
		pnlCentro.add(txtValor);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(229, 116, 70, 15);
		pnlCentro.add(lblAno);
		
		JFormattedTextField txtAno = new JFormattedTextField();
		txtAno.setBounds(229, 144, 180, 25);
		pnlCentro.add(txtAno);
		
		JButton btnInserir = new JButton("Adicionar");
		btnInserir.setBounds(547, 297, 117, 25);
		pnlCentro.add(btnInserir);
	}


}
