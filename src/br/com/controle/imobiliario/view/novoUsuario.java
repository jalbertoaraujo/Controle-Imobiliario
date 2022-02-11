package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import br.com.controle.imobiliario.DAO.PovoarComboDao;
import br.com.controle.imobiliario.DAO.UsuarioDao;
import br.com.controle.imobiliario.uteis.UpperCaseDocument;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class novoUsuario extends JFrame {

	private JPanel contentPane;
	public static JTextField tfnovousuario;
	public static JTextField tfnovasenha;
	public static JTextField tfrepetesenha;
	public static JTextField tfdicadesenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					novoUsuario frame = new novoUsuario();
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
	public novoUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(novoUsuario.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setResizable(false);
		setTitle(" CADASTRAR NOVO USU\u00C1RIO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("LIMPAR");
		btnNewButton_1.setToolTipText("LIMPA TODOS OS CAMPOS DIGITADOS");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tfnovousuario.setText("");
				tfnovasenha.setText("");
				tfrepetesenha.setText("");
				tfdicadesenha.setText("");
				tfnovousuario.requestFocus();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(296, 228, 136, 24);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.setToolTipText("PARA CADASTRAR UM NOVO USU\u00C1RIO PREENCHA OS DADOS ACIMA ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String tf1 = tfnovasenha.getText();
				String tf2 = tfrepetesenha.getText();
				if(tf1.equals(tf2)){
					UsuarioDao ud = new UsuarioDao();
					ud.adicionaUsuario(null);				
					JOptionPane.showMessageDialog(null, "Cadastro de Novo Usuário Realizado com Sucesso");
					tfnovousuario.setText("");
					tfnovasenha.setText("");
					tfrepetesenha.setText("");
					tfdicadesenha.setText("");
					PovoarComboDao povoar = new PovoarComboDao();
					povoar.listar();
				}else{
					JOptionPane.showMessageDialog(null, "Senhas Incopatíveis");
					tfnovasenha.setText("");
					tfrepetesenha.setText("");
					tfnovasenha.requestFocus();
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(160, 229, 130, 23);
		contentPane.add(btnNewButton);
		
		tfdicadesenha = new JTextField();
		tfdicadesenha.setToolTipText("INFORME UMA DICA DE SENHA ");
		tfdicadesenha.setBounds(160, 194, 272, 25);
		contentPane.add(tfdicadesenha);
		tfdicadesenha.setColumns(10);
		tfdicadesenha.setDocument(new UpperCaseDocument());
		
		tfrepetesenha = new JTextField();
		tfrepetesenha.setToolTipText("CONFIRME A SENHA DIGITADA ANTERIORMENTE");
		tfrepetesenha.setBounds(161, 153, 271, 25);
		contentPane.add(tfrepetesenha);
		tfrepetesenha.setColumns(10);
		tfrepetesenha.setDocument(new UpperCaseDocument());
		
		tfnovasenha = new JTextField();
		tfnovasenha.setToolTipText("INFORME UMA SENHA DE SUA ESCOLHA");
		tfnovasenha.setBounds(160, 110, 272, 25);
		contentPane.add(tfnovasenha);
		tfnovasenha.setColumns(10);
		tfnovasenha.setDocument(new UpperCaseDocument());
		
		tfnovousuario = new JTextField();
		tfnovousuario.setToolTipText("INFORME UM USU\u00C1RIO PARA CADASTRAR");
		tfnovousuario.setBounds(160, 69, 272, 25);
		contentPane.add(tfnovousuario);
		tfnovousuario.setColumns(10);
		tfnovousuario.setDocument(new UpperCaseDocument());
		
		JLabel lblDicaDeSenha = new JLabel("Dica de Senha :");
		lblDicaDeSenha.setForeground(Color.WHITE);
		lblDicaDeSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDicaDeSenha.setBounds(13, 195, 116, 25);
		contentPane.add(lblDicaDeSenha);
		
		JLabel lblRepitirSenha = new JLabel("Repitir Senha :");
		lblRepitirSenha.setForeground(Color.WHITE);
		lblRepitirSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRepitirSenha.setBounds(13, 154, 116, 24);
		contentPane.add(lblRepitirSenha);
		
		JLabel lblSenha = new JLabel("Senha :");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(13, 117, 72, 14);
		contentPane.add(lblSenha);
		
		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(13, 70, 72, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNovoUsurio = new JLabel("Novo Usu\u00E1rio");
		lblNovoUsurio.setForeground(Color.WHITE);
		lblNovoUsurio.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblNovoUsurio.setBounds(13, 5, 311, 54);
		contentPane.add(lblNovoUsurio);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(novoUsuario.class.getResource("/br/com/controle/imobiliario/imagem/fundo.jpg")));
		lblNewLabel.setBounds(0, 0, 442, 282);
		contentPane.add(lblNewLabel);
	}
}
