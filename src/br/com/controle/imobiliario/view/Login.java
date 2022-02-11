package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Window.Type;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;






import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

import br.com.controle.imobiliario.DAO.AcessarDao;
import br.com.controle.imobiliario.DAO.ListaImoveisDao;
import br.com.controle.imobiliario.DAO.PovoarComboDao;
import br.com.controle.imobiliario.uteis.UpperCaseDocument;

import javax.swing.JComboBox;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	public static JPasswordField tfsenha;
	public static JComboBox cbusuario;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle(" ACESSAR");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 349, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		setLocationRelativeTo(null); // tela sempre no centro
	//	setUndecorated(true); // para retirar as bordas e botões do frame
		
		JLabel lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setText("<html><u>Criar Usu\u00E1rio</u></html>");
		lblNewLabel_4.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				novoUsuario nu = new novoUsuario();
				nu.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("SAIR");
		btnNewButton_1.setToolTipText("SAIR DO SISTEMA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}
		});
		
		cbusuario = new JComboBox();
		cbusuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbusuario.setBounds(81, 87, 250, 22);
		contentPane.add(cbusuario);
		
		tfsenha = new JPasswordField();
		tfsenha.setToolTipText("INFORME SENHA CADASTRADA");
		tfsenha.setBounds(81, 119, 250, 20);
		tfsenha.setDocument(new UpperCaseDocument());		
		contentPane.add(tfsenha);
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(223, 178, 108, 27);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("Bem Vindo Ao Sistema de Controle Imobili\u00E1rio");
		lblNewLabel_5.setForeground(SystemColor.text);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(10, 45, 294, 27);
		contentPane.add(lblNewLabel_5);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(81, 142, 95, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				esqueciSenha es = new esqueciSenha();
				es.setVisible(true);
			}
		});
		lblNewLabel_3.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
		lblNewLabel_3.setText("<html><u>Esqueci a Senha</u></html>");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(236, 142, 95, 27);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.setToolTipText("PARA ACESSAR O SISTEMA INFORME USU\u00C1RIO E SENHA V\u00C1LIDOS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (cbusuario.getSelectedItem().equals("") || tfsenha.getText().equals("")){					
					JOptionPane.showMessageDialog(null, "Preencha os Dados Corretamente");
					tfsenha.requestFocus();
				}else{
					AcessarDao acesso = new AcessarDao();
					acesso.acessar();
					dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(81, 178, 132, 27);
		contentPane.add(btnNewButton);
		getRootPane().setDefaultButton(btnNewButton);// entrar com a tecla enter
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 102, 61, 50);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio:");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 73, 61, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(SystemColor.text);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblLogin.setBounds(9, -10, 134, 66);
		contentPane.add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/br/com/controle/imobiliario/imagem/fundo.jpg")));
		lblNewLabel.setBounds(0, 0, 345, 220);
		contentPane.add(lblNewLabel);
		
		PovoarComboDao povoar = new PovoarComboDao();
		povoar.listar();			
		
	}
}
