package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.Window.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.DAO.AlterarDespesaDao;
import br.com.controle.imobiliario.DAO.AlterarReceitaDao;
import br.com.controle.imobiliario.DAO.CadastrarDespesaDao;
import br.com.controle.imobiliario.DAO.CadastrarReceitaDao;
import br.com.controle.imobiliario.DAO.ListaImoveisDao;
import br.com.controle.imobiliario.DAO.ListarDespesaDao;
import br.com.controle.imobiliario.DAO.ListarReceitaDao;
import br.com.controle.imobiliario.DAO.PovoarComboCadNovaDespesaDao;
import br.com.controle.imobiliario.DAO.PovoarComboCadNovaDespesaEmpreendimentoDao;
import br.com.controle.imobiliario.DAO.PovoarComboCadNovaReceitaDao;
import br.com.controle.imobiliario.DAO.PovoarComboNomeDespesaAlterarDao;
import br.com.controle.imobiliario.DAO.PovoarComboNomeDespesaDao;
import br.com.controle.imobiliario.DAO.PovoarComboNomeReceitaAlterarDao;
import br.com.controle.imobiliario.uteis.UpperCaseDocument;

import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.ComponentOrientation;


public class AlterarReceita extends JFrame {

	private JPanel contentPane;
	public static JTextField tfvalorreceita;
	public static JTextField tfobsreceita;
	public static JComboBox cbnomereceitaalterar;
	public static JComboBox cbcompetenciareceita;
	public static JTextField tfidreceitaalterar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarReceita frame = new AlterarReceita();
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
	public AlterarReceita() {
		setTitle("ALTERAR RECEITA");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AlterarReceita.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(-13, -152, 642, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		DefaultTableCellRenderer tabela1 = new DefaultTableCellRenderer();// alinhar
																			// à
																			// direita
																			// valores
																			// da
																			// coluna
																			// indicada
		tabela1.setHorizontalAlignment(SwingConstants.RIGHT);
																				// qual
																				// coluna
																				// ficará
																				// à
																				// direita

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(0, 204, 636, 6);
		contentPane.add(separator_1);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)), "ALTERAR DESPESA",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		panel.setBounds(10, 26, 615, 166);
		contentPane.add(panel);

		JLabel lblDespesa = new JLabel("Receita");
		lblDespesa.setForeground(Color.WHITE);
		lblDespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDespesa.setBounds(9, 49, 63, 17);
		panel.add(lblDespesa);

		JLabel label_1 = new JLabel("Valor ");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(9, 80, 46, 14);
		panel.add(label_1);

		JLabel label_2 = new JLabel("Observa\u00E7\u00E3o");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(9, 133, 91, 14);
		panel.add(label_2);

		JButton btinserirdespesa = new JButton("<html><center>ALTERAR<br/>RECEITA</center></html>");
		btinserirdespesa.setForeground(Color.WHITE);
		btinserirdespesa.setBackground(SystemColor.activeCaption);
		btinserirdespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			AlterarReceitaDao ard = new AlterarReceitaDao();
			ard.listar();
			ListarReceitaDao lisrec = new ListarReceitaDao();
			lisrec.Listar();
			}
		});
		btinserirdespesa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btinserirdespesa.setBounds(401, 102, 79, 49);
		panel.add(btinserirdespesa);

		tfvalorreceita = new JTextField();
		tfvalorreceita.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfvalorreceita.setColumns(10);
		tfvalorreceita.setBounds(106, 76, 283, 20);
		tfvalorreceita.setDocument(new UpperCaseDocument());
		tfvalorreceita.setHorizontalAlignment(tfvalorreceita.RIGHT); // alinha a
																		// direita
		panel.add(tfvalorreceita);

		tfobsreceita = new JTextField();
		tfobsreceita.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfobsreceita.setColumns(10);
		tfobsreceita.setBounds(106, 130, 283, 20);
		tfobsreceita.setDocument(new UpperCaseDocument());
		panel.add(tfobsreceita);

		cbnomereceitaalterar = new JComboBox();
		cbnomereceitaalterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		cbnomereceitaalterar.setBounds(105, 49, 286, 20);
		panel.add(cbnomereceitaalterar);
		
		JLabel lblCompetncia = new JLabel("Compet\u00EAncia");
		lblCompetncia.setForeground(Color.WHITE);
		lblCompetncia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCompetncia.setBounds(9, 105, 91, 14);
		panel.add(lblCompetncia);
		
		cbcompetenciareceita = new JComboBox();
		cbcompetenciareceita.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbcompetenciareceita.setModel(new DefaultComboBoxModel(new String[] {"JANEIRO/19", "FEVEREIRO/19", "MAR\u00C7O/19", "ABRIL/19", "MAIO/19", "JUNHO/19", "JULHO/19", "AGOSTO/19", "SETEMBRO/19", "OUTUBRO/19", "NOVEMBRO/19", "DEZEMBRO/19", "JANEIRO/20", "FEVEREIRO/20", "MAR\u00C7O/20", "ABRIL/20", "MAIO/20", "JUNHO/20", "JULHO/20", "AGOSTO/20", "SETEMBRO/20", "OUTUBRO/20", "NOVEMBRO/20", "DEZEMBRO/20", "JANEIRO/21", "FEVEREIRO/21", "MAR\u00C7O/21", "ABRIL/21", "MAIO/21", "JUNHO/21", "JULHO/21", "AGOSTO/21", "SETEMBRO/21", "OUTUBRO/21", "NOVEMBRO/21", "DEZEMBRO/21", "JANEIRO/22", "FEVEREIRO/22", "MAR\u00C7O/22", "ABRIL/22", "MAIO/22", "JUNHO/22", "JULHO/22", "AGOSTO/22", "SETEMBRO/22", "OUTUBRO/22", "NOVEMBRO/22", "DEZEMBRO/22", "JANEIRO/23", "FEVEREIRO/23", "MAR\u00C7O/23", "ABRIL/23", "MAIO/23", "JUNHO/23", "JULHO/23", "AGOSTO/23", "SETEMBRO/23", "OUTUBRO/23", "NOVEMBRO/23", "DEZEMBRO/23", "JANEIRO/24", "FEVEREIRO/24", "MAR\u00C7O/24", "ABRIL/24", "MAIO/24", "JUNHO/24", "JULHO/24", "AGOSTO/24", "SETEMBRO/24", "OUTUBRO/24", "NOVEMBRO/24", "DEZEMBRO/24", "JANEIRO/25", "FEVEREIRO/25", "MAR\u00C7O/25", "ABRIL/25", "MAIO/25", "JUNHO/25", "JULHO/25", "AGOSTO/25", "SETEMBRO/25", "OUTUBRO/25", "NOVEMBRO/25", "DEZEMBRO/25", "JANEIRO/26", "FEVEREIRO/26", "MAR\u00C7O/26", "ABRIL/26", "MAIO/26", "JUNHO/26", "JULHO/26", "AGOSTO/26", "SETEMBRO/26", "OUTUBRO/26", "NOVEMBRO/26", "DEZEMBRO/26", "JANEIRO/27", "FEVEREIRO/27", "MAR\u00C7O/27", "ABRIL/27", "MAIO/27", "JUNHO/27", "JULHO/27", "AGOSTO/27", "SETEMBRO/27", "OUTUBRO/27", "NOVEMBRO/27", "DEZEMBRO/27", "JANEIRO/28", "FEVEREIRO/28", "MAR\u00C7O/28", "ABRIL/28", "MAIO/28", "JUNHO/28", "JULHO/28", "AGOSTO/28", "SETEMBRO/28", "OUTUBRO/28", "NOVEMBRO/28", "DEZEMBRO/28", "JANEIRO/29", "FEVEREIRO/29", "MAR\u00C7O/29", "ABRIL/29", "MAIO/29", "JUNHO/29", "JULHO/29", "AGOSTO/29", "SETEMBRO/29", "OUTUBRO/29", "NOVEMBRO/29", "DEZEMBRO/29"}));
		cbcompetenciareceita.setBounds(106, 103, 285, 20);
		panel.add(cbcompetenciareceita);
		
		JLabel lblIddespesa = new JLabel("Id_Receita");
		lblIddespesa.setForeground(Color.WHITE);
		lblIddespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIddespesa.setBounds(9, 23, 91, 17);
		panel.add(lblIddespesa);
		
		tfidreceitaalterar = new JTextField();
		tfidreceitaalterar.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfidreceitaalterar.setEditable(false);
		tfidreceitaalterar.setBounds(106, 23, 86, 20);
		panel.add(tfidreceitaalterar);
		tfidreceitaalterar.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(0, 13, 636, 6);
		contentPane.add(separator);
		//tfperiodolocatario.setText(sdf1.format(d1));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(AlterarReceita.class.getResource("/br/com/controle/imobiliario/imagem/download.jpg")));
		lblNewLabel.setBounds(0, 0, 636, 220);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
																	// menu da
																	// tabela
																	// fixo

//		ListarDespesaDao lisdes = new ListarDespesaDao();
//		lisdes.Listar();
//
//		PovoarComboCadNovaDespesaDao pccnd = new PovoarComboCadNovaDespesaDao();
//		pccnd.listar();
		PovoarComboNomeReceitaAlterarDao pcnr = new PovoarComboNomeReceitaAlterarDao();
		pcnr.listar();
//		PovoarComboCadNovaDespesaEmpreendimentoDao pccnde = new PovoarComboCadNovaDespesaEmpreendimentoDao();
//		pccnde.listar();

	}
}
