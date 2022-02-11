package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.DAO.ListaSaldoDao;

import br.com.controle.imobiliario.DAO.PovoarComboCbPeriodoSaldoAnualDao;
import br.com.controle.imobiliario.uteis.AbrirTelainfDespesaGeral;
import br.com.controle.imobiliario.uteis.AbrirTelainfReceitaGeral;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InfAnualSaldo extends JFrame {

	private JPanel contentPane;
	public static JTable tabelasaldoanual;
	public static JComboBox cbperiodosaldoanual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfAnualSaldo frame = new InfAnualSaldo();
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
	public InfAnualSaldo() {
		setResizable(false);
		setTitle(" INFORMA\u00C7\u00D5ES DE SALDO POR PER\u00CDODO");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InfAnualSaldo.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 950, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LISTA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ListaSaldoDao lsd = new ListaSaldoDao();
				lsd.listar();
			}
		});
		
		JLabel lblListaGeralDe = new JLabel("LISTA GERAL DE SALDO POR PER\u00CDODO");
		lblListaGeralDe.setForeground(Color.WHITE);
		lblListaGeralDe.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblListaGeralDe.setBounds(10, 62, 532, 41);
		contentPane.add(lblListaGeralDe);
		
		JLabel lblPerodo = new JLabel("Per\u00EDodo");
		lblPerodo.setForeground(Color.WHITE);
		lblPerodo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPerodo.setBounds(674, 13, 64, 14);
		contentPane.add(lblPerodo);
		
		cbperiodosaldoanual = new JComboBox();
		cbperiodosaldoanual.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbperiodosaldoanual.setBounds(741, 11, 192, 20);
		contentPane.add(cbperiodosaldoanual);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(844, 47, 89, 47);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 105, 924, 487);
		contentPane.add(scrollPane);
		
		tabelasaldoanual = new JTable();
		tabelasaldoanual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int coluna = tabelasaldoanual.getSelectedColumn();
				//JOptionPane.showMessageDialog(null, "coluna = "+coluna);
				if(coluna == 2){
					AbrirTelainfReceitaGeral atrg = new AbrirTelainfReceitaGeral();
					atrg.AbrirTelainfReceitaGeral();
				}if(coluna == 3){
					AbrirTelainfDespesaGeral atrg = new AbrirTelainfDespesaGeral();
					atrg.AbrirTelainfDespesaGeral();
				}
			}
		});
		tabelasaldoanual.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"EMPREENDIMENTO", "UNIDADE", "TOTAL RECEITA", "TOTAL DESPESA", "SALDO"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelasaldoanual.getColumnModel().getColumn(0).setPreferredWidth(349);
		tabelasaldoanual.getColumnModel().getColumn(1).setPreferredWidth(300);
		tabelasaldoanual.getColumnModel().getColumn(2).setPreferredWidth(110);
		tabelasaldoanual.getColumnModel().getColumn(3).setPreferredWidth(110);
		tabelasaldoanual.getColumnModel().getColumn(4).setPreferredWidth(110);
		scrollPane.setViewportView(tabelasaldoanual);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InfAnualSaldo.class.getResource("/br/com/controle/imobiliario/imagem/download.jpg")));
		lblNewLabel.setBounds(0, 0, 944, 603);
		contentPane.add(lblNewLabel);
		
		tabelasaldoanual.getTableHeader().setReorderingAllowed(false);// manter menu da tabela fixo
		
		PovoarComboCbPeriodoSaldoAnualDao pcpsa = new PovoarComboCbPeriodoSaldoAnualDao();
		pcpsa.listar();
//		PovoarComboCbUnidadeSaldoAnualDao pcnd = new PovoarComboCbUnidadeSaldoAnualDao();
//		pcnd.listar();
//		PovoarComboCbEmpreendimentoSaldoAnualDao pcesa = new PovoarComboCbEmpreendimentoSaldoAnualDao();
//		pcesa.listar();
	}
}
