package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.controle.imobiliario.DAO.PovoarComborelatDespesaempreendimentoDao;
import br.com.controle.imobiliario.DAO.PovoarComborelatDespesaunidadeDao;
import br.com.controle.imobiliario.DAO.RelatorioDespesaDao;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;

public class RelatorioDespesaporEmpreendimento extends JFrame {

	private JPanel contentPane;
	public static JComboBox cbrelatdespesaunidade;
	public static JComboBox cbrelatdespesaempreendimento;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioDespesaporEmpreendimento frame = new RelatorioDespesaporEmpreendimento();
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
	public RelatorioDespesaporEmpreendimento() {
		setResizable(false);
		setTitle(" RELAT\u00D3RIO DESPESA POR EMPREENDIMENTO E UNIDADE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RelatorioDespesaporEmpreendimento.class.getResource("/br/com/controle/imobiliario/imagem/Logo_CI_menor.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 469, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblInformeAUnidade = new JLabel("Informe a Unidade");
		lblInformeAUnidade.setForeground(Color.WHITE);
		lblInformeAUnidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformeAUnidade.setBounds(15, 132, 205, 14);
		contentPane.add(lblInformeAUnidade);
		
		JLabel lblInformeOEmpreendimento = new JLabel("Informe o Empreendimento");
		lblInformeOEmpreendimento.setForeground(Color.WHITE);
		lblInformeOEmpreendimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformeOEmpreendimento.setBounds(15, 77, 220, 14);
		contentPane.add(lblInformeOEmpreendimento);
		btnNewButton_1.setBounds(242, 212, 205, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("GERAR RELAT\u00D3RIO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RelatorioDespesaDao rdd = new RelatorioDespesaDao();
				rdd.RelatorioDespesaEmpreendimento();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(15, 212, 205, 38);
		contentPane.add(btnNewButton);
		
		cbrelatdespesaunidade = new JComboBox();
		cbrelatdespesaunidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbrelatdespesaunidade.setBounds(15, 153, 432, 23);
		contentPane.add(cbrelatdespesaunidade);
		
		cbrelatdespesaempreendimento = new JComboBox();
		cbrelatdespesaempreendimento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				RelatorioDespesaporEmpreendimento.cbrelatdespesaunidade.removeAllItems();
				PovoarComborelatDespesaunidadeDao pcrdu = new PovoarComborelatDespesaunidadeDao();
				pcrdu.listar();
			}
		});
		cbrelatdespesaempreendimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbrelatdespesaempreendimento.setBounds(15, 98, 432, 23);
		contentPane.add(cbrelatdespesaempreendimento);
		
		JLabel lblNewLabel_1 = new JLabel("Relat\u00F3rio de Despesas");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 11, 432, 67);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RelatorioDespesaporEmpreendimento.class.getResource("/br/com/controle/imobiliario/imagem/fundo.jpg")));
		lblNewLabel.setBounds(0, 0, 463, 272);
		contentPane.add(lblNewLabel);
		
		JLabel lblRelatrioDespesaPor = new JLabel("Relat\u00F3rio Despesa por Empreendimento e Unidade");
		lblRelatrioDespesaPor.setBounds(10, 11, 46, 14);
		contentPane.add(lblRelatrioDespesaPor);
		
		PovoarComborelatDespesaempreendimentoDao pcrde = new PovoarComborelatDespesaempreendimentoDao();
		pcrde.listar();
		
	}
}
