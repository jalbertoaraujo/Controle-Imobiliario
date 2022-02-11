package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Rateio extends JFrame {

	private JPanel contentPane;	
	public static JTextField tfvalorrateio;
	public static JTextField tfresultrateio;
	public static JTextField tfquantrateio;
	private JLabel lblQuantidadeASer;
	private JLabel label_2;
	public static JComboBox cb1;
	public static JComboBox cb2;
	public static JComboBox cb3;
	public static JComboBox cb4;
	public static JComboBox cb5;
	public static JComboBox cb6;
	public static JComboBox cb7_1;
	public static JComboBox cb8_1;
	public static JComboBox cb9_1;
	public static JComboBox cb10;
	public static JPanel panel10;
	public static JComboBox cbquant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rateio frame = new Rateio();
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
	public Rateio() {
		setTitle("RATEIO");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Rateio.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 642, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		

		cbquant = new JComboBox();
		cbquant.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {

				if (cbquant.getSelectedItem().equals("2")) {
					
					cb1.setVisible(true);
					cb2.setVisible(true);
					cb3.setVisible(false);
					cb4.setVisible(false);
					cb5.setVisible(false);
					cb6.setVisible(false);
					cb7_1.setVisible(false);
					cb8_1.setVisible(false);
					cb9_1.setVisible(false);
					cb10.setVisible(false);
					
				}
				if (cbquant.getSelectedItem().equals("3")) {
				
					cb1.setVisible(true);
					cb2.setVisible(true);
					cb3.setVisible(true);
					cb4.setVisible(false);
					cb5.setVisible(false);
					cb6.setVisible(false);
					cb7_1.setVisible(false);
					cb8_1.setVisible(false);
					cb9_1.setVisible(false);
					cb10.setVisible(false);
					
				}

				if (cbquant.getSelectedItem().equals("4")) {
					
					cb1.setVisible(true);
					cb2.setVisible(true);
					cb3.setVisible(true);
					cb4.setVisible(true);
					cb5.setVisible(false);
					cb6.setVisible(false);
					cb7_1.setVisible(false);
					cb8_1.setVisible(false);
					cb9_1.setVisible(false);
					cb10.setVisible(false);			
					
				}
				if (cbquant.getSelectedItem().equals("5")) {
					
					cb1.setVisible(true);
					cb2.setVisible(true);
					cb3.setVisible(true);
					cb4.setVisible(true);
					cb5.setVisible(true);
					cb6.setVisible(false);
					cb7_1.setVisible(false);
					cb8_1.setVisible(false);
					cb9_1.setVisible(false);
					cb10.setVisible(false);
					
					
				}
				if (cbquant.getSelectedItem().equals("6")) {
					
					cb1.setVisible(true);
					cb2.setVisible(true);
					cb3.setVisible(true);
					cb4.setVisible(true);
					cb5.setVisible(true);
					cb6.setVisible(true);
					cb7_1.setVisible(false);
					cb8_1.setVisible(false);
					cb9_1.setVisible(false);
					cb10.setVisible(false);
					
				}
				if (cbquant.getSelectedItem().equals("7")) {
					
					cb1.setVisible(true);
					cb2.setVisible(true);
					cb3.setVisible(true);
					cb4.setVisible(true);
					cb5.setVisible(true);
					cb6.setVisible(true);
					cb7_1.setVisible(true);
					cb8_1.setVisible(false);
					cb9_1.setVisible(false);
					cb10.setVisible(false);
				}
				if (cbquant.getSelectedItem().equals("8")) {
					
					cb1.setVisible(true);
					cb2.setVisible(true);
					cb3.setVisible(true);
					cb4.setVisible(true);
					cb5.setVisible(true);
					cb6.setVisible(true);
					cb7_1.setVisible(true);
					cb8_1.setVisible(true);
					cb9_1.setVisible(false);
					cb10.setVisible(false);
				}
				if (cbquant.getSelectedItem().equals("9")) {
					
					cb1.setVisible(true);
					cb2.setVisible(true);
					cb3.setVisible(true);
					cb4.setVisible(true);
					cb5.setVisible(true);
					cb6.setVisible(true);
					cb7_1.setVisible(true);
					cb8_1.setVisible(true);
					cb9_1.setVisible(true);
					cb10.setVisible(false);
				}
				if (cbquant.getSelectedItem().equals("10")) {
					
					cb1.setVisible(true);
					cb2.setVisible(true);
					cb3.setVisible(true);
					cb4.setVisible(true);
					cb5.setVisible(true);
					cb6.setVisible(true);
					cb7_1.setVisible(true);
					cb8_1.setVisible(true);
					cb9_1.setVisible(true);
					cb10.setVisible(true);
				}
			}
		});
		
		panel10 = new JPanel();
		panel10.setOpaque(false);
		panel10.setBounds(10, 128, 347, 393);
		contentPane.add(panel10);
		panel10.setBackground(UIManager.getColor("Panel.background"));
		panel10.setLayout(null);
		
		cb7_1 = new JComboBox();
		cb7_1.setVisible(false);
		cb7_1.setEditable(true);
		cb7_1.setBounds(10, 218, 327, 20);
		panel10.add(cb7_1);
		
		cb9_1 = new JComboBox();
		cb9_1.setVisible(false);
		cb9_1.setEditable(true);
		cb9_1.setBounds(10, 286, 327, 20);
		panel10.add(cb9_1);
		
		cb8_1 = new JComboBox();
		cb8_1.setVisible(false);
		cb8_1.setEditable(true);
		cb8_1.setBounds(10, 252, 327, 20);
		panel10.add(cb8_1);
		
		cb10 = new JComboBox();
		cb10.setVisible(false);
		cb10.setEditable(true);
		cb10.setBounds(10, 320, 327, 20);
		panel10.add(cb10);
		
		cb6 = new JComboBox();
		cb6.setVisible(false);
		cb6.setEditable(true);
		cb6.setBounds(10, 184, 327, 20);
		panel10.add(cb6);
		
		cb2 = new JComboBox();
		cb2.setEditable(true);
		cb2.setBounds(10, 48, 327, 20);
		panel10.add(cb2);
		
		cb4 = new JComboBox();
		cb4.setVisible(false);
		cb4.setEditable(true);
		cb4.setBounds(10, 116, 327, 20);
		panel10.add(cb4);
		
		cb3 = new JComboBox();
		cb3.setVisible(false);
		cb3.setEditable(true);
		cb3.setBounds(10, 82, 327, 20);
		panel10.add(cb3);
		
		cb5 = new JComboBox();
		cb5.setVisible(false);
		cb5.setEditable(true);
		cb5.setBounds(10, 150, 327, 20);
		panel10.add(cb5);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(73, 359, 200, 23);
		panel10.add(btnNewButton);
		
		cb1 = new JComboBox();
		cb1.setEditable(true);
		cb1.setBounds(10, 14, 327, 20);
		panel10.add(cb1);
		
		label_2 = new JLabel("Valor a ser Ratiado ");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(387, 70, 134, 17);
		contentPane.add(label_2);
		
		lblQuantidadeASer = new JLabel("Quantidade a ser Ratiada ");
		lblQuantidadeASer.setForeground(Color.WHITE);
		lblQuantidadeASer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantidadeASer.setBounds(344, 41, 177, 17);
		contentPane.add(lblQuantidadeASer);
		
		tfquantrateio = new JTextField();
		tfquantrateio.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfquantrateio.setBounds(529, 41, 86, 20);
		contentPane.add(tfquantrateio);
		tfquantrateio.setColumns(10);		
			
		tfresultrateio = new JTextField();
		tfresultrateio.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfresultrateio.setBounds(529, 70, 86, 20);
		contentPane.add(tfresultrateio);
		tfresultrateio.setColumns(10);
		
		cbquant.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbquant.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		cbquant.setBounds(240, 85, 52, 23);
		contentPane.add(cbquant);

		JLabel label_1 = new JLabel("4");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(57, 130, 46, 39);
		

		JLabel lblEscolhaQuantideDe = new JLabel("Escolha Quantide de Unidades");
		lblEscolhaQuantideDe.setForeground(Color.WHITE);
		lblEscolhaQuantideDe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEscolhaQuantideDe.setBounds(8, 88, 222, 17);
		contentPane.add(lblEscolhaQuantideDe);

		tfvalorrateio = new JTextField();
		tfvalorrateio.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfvalorrateio.setText("0");
		tfvalorrateio.setBounds(529, 11, 86, 20);
		contentPane.add(tfvalorrateio);
		tfvalorrateio.setColumns(10);		

		JLabel lblInformeValorA = new JLabel("Valor a ser Ratiado ");
		lblInformeValorA.setForeground(Color.WHITE);
		lblInformeValorA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformeValorA.setBounds(387, 12, 134, 17);
		contentPane.add(lblInformeValorA);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon(Rateio.class.getResource("/br/com/controle/imobiliario/imagem/download.jpg")));
		lblNewLabel.setBounds(0, 0, 626, 586);
		contentPane.add(lblNewLabel);
	}
}
