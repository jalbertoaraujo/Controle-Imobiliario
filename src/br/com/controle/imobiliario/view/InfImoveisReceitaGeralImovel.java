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

import br.com.controle.imobiliario.DAO.ListarInfReceitaAnualDao;
import br.com.controle.imobiliario.DAO.PovoarComboCadNovaReceitaEmpreendimentoPeriodoDao;
import br.com.controle.imobiliario.DAO.PovoarComboCadNovaReceitaPeriodoDao;
import br.com.controle.imobiliario.DAO.PovoarComboInfReceitaPeriodoDao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;

public class InfImoveisReceitaGeralImovel extends JFrame {

	private JPanel contentPane;
	public static JTable tabelasaldoanual;
	public static JComboBox cbcadnovareceitaempreendimentoperiodo;
	public static JComboBox cbcadnovareceitaperiodo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfImoveisReceitaGeralImovel frame = new InfImoveisReceitaGeralImovel();
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
	public InfImoveisReceitaGeralImovel() {
		setResizable(false);
		setTitle(" GERAL DE RECEITA POR IM\u00D3VEL");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InfImoveisReceitaGeralImovel.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 808, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LISTA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ListarInfReceitaAnualDao lird = new ListarInfReceitaAnualDao();
				lird.Listar();
			}
		});
		
		cbcadnovareceitaperiodo = new JComboBox();
		cbcadnovareceitaperiodo.setBounds(418, 38, 274, 20);
		contentPane.add(cbcadnovareceitaperiodo);
		
		cbcadnovareceitaempreendimentoperiodo = new JComboBox();
		cbcadnovareceitaempreendimentoperiodo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				InfImoveisReceitaGeralImovel.cbcadnovareceitaperiodo.removeAllItems();
				PovoarComboCadNovaReceitaPeriodoDao pccnrp = new PovoarComboCadNovaReceitaPeriodoDao();
				pccnrp.listar();
			}
		});
		cbcadnovareceitaempreendimentoperiodo.setBounds(10, 39, 398, 20);
		contentPane.add(cbcadnovareceitaempreendimentoperiodo);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(703, 12, 89, 47);
		contentPane.add(btnNewButton);
		
		JLabel label_1 = new JLabel("Unidade");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(422, 16, 69, 14);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("Empreendimento / Im\u00F3vel");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(10, 12, 208, 20);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 782, 520);
		contentPane.add(scrollPane);
		
		tabelasaldoanual = new JTable();
		tabelasaldoanual.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"DESCRI\u00C7\u00C3O DA RECEITA", "VALOR", "PER\u00CDODO"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
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
		lblNewLabel.setIcon(new ImageIcon(InfImoveisReceitaGeralImovel.class.getResource("/br/com/controle/imobiliario/imagem/download.jpg")));
		lblNewLabel.setBounds(0, 0, 802, 603);
		contentPane.add(lblNewLabel);
		
		tabelasaldoanual.getTableHeader().setReorderingAllowed(false);// manter menu da tabela fixo
		
		PovoarComboInfReceitaPeriodoDao pcirp = new PovoarComboInfReceitaPeriodoDao();
		pcirp.listar();
		PovoarComboCadNovaReceitaEmpreendimentoPeriodoDao pccnrep = new PovoarComboCadNovaReceitaEmpreendimentoPeriodoDao();
		pccnrep.listar();
		PovoarComboCadNovaReceitaPeriodoDao pccnrp = new PovoarComboCadNovaReceitaPeriodoDao();
		pccnrp.listar();		
	}
}
