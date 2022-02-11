package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Window.Type;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.DAO.CadastrarDespesaDao;
import br.com.controle.imobiliario.DAO.CadastrarReceitaDao;
import br.com.controle.imobiliario.DAO.InfDespesaTotalDao;
import br.com.controle.imobiliario.DAO.InfReceitaTotalDao;
import br.com.controle.imobiliario.DAO.ListaInfDespesaDao;
import br.com.controle.imobiliario.DAO.ListaInfReceitaDao;
import br.com.controle.imobiliario.DAO.ListarDespesaDao;
import br.com.controle.imobiliario.DAO.ListarInfDespesaDao;
import br.com.controle.imobiliario.DAO.ListarInfReceitaDao;
import br.com.controle.imobiliario.DAO.ListarReceitaDao;
import br.com.controle.imobiliario.DAO.PovoarComboInfDespesaDao;
import br.com.controle.imobiliario.DAO.PovoarComboInfFinalDespesaDao;
import br.com.controle.imobiliario.DAO.PovoarComboInfIniciaReceitalDao;
import br.com.controle.imobiliario.DAO.PovoarComboInfInicialDespesaDao;
import br.com.controle.imobiliario.DAO.PovoarComboInfReceitaDao;
import br.com.controle.imobiliario.DAO.PovoarComboInfUnidadePeriodoDao;
import br.com.controle.imobiliario.DAO.PovoarComboInfUnidadePeriodoDespesaDao;
import br.com.controle.imobiliario.DAO.PovoarComdoInfFinalReceitaDao;
import br.com.controle.imobiliario.DAO.SomaInfDespesaDao;
import br.com.controle.imobiliario.DAO.SomaInfDespesaIntervaloDao;
import br.com.controle.imobiliario.DAO.SomaInfReceitaDao;
import br.com.controle.imobiliario.DAO.SomaInfReceitaIntervaloDao;
import br.com.controle.imobiliario.DAO.TotalImoveisDao;
import br.com.controle.imobiliario.DAO.ValorTotalImoveisDao;
import br.com.controle.imobiliario.uteis.UpperCaseDocument;

import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;
import java.awt.Component;

public class Estatisticas extends JFrame {

	private JPanel contentPane;
	public static JTable tabelainfreceita;
	public static JTextField tftotalreceita;
	public static JTextField tftotaldespesa;
	public static JTable tabelainfdespesa;
	public static JTextField tfinfdespesa;
	public static JTextField tfinfreceita;
	public static JComboBox cbinfperiodo;
	public static JComboBox cbinfunidade;
	public static JLabel lblReceita;
	public static JLabel lblDespesa;
	public static JButton btnNewButton;
	public static JTextField tfinfreceitaperiodo;
	public static JComboBox cbinfunidadeperiodo;
	public static JComboBox cbinfinicial;
	public static JComboBox cbinffinal;
	public static JComboBox cbinffinaldespesa;
	public static JComboBox cbinfunidadeperiododespesa;
	public static JComboBox cbinfinicialdespesa;
	public static JTextField tfinfdespesaperiodo;
	public static JTable tabelaextrato;
	public static JTextField tftotalimoveiscadastrados;
	public static JTextField tfinflucro;
	public static JTextField tfinfvalorimovel;
	private JLabel lblValorImvel;
	public static JTextField tfinfsaldominimoesperado;
	public static JLabel lblimagemnegativo;
	private JLabel lblimagempositivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estatisticas frame = new Estatisticas();
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Estatisticas() {
		setResizable(false);
		setTitle(" INFORMA\u00C7\u00D5ES");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Estatisticas.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1021, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTotalDeImveis = new JLabel("TOTAL DE IM\u00D3VEIS CADASTRADOS");
		lblTotalDeImveis.setForeground(Color.WHITE);
		lblTotalDeImveis.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalDeImveis.setBounds(587, 30, 257, 17);
		contentPane.add(lblTotalDeImveis);

		tftotalimoveiscadastrados = new JTextField();
		tftotalimoveiscadastrados.setFont(new Font("Tahoma", Font.BOLD, 14));
		tftotalimoveiscadastrados.setEditable(false);
		tftotalimoveiscadastrados.setBounds(852, 28, 152, 20);
		contentPane.add(tftotalimoveiscadastrados);
		tftotalimoveiscadastrados.setColumns(10);
		tftotalimoveiscadastrados.setHorizontalAlignment(tfinflucro.RIGHT); // alinha a direita

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(650, 409, 356, 227);
		contentPane.add(scrollPane_2);

		tabelaextrato = new JTable();
		tabelaextrato.setAutoCreateRowSorter(true);
		tabelaextrato.setFont(new Font("Tahoma", Font.BOLD, 14));
		tabelaextrato
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "DESCRI\u00C7\u00C3O", "VALOR" }) {
					Class[] columnTypes = new Class[] { String.class, String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
		tabelaextrato.getColumnModel().getColumn(0).setResizable(false);
		tabelaextrato.getColumnModel().getColumn(0).setPreferredWidth(420);
		tabelaextrato.getColumnModel().getColumn(1).setResizable(false);
		tabelaextrato.getColumnModel().getColumn(1).setPreferredWidth(202);
		scrollPane_2.setViewportView(tabelaextrato);
		
		DefaultTableCellRenderer tabela1 = new DefaultTableCellRenderer();//alinhar à direita valores da coluna indicada
		tabela1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tabelaextrato.getColumnModel().getColumn(1).setCellRenderer(tabela1); //indica qual coluna ficará à direita

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)),
				"INFORMAÇÕES DA DESPESA POR INTERVALO DE PERÍODO", TitledBorder.LEADING, TitledBorder.TOP, null,
				Color.WHITE));
		panel.setBounds(8, 532, 632, 105);
		contentPane.add(panel);

		JButton button_1 = new JButton("Buscar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ListarInfDespesaDao lid = new ListarInfDespesaDao();
				lid.Listar();
				SomaInfDespesaIntervaloDao sidi = new SomaInfDespesaIntervaloDao();
				sidi.Listar();
			}
		});
		button_1.setBounds(307, 52, 121, 23);
		panel.add(button_1);

		cbinfinicialdespesa = new JComboBox();
		cbinfinicialdespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbinfinicialdespesa.setBounds(10, 22, 153, 20);
		panel.add(cbinfinicialdespesa);

		tfinfdespesaperiodo = new JTextField();
		tfinfdespesaperiodo.setForeground(Color.RED);
		tfinfdespesaperiodo.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfinfdespesaperiodo.setEditable(false);
		tfinfdespesaperiodo.setColumns(10);
		tfinfdespesaperiodo.setBounds(10, 53, 286, 20);
		tfinfdespesaperiodo.setHorizontalAlignment(tfinflucro.RIGHT); // alinha a direita
		panel.add(tfinfdespesaperiodo);

		cbinfunidadeperiododespesa = new JComboBox();
		cbinfunidadeperiododespesa.setBounds(336, 24, 286, 20);
		panel.add(cbinfunidadeperiododespesa);

		JLabel label_3 = new JLabel("DESPESA");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(11, 79, 81, 14);
		panel.add(label_3);

		cbinffinaldespesa = new JComboBox();
		cbinffinaldespesa.setEnabled(false);
		cbinffinaldespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbinffinaldespesa.setBounds(173, 23, 153, 20);
		panel.add(cbinffinaldespesa);

		JPanel paneltotalperiodo = new JPanel();
		paneltotalperiodo.setLayout(null);
		paneltotalperiodo.setOpaque(false);
		paneltotalperiodo.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)),
				"INFORMAÇÕES DA RECEITA POR INTERVALO DE PERÍODO", TitledBorder.LEADING, TitledBorder.TOP, null,
				Color.WHITE));
		paneltotalperiodo.setBounds(9, 410, 632, 105);
		contentPane.add(paneltotalperiodo);

		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ListarInfReceitaDao lird = new ListarInfReceitaDao();
				lird.Listar();
				SomaInfReceitaIntervaloDao siri = new SomaInfReceitaIntervaloDao();
				siri.Listar();
			}
		});
		button.setBounds(306, 51, 121, 23);
		paneltotalperiodo.add(button);

		JLabel label = new JLabel("RECEITA");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(11, 78, 77, 14);
		paneltotalperiodo.add(label);

		cbinfinicial = new JComboBox();
		cbinfinicial.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbinfinicial.setBounds(10, 22, 153, 20);
		paneltotalperiodo.add(cbinfinicial);

		cbinfunidadeperiodo = new JComboBox();
		cbinfunidadeperiodo.setBounds(336, 24, 286, 20);
		paneltotalperiodo.add(cbinfunidadeperiodo);

		tfinfreceitaperiodo = new JTextField();
		tfinfreceitaperiodo.setForeground(new Color(0, 153, 51));
		tfinfreceitaperiodo.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfinfreceitaperiodo.setEditable(false);
		tfinfreceitaperiodo.setColumns(10);
		tfinfreceitaperiodo.setBounds(10, 52, 286, 20);
		tfinfreceitaperiodo.setHorizontalAlignment(tfinflucro.RIGHT); // alinha a direita
		paneltotalperiodo.add(tfinfreceitaperiodo);

		cbinffinal = new JComboBox();
		cbinffinal.setEnabled(false);
		cbinffinal.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbinffinal.setBounds(173, 23, 153, 20);
		paneltotalperiodo.add(cbinffinal);

		JPanel paneltotalinf = new JPanel();
		paneltotalinf.setOpaque(false);
		paneltotalinf.setBounds(9, 287, 995, 105);
		contentPane.add(paneltotalinf);
		paneltotalinf.setLayout(null);
		paneltotalinf.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)),
				"INFORMAÇÕES DA RECEITA / DESPESA POR PERÍODO E UNIDADE", TitledBorder.LEADING, TitledBorder.TOP, null,
				Color.WHITE));

		btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tfinflucro.setText("");
				SomaInfReceitaDao sir = new SomaInfReceitaDao();
				sir.Listar();
				SomaInfDespesaDao sid = new SomaInfDespesaDao();
				sid.Listar();
				ValorTotalImoveisDao vti = new ValorTotalImoveisDao();
				vti.listar();

				Double valor2 = 0.0;				

				if (tfinfreceita.getText().equals("")) {
					tfinfreceita.setText(String.valueOf(valor2));
				}if(tfinfdespesa.getText().equals("")){
					tfinfdespesa.setText(String.valueOf(valor2));
				}
				Double receita = Double.parseDouble(tfinfreceita.getText());
				Double despesa = Double.parseDouble(tfinfdespesa.getText());
				Double valor = receita - despesa;
				tfinflucro.setText(String.valueOf(valor));
				Double esp1 = Double.parseDouble(tfinfvalorimovel.getText());
				Double esp2 = esp1*0.005;
				Double saldoesperado = esp2;
				tfinfsaldominimoesperado.setText(String.valueOf(saldoesperado));
				Double val1 = Double.parseDouble(tfinflucro.getText());
				Double val2 = Double.parseDouble(tfinfsaldominimoesperado.getText());
				if(val1 > val2){
					lblimagempositivo.setVisible(true);
					JOptionPane.showMessageDialog(null, "IMÓVEL OBTEVE LUCRO NESTE MÊS");
					lblimagempositivo.setVisible(false);
				}else{
					lblimagemnegativo.setVisible(true);
					JOptionPane.showMessageDialog(null, "IMÓVEL NÃO OBTEVE LUCRO NESTE MÊS");
					lblimagemnegativo.setVisible(false);
				}			
			}
		});
		
		lblimagempositivo = new JLabel("");
		lblimagempositivo.setVisible(false);
		lblimagempositivo.setIcon(new ImageIcon(Estatisticas.class.getResource("/br/com/controle/imobiliario/imagem/positivo.png")));
		lblimagempositivo.setBounds(889, 15, 71, 83);
		paneltotalinf.add(lblimagempositivo);
		btnNewButton.setBounds(470, 22, 121, 23);
		paneltotalinf.add(btnNewButton);

		lblReceita = new JLabel("RECEITA");
		lblReceita.setForeground(Color.WHITE);
		lblReceita.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReceita.setBounds(13, 79, 77, 14);
		paneltotalinf.add(lblReceita);

		cbinfperiodo = new JComboBox();
		cbinfperiodo.setBounds(12, 22, 153, 20);
		paneltotalinf.add(cbinfperiodo);
		cbinfperiodo.setFont(new Font("Tahoma", Font.BOLD, 14));

		tfinfdespesa = new JTextField();
		tfinfdespesa.setEditable(false);
		tfinfdespesa.setForeground(Color.RED);
		tfinfdespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfinfdespesa.setBounds(160, 53, 137, 20);
		paneltotalinf.add(tfinfdespesa);
		tfinfdespesa.setColumns(10);
		tfinfdespesa.setHorizontalAlignment(tfinflucro.RIGHT); // alinha a direita

		cbinfunidade = new JComboBox();
		cbinfunidade.setBounds(174, 23, 286, 20);
		paneltotalinf.add(cbinfunidade);

		tfinfreceita = new JTextField();
		tfinfreceita.setEditable(false);
		tfinfreceita.setForeground(new Color(0, 153, 51));
		tfinfreceita.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfinfreceita.setColumns(10);
		tfinfreceita.setBounds(12, 53, 137, 20);
		tfinfreceita.setHorizontalAlignment(tfinflucro.RIGHT); // alinha a direita
		paneltotalinf.add(tfinfreceita);

		lblDespesa = new JLabel("DESPESA");
		lblDespesa.setForeground(Color.WHITE);
		lblDespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDespesa.setBounds(161, 78, 94, 14);
		paneltotalinf.add(lblDespesa);

		tfinflucro = new JTextField();
		tfinflucro.setForeground(Color.BLUE);
		tfinflucro.setEditable(false);
		tfinflucro.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfinflucro.setBounds(307, 53, 137, 20);
		paneltotalinf.add(tfinflucro);
		tfinflucro.setColumns(10);
		tfinflucro.setHorizontalAlignment(tfinflucro.RIGHT); // alinha a direita

		JLabel lblLucro = new JLabel("SALDO");
		lblLucro.setForeground(Color.WHITE);
		lblLucro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLucro.setBounds(310, 78, 94, 14);
		paneltotalinf.add(lblLucro);
		
		tfinfvalorimovel = new JTextField();
		tfinfvalorimovel.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfinfvalorimovel.setEditable(false);
		tfinfvalorimovel.setBounds(454, 53, 137, 20);
		paneltotalinf.add(tfinfvalorimovel);
		tfinfvalorimovel.setColumns(10);
		tfinfvalorimovel.setHorizontalAlignment(tfinfvalorimovel.RIGHT); // alinha a direita
		
		lblValorImvel = new JLabel("VALOR IM\u00D3VEL");
		lblValorImvel.setForeground(Color.WHITE);
		lblValorImvel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorImvel.setBounds(456, 78, 121, 14);
		paneltotalinf.add(lblValorImvel);
		
		JLabel lblNewLabel_2 = new JLabel("SALDO M\u00CDNIMO ESPERADO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(655, 30, 199, 14);
		paneltotalinf.add(lblNewLabel_2);
		
		tfinfsaldominimoesperado = new JTextField();
		tfinfsaldominimoesperado.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfinfsaldominimoesperado.setEditable(false);
		tfinfsaldominimoesperado.setBounds(686, 53, 136, 20);
		paneltotalinf.add(tfinfsaldominimoesperado);
		tfinfsaldominimoesperado.setColumns(10);
		tfinfsaldominimoesperado.setHorizontalAlignment(tfinflucro.RIGHT); // alinha a direita

		JLabel lblTotalGeralDe = new JLabel("TOTAL GERAL DE DESPESAS");
		lblTotalGeralDe.setForeground(Color.WHITE);
		lblTotalGeralDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalGeralDe.setBounds(646, 247, 208, 17);
		contentPane.add(lblTotalGeralDe);

		JLabel lblNewLabel_1 = new JLabel("TOTAL GERAL DE RECEITAS");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(145, 246, 208, 17);
		contentPane.add(lblNewLabel_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(512, 62, 492, 176);
		contentPane.add(scrollPane_1);

		tabelainfdespesa = new JTable();
		tabelainfdespesa.setAutoCreateRowSorter(true);
		tabelainfdespesa.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "UNIDADE", "VALOR" }) {
			Class[] columnTypes = new Class[] { String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelainfdespesa.getColumnModel().getColumn(0).setResizable(false);
		tabelainfdespesa.getColumnModel().getColumn(0).setPreferredWidth(450);
		tabelainfdespesa.getColumnModel().getColumn(1).setResizable(false);
		tabelainfdespesa.getColumnModel().getColumn(1).setPreferredWidth(174);
		tabelainfdespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane_1.setViewportView(tabelainfdespesa);
		
		tabelainfdespesa.getColumnModel().getColumn(1).setCellRenderer(tabela1); //indica qual coluna ficará à direita
		
		DefaultTableCellRenderer tabela2 = new DefaultTableCellRenderer();//alinhar à direita valores da coluna indicada
		tabela2.setHorizontalAlignment(SwingConstants.RIGHT);		

		tftotaldespesa = new JTextField();
		tftotaldespesa.setEditable(false);
		tftotaldespesa.setForeground(Color.RED);
		tftotaldespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		tftotaldespesa.setBounds(852, 246, 150, 20);
		contentPane.add(tftotaldespesa);
		tftotaldespesa.setColumns(10);
		tftotaldespesa.setHorizontalAlignment(tfinflucro.RIGHT); // alinha a direita

		tftotalreceita = new JTextField();
		tftotalreceita.setEditable(false);
		tftotalreceita.setForeground(new Color(0, 153, 51));
		tftotalreceita.setFont(new Font("Tahoma", Font.BOLD, 14));
		tftotalreceita.setBounds(350, 245, 150, 20);
		contentPane.add(tftotalreceita);
		tftotalreceita.setColumns(10);
		tftotalreceita.setHorizontalAlignment(tfinflucro.RIGHT); // alinha a direita
		
		lblimagemnegativo = new JLabel("");
		lblimagemnegativo.setVisible(false);
		lblimagemnegativo.setIcon(new ImageIcon(Estatisticas.class.getResource("/br/com/controle/imobiliario/imagem/negativo.png")));
		lblimagemnegativo.setBounds(889, 15, 71, 83);
		paneltotalinf.add(lblimagemnegativo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 61, 494, 176);
		contentPane.add(scrollPane);

		tabelainfreceita = new JTable();
		tabelainfreceita.setAutoCreateRowSorter(true);
		tabelainfreceita.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "UNIDADE", "VALOR" }) {
			Class[] columnTypes = new Class[] { String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelainfreceita.getColumnModel().getColumn(0).setResizable(false);
		tabelainfreceita.getColumnModel().getColumn(0).setPreferredWidth(450);
		tabelainfreceita.getColumnModel().getColumn(1).setResizable(false);
		tabelainfreceita.getColumnModel().getColumn(1).setPreferredWidth(174);
		tabelainfreceita.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setViewportView(tabelainfreceita);
		
		tabelainfreceita.getColumnModel().getColumn(1).setCellRenderer(tabela1); //indica qual coluna ficará à direita
		
		DefaultTableCellRenderer tabela3 = new DefaultTableCellRenderer();//alinhar à direita valores da coluna indicada
		tabela3.setHorizontalAlignment(SwingConstants.RIGHT);		

		JLabel lblInformaes = new JLabel("Informa\u00E7\u00F5es");
		lblInformaes.setForeground(Color.WHITE);
		lblInformaes.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblInformaes.setBounds(9, 1, 297, 49);
		contentPane.add(lblInformaes);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(0, 275, 1014, 7);
		contentPane.add(separator);

		Date d1 = new Date();

		Locale local1 = new Locale("pt", "BR"); // Para internacionalizar a
												// data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM/yy", local1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(Estatisticas.class.getResource("/br/com/controle/imobiliario/imagem/download.jpg")));
		lblNewLabel.setBounds(0, 2, 1015, 645);
		contentPane.add(lblNewLabel);

		tabelainfreceita.getTableHeader().setReorderingAllowed(false);// manter
																		// menu
																		// da
																		// tabela
																		// fixo
		tabelainfdespesa.getTableHeader().setReorderingAllowed(false);// manter
																		// menu
																		// da
																		// tabela
																		// fixo
		tabelaextrato.getTableHeader().setReorderingAllowed(false);// manter
																	// menu da
																	// tabela
																	// fixo

		ListaInfReceitaDao lir = new ListaInfReceitaDao();
		lir.Listar();
		ListaInfDespesaDao lid = new ListaInfDespesaDao();
		lid.Listar();
		InfReceitaTotalDao irtd = new InfReceitaTotalDao();
		irtd.Listar();
		InfDespesaTotalDao idtd = new InfDespesaTotalDao();
		idtd.Listar();

		PovoarComboInfDespesaDao pcid = new PovoarComboInfDespesaDao();
		pcid.listar();
		PovoarComboInfReceitaDao pcir = new PovoarComboInfReceitaDao();
		pcir.listar();
		PovoarComboInfUnidadePeriodoDao pciup = new PovoarComboInfUnidadePeriodoDao();
		pciup.listar();
		PovoarComboInfIniciaReceitalDao pciir = new PovoarComboInfIniciaReceitalDao();
		pciir.listar();
		PovoarComdoInfFinalReceitaDao pcifr = new PovoarComdoInfFinalReceitaDao();
		pcifr.listar();
		PovoarComboInfInicialDespesaDao pciid = new PovoarComboInfInicialDespesaDao();
		pciid.listar();
		PovoarComboInfFinalDespesaDao pcifd = new PovoarComboInfFinalDespesaDao();
		pcifd.listar();
		PovoarComboInfUnidadePeriodoDespesaDao pciupd = new PovoarComboInfUnidadePeriodoDespesaDao();
		pciupd.listar();
		TotalImoveisDao ti = new TotalImoveisDao();
		ti.listar();	

	}
}
