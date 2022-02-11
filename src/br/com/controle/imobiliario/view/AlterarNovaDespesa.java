package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.controle.imobiliario.DAO.AlterarImoveisDao;
import br.com.controle.imobiliario.DAO.AlterarTipoDespesaDao;
import br.com.controle.imobiliario.DAO.AlterarTipoReceitaDao;
import br.com.controle.imobiliario.DAO.CadastrarImoveisDao;
import br.com.controle.imobiliario.DAO.ExcluirImoveisDao;
import br.com.controle.imobiliario.DAO.IncluirNovaReceitaDao;
import br.com.controle.imobiliario.DAO.ListaImoveisAlterarDao;
import br.com.controle.imobiliario.DAO.ListaImoveisDao;
import br.com.controle.imobiliario.DAO.ListaTipoDespesaAlterarDao;
import br.com.controle.imobiliario.DAO.ListaTipoReceitaAlterarDao;
import br.com.controle.imobiliario.DAO.ListarIncluirDespesaDao;
import br.com.controle.imobiliario.DAO.ListarIncluirReceitaDao;
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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;

public class AlterarNovaDespesa extends JFrame {

	private JPanel contentPane;
	public static JTextField tfalterartipodespesa;
	public static JTextField tfidalterartipodespesa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarNovaDespesa frame = new AlterarNovaDespesa();
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
	public AlterarNovaDespesa() {
		setTitle("ALTERAR TIPO DESPESA");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AlterarNovaDespesa.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 433, 266);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDeImveis = new JLabel("Alterar Despesa");
		lblCadastroDeImveis.setForeground(Color.WHITE);
		lblCadastroDeImveis.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblCadastroDeImveis.setBounds(10, 11, 354, 43);
		contentPane.add(lblCadastroDeImveis);

		JPanel panelCadastrarImoveis = new JPanel();
		panelCadastrarImoveis.setOpaque(false);
		panelCadastrarImoveis.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelCadastrarImoveis.setBackground(UIManager.getColor("Panel.background"));
		panelCadastrarImoveis.setBounds(10, 66, 409, 161);
		panelCadastrarImoveis.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)),
				"ALTERAR TIPO DESPESA", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		contentPane.add(panelCadastrarImoveis);
		panelCadastrarImoveis.setLayout(null);

		JButton btnNewButton = new JButton("ALTERAR ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				AlterarTipoDespesaDao atdd = new AlterarTipoDespesaDao();
				atdd.listar();
				ListarIncluirDespesaDao lid = new ListarIncluirDespesaDao();
				lid.Listar();
			}
		});
		btnNewButton.setBounds(207, 127, 187, 25);
		panelCadastrarImoveis.add(btnNewButton);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblEmpreendimento = new JLabel("Descri\u00E7\u00E3o da Nova Despesa");
		lblEmpreendimento.setForeground(Color.WHITE);
		lblEmpreendimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpreendimento.setBounds(11, 75, 204, 14);
		panelCadastrarImoveis.add(lblEmpreendimento);

		tfalterartipodespesa = new JTextField();
		tfalterartipodespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfalterartipodespesa.setBounds(10, 96, 384, 20);
		panelCadastrarImoveis.add(tfalterartipodespesa);
		tfalterartipodespesa.setColumns(10);
		tfalterartipodespesa.setDocument(new UpperCaseDocument());
		
		JLabel lblIdDaReceita = new JLabel("Id da Despesa");
		lblIdDaReceita.setForeground(Color.WHITE);
		lblIdDaReceita.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdDaReceita.setBounds(11, 24, 102, 14);
		panelCadastrarImoveis.add(lblIdDaReceita);
		
		tfidalterartipodespesa = new JTextField();
		tfidalterartipodespesa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				ListaTipoDespesaAlterarDao ltdad = new ListaTipoDespesaAlterarDao();
				ltdad.listar();
			}
		});
		tfidalterartipodespesa.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfidalterartipodespesa.setColumns(10);
		tfidalterartipodespesa.setBounds(10, 49, 194, 20);
		panelCadastrarImoveis.add(tfidalterartipodespesa);
															// tabela fixo

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(AlterarNovaDespesa.class.getResource("/br/com/controle/imobiliario/imagem/fundo.jpg")));
		lblNewLabel.setBounds(0, 0, 427, 238);
		contentPane.add(lblNewLabel);

		//setLocationRelativeTo(null); // tela sempre no centro		
		

	}
}
