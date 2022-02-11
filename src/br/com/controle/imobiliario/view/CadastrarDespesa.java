package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Window.Type;
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
import br.com.controle.imobiliario.DAO.ListarDespesaDao;
import br.com.controle.imobiliario.DAO.ListarReceitaDao;
import br.com.controle.imobiliario.DAO.PovoarComboCadNovaDespesaDao;
import br.com.controle.imobiliario.DAO.PovoarComboCadNovaDespesaEmpreendimentoDao;
import br.com.controle.imobiliario.DAO.PovoarComboCadNovaReceitaDao;
import br.com.controle.imobiliario.DAO.PovoarComboNomeDespesaDao;
import br.com.controle.imobiliario.uteis.AbrirTelaAlterarDespesa;
import br.com.controle.imobiliario.uteis.UpperCaseDocument;

import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CadastrarDespesa extends JFrame {

	private JPanel contentPane;
	public static JTextField tfperiodolocatario;
	public static JTextField tfvalordespesa;
	public static JTextField tfobsdespesa;
	public static JTable tabeladespesa;
	public static JComboBox cbcadnovadespesaunidade;
	public static JTextField tfdatadespesa;
	public static JComboBox cbnomedespesa;
	public static JComboBox cbcadnovadespesaempreendimento;
	public static JComboBox cbcompetenciadespesa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarDespesa frame = new CadastrarDespesa();
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
	public CadastrarDespesa() {
		setTitle(" CADASTRAR NOVA DESPESA");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CadastrarDespesa.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(-13, -152, 771, 783);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cbcadnovadespesaempreendimento = new JComboBox();
		cbcadnovadespesaempreendimento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {

				CadastrarDespesa.cbcadnovadespesaunidade.removeAllItems();
				PovoarComboCadNovaDespesaDao pccnd = new PovoarComboCadNovaDespesaDao();
				pccnd.listar();
			}
		});
		
		JRadioButton rdbtnIncluirNovoTipo = new JRadioButton("Incluir Novo Tipo de Despesa");
		rdbtnIncluirNovoTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				IncluirNovaDespesa ind = new IncluirNovaDespesa();
				ind.setVisible(true);
			}
		});
		rdbtnIncluirNovoTipo.setOpaque(false);
		rdbtnIncluirNovoTipo.setForeground(Color.WHITE);
		rdbtnIncluirNovoTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnIncluirNovoTipo.setBounds(526, 724, 227, 23);
		contentPane.add(rdbtnIncluirNovoTipo);

		JButton btlistardespesa = new JButton("<html><center>LISTAR<br/>DESPESA</center></html>");
		btlistardespesa.setBounds(542, 51, 79, 49);
		contentPane.add(btlistardespesa);
		btlistardespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ListarDespesaDao lisdes = new ListarDespesaDao();
				lisdes.Listar();
			}
		});
		btlistardespesa.setForeground(Color.WHITE);
		btlistardespesa.setBackground(SystemColor.activeCaption);
		btlistardespesa.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbcadnovadespesaempreendimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbcadnovadespesaempreendimento.setBounds(148, 45, 381, 20);
		contentPane.add(cbcadnovadespesaempreendimento);

		JLabel lblEmpreendimento = new JLabel("Empreendimento");
		lblEmpreendimento.setForeground(Color.WHITE);
		lblEmpreendimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpreendimento.setBounds(10, 43, 128, 20);
		contentPane.add(lblEmpreendimento);

		cbcadnovadespesaunidade = new JComboBox();		
		cbcadnovadespesaunidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbcadnovadespesaunidade.setBounds(148, 79, 381, 20);
		contentPane.add(cbcadnovadespesaunidade);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(14, 315, 740, 402);
		contentPane.add(scrollPane_1);

		tabeladespesa = new JTable();
		tabeladespesa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				AbrirTelaAlterarDespesa atad = new AbrirTelaAlterarDespesa();
				atad.abretela();
			}
		});
		tabeladespesa.setAutoCreateRowSorter(true);
		tabeladespesa.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabeladespesa.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID_DESP.", "DESPESA", "VALOR", "COMPETENCIA", "OBS"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabeladespesa.getColumnModel().getColumn(0).setPreferredWidth(57);
		tabeladespesa.getColumnModel().getColumn(1).setResizable(false);
		tabeladespesa.getColumnModel().getColumn(1).setPreferredWidth(216);
		tabeladespesa.getColumnModel().getColumn(2).setResizable(false);
		tabeladespesa.getColumnModel().getColumn(2).setPreferredWidth(87);
		tabeladespesa.getColumnModel().getColumn(3).setResizable(false);
		tabeladespesa.getColumnModel().getColumn(3).setPreferredWidth(113);
		tabeladespesa.getColumnModel().getColumn(4).setResizable(false);
		tabeladespesa.getColumnModel().getColumn(4).setPreferredWidth(249);
		scrollPane_1.setViewportView(tabeladespesa);

		DefaultTableCellRenderer tabela1 = new DefaultTableCellRenderer();// alinhar
																			// à
																			// direita
																			// valores
																			// da
																			// coluna
																			// indicada
		tabela1.setHorizontalAlignment(SwingConstants.RIGHT);
																				// qual
																				// coluna
																				// ficará
																				// à
																				// direita

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(0, 298, 764, 7);
		contentPane.add(separator_1);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "CADASTRAR NOVA DESPESA",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel.setBounds(10, 125, 615, 162);
		contentPane.add(panel);

		JLabel lblDespesa = new JLabel("Despesa");
		lblDespesa.setForeground(Color.WHITE);
		lblDespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDespesa.setBounds(9, 21, 63, 17);
		panel.add(lblDespesa);

		JLabel label_1 = new JLabel("Valor ");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(9, 52, 46, 14);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Observa\u00E7\u00E3o");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(9, 105, 91, 14);
		panel.add(label_2);

		JButton btinserirdespesa = new JButton("<html><center>SALVAR<br/>DESPESA</center></html>");
		btinserirdespesa.setForeground(Color.WHITE);
		btinserirdespesa.setBackground(SystemColor.activeCaption);
		btinserirdespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tfvalordespesa.getText().equals("") || tfobsdespesa.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"FAVOR PREENCHER TODOS OS CAMPOS PARA CADASTRAR UMA NOVA DESPESA");
				} else {
					CadastrarDespesaDao cad = new CadastrarDespesaDao();
					cad.cadastrarDespesa(null);
					ListarDespesaDao lisdes = new ListarDespesaDao();
					lisdes.Listar();
					tfvalordespesa.setText("");
					tfobsdespesa.setText("");
					
				}
			}
		});
		btinserirdespesa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btinserirdespesa.setBounds(401, 75, 79, 49);
		panel.add(btinserirdespesa);

		tfvalordespesa = new JTextField();
		tfvalordespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfvalordespesa.setColumns(10);
		tfvalordespesa.setBounds(106, 48, 283, 20);
		tfvalordespesa.setDocument(new UpperCaseDocument());
		tfvalordespesa.setHorizontalAlignment(tfvalordespesa.RIGHT); // alinha a
																		// direita
		panel.add(tfvalordespesa);

		tfobsdespesa = new JTextField();
		tfobsdespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfobsdespesa.setColumns(10);
		tfobsdespesa.setBounds(106, 102, 283, 20);
		tfobsdespesa.setDocument(new UpperCaseDocument());
		panel.add(tfobsdespesa);

		Date d2 = new Date();

		Locale local2 = new Locale("pt", "BR"); // Para internacionalizar a
												// data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy", local2);
		tfdatadespesa = new JTextField();
		tfdatadespesa.setEditable(false);
		tfdatadespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfdatadespesa.setBounds(107, 130, 99, 20);
		panel.add(tfdatadespesa);
		tfdatadespesa.setColumns(10);
		tfdatadespesa.setDocument(new UpperCaseDocument());
		tfdatadespesa.setText(sdf2.format(d2));

		JLabel lblData = new JLabel("Data");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblData.setBounds(9, 133, 46, 17);
		panel.add(lblData);

		cbnomedespesa = new JComboBox();
		cbnomedespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbnomedespesa.setBounds(105, 21, 286, 20);
		panel.add(cbnomedespesa);
							
		JLabel lblCompetncia = new JLabel("Compet\u00EAncia");
		lblCompetncia.setForeground(Color.WHITE);
		lblCompetncia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompetncia.setBounds(9, 77, 91, 14);
		panel.add(lblCompetncia);
		
		cbcompetenciadespesa = new JComboBox();
		cbcompetenciadespesa.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbcompetenciadespesa.setModel(new DefaultComboBoxModel(new String[] {"AGOSTO/19", "SETEMBRO/19", "OUTUBRO/19", "NOVEMBRO/19", "DEZEMBRO/19", "JANEIRO/20", "FEVEREIRO/20", "MAR\u00C7O/20", "ABRIL/20", "MAIO/20", "JUNHO/20", "JULHO/20", "AGOSTO/20", "SETEMBRO/20", "OUTUBRO/20", "NOVEMBRO/20", "DEZEMBRO/20", "JANEIRO/21", "FEVEREIRO/21", "MAR\u00C7O/21", "ABRIL/21", "MAIO/21", "JUNHO/21", "JULHO/21", "AGOSTO/21", "SETEMBRO/21", "OUTUBRO/21", "NOVEMBRO/21", "DEZEMBRO/21", "JANEIRO/22", "FEVEREIRO/22", "MAR\u00C7O/22", "ABRIL/22", "MAIO/22", "JUNHO/22", "JULHO/22", "AGOSTO/22", "SETEMBRO/22", "OUTUBRO/22", "NOVEMBRO/22", "DEZEMBRO/22", "JANEIRO/23", "FEVEREIRO/23", "MAR\u00C7O/23", "ABRIL/23", "MAIO/23", "JUNHO/23", "JULHO/23", "AGOSTO/23", "SETEMBRO/23", "OUTUBRO/23", "NOVEMBRO/23", "DEZEMBRO/23", "JANEIRO/24", "FEVEREIRO/24", "MAR\u00C7O/24", "ABRIL/24", "MAIO/24", "JUNHO/24", "JULHO/24", "AGOSTO/24", "SETEMBRO/24", "OUTUBRO/24", "NOVEMBRO/24", "DEZEMBRO/24", "JANEIRO/25", "FEVEREIRO/25", "MAR\u00C7O/25", "ABRIL/25", "MAIO/25", "JUNHO/25", "JULHO/25", "AGOSTO/25", "SETEMBRO/25", "OUTUBRO/25", "NOVEMBRO/25", "DEZEMBRO/25", "JANEIRO/26", "FEVEREIRO/26", "MAR\u00C7O/26", "ABRIL/26", "MAIO/26", "JUNHO/26", "JULHO/26", "AGOSTO/26", "SETEMBRO/26", "OUTUBRO/26", "NOVEMBRO/26", "DEZEMBRO/26", "JANEIRO/27", "FEVEREIRO/27", "MAR\u00C7O/27", "ABRIL/27", "MAIO/27", "JUNHO/27", "JULHO/27", "AGOSTO/27", "SETEMBRO/27", "OUTUBRO/27", "NOVEMBRO/27", "DEZEMBRO/27", "JANEIRO/28", "FEVEREIRO/28", "MAR\u00C7O/28", "ABRIL/28", "MAIO/28", "JUNHO/28", "JULHO/28", "AGOSTO/28", "SETEMBRO/28", "OUTUBRO/28", "NOVEMBRO/28", "DEZEMBRO/28", "JANEIRO/29", "FEVEREIRO/29", "MAR\u00C7O/29", "ABRIL/29", "MAIO/29", "JUNHO/29", "JULHO/29", "AGOSTO/29", "SETEMBRO/29", "OUTUBRO/29", "NOVEMBRO/29", "DEZEMBRO/29"}));
		cbcompetenciadespesa.setBounds(106, 75, 285, 20);
		panel.add(cbcompetenciadespesa);
		
		JButton btnRateio = new JButton("RATEIO");
		btnRateio.setVisible(false);
		btnRateio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnRateio.setForeground(Color.WHITE);
		btnRateio.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRateio.setBackground(SystemColor.activeCaption);
		btnRateio.setBounds(490, 75, 115, 49);
		panel.add(btnRateio);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(0, 111, 764, 7);
		contentPane.add(separator);

		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setForeground(Color.WHITE);
		lblUnidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnidade.setBounds(10, 78, 66, 20);
		contentPane.add(lblUnidade);

		JLabel lblPerodo = new JLabel("Per\u00EDodo");
		lblPerodo.setForeground(Color.WHITE);
		lblPerodo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPerodo.setBounds(10, 12, 66, 14);
		contentPane.add(lblPerodo);

		Date d1 = new Date();

		Locale local1 = new Locale("pt", "BR"); // Para internacionalizar a
												// data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf1 = new SimpleDateFormat("MMMM/yy", local1);

		tfperiodolocatario = new JTextField();
		tfperiodolocatario.setEditable(false);
		tfperiodolocatario.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfperiodolocatario.setBounds(148, 11, 111, 20);
		contentPane.add(tfperiodolocatario);
		tfperiodolocatario.setColumns(10);
		tfperiodolocatario.setText(sdf1.format(d1));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(CadastrarDespesa.class.getResource("/br/com/controle/imobiliario/imagem/download.jpg")));
		lblNewLabel.setBounds(0, 0, 764, 755);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null); // tela sempre no centro
		
		tabeladespesa.getTableHeader().setReorderingAllowed(false);// manter menu da tabela fixo
		
		ListarDespesaDao lisdes = new ListarDespesaDao();
		lisdes.Listar();	
		PovoarComboCadNovaDespesaDao pccnd = new PovoarComboCadNovaDespesaDao();
		pccnd.listar();		
		PovoarComboNomeDespesaDao pcnd = new PovoarComboNomeDespesaDao();
		pcnd.listar();
		PovoarComboCadNovaDespesaEmpreendimentoDao pccnde = new PovoarComboCadNovaDespesaEmpreendimentoDao();
		pccnde.listar();

	}
}
