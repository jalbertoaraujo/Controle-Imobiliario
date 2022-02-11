package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.controle.imobiliario.DAO.CadastrarCodigoDao;
import br.com.controle.imobiliario.DAO.ListarNumeroDao;
import br.com.controle.imobiliario.DAO.PovoarComboCodigoCidadeDao;
import br.com.controle.imobiliario.uteis.LimitaNroCaracteres;
import br.com.controle.imobiliario.uteis.RetornaNumero;
import br.com.controle.imobiliario.uteis.UpperCaseDocument;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;

public class GerarCodigo extends JFrame {

	private JPanel contentPane;
	public static JTextField tfcodcidade;
	public static JTextField tfcodigogerado;
	public static JComboBox cbcodestado;
	public static JTextField tfcodidimovel;
	public static JTextField tfcodigo;
	public static JComboBox cbcodigocidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerarCodigo frame = new GerarCodigo();
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
	public GerarCodigo() {
		setResizable(false);
		setTitle(" GERAR C\u00D3DIGO DO IM\u00D3VEL");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GerarCodigo.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 302, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfcodigo = new JTextField();
		tfcodigo.setEditable(false);
		tfcodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfcodigo.setBounds(13, 74, 127, 20);
		contentPane.add(tfcodigo);
		tfcodigo.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(0, 249, 296, 2);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(0, 105, 296, 2);
		contentPane.add(separator);
		
		cbcodigocidade = new JComboBox();
		cbcodigocidade.setBounds(13, 119, 178, 23);
		contentPane.add(cbcodigocidade);
		
		
		JButton btnNewButton_1 = new JButton("INSERIR");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbcodigocidade.removeAllItems();
				CadastrarCodigoDao cadcod = new CadastrarCodigoDao();
				cadcod.cadastrarCodigo(null);
				PovoarComboCodigoCidadeDao pccc = new PovoarComboCodigoCidadeDao();
				pccc.listar();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(150, 73, 136, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblCdigoDoImvel = new JLabel("C\u00F3digo do Im\u00F3vel");
		lblCdigoDoImvel.setForeground(Color.WHITE);
		lblCdigoDoImvel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdigoDoImvel.setBounds(13, 191, 127, 20);
		contentPane.add(lblCdigoDoImvel);
		
		tfcodidimovel = new JTextField();
		tfcodidimovel.setBounds(270, 41, 16, 20);
		contentPane.add(tfcodidimovel);
		tfcodidimovel.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Inserir Cidade ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(13, 11, 109, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Escolha o Estado");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(13, 42, 127, 14);
		contentPane.add(lblNewLabel_1);
		
		tfcodcidade = new JTextField();
		tfcodcidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfcodcidade.setBounds(123, 9, 86, 20);
		contentPane.add(tfcodcidade);
		tfcodcidade.setColumns(10);
		tfcodcidade.setDocument(new UpperCaseDocument());
		tfcodcidade.setDocument(new LimitaNroCaracteres(3));
				
		cbcodestado = new JComboBox();
		cbcodestado.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String n1 = tfcodcidade.getText();
				String n2 = (String) cbcodestado.getSelectedItem();
				tfcodigo.setText(n1+n2);				
			}
		});
		cbcodestado.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbcodestado.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA ", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cbcodestado.setBounds(135, 40, 72, 20);
		contentPane.add(cbcodestado);
		
		JButton btnNewButton = new JButton("GERAR C\u00D3DIGO");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
			
//				RetornaNumero retorna = new RetornaNumero();
//				retorna.retornanumero();
				ListarNumeroDao lnd = new ListarNumeroDao();
				lnd.Listar();
				if(tfcodidimovel.getText() != "000"){
//				    String n1 = tfcodcidade.getText();
					String n2 = (String) cbcodigocidade.getSelectedItem();
					String n3 = tfcodidimovel.getText();
					int n4 = Integer.parseInt(n3)+1;
					String n5 = Integer.toString(n4);				
					
					String formatted = String.format("%03d",n4);
					GerarCodigo.tfcodidimovel.setText(formatted);
				
					
					principal.tfcodigoimovel.setText(GerarCodigo.tfcodigogerado.getText());
					
					principal.tfempreendimentoprincipal.setEditable(true);
					principal.tfdescricaoprincipal.setEditable(true);
					principal.tfcarecteristicaprincipal.setEditable(true);
					principal.tfareaprincipal.setEditable(true);
					principal.tfsequencialprincipal.setEditable(true);
					principal.tfvalorprincipal.setEditable(true);
					principal.tfendereçoprincipal.setEditable(true);
					principal.tfcidadeprincipal.setEditable(true);
					principal.tfregistroprincipal.setEditable(true);
					principal.tfcartorioprincipal.setEditable(true);				
				}
				
				if(tfcodidimovel.getText().equals("000")){					

					String n2 = (String) cbcodigocidade.getSelectedItem();					
					tfcodigogerado.setText(n2+" - "+"001");
					principal.tfcodigoimovel.setText(GerarCodigo.tfcodigogerado.getText());
					
					principal.tfempreendimentoprincipal.setEditable(true);
					principal.tfdescricaoprincipal.setEditable(true);
					principal.tfcarecteristicaprincipal.setEditable(true);
					principal.tfareaprincipal.setEditable(true);
					principal.tfsequencialprincipal.setEditable(true);
					principal.tfvalorprincipal.setEditable(true);
					principal.tfendereçoprincipal.setEditable(true);
					principal.tfcidadeprincipal.setEditable(true);
					principal.tfregistroprincipal.setEditable(true);
					principal.tfcartorioprincipal.setEditable(true);
					
				}if(tfcodidimovel.getText() != "000"){
//			    String n1 = tfcodcidade.getText();
				String n2 = (String) cbcodigocidade.getSelectedItem();
				String n3 = tfcodidimovel.getText();
				int n4 = Integer.parseInt(n3)+1;
				String n5 = Integer.toString(n4);				
				
				String formatted = String.format("%03d",n4);
				GerarCodigo.tfcodidimovel.setText(formatted);
			
				tfcodigogerado.setText(n2+" - "+n3);
				principal.tfcodigoimovel.setText(GerarCodigo.tfcodigogerado.getText());
				tfcodidimovel.setText("JOGO");				
				principal.tfempreendimentoprincipal.setEditable(true);
				principal.tfdescricaoprincipal.setEditable(true);
				principal.tfcarecteristicaprincipal.setEditable(true);
				principal.tfareaprincipal.setEditable(true);
				principal.tfsequencialprincipal.setEditable(true);
				principal.tfvalorprincipal.setEditable(true);
				principal.tfendereçoprincipal.setEditable(true);
				principal.tfcidadeprincipal.setEditable(true);
				principal.tfregistroprincipal.setEditable(true);
				principal.tfcartorioprincipal.setEditable(true);
				
				GerarCodigo gerar = new GerarCodigo();
				gerar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
			}});
		btnNewButton.setBounds(13, 155, 148, 25);
		contentPane.add(btnNewButton);
		
		tfcodigogerado = new JTextField();
		tfcodigogerado.setEditable(false);
		tfcodigogerado.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfcodigogerado.setBounds(13, 215, 148, 20);
		contentPane.add(tfcodigogerado);
		tfcodigogerado.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(GerarCodigo.class.getResource("/br/com/controle/imobiliario/imagem/fundo.jpg")));
		lblNewLabel_2.setBounds(0, 0, 296, 264);
		contentPane.add(lblNewLabel_2);
		
//		RetornaNumero retorna = new RetornaNumero();
//		retorna.retornanumero();
		
		ListarNumeroDao lnd = new ListarNumeroDao();
		lnd.Listar();
		
		int i = Integer.parseInt(tfcodidimovel.getText());
		String formatted = String.format("%03d",i);
		
		PovoarComboCodigoCidadeDao pccc = new PovoarComboCodigoCidadeDao();
		pccc.listar();
		
		tfcodidimovel.setVisible(false);		
	
	}
}
