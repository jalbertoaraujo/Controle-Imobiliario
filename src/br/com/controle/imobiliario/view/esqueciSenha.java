package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import br.com.controle.imobiliario.DAO.UsuarioDao;
import br.com.controle.imobiliario.uteis.UpperCaseDocument;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class esqueciSenha extends JFrame {

	private JPanel contentPane;
	public static JTextField tflembrausuario;
	public static JTextField tflembradica;
	public static JLabel lblembrasenha;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					esqueciSenha frame = new esqueciSenha();
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
	public esqueciSenha() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(esqueciSenha.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setResizable(false);
		setTitle(" ESQUECI A SENHA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblembrasenha = new JLabel("");
		lblembrasenha.setForeground(Color.WHITE);
		lblembrasenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblembrasenha.setBounds(10, 223, 422, 28);
		contentPane.add(lblembrasenha);
		
		JButton btnNewButton = new JButton("BUSCAR SENHA ");
		btnNewButton.setToolTipText("PARA LEMBRAR A SENHA INFORME OS DADOS ACIMA ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(tflembrausuario.getText().equals("") && tflembradica.getText().equals("")){
					
					JOptionPane.showMessageDialog(null, "Preencha Todos os Campos");
				}else{
					UsuarioDao ud1 = new UsuarioDao();
					ud1.buscasenha();
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(164, 153, 268, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblSuaSenhaCadastrada = new JLabel("Sua Senha Cadastrada \u00E9 :");
		lblSuaSenhaCadastrada.setForeground(Color.WHITE);
		lblSuaSenhaCadastrada.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSuaSenhaCadastrada.setBounds(114, 189, 231, 23);
		contentPane.add(lblSuaSenhaCadastrada);
		
		tflembradica = new JTextField();
		tflembradica.setToolTipText("INFORME SUA DICA DE SENHA CADASTRADA");
		tflembradica.setBounds(164, 116, 268, 23);
		contentPane.add(tflembradica);
		tflembradica.setColumns(10);
		tflembradica.setDocument(new UpperCaseDocument());
		
		JLabel lblDicaDeSenha = new JLabel("Dica de Senha :");
		lblDicaDeSenha.setForeground(Color.WHITE);
		lblDicaDeSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDicaDeSenha.setBounds(11, 121, 114, 17);
		contentPane.add(lblDicaDeSenha);
		
		tflembrausuario = new JTextField();
		tflembrausuario.setToolTipText("INFORME O SEU USU\u00C1RIO CADASTRADO");
		tflembrausuario.setBounds(164, 76, 268, 23);
		contentPane.add(tflembrausuario);
		tflembrausuario.setColumns(10);
		tflembrausuario.setDocument(new UpperCaseDocument());
		
		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(11, 82, 72, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblLembrarSenha = new JLabel("Lembrar Senha");
		lblLembrarSenha.setForeground(Color.WHITE);
		lblLembrarSenha.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblLembrarSenha.setBounds(11, 11, 351, 54);
		contentPane.add(lblLembrarSenha);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(esqueciSenha.class.getResource("/br/com/controle/imobiliario/imagem/fundo.jpg")));
		lblNewLabel.setBounds(0, 0, 442, 273);
		contentPane.add(lblNewLabel);
	}

}
