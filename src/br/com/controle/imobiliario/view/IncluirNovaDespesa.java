package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.controle.imobiliario.DAO.AlterarImoveisDao;
import br.com.controle.imobiliario.DAO.CadastrarImoveisDao;
import br.com.controle.imobiliario.DAO.ExcluirImoveisDao;
import br.com.controle.imobiliario.DAO.IncluirNovaDespesaDao;
import br.com.controle.imobiliario.DAO.ListaImoveisAlterarDao;
import br.com.controle.imobiliario.DAO.ListaImoveisDao;
import br.com.controle.imobiliario.DAO.ListarDespesaDao;
import br.com.controle.imobiliario.DAO.ListarIncluirDespesaDao;
import br.com.controle.imobiliario.DAO.PovoarComboNomeDespesaDao;
import br.com.controle.imobiliario.uteis.AbrirTelaDespesa;
import br.com.controle.imobiliario.uteis.UpperCaseDocument;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Window.Type;

import javax.swing.JTabbedPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.SystemColor;

public class IncluirNovaDespesa extends JFrame {

	private JPanel contentPane;
	public static JTextField tfincluirnovadespesa;
	public static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IncluirNovaDespesa frame = new IncluirNovaDespesa();
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
	public IncluirNovaDespesa() {
		setTitle("INCLUIR NOVA DESPESA");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(IncluirNovaDespesa.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 433, 616);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDeImveis = new JLabel("Incluir Despesa");
		lblCadastroDeImveis.setForeground(Color.WHITE);
		lblCadastroDeImveis.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblCadastroDeImveis.setBounds(10, 11, 354, 43);
		contentPane.add(lblCadastroDeImveis);

		JPanel panelCadastrarImoveis = new JPanel();
		panelCadastrarImoveis.setOpaque(false);
		panelCadastrarImoveis.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelCadastrarImoveis.setBackground(UIManager.getColor("Panel.background"));
		panelCadastrarImoveis.setBounds(10, 66, 409, 510);
		panelCadastrarImoveis.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)),
				"INCLUIR NOVA DESPESA", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		contentPane.add(panelCadastrarImoveis);
		panelCadastrarImoveis.setLayout(null);

		JButton btnNewButton = new JButton("INCLUIR ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(tfincluirnovadespesa.getText().equals("")){
					JOptionPane.showMessageDialog(null, "FAVOR PREENCHER O CAMPO PARA CADASTRAR NOVA DESPESA");
				}else{
				IncluirNovaDespesaDao ind = new IncluirNovaDespesaDao();
				ind.incluirDespesa(null);
				ListarIncluirDespesaDao lid = new ListarIncluirDespesaDao();
				lid.Listar();
				PovoarComboNomeDespesaDao pcnd = new PovoarComboNomeDespesaDao();
				pcnd.listar();				
				}
			}
		});
		btnNewButton.setBounds(207, 73, 187, 25);
		panelCadastrarImoveis.add(btnNewButton);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblEmpreendimento = new JLabel("Descri\u00E7\u00E3o da Nova Despesa");
		lblEmpreendimento.setForeground(Color.WHITE);
		lblEmpreendimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpreendimento.setBounds(11, 21, 204, 14);
		panelCadastrarImoveis.add(lblEmpreendimento);

		tfincluirnovadespesa = new JTextField();
		tfincluirnovadespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfincluirnovadespesa.setBounds(10, 42, 384, 20);
		panelCadastrarImoveis.add(tfincluirnovadespesa);
		tfincluirnovadespesa.setColumns(10);
		tfincluirnovadespesa.setDocument(new UpperCaseDocument());

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 110, 388, 369);
		panelCadastrarImoveis.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				AbrirTelaDespesa at = new AbrirTelaDespesa();
				at.abretela();
			}
		});
		table.setAutoCreateRowSorter(true);
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID_DESPESA", "DESCRI\u00C7\u00C3O DA DESPESA" }) {
			Class[] columnTypes = new Class[] { String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(137);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(487);
		scrollPane.setViewportView(table);
		
		JRadioButton rdbtnAlterarTipoDespesa = new JRadioButton("Alterar Tipo Despesa");
		rdbtnAlterarTipoDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AlterarNovaDespesa and = new AlterarNovaDespesa();
				and.setVisible(true);
			}
		});
		rdbtnAlterarTipoDespesa.setOpaque(false);
		rdbtnAlterarTipoDespesa.setForeground(Color.WHITE);
		rdbtnAlterarTipoDespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnAlterarTipoDespesa.setBounds(233, 480, 171, 23);
		panelCadastrarImoveis.add(rdbtnAlterarTipoDespesa);

		table.getTableHeader().setReorderingAllowed(false);// manter menu da
															// tabela fixo

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(IncluirNovaDespesa.class.getResource("/br/com/controle/imobiliario/imagem/fundo.jpg")));
		lblNewLabel.setBounds(0, 0, 427, 591);
		contentPane.add(lblNewLabel);

		setLocationRelativeTo(null); // tela sempre no centro
		
		ListarIncluirDespesaDao lid = new ListarIncluirDespesaDao();
		lid.Listar();		

	}
}
