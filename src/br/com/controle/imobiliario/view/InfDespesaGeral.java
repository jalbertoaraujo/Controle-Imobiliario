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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.DAO.ListarInfDespesaGeralDao;
import br.com.controle.imobiliario.DAO.ListarInfReceitaAnualDao;
import br.com.controle.imobiliario.DAO.ListarInfReceitaGeralDao;
import br.com.controle.imobiliario.DAO.PovoarComboCadNovaReceitaEmpreendimentoPeriodoDao;
import br.com.controle.imobiliario.DAO.PovoarComboCadNovaReceitaPeriodoDao;
import br.com.controle.imobiliario.DAO.PovoarComboInfReceitaPeriodoDao;
import br.com.controle.imobiliario.DAO.SomaInfDespesaDao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;

public class InfDespesaGeral extends JFrame {

	private JPanel contentPane;
	public static JTable tabelasaldoanual;
	public static JTextField tfvalorgeraldespesa;
	public static JTextField tfempreendimentodespesageral;
	public static JTextField tfunidadedespesageral;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfDespesaGeral frame = new InfDespesaGeral();
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
	public InfDespesaGeral() {
		setResizable(false);
		setTitle(" GERAL DE DESPESA");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InfDespesaGeral.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 808, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LISTA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ListarInfDespesaGeralDao lidd = new ListarInfDespesaGeralDao();
				lidd.Listar();
				SomaInfDespesaDao sidd = new SomaInfDespesaDao();
				sidd.Listar();
			}
		});
		
		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setForeground(Color.WHITE);
		lblUnidade.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnidade.setBounds(407, 22, 73, 14);
		contentPane.add(lblUnidade);
		
		JLabel lblEmpreendimento = new JLabel("Empreendimento");
		lblEmpreendimento.setForeground(Color.WHITE);
		lblEmpreendimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpreendimento.setBounds(10, 22, 123, 14);
		contentPane.add(lblEmpreendimento);
		
		tfunidadedespesageral = new JTextField();
		tfunidadedespesageral.setBounds(407, 40, 284, 20);
		contentPane.add(tfunidadedespesageral);
		tfunidadedespesageral.setColumns(10);
		
		tfempreendimentodespesageral = new JTextField();
		tfempreendimentodespesageral.setBounds(10, 40, 387, 20);
		contentPane.add(tfempreendimentodespesageral);
		tfempreendimentodespesageral.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("VALOR TOTAL DE DESPESA ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(450, 574, 170, 17);
		contentPane.add(lblNewLabel_1);
		
		tfvalorgeraldespesa = new JTextField();
		tfvalorgeraldespesa.setBounds(622, 572, 170, 20);
		contentPane.add(tfvalorgeraldespesa);
		tfvalorgeraldespesa.setColumns(10);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(703, 12, 89, 47);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 782, 489);
		contentPane.add(scrollPane);
		
		tabelasaldoanual = new JTable();
		tabelasaldoanual.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DESCRI\u00C7\u00C3O DA DESPESA", "VALOR", "PER\u00CDODO"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelasaldoanual.getColumnModel().getColumn(0).setResizable(false);
		tabelasaldoanual.getColumnModel().getColumn(0).setPreferredWidth(425);
		tabelasaldoanual.getColumnModel().getColumn(1).setResizable(false);
		tabelasaldoanual.getColumnModel().getColumn(1).setPreferredWidth(146);
		tabelasaldoanual.getColumnModel().getColumn(2).setResizable(false);
		tabelasaldoanual.getColumnModel().getColumn(2).setPreferredWidth(100);
		scrollPane.setViewportView(tabelasaldoanual);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InfDespesaGeral.class.getResource("/br/com/controle/imobiliario/imagem/download.jpg")));
		lblNewLabel.setBounds(0, 0, 802, 603);
		contentPane.add(lblNewLabel);
		
		tabelasaldoanual.getTableHeader().setReorderingAllowed(false);// manter menu da tabela fixo			
	}
}
