package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.controle.imobiliario.DAO.AlterarImoveisDao;
import br.com.controle.imobiliario.DAO.CadastrarImoveisDao;
import br.com.controle.imobiliario.DAO.ExcluirImoveisDao;
import br.com.controle.imobiliario.DAO.ListaImoveisAlterarDao;
import br.com.controle.imobiliario.DAO.ListaImoveisDao;
import br.com.controle.imobiliario.DAO.ListarDespesaDao;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;

public class AlterarImoveis extends JFrame {

	private JPanel contentPane;
	public static JTextField tfcodalterar;
	public static JTextField tfdescricaoalterar;
	public static JTextField tfendereçoalterar;
	public static JTextField tfvaloralterar;
	public static JComboBox cbtipoalterar;
	public static JTextField tfempreendimentoalterar;
	public static JTextField tfsequencialalterar;
	public static JTextField tfcaracteristicaalterar;
	public static JTextField tfareaalterar;
	public static JTextField tfregistroalterar;
	public static JTextField tfcartorioalterar;
	public static JTextField tfcidadealterar;
	public static JComboBox cbestadoalterar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarImoveis frame = new AlterarImoveis();
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
	public AlterarImoveis() {
		setTitle("ALTERAR IM\u00D3VEIS CADASTRADOS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AlterarImoveis.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 435, 730);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDeImveis = new JLabel("Alterar Im\u00F3veis ");
		lblCadastroDeImveis.setForeground(Color.WHITE);
		lblCadastroDeImveis.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblCadastroDeImveis.setBounds(10, 11, 354, 43);
		contentPane.add(lblCadastroDeImveis);

		JPanel panelCadastrarImoveis = new JPanel();
		panelCadastrarImoveis.setOpaque(false);
		panelCadastrarImoveis.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelCadastrarImoveis.setBackground(UIManager.getColor("Panel.background"));
		panelCadastrarImoveis.setBounds(10, 66, 409, 626);
		panelCadastrarImoveis.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "ALTERAR IM\u00D3VEL CADASTRADO", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		contentPane.add(panelCadastrarImoveis);
		panelCadastrarImoveis.setLayout(null);

		JLabel lblUsurioLogado = new JLabel("C\u00F3digo");
		lblUsurioLogado.setBounds(10, 16, 158, 20);
		panelCadastrarImoveis.add(lblUsurioLogado);
		lblUsurioLogado.setForeground(Color.WHITE);
		lblUsurioLogado.setFont(new Font("Tahoma", Font.BOLD, 12));

		tfcodalterar = new JTextField();
		tfcodalterar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				ListaImoveisAlterarDao lia = new ListaImoveisAlterarDao();
				lia.listar();
			}
		});
		tfcodalterar.setCaretColor(Color.RED);
		tfcodalterar.setBounds(10, 40, 158, 20);
		panelCadastrarImoveis.add(tfcodalterar);
		tfcodalterar.setForeground(Color.BLACK);
		tfcodalterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfcodalterar.setColumns(10);		

		JLabel lblDescrio = new JLabel("Unidade");
		lblDescrio.setBounds(10, 111, 83, 20);
		panelCadastrarImoveis.add(lblDescrio);
		lblDescrio.setForeground(Color.WHITE);
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 12));

		tfdescricaoalterar = new JTextField();
		tfdescricaoalterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfdescricaoalterar.setBounds(10, 134, 384, 20);
		panelCadastrarImoveis.add(tfdescricaoalterar);
		tfdescricaoalterar.setColumns(10);
		tfdescricaoalterar.setDocument(new UpperCaseDocument());

		JButton btnNewButton = new JButton("ALTERAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				AlterarImoveisDao ai = new AlterarImoveisDao();
				ai.listar();
				ListaImoveisDao lista = new ListaImoveisDao();
				lista.listar();
				
			}
		});
		btnNewButton.setBounds(207, 588, 187, 25);
		panelCadastrarImoveis.add(btnNewButton);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setForeground(Color.WHITE);
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndereo.setBounds(10, 205, 73, 20);
		panelCadastrarImoveis.add(lblEndereo);
		
		tfendereçoalterar = new JTextField();
		tfendereçoalterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfendereçoalterar.setBounds(10, 228, 384, 20);
		panelCadastrarImoveis.add(tfendereçoalterar);
		tfendereçoalterar.setColumns(10);
		tfendereçoalterar.setDocument(new UpperCaseDocument());
		
		JLabel lblValorDoImvel = new JLabel("Valor do Im\u00F3vel");
		lblValorDoImvel.setForeground(Color.WHITE);
		lblValorDoImvel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblValorDoImvel.setBounds(11, 535, 122, 20);
		panelCadastrarImoveis.add(lblValorDoImvel);
		
		tfvaloralterar = new JTextField();
		tfvaloralterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfvaloralterar.setBounds(10, 557, 157, 20);
		panelCadastrarImoveis.add(tfvaloralterar);
		tfvaloralterar.setColumns(10);
		tfvaloralterar.setHorizontalAlignment(tfvaloralterar.RIGHT); // alinha a direita
		
		JLabel lblEmpreendimento = new JLabel("Empreendimento");
		lblEmpreendimento.setForeground(Color.WHITE);
		lblEmpreendimento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmpreendimento.setBounds(11, 65, 131, 14);
		panelCadastrarImoveis.add(lblEmpreendimento);
		
		JLabel lblComercial = new JLabel("Comercial");
		lblComercial.setForeground(Color.WHITE);
		lblComercial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblComercial.setBounds(183, 534, 83, 20);
		panelCadastrarImoveis.add(lblComercial);
		
		cbtipoalterar = new JComboBox();
		cbtipoalterar.setModel(new DefaultComboBoxModel(new String[] {"SIM", "N\u00C3O"}));
		cbtipoalterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbtipoalterar.setBounds(183, 557, 78, 20);
		panelCadastrarImoveis.add(cbtipoalterar);
		
		JButton button = new JButton("EXCLUIR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ExcluirImoveisDao ei = new ExcluirImoveisDao();
				ei.listar();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBackground(new Color(255, 51, 102));
		button.setBounds(10, 588, 187, 25);
		panelCadastrarImoveis.add(button);
		
		tfempreendimentoalterar = new JTextField();
		tfempreendimentoalterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfempreendimentoalterar.setBounds(10, 86, 384, 20);
		panelCadastrarImoveis.add(tfempreendimentoalterar);
		tfempreendimentoalterar.setColumns(10);
		tfempreendimentoalterar.setDocument(new UpperCaseDocument());
		
		JLabel lblSequncial = new JLabel("Sequ\u00EAncial");
		lblSequncial.setForeground(Color.WHITE);
		lblSequncial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSequncial.setBounds(10, 157, 83, 20);
		panelCadastrarImoveis.add(lblSequncial);
		
		tfsequencialalterar = new JTextField();
		tfsequencialalterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfsequencialalterar.setBounds(10, 181, 384, 20);
		panelCadastrarImoveis.add(tfsequencialalterar);
		tfsequencialalterar.setColumns(10);
		tfsequencialalterar.setDocument(new UpperCaseDocument());
		
		tfcaracteristicaalterar = new JTextField();
		tfcaracteristicaalterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfcaracteristicaalterar.setColumns(10);
		tfcaracteristicaalterar.setBounds(10, 367, 384, 20);
		panelCadastrarImoveis.add(tfcaracteristicaalterar);
		tfcaracteristicaalterar.setDocument(new UpperCaseDocument());
		
		JLabel lblCaracteristcas = new JLabel("Caracterist\u00EDcas");
		lblCaracteristcas.setForeground(Color.WHITE);
		lblCaracteristcas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCaracteristcas.setBounds(10, 344, 108, 20);
		panelCadastrarImoveis.add(lblCaracteristcas);
		
		tfareaalterar = new JTextField();
		tfareaalterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfareaalterar.setColumns(10);
		tfareaalterar.setBounds(10, 414, 384, 20);
		tfareaalterar.setDocument(new UpperCaseDocument());
		panelCadastrarImoveis.add(tfareaalterar);
		
		JLabel lblrea = new JLabel("\u00C1rea");
		lblrea.setForeground(Color.WHITE);
		lblrea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblrea.setBounds(10, 391, 73, 20);
		panelCadastrarImoveis.add(lblrea);
		
		tfregistroalterar = new JTextField();
		tfregistroalterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfregistroalterar.setColumns(10);
		tfregistroalterar.setBounds(10, 462, 384, 20);
		tfregistroalterar.setDocument(new UpperCaseDocument());
		panelCadastrarImoveis.add(tfregistroalterar);
		
		JLabel lblRegistroDoImvel = new JLabel("Registro do Im\u00F3vel");
		lblRegistroDoImvel.setForeground(Color.WHITE);
		lblRegistroDoImvel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegistroDoImvel.setBounds(10, 439, 158, 20);
		panelCadastrarImoveis.add(lblRegistroDoImvel);
		
		tfcartorioalterar = new JTextField();
		tfcartorioalterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfcartorioalterar.setColumns(10);
		tfcartorioalterar.setBounds(10, 508, 384, 20);
		tfcartorioalterar.setDocument(new UpperCaseDocument());
		panelCadastrarImoveis.add(tfcartorioalterar);
		
		JLabel lblCartrio = new JLabel("Cart\u00F3rio");
		lblCartrio.setForeground(Color.WHITE);
		lblCartrio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCartrio.setBounds(10, 485, 73, 20);
		panelCadastrarImoveis.add(lblCartrio);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCidade.setBounds(10, 252, 73, 20);
		panelCadastrarImoveis.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstado.setBounds(10, 299, 73, 20);
		panelCadastrarImoveis.add(lblEstado);
		
		tfcidadealterar = new JTextField();
		tfcidadealterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfcidadealterar.setBounds(11, 275, 383, 20);
		panelCadastrarImoveis.add(tfcidadealterar);
		tfcidadealterar.setColumns(10);
		tfcidadealterar.setDocument(new UpperCaseDocument());
		
		cbestadoalterar = new JComboBox();
		cbestadoalterar.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbestadoalterar.setModel(new DefaultComboBoxModel(new String[] {"ACRE (AC)", "ALAGOAS (AL)", "AMAP\u00C1 (AP)", "AMAZONAS (AM)", "BAHIA (BA)", "CEAR\u00C1 (CE)", "DISTRITO FEDERAL (DF)", "ESPIRITO SANTO (ES)", "GOI\u00C1S (GO)", "MARANH\u00C3O (MA)", "MATO GROSSO (MT)", "MATO GROSSO DO SUL (MS)", "MINAS GERAIS (MG)", "PAR\u00C1 (PA) ", "PARAIBA (PB)", "PARAN\u00C1 (PR)", "PERNAMBUCO (PE)", "PIAU\u00CD (PI)", "RIO DE JANEIRO (RJ)", "RIO GRANDE DO NORTE (RN)", "RIO GRANDE DO SUL (RS)", "ROND\u00D4NIA (RO)", "RORAIMA (RR)", "SANTA CATARINA (SC)", "S\u00C3O PAULO (SP)", "SERGIPE (SE)", "TOCANTINS(TO)"}));
		cbestadoalterar.setBounds(10, 321, 384, 20);
		panelCadastrarImoveis.add(cbestadoalterar);
		
		DefaultTableCellRenderer tabela1 = new DefaultTableCellRenderer();//alinhar à direita valores da coluna indicada
		tabela1.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon(AlterarImoveis.class.getResource("/br/com/controle/imobiliario/imagem/fundo.jpg")));
		lblNewLabel.setBounds(0, 0, 429, 702);
		contentPane.add(lblNewLabel);
															
		setLocationRelativeTo(null); // tela sempre no centro	
		
	}
}
