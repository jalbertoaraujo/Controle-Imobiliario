package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.com.controle.imobiliario.DAO.AlterarImoveisDao;
import br.com.controle.imobiliario.DAO.AlterarTipoReceitaDao;
import br.com.controle.imobiliario.DAO.CadastrarImoveisDao;
import br.com.controle.imobiliario.DAO.ExcluirImoveisDao;
import br.com.controle.imobiliario.DAO.IncluirNovaReceitaDao;
import br.com.controle.imobiliario.DAO.ListaImoveisAlterarDao;
import br.com.controle.imobiliario.DAO.ListaImoveisDao;
import br.com.controle.imobiliario.DAO.ListaTipoReceitaAlterarDao;
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

public class AlterarNovaReceita extends JFrame {

	private JPanel contentPane;
	public static JTextField tfalterartiporeceita;
	public static JTextField tfidalterartiporeceita;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarNovaReceita frame = new AlterarNovaReceita();
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
	public AlterarNovaReceita() {
		setTitle("ALTERAR TIPO RECEITA");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AlterarNovaReceita.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 433, 266);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDeImveis = new JLabel("Alterar Receita");
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
				"ALTERAR TIPO RECEITA", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		contentPane.add(panelCadastrarImoveis);
		panelCadastrarImoveis.setLayout(null);

		JButton btnNewButton = new JButton("ALTERAR ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				AlterarTipoReceitaDao atrd = new AlterarTipoReceitaDao();
				atrd.listar();
				ListarIncluirReceitaDao lid = new ListarIncluirReceitaDao();
				lid.Listar();
			
			}
		});
		btnNewButton.setBounds(207, 127, 187, 25);
		panelCadastrarImoveis.add(btnNewButton);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblEmpreendimento = new JLabel("Descri\u00E7\u00E3o da Nova Receita");
		lblEmpreendimento.setForeground(Color.WHITE);
		lblEmpreendimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpreendimento.setBounds(11, 75, 204, 14);
		panelCadastrarImoveis.add(lblEmpreendimento);

		tfalterartiporeceita = new JTextField();
		tfalterartiporeceita.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfalterartiporeceita.setBounds(10, 96, 384, 20);
		panelCadastrarImoveis.add(tfalterartiporeceita);
		tfalterartiporeceita.setColumns(10);
		tfalterartiporeceita.setDocument(new UpperCaseDocument());
		
		JLabel lblIdDaReceita = new JLabel("Id da Receita");
		lblIdDaReceita.setForeground(Color.WHITE);
		lblIdDaReceita.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdDaReceita.setBounds(11, 24, 102, 14);
		panelCadastrarImoveis.add(lblIdDaReceita);
		
		tfidalterartiporeceita = new JTextField();
		tfidalterartiporeceita.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				ListaTipoReceitaAlterarDao ltra = new ListaTipoReceitaAlterarDao();
				ltra.listar();
			}
		});
		tfidalterartiporeceita.setFont(new Font("Tahoma", Font.BOLD, 14));
		tfidalterartiporeceita.setColumns(10);
		tfidalterartiporeceita.setBounds(10, 49, 194, 20);
		panelCadastrarImoveis.add(tfidalterartiporeceita);
															// tabela fixo

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(AlterarNovaReceita.class.getResource("/br/com/controle/imobiliario/imagem/fundo.jpg")));
		lblNewLabel.setBounds(0, 0, 427, 238);
		contentPane.add(lblNewLabel);

		//setLocationRelativeTo(null); // tela sempre no centro		
		

	}
}
