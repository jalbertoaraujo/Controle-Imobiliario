package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.DAO.CadastrarSaldoAnualDao;
import br.com.controle.imobiliario.DAO.ListaSaldoAnualDao;
import br.com.controle.imobiliario.DAO.ListarInfDespesaDao;
import br.com.controle.imobiliario.DAO.ListarInfReceitaDao;
import br.com.controle.imobiliario.DAO.PovoarComboInfInicialDespesaDao;
import br.com.controle.imobiliario.DAO.SomaInfDespesaDao;
import br.com.controle.imobiliario.DAO.SomaInfDespesaIntervaloDao;
import br.com.controle.imobiliario.DAO.SomaInfReceitaDao;
import br.com.controle.imobiliario.DAO.SomaInfReceitaIntervaloDao;
import br.com.controle.imobiliario.DAO.ValorTotalImoveisDao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class EstatisticaImoveis extends JFrame {

	private JPanel contentPane;
	public static JTextField tfempreendimentoestatisticaimovel;
	public static JTextField tfestatisticaunidade;
	public static JTable tabelaestatisticareceitaimovel;
	public static JTable tabelaestatisticadespesaimovel;
	public static JTextField tftotalreceita;
	public static JTextField tftotaldespesa;
	public static JComboBox cbinfinicialdespesa;
	public static JTextField tfinfvalorimovel;
	public static JTextField tfinfsaldominimoesperado;
	public static JTextField tfinflucro;
	public static JLabel lblimagempositivo;
	public static JLabel lblimagemnegativo;
	public static JLabel lblImvelObteveLucro;
	public static JLabel lblImvelNaoObteveLucro;
	private JButton btnNewButton_1;
	public static JTextField tfcodsaldoanual;
	private JLabel lblCdigoImvel;
	public static JTable tabelasaldoanual;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstatisticaImoveis frame = new EstatisticaImoveis();
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
	public EstatisticaImoveis() {
		setResizable(false);
		setTitle(" INFORMA\u00C7\u00D5ES DO IM\u00D3VEL");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EstatisticaImoveis.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(-3, -27, 1100, 738);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); // tela sempre no centro
		
		JButton btnNewButton = new JButton("BUSCAR");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarInfReceitaDao lird = new ListarInfReceitaDao();
				lird.Listar();
				ListarInfDespesaDao lid = new ListarInfDespesaDao();
				lid.Listar();
				SomaInfDespesaIntervaloDao sidi = new SomaInfDespesaIntervaloDao();
				sidi.Listar();
				SomaInfReceitaIntervaloDao siri = new SomaInfReceitaIntervaloDao();
				siri.Listar();
				
				tfinflucro.setText("");
				SomaInfReceitaIntervaloDao siri1 = new SomaInfReceitaIntervaloDao();
				siri1.Listar();
				SomaInfDespesaIntervaloDao sidi1 = new SomaInfDespesaIntervaloDao();
				sidi1.Listar();	
				ValorTotalImoveisDao vti = new ValorTotalImoveisDao();
				vti.listar();

				Double valor2 = 0.0;

				if (tftotalreceita.getText().equals("")) {
					tftotalreceita.setText(String.valueOf(valor2));
				}if(tftotaldespesa.getText().equals("")){
					tftotaldespesa.setText(String.valueOf(valor2));
				}
				Double receita = Double.parseDouble(tftotalreceita.getText());
				Double despesa = Double.parseDouble(tftotaldespesa.getText());
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
					lblImvelObteveLucro.setVisible(true);
					//JOptionPane.showMessageDialog(null, "IMÓVEL OBTEVE LUCRO NESTE MÊS");
					//lblimagempositivo.setVisible(false);
				}else{
					lblimagemnegativo.setVisible(true);
					lblImvelNaoObteveLucro.setVisible(true);
					//JOptionPane.showMessageDialog(null, "IMÓVEL NÃO OBTEVE LUCRO NESTE MÊS");
					//lblimagemnegativo.setVisible(false);
				}					
			}
		});
		
		lblimagempositivo = new JLabel("");
		lblimagempositivo.setVisible(false);
		
		lblImvelObteveLucro = new JLabel("IM\u00D3VEL OBTEVE LUCRO NESTE PER\u00CDODO");
		lblImvelObteveLucro.setVisible(false);
		
		lblImvelNaoObteveLucro = new JLabel("IM\u00D3VEL N\u00C3O OBTEVE LUCRO NESTE PER\u00CDODO");
		lblImvelNaoObteveLucro.setVisible(false);
		
		btnNewButton_1 = new JButton("SALVAR SALDO DO PER\u00CDODO");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
							
				CadastrarSaldoAnualDao csad = new CadastrarSaldoAnualDao();
				csad.cadastrarsaldoanual(null);
				ListaSaldoAnualDao lsa = new ListaSaldoAnualDao();
				lsa.listar();
			}
		});
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 512, 1076, 189);
		contentPane.add(scrollPane_2);
		
		tabelasaldoanual = new JTable();
		tabelasaldoanual.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PER\u00CDODO", "TOTAL RECEITA", "TOTAL DESPESA", "SALDO"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelasaldoanual.getColumnModel().getColumn(0).setResizable(false);
		tabelasaldoanual.getColumnModel().getColumn(0).setPreferredWidth(84);
		tabelasaldoanual.getColumnModel().getColumn(1).setResizable(false);
		tabelasaldoanual.getColumnModel().getColumn(1).setPreferredWidth(180);
		tabelasaldoanual.getColumnModel().getColumn(2).setResizable(false);
		tabelasaldoanual.getColumnModel().getColumn(2).setPreferredWidth(180);
		tabelasaldoanual.getColumnModel().getColumn(3).setResizable(false);
		tabelasaldoanual.getColumnModel().getColumn(3).setPreferredWidth(180);
		scrollPane_2.setViewportView(tabelasaldoanual);
		
		DefaultTableCellRenderer tabela3 = new DefaultTableCellRenderer();//alinhar à direita valores da coluna indicada
		tabela3.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblCdigoImvel = new JLabel("C\u00F3digo");
		lblCdigoImvel.setForeground(Color.WHITE);
		lblCdigoImvel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigoImvel.setBounds(13, 26, 66, 20);
		contentPane.add(lblCdigoImvel);
		
		tfcodsaldoanual = new JTextField();
		tfcodsaldoanual.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfcodsaldoanual.setColumns(10);
		tfcodsaldoanual.setBounds(10, 49, 93, 20);
		contentPane.add(tfcodsaldoanual);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 458, 1094, 2);
		contentPane.add(separator);
		btnNewButton_1.setBounds(14, 474, 252, 23);
		contentPane.add(btnNewButton_1);
		lblImvelNaoObteveLucro.setForeground(Color.RED);
		lblImvelNaoObteveLucro.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblImvelNaoObteveLucro.setBounds(571, 422, 434, 23);
		contentPane.add(lblImvelNaoObteveLucro);
		lblImvelObteveLucro.setForeground(new Color(102, 255, 51));
		lblImvelObteveLucro.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblImvelObteveLucro.setBounds(607, 422, 393, 23);
		contentPane.add(lblImvelObteveLucro);
		lblimagempositivo.setIcon(new ImageIcon(EstatisticaImoveis.class.getResource("/br/com/controle/imobiliario/imagem/positivo.png")));
		lblimagempositivo.setBounds(1010, 384, 76, 70);
		contentPane.add(lblimagempositivo);
		
		lblimagemnegativo = new JLabel("");
		lblimagemnegativo.setVisible(false);
		lblimagemnegativo.setIcon(new ImageIcon(EstatisticaImoveis.class.getResource("/br/com/controle/imobiliario/imagem/negativo.png")));
		lblimagemnegativo.setBounds(1010, 384, 76, 70);
		contentPane.add(lblimagemnegativo);
		
		JLabel lblPerodo = new JLabel("Per\u00EDodo");
		lblPerodo.setForeground(Color.WHITE);
		lblPerodo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPerodo.setBounds(855, 14, 61, 14);
		contentPane.add(lblPerodo);
		
		tfinflucro = new JTextField();
		tfinflucro.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfinflucro.setColumns(10);
		tfinflucro.setBounds(386, 424, 164, 20);
		tfinflucro.setHorizontalAlignment(tftotaldespesa.RIGHT);
		contentPane.add(tfinflucro);
		
		JLabel lblSaldoAtual = new JLabel("Saldo Atual");
		lblSaldoAtual.setForeground(Color.WHITE);
		lblSaldoAtual.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSaldoAtual.setBounds(386, 404, 110, 14);
		contentPane.add(lblSaldoAtual);
		
		tfinfsaldominimoesperado = new JTextField();
		tfinfsaldominimoesperado.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfinfsaldominimoesperado.setBounds(192, 424, 164, 20);
		contentPane.add(tfinfsaldominimoesperado);
		tfinfsaldominimoesperado.setColumns(10);
		tfinfsaldominimoesperado.setHorizontalAlignment(tftotaldespesa.RIGHT);
		
		JLabel lblSaldoMnimoEsperado = new JLabel("Saldo M\u00EDnimo Esperado");
		lblSaldoMnimoEsperado.setForeground(Color.WHITE);
		lblSaldoMnimoEsperado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSaldoMnimoEsperado.setBounds(193, 403, 179, 14);
		contentPane.add(lblSaldoMnimoEsperado);
		
		JLabel lblValorDoImvel = new JLabel("Valor do Im\u00F3vel");
		lblValorDoImvel.setForeground(Color.WHITE);
		lblValorDoImvel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorDoImvel.setBounds(17, 403, 124, 14);
		contentPane.add(lblValorDoImvel);
		
		tfinfvalorimovel = new JTextField();
		tfinfvalorimovel.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfinfvalorimovel.setBounds(15, 424, 164, 20);
		contentPane.add(tfinfvalorimovel);
		tfinfvalorimovel.setColumns(10);
		tfinfvalorimovel.setHorizontalAlignment(tftotaldespesa.RIGHT);
		
		JLabel lblTotalDespesa = new JLabel("Total Despesa");
		lblTotalDespesa.setForeground(Color.WHITE);
		lblTotalDespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalDespesa.setBounds(894, 359, 105, 14);
		contentPane.add(lblTotalDespesa);
		
		JLabel lblTotalReceita = new JLabel("Total Receita");
		lblTotalReceita.setForeground(Color.WHITE);
		lblTotalReceita.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalReceita.setBounds(358, 359, 96, 14);
		contentPane.add(lblTotalReceita);
		btnNewButton.setBounds(796, 48, 117, 23);
		contentPane.add(btnNewButton);
		
		cbinfinicialdespesa = new JComboBox();
		cbinfinicialdespesa.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbinfinicialdespesa.setBounds(922, 11, 164, 20);
		contentPane.add(cbinfinicialdespesa);
		
		tftotaldespesa = new JTextField();
		tftotaldespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		tftotaldespesa.setBounds(1000, 356, 86, 20);
		contentPane.add(tftotaldespesa);
		tftotaldespesa.setColumns(10);
		tftotaldespesa.setHorizontalAlignment(tftotaldespesa.RIGHT); // alinha a direita
		
		tftotalreceita = new JTextField();
		tftotalreceita.setFont(new Font("Tahoma", Font.BOLD, 14));
		tftotalreceita.setBounds(457, 356, 86, 20);
		contentPane.add(tftotalreceita);
		tftotalreceita.setColumns(10);
		tftotalreceita.setHorizontalAlignment(tftotalreceita.RIGHT); // alinha a direita
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(552, 100, 534, 245);
		contentPane.add(scrollPane_1);
		
		tabelaestatisticadespesaimovel = new JTable();
		tabelaestatisticadespesaimovel.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabelaestatisticadespesaimovel.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DESCRI\u00C7\u00C3O DESPESA", "VALOR"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelaestatisticadespesaimovel.getColumnModel().getColumn(0).setResizable(false);
		tabelaestatisticadespesaimovel.getColumnModel().getColumn(0).setPreferredWidth(489);
		tabelaestatisticadespesaimovel.getColumnModel().getColumn(1).setResizable(false);
		tabelaestatisticadespesaimovel.getColumnModel().getColumn(1).setPreferredWidth(135);
		scrollPane_1.setViewportView(tabelaestatisticadespesaimovel);
		
		DefaultTableCellRenderer tabela1 = new DefaultTableCellRenderer();//alinhar à direita valores da coluna indicada
		tabela1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 100, 534, 245);
		contentPane.add(scrollPane);
		
		tabelaestatisticareceitaimovel = new JTable();
		tabelaestatisticareceitaimovel.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabelaestatisticareceitaimovel.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DESCRI\u00C7\u00C3O RECEITA", "VALOR"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelaestatisticareceitaimovel.getColumnModel().getColumn(0).setPreferredWidth(489);
		tabelaestatisticareceitaimovel.getColumnModel().getColumn(1).setResizable(false);
		tabelaestatisticareceitaimovel.getColumnModel().getColumn(1).setPreferredWidth(135);
		scrollPane.setViewportView(tabelaestatisticareceitaimovel);
		
		DefaultTableCellRenderer tabela2 = new DefaultTableCellRenderer();//alinhar à direita valores da coluna indicada
		tabela2.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblNewLabel_4 = new JLabel("Despesa");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(557, 78, 76, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Receita");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(15, 73, 66, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Unidade");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(580, 29, 85, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Empreendimento / Im\u00F3vel");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(116, 25, 208, 20);
		contentPane.add(lblNewLabel_1);
		
		tfestatisticaunidade = new JTextField();
		tfestatisticaunidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfestatisticaunidade.setBounds(578, 50, 208, 20);
		contentPane.add(tfestatisticaunidade);
		tfestatisticaunidade.setColumns(10);
		
		tfempreendimentoestatisticaimovel = new JTextField();
		tfempreendimentoestatisticaimovel.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfempreendimentoestatisticaimovel.setBounds(115, 50, 452, 20);
		contentPane.add(tfempreendimentoestatisticaimovel);
		tfempreendimentoestatisticaimovel.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EstatisticaImoveis.class.getResource("/br/com/controle/imobiliario/imagem/download.jpg")));
		lblNewLabel.setBounds(0, 0, 1094, 712);
		contentPane.add(lblNewLabel);
		
		tabelaestatisticareceitaimovel.getTableHeader().setReorderingAllowed(false);// manter menu da tabela fixo
		tabelaestatisticadespesaimovel.getTableHeader().setReorderingAllowed(false);// manter menu da tabela fixo
		tabelasaldoanual.getTableHeader().setReorderingAllowed(false);// manter menu da tabela fixo
		
		PovoarComboInfInicialDespesaDao pciid = new PovoarComboInfInicialDespesaDao();
		pciid.listar();
//		ListarInfReceitaDao lird = new ListarInfReceitaDao();
//		lird.Listar();		
	}
}
