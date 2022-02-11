package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.controle.imobiliario.uteis.AbrirTelaEstatisticaImoveis;
import br.com.controle.imobiliario.uteis.AbrirTelainfDespesaGeral;
import br.com.controle.imobiliario.uteis.AbrirTelainfReceitaGeral;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class Acoes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acoes frame = new Acoes();
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
	public Acoes() {
		setResizable(false);
		setTitle(" A\u00C7\u00D5ES");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Acoes.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 611, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDespesa = new JButton("<html><CENTER>GERAL<br>DE<br>DESPESA<CENTER></html>");
		btnDespesa.setIcon(new ImageIcon(Acoes.class.getResource("/br/com/controle/imobiliario/imagem/despesa.png")));
		btnDespesa.setForeground(Color.WHITE);
		btnDespesa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AbrirTelainfDespesaGeral atrg = new AbrirTelainfDespesaGeral();
				atrg.AbrirTelainfDespesaGeral();
			}
		});
		btnDespesa.setBackground(SystemColor.activeCaption);
		btnDespesa.setBounds(308, 11, 139, 130);
		contentPane.add(btnDespesa);
		btnDespesa.setVerticalTextPosition (SwingConstants.BOTTOM);
		btnDespesa.setHorizontalTextPosition (SwingConstants.CENTER);
		
		JButton btnsaldogeral = new JButton("<html><CENTER>SALDO<br>GERAL<CENTER></html>");
		btnsaldogeral.setForeground(new Color(255, 255, 255));
		btnsaldogeral.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnsaldogeral.setIcon(new ImageIcon(Acoes.class.getResource("/br/com/controle/imobiliario/imagem/saldo.png")));
		btnsaldogeral.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				InfAnualSaldo frame = new InfAnualSaldo();
				frame.setVisible(true);
			}
		});
		btnsaldogeral.setBackground(SystemColor.activeCaption);
		btnsaldogeral.setBounds(457, 11, 139, 130);
		contentPane.add(btnsaldogeral);
		btnsaldogeral.setVerticalTextPosition (SwingConstants.BOTTOM);
		btnsaldogeral.setHorizontalTextPosition (SwingConstants.CENTER);
		
		JButton btnReceita = new JButton("<html><CENTER>GERAL<br>DE<br>RECEITA<CENTER></html>");
		btnReceita.setIcon(new ImageIcon(Acoes.class.getResource("/br/com/controle/imobiliario/imagem/receita.png")));
		btnReceita.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReceita.setForeground(Color.WHITE);
		btnReceita.setBackground(SystemColor.activeCaption);
		btnReceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AbrirTelainfReceitaGeral atrg = new AbrirTelainfReceitaGeral();
				atrg.AbrirTelainfReceitaGeral();
			}
		});
		btnReceita.setBounds(159, 11, 139, 130);
		contentPane.add(btnReceita);
		btnReceita.setVerticalTextPosition (SwingConstants.BOTTOM);
		btnReceita.setHorizontalTextPosition (SwingConstants.CENTER);
		
		JButton btnLanamentosDoPerodo = new JButton("<html><CENTER>LANÇAMENTOS<br>DO<br>PERÍODO<CENTER></html>");
		btnLanamentosDoPerodo.setBackground(SystemColor.activeCaption);
		btnLanamentosDoPerodo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLanamentosDoPerodo.setForeground(Color.WHITE);
		btnLanamentosDoPerodo.setIcon(new ImageIcon(Acoes.class.getResource("/br/com/controle/imobiliario/imagem/calculadora.png")));
		btnLanamentosDoPerodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AbrirTelaEstatisticaImoveis atei = new AbrirTelaEstatisticaImoveis();
				atei.AbrirTelaEstatisticaImoveis();
			}
		});				
		btnLanamentosDoPerodo.setBounds(10, 11, 139, 130);		
		contentPane.add(btnLanamentosDoPerodo);
		btnLanamentosDoPerodo.setVerticalTextPosition (SwingConstants.BOTTOM);
		btnLanamentosDoPerodo.setHorizontalTextPosition (SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Acoes.class.getResource("/br/com/controle/imobiliario/imagem/download.jpg")));
		lblNewLabel.setBounds(0, 0, 605, 152);
		contentPane.add(lblNewLabel);
	}
}
