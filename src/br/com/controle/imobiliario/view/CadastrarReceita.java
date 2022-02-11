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
import br.com.controle.imobiliario.DAO.PovoarComboCadNovaReceitaDao;
import br.com.controle.imobiliario.DAO.PovoarComboCadNovaReceitaEmpreendimentoDao;
import br.com.controle.imobiliario.DAO.PovoarComboNomeReceitaDao;
import br.com.controle.imobiliario.uteis.AbrirTelaAlterarDespesa;
import br.com.controle.imobiliario.uteis.AbrirTelaAlterarReceita;
import br.com.controle.imobiliario.uteis.UpperCaseDocument;

import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastrarReceita extends JFrame {

	private JPanel contentPane;
	public static JTextField tfperiodolocatario;
	public static JTextField tfobsreceita;
	public static JTextField tfvalorreceita;
	public static JTable tabelareceita;
	public static JComboBox cbcadnovareceita;
	public static JTextField tfdatareceita;
	public static JComboBox cbnomereceita;
	public static JComboBox cbcadnovareceitaempreendimento;
	public static JComboBox cbcompetenciareceita;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarReceita frame = new CadastrarReceita();
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
	public CadastrarReceita() {
		setTitle("CADASTRAR NOVA RECEITA");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CadastrarReceita.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 770, 783);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cbcadnovareceitaempreendimento = new JComboBox();
		cbcadnovareceitaempreendimento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				CadastrarReceita.cbcadnovareceita.removeAllItems();
				PovoarComboCadNovaReceitaDao pccnr = new PovoarComboCadNovaReceitaDao();
				pccnr.listar();
			}
		});
		
				JButton btlistarreceita = new JButton("<html><center>LISTAR<br/>RECEITA</center></html>");
				btlistarreceita.setBounds(542, 51, 79, 49);
				contentPane.add(btlistarreceita);
				btlistarreceita.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						ListarReceitaDao lisrec = new ListarReceitaDao();
						lisrec.Listar();
					}
				});
				btlistarreceita.setForeground(Color.WHITE);
				btlistarreceita.setBackground(SystemColor.activeCaption);
				btlistarreceita.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JRadioButton rdbtnIncluirNovoTipo = new JRadioButton("Incluir Novo Tipo de Receita");
		rdbtnIncluirNovoTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				IncluirNovaReceita inr = new IncluirNovaReceita();
				inr.setVisible(true);
			}
		});
		rdbtnIncluirNovoTipo.setOpaque(false);
		rdbtnIncluirNovoTipo.setForeground(Color.WHITE);
		rdbtnIncluirNovoTipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnIncluirNovoTipo.setBounds(535, 725, 219, 23);
		contentPane.add(rdbtnIncluirNovoTipo);
		cbcadnovareceitaempreendimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbcadnovareceitaempreendimento.setBounds(145, 45, 382, 20);
		contentPane.add(cbcadnovareceitaempreendimento);

		JLabel lblEmpreendimento = new JLabel("Empreendimento");
		lblEmpreendimento.setForeground(Color.WHITE);
		lblEmpreendimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpreendimento.setBounds(10, 43, 132, 20);
		contentPane.add(lblEmpreendimento);

		cbcadnovareceita = new JComboBox();
		cbcadnovareceita.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbcadnovareceita.setBounds(145, 79, 383, 20);
		contentPane.add(cbcadnovareceita);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 316, 744, 402);
		contentPane.add(scrollPane);

		tabelareceita = new JTable();
		tabelareceita.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				AbrirTelaAlterarReceita atar = new AbrirTelaAlterarReceita();
				atar.abretela();
			}
		});
		tabelareceita.setAutoCreateRowSorter(true);
		tabelareceita.setFont(new Font("Tahoma", Font.BOLD, 11));
		tabelareceita.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID_REC.", "RECEITA", "VALOR", "COMPETENCIA", "OBS"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelareceita.getColumnModel().getColumn(0).setResizable(false);
		tabelareceita.getColumnModel().getColumn(0).setPreferredWidth(58);
		tabelareceita.getColumnModel().getColumn(1).setResizable(false);
		tabelareceita.getColumnModel().getColumn(1).setPreferredWidth(210);
		tabelareceita.getColumnModel().getColumn(2).setResizable(false);
		tabelareceita.getColumnModel().getColumn(2).setPreferredWidth(108);
		tabelareceita.getColumnModel().getColumn(3).setResizable(false);
		tabelareceita.getColumnModel().getColumn(3).setPreferredWidth(103);
		tabelareceita.getColumnModel().getColumn(4).setResizable(false);
		tabelareceita.getColumnModel().getColumn(4).setPreferredWidth(306);
		scrollPane.setViewportView(tabelareceita);

		DefaultTableCellRenderer tabela1 = new DefaultTableCellRenderer();// alinhar
																			// à
																			// direita
																			// valores
																			// da
																			// coluna
																			// indicada
		tabela1.setHorizontalAlignment(SwingConstants.RIGHT);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(0, 300, 764, 6);
		contentPane.add(separator_1);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(0, 113, 764, 2);
		contentPane.add(separator);

		JPanel panelcadastrolocatario1 = new JPanel();
		panelcadastrolocatario1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelcadastrolocatario1.setOpaque(false);
		panelcadastrolocatario1.setBounds(10, 123, 615, 164);
		panelcadastrolocatario1.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)),
				"CADASTRAR NOVA RECEITA", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		contentPane.add(panelcadastrolocatario1);
		panelcadastrolocatario1.setLayout(null);

		JLabel lblNome = new JLabel("Receita");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(18, 20, 65, 17);
		panelcadastrolocatario1.add(lblNome);

		JLabel lblValor = new JLabel("Valor ");
		lblValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValor.setForeground(Color.WHITE);
		lblValor.setBounds(18, 52, 46, 14);
		panelcadastrolocatario1.add(lblValor);

		JLabel lblObservao = new JLabel("Observa\u00E7\u00E3o");
		lblObservao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblObservao.setForeground(Color.WHITE);
		lblObservao.setBounds(18, 109, 91, 14);
		panelcadastrolocatario1.add(lblObservao);

		tfobsreceita = new JTextField();
		tfobsreceita.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfobsreceita.setBounds(116, 105, 283, 20);
		panelcadastrolocatario1.add(tfobsreceita);
		tfobsreceita.setColumns(10);
		tfobsreceita.setDocument(new UpperCaseDocument());

		tfvalorreceita = new JTextField();
		tfvalorreceita.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfvalorreceita.setColumns(10);
		tfvalorreceita.setBounds(116, 48, 283, 20);
		tfvalorreceita.setDocument(new UpperCaseDocument());
		tfvalorreceita.setHorizontalAlignment(tfvalorreceita.RIGHT); // alinha a
																		// direita
		panelcadastrolocatario1.add(tfvalorreceita);

		JButton btncadastrarreceita = new JButton("<html><center>SALVAR<br/>RECEITA</center></html>");
		btncadastrarreceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfvalorreceita.getText().equals("") || tfobsreceita.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"FAVOR PREENCHER TODOS OS CAMPOS PARA CADASTRAR UMA NOVA RECEITA");
				} else {
					CadastrarReceitaDao cad = new CadastrarReceitaDao();
					cad.cadastrarReceita(null);
					ListarReceitaDao lisrec = new ListarReceitaDao();
					lisrec.Listar();
					tfvalorreceita.setText("");
					tfobsreceita.setText("");					
				}
			}
		});
		btncadastrarreceita.setForeground(Color.WHITE);
		btncadastrarreceita.setBackground(SystemColor.activeCaption);
		btncadastrarreceita.setFont(new Font("Tahoma", Font.BOLD, 11));
		btncadastrarreceita.setBounds(413, 75, 79, 49);
		panelcadastrolocatario1.add(btncadastrarreceita);

		JLabel lblData = new JLabel("Data");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblData.setBounds(18, 134, 91, 14);
		panelcadastrolocatario1.add(lblData);

		Date d2 = new Date();

		Locale local2 = new Locale("pt", "BR"); // Para internacionalizar a
												// data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy", local2);
		tfdatareceita = new JTextField();
		tfdatareceita.setEditable(false);
		tfdatareceita.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfdatareceita.setBounds(117, 132, 99, 20);
		panelcadastrolocatario1.add(tfdatareceita);
		tfdatareceita.setColumns(10);
		tfdatareceita.setText(sdf2.format(d2));
		
		cbnomereceita = new JComboBox();
		cbnomereceita.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbnomereceita.setBounds(116, 20, 283, 20);
		panelcadastrolocatario1.add(cbnomereceita);		
		
		JLabel lblCompetencia = new JLabel("Compet\u00EAncia");
		lblCompetencia.setForeground(Color.WHITE);
		lblCompetencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompetencia.setBounds(18, 79, 91, 14);
		panelcadastrolocatario1.add(lblCompetencia);
		
		cbcompetenciareceita = new JComboBox();
		cbcompetenciareceita.setModel(new DefaultComboBoxModel(new String[] {"AGOSTO/19", "SETEMBRO/19", "OUTUBRO/19", "NOVEMBRO/19", "DEZEMBRO/19", "JANEIRO/20", "FEVEREIRO/20", "MAR\u00C7O/20", "ABRIL/20", "MAIO/20", "JUNHO/20", "JULHO/20", "AGOSTO/20", "SETEMBRO/20", "OUTUBRO/20", "NOVEMBRO/20", "DEZEMBRO/20", "JANEIRO/21", "FEVEREIRO/21", "MAR\u00C7O/21", "ABRIL/21", "MAIO/21", "JUNHO/21", "JULHO/21", "AGOSTO/21", "SETEMBRO/21", "OUTUBRO/21", "NOVEMBRO/21", "DEZEMBRO/21", "JANEIRO/22", "FEVEREIRO/22", "MAR\u00C7O/22", "ABRIL/22", "MAIO/22", "JUNHO/22", "JULHO/22", "AGOSTO/22", "SETEMBRO/22", "OUTUBRO/22", "NOVEMBRO/22", "DEZEMBRO/22", "JANEIRO/23", "FEVEREIRO/23", "MAR\u00C7O/23", "ABRIL/23", "MAIO/23", "JUNHO/23", "JULHO/23", "AGOSTO/23", "SETEMBRO/23", "OUTUBRO/23", "NOVEMBRO/23", "DEZEMBRO/23", "JANEIRO/24", "FEVEREIRO/24", "MAR\u00C7O/24", "ABRIL/24", "MAIO/24", "JUNHO/24", "JULHO/24", "AGOSTO/24", "SETEMBRO/24", "OUTUBRO/24", "NOVEMBRO/24", "DEZEMBRO/24", "JANEIRO/25", "FEVEREIRO/25", "MAR\u00C7O/25", "ABRIL/25", "MAIO/25", "JUNHO/25", "JULHO/25", "AGOSTO/25", "SETEMBRO/25", "OUTUBRO/25", "NOVEMBRO/25", "DEZEMBRO/25", "JANEIRO/26", "FEVEREIRO/26", "MAR\u00C7O/26", "ABRIL/26", "MAIO/26", "JUNHO/26", "JULHO/26", "AGOSTO/26", "SETEMBRO/26", "OUTUBRO/26", "NOVEMBRO/26", "DEZEMBRO/26", "JANEIRO/27", "FEVEREIRO/27", "MAR\u00C7O/27", "ABRIL/27", "MAIO/27", "JUNHO/27", "JULHO/27", "AGOSTO/27", "SETEMBRO/27", "OUTUBRO/27", "NOVEMBRO/27", "DEZEMBRO/27", "JANEIRO/28", "FEVEREIRO/28", "MAR\u00C7O/28", "ABRIL/28", "MAIO/28", "JUNHO/28", "JULHO/28", "AGOSTO/28", "SETEMBRO/28", "OUTUBRO/28", "NOVEMBRO/28", "DEZEMBRO/28", "JANEIRO/29", "FEVEREIRO/29", "MAR\u00C7O/29", "ABRIL/29", "MAIO/29", "JUNHO/29", "JULHO/29", "AGOSTO/29", "SETEMBRO/29", "OUTUBRO/29", "NOVEMBRO/29", "DEZEMBRO/29"}));
		cbcompetenciareceita.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbcompetenciareceita.setBounds(116, 77, 283, 20);
		panelcadastrolocatario1.add(cbcompetenciareceita);

		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setForeground(Color.WHITE);
		lblUnidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnidade.setBounds(10, 77, 66, 20);
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
		tfperiodolocatario.setBounds(145, 11, 111, 20);
		contentPane.add(tfperiodolocatario);
		tfperiodolocatario.setColumns(10);
		tfperiodolocatario.setText(sdf1.format(d1));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(CadastrarReceita.class.getResource("/br/com/controle/imobiliario/imagem/download.jpg")));
		lblNewLabel.setBounds(0, 0, 764, 755);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null); // tela sempre no centro

		tabelareceita.getTableHeader().setReorderingAllowed(false);
		cbnomereceita.removeAllItems();
		PovoarComboCadNovaReceitaDao pccnr = new PovoarComboCadNovaReceitaDao();
		pccnr.listar();		
		PovoarComboNomeReceitaDao pcr = new PovoarComboNomeReceitaDao();
		pcr.listar();
		PovoarComboCadNovaReceitaEmpreendimentoDao pccnre = new PovoarComboCadNovaReceitaEmpreendimentoDao();
		pccnre.listar();		

	}
}
