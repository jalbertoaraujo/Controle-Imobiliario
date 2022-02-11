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

import br.com.controle.imobiliario.DAO.ListarInfDespesaAnualDao;
import br.com.controle.imobiliario.DAO.PovoarComboCadNovaDespesaEmpreendimentoDao;
import br.com.controle.imobiliario.DAO.PovoarComboCadNovaDespesaPeriodoDao;
import br.com.controle.imobiliario.DAO.PovoarComboCadNovaDespesaEmpreendimentoPeriodoDao;
import br.com.controle.imobiliario.DAO.PovoarComboInfDespesaPeriodoDao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;

public class InfImoveisDespesaGeralImovel extends JFrame {

	private JPanel contentPane;
	public static JTable tabelasaldodespesaanual;
	public static JComboBox cbcadnovadespesaempreendimentoperiodo;
	public static JComboBox cbcadnovadespesaperiodo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfImoveisDespesaGeralImovel frame = new InfImoveisDespesaGeralImovel();
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
	public InfImoveisDespesaGeralImovel() {
		setResizable(false);
		setTitle(" GERAL DE DESPESA POR IM\u00D3VEL");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InfImoveisDespesaGeralImovel.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 808, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LISTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ListarInfDespesaAnualDao lida = new ListarInfDespesaAnualDao();
				lida.Listar();
			}
		});
		
		cbcadnovadespesaperiodo = new JComboBox();
		cbcadnovadespesaperiodo.setBounds(433, 39, 260, 20);
		contentPane.add(cbcadnovadespesaperiodo);
		
		cbcadnovadespesaempreendimentoperiodo = new JComboBox();
		cbcadnovadespesaempreendimentoperiodo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				InfImoveisDespesaGeralImovel.cbcadnovadespesaperiodo.removeAllItems();
				PovoarComboCadNovaDespesaPeriodoDao pcndp = new PovoarComboCadNovaDespesaPeriodoDao();
				pcndp.listar();
			}
		});
		cbcadnovadespesaempreendimentoperiodo.setBounds(10, 39, 412, 20);
		contentPane.add(cbcadnovadespesaempreendimentoperiodo);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(703, 25, 89, 34);
		contentPane.add(btnNewButton);
		
		JLabel label_1 = new JLabel("Unidade");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(435, 18, 74, 14);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("Empreendimento / Im\u00F3vel");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(10, 14, 208, 20);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 782, 519);
		contentPane.add(scrollPane);
		
		tabelasaldodespesaanual = new JTable();
		tabelasaldodespesaanual.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"DESCRI\u00C7\u00C3O DA  DESPESA", "VALOR", "PER\u00CDODO"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelasaldodespesaanual.getColumnModel().getColumn(0).setPreferredWidth(425);
		tabelasaldodespesaanual.getColumnModel().getColumn(1).setPreferredWidth(146);
		tabelasaldodespesaanual.getColumnModel().getColumn(2).setPreferredWidth(100);
		scrollPane.setViewportView(tabelasaldodespesaanual);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InfImoveisDespesaGeralImovel.class.getResource("/br/com/controle/imobiliario/imagem/download.jpg")));
		lblNewLabel.setBounds(0, 0, 802, 603);
		contentPane.add(lblNewLabel);
		
		tabelasaldodespesaanual.getTableHeader().setReorderingAllowed(false);// manter menu da tabela fixo
		
		PovoarComboCadNovaDespesaEmpreendimentoPeriodoDao pccnde = new PovoarComboCadNovaDespesaEmpreendimentoPeriodoDao();
		pccnde.listar();
		PovoarComboCadNovaDespesaPeriodoDao pcndp = new PovoarComboCadNovaDespesaPeriodoDao();
		pcndp.listar();
		PovoarComboInfDespesaPeriodoDao pcidp = new PovoarComboInfDespesaPeriodoDao();
		pcidp.listar();
	}
}
