package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.controle.imobiliario.DAO.CadastrarImoveisDao;
import br.com.controle.imobiliario.DAO.ListaImoveisAlterarDao;
import br.com.controle.imobiliario.DAO.ListaImoveisDao;
import br.com.controle.imobiliario.DAO.ListarDespesaDao;
import br.com.controle.imobiliario.uteis.AbrirTelaImoveis;
import br.com.controle.imobiliario.uteis.UpperCaseDocument;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Window.Type;

import javax.swing.JTabbedPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;

public class principal extends JFrame {

	private JPanel contentPane;
	public static JTextField tfusuarioprincipal;
	public static JTextField tfdescricaoprincipal;
	public static JTable table;
	public static JTextField tfendereçoprincipal;
	public static JTextField tfvalorprincipal;
	public static JComboBox cbtipoprincipal;
	public static JTextField tfempreendimentoprincipal;
	public static JTextField tfsequencialprincipal;
	public static JTextField tfcarecteristicaprincipal;
	public static JTextField tfareaprincipal;
	public static JTextField tfregistroprincipal;
	public static JTextField tfcartorioprincipal;
	public static JTextField tfcidadeprincipal;
	public static JComboBox cbestadoprincipal;
	public static JTextField tfcodigoimovel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
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
	public principal() {
		setTitle(" CADASTRO DE IM\u00D3VEIS");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(principal.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(-19, -91, 1207, 750);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_1 = new JButton("Gerar C\u00F3digo");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				GerarCodigo frame = new GerarCodigo();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(838, 34, 150, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblCdImvel = new JLabel("C\u00F3d. Im\u00F3vel");
		lblCdImvel.setForeground(Color.WHITE);
		lblCdImvel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdImvel.setBounds(998, 35, 92, 20);
		contentPane.add(lblCdImvel);

		tfcodigoimovel = new JTextField();
		tfcodigoimovel.setEditable(false);
		tfcodigoimovel.setBounds(1089, 35, 102, 20);
		contentPane.add(tfcodigoimovel);
		tfcodigoimovel.setColumns(10);

		JLabel lblCadastroDeImveis = new JLabel("Cadastro de Im\u00F3veis ");
		lblCadastroDeImveis.setForeground(Color.WHITE);
		lblCadastroDeImveis.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblCadastroDeImveis.setBounds(10, 11, 466, 43);
		contentPane.add(lblCadastroDeImveis);

		JPanel panelCadastrarImoveis = new JPanel();
		panelCadastrarImoveis.setOpaque(false);
		panelCadastrarImoveis.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelCadastrarImoveis.setBackground(UIManager.getColor("Panel.background"));
		panelCadastrarImoveis.setBounds(10, 66, 1181, 126);
		panelCadastrarImoveis.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)),
				"CADASTRAR NOVO IM\u00D3VEL", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		contentPane.add(panelCadastrarImoveis);
		panelCadastrarImoveis.setLayout(null);

		tfcidadeprincipal = new JTextField();
		tfcidadeprincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcidadeprincipal.setBounds(409, 92, 133, 20);
		panelCadastrarImoveis.add(tfcidadeprincipal);
		tfcidadeprincipal.setColumns(10);
		tfcidadeprincipal.setDocument(new UpperCaseDocument());

		tfregistroprincipal = new JTextField();
		tfregistroprincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfregistroprincipal.setBounds(852, 92, 127, 20);
		panelCadastrarImoveis.add(tfregistroprincipal);
		tfregistroprincipal.setColumns(10);
		tfregistroprincipal.setDocument(new UpperCaseDocument());

		JLabel lblUsurioLogado = new JLabel("Usu\u00E1rio Logado");
		lblUsurioLogado.setBounds(10, 22, 158, 20);
		panelCadastrarImoveis.add(lblUsurioLogado);
		lblUsurioLogado.setForeground(Color.WHITE);
		lblUsurioLogado.setFont(new Font("Tahoma", Font.BOLD, 14));

		tfusuarioprincipal = new JTextField();
		tfusuarioprincipal.setCaretColor(Color.RED);
		tfusuarioprincipal.setBounds(10, 46, 107, 20);
		panelCadastrarImoveis.add(tfusuarioprincipal);
		tfusuarioprincipal.setForeground(Color.BLACK);
		tfusuarioprincipal.setEditable(false);
		tfusuarioprincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfusuarioprincipal.setColumns(10);
		tfusuarioprincipal.setText(Login.cbusuario.getSelectedItem().toString());

		JLabel lblDescrio = new JLabel("Unidade");
		lblDescrio.setBounds(459, 22, 83, 20);
		panelCadastrarImoveis.add(lblDescrio);
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 14));

		tfdescricaoprincipal = new JTextField();
		tfdescricaoprincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfdescricaoprincipal.setBounds(457, 45, 158, 20);
		panelCadastrarImoveis.add(tfdescricaoprincipal);
		tfdescricaoprincipal.setColumns(10);
		tfdescricaoprincipal.setDocument(new UpperCaseDocument());

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (tfempreendimentoprincipal.getText().equals("") && tfdescricaoprincipal.getText().equals("")
						&& tfendereçoprincipal.getText().equals("") && tfvalorprincipal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS PARA CADASTRAR UM NOVO IMÓVEL");
				} else {
					CadastrarImoveisDao imoveis = new CadastrarImoveisDao();
					imoveis.cadastrarImoveis(null);
					tfdescricaoprincipal.setText("");
					tfdescricaoprincipal.requestFocus();
					ListaImoveisDao lista = new ListaImoveisDao();
					lista.listar();
				}
			}
		});
		btnNewButton.setBounds(1091, 88, 73, 25);
		panelCadastrarImoveis.add(btnNewButton);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setForeground(Color.WHITE);
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndereo.setBounds(10, 70, 73, 20);
		panelCadastrarImoveis.add(lblEndereo);

		tfendereçoprincipal = new JTextField();
		tfendereçoprincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfendereçoprincipal.setBounds(10, 93, 384, 20);
		panelCadastrarImoveis.add(tfendereçoprincipal);
		tfendereçoprincipal.setColumns(10);
		tfendereçoprincipal.setDocument(new UpperCaseDocument());

		JLabel lblValorDoImvel = new JLabel("Valor do Im\u00F3vel");
		lblValorDoImvel.setForeground(Color.WHITE);
		lblValorDoImvel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorDoImvel.setBounds(1042, 22, 129, 20);
		panelCadastrarImoveis.add(lblValorDoImvel);

		tfvalorprincipal = new JTextField();
		tfvalorprincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfvalorprincipal.setBounds(1038, 44, 130, 20);
		panelCadastrarImoveis.add(tfvalorprincipal);
		tfvalorprincipal.setColumns(10);
		tfvalorprincipal.setHorizontalAlignment(tfvalorprincipal.RIGHT); // alinha
																			// a
																			// direita

		JLabel lblEmpreendimento = new JLabel("Empreendimento / Im\u00F3vel");
		lblEmpreendimento.setForeground(Color.WHITE);
		lblEmpreendimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpreendimento.setBounds(132, 25, 220, 14);
		panelCadastrarImoveis.add(lblEmpreendimento);

		JLabel lblComercial = new JLabel("Comercial");
		lblComercial.setForeground(Color.WHITE);
		lblComercial.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblComercial.setBounds(760, 69, 83, 20);
		panelCadastrarImoveis.add(lblComercial);

		cbtipoprincipal = new JComboBox();
		cbtipoprincipal.setModel(new DefaultComboBoxModel(new String[] { "SIM", "N\u00C3O" }));
		cbtipoprincipal.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbtipoprincipal.setBounds(759, 92, 78, 20);
		panelCadastrarImoveis.add(cbtipoprincipal);

		tfempreendimentoprincipal = new JTextField();
		tfempreendimentoprincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfempreendimentoprincipal.setBounds(131, 46, 310, 20);
		panelCadastrarImoveis.add(tfempreendimentoprincipal);
		tfempreendimentoprincipal.setColumns(10);
		tfempreendimentoprincipal.setDocument(new UpperCaseDocument());

		JLabel lblSequncial = new JLabel("Sequ\u00EAncial");
		lblSequncial.setForeground(Color.WHITE);
		lblSequncial.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSequncial.setBounds(904, 20, 83, 20);
		panelCadastrarImoveis.add(lblSequncial);

		tfsequencialprincipal = new JTextField();
		tfsequencialprincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfsequencialprincipal.setBounds(903, 44, 120, 20);
		panelCadastrarImoveis.add(tfsequencialprincipal);
		tfsequencialprincipal.setColumns(10);

		JLabel lblCaracteristicas = new JLabel("Caracteristicas");
		lblCaracteristicas.setForeground(Color.WHITE);
		lblCaracteristicas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCaracteristicas.setBounds(629, 20, 100, 20);
		panelCadastrarImoveis.add(lblCaracteristicas);

		tfcarecteristicaprincipal = new JTextField();
		tfcarecteristicaprincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcarecteristicaprincipal.setBounds(629, 45, 158, 20);
		panelCadastrarImoveis.add(tfcarecteristicaprincipal);
		tfcarecteristicaprincipal.setColumns(10);
		tfcarecteristicaprincipal.setDocument(new UpperCaseDocument());

		JLabel lblrea = new JLabel("\u00C1rea");
		lblrea.setForeground(Color.WHITE);
		lblrea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblrea.setBounds(804, 20, 46, 20);
		panelCadastrarImoveis.add(lblrea);

		tfareaprincipal = new JTextField();
		tfareaprincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfareaprincipal.setBounds(802, 44, 86, 20);
		panelCadastrarImoveis.add(tfareaprincipal);
		tfareaprincipal.setColumns(10);
		tfareaprincipal.setDocument(new UpperCaseDocument());

		JLabel lblRegistro = new JLabel("Registro do Im\u00F3vel");
		lblRegistro.setForeground(Color.WHITE);
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegistro.setBounds(851, 69, 146, 20);
		panelCadastrarImoveis.add(lblRegistro);

		JLabel lblCartrio = new JLabel("Cart\u00F3rio");
		lblCartrio.setForeground(Color.WHITE);
		lblCartrio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCartrio.setBounds(993, 69, 67, 20);
		panelCadastrarImoveis.add(lblCartrio);

		tfcartorioprincipal = new JTextField();
		tfcartorioprincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfcartorioprincipal.setBounds(992, 92, 86, 20);
		panelCadastrarImoveis.add(tfcartorioprincipal);
		tfcartorioprincipal.setColumns(10);
		tfcartorioprincipal.setDocument(new UpperCaseDocument());

		cbestadoprincipal = new JComboBox();
		cbestadoprincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbestadoprincipal.setModel(new DefaultComboBoxModel(new String[] { "ACRE (AC)", "ALAGOAS (AL)",
				"AMAP\u00C1 (AP)", "AMAZONAS (AM)", "BAHIA (BA)", "CEAR\u00C1 (CE)", "DISTRITO FEDERAL (DF)",
				"ESPIRITO SANTO (ES)", "GOI\u00C1S (GO)", "MARANH\u00C3O (MA)", "MATO GROSSO (MT)",
				"MATO GROSSO DO SUL (MS)", "MINAS GERAIS (MG)", "PAR\u00C1 (PA) ", "PARAIBA (PB)", "PARAN\u00C1 (PR)",
				"PERNAMBUCO (PE)", "PIAU\u00CD (PI)", "RIO DE JANEIRO (RJ)", "RIO GRANDE DO NORTE (RN)",
				"RIO GRANDE DO SUL (RS)", "ROND\u00D4NIA (RO)", "RORAIMA (RR)", "SANTA CATARINA (SC)",
				"S\u00C3O PAULO (SP)", "SERGIPE (SE)", "TOCANTINS(TO)" }));
		cbestadoprincipal.setBounds(554, 92, 190, 20);
		panelCadastrarImoveis.add(cbestadoprincipal);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEstado.setBounds(554, 70, 83, 20);
		panelCadastrarImoveis.add(lblEstado);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCidade.setBounds(411, 70, 83, 20);
		panelCadastrarImoveis.add(lblCidade);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 199, 1181, 512);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				AbrirTelaImoveis ati = new AbrirTelaImoveis();
				ati.AbrirTelaImoveis();
			}
		});
		
		table.setAutoCreateRowSorter(true);
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C\u00D3DIGO", "EMPREENDIMENTO", "UNIDADE", "SEQU\u00CANCIAL", "VAOR DO IM\u00D3VEL" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(398);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(103);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(63);

		DefaultTableCellRenderer tabela1 = new DefaultTableCellRenderer();// alinhar
																			// à
																			// direita
																			// valores
																			// da
																			// coluna
																			// indicada
		tabela1.setHorizontalAlignment(SwingConstants.RIGHT);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(principal.class.getResource("/br/com/controle/imobiliario/imagem/download.jpg")));
		lblNewLabel.setBounds(0, 0, 1201, 722);
		contentPane.add(lblNewLabel);

		table.getTableHeader().setReorderingAllowed(false);// manter menu da tabela fixo
	
		setLocationRelativeTo(null); // tela sempre no centro

		ListaImoveisDao lista = new ListaImoveisDao();
		lista.listar();

		if (tfcodigoimovel.getText().equals("")) {
			tfempreendimentoprincipal.setEditable(false);
			tfdescricaoprincipal.setEditable(false);
			tfcarecteristicaprincipal.setEditable(false);
			tfareaprincipal.setEditable(false);
			tfsequencialprincipal.setEditable(false);
			tfvalorprincipal.setEditable(false);
			tfendereçoprincipal.setEditable(false);
			tfcidadeprincipal.setEditable(false);
			tfregistroprincipal.setEditable(false);
			tfcartorioprincipal.setEditable(false);
		}

	}
}
