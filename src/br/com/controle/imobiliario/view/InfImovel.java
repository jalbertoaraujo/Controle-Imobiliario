package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.controle.imobiliario.DAO.ListaEstatisticaImoveisDao;
import br.com.controle.imobiliario.uteis.AbrirTelaEstatisticaImoveis;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InfImovel extends JFrame {

	private JPanel contentPane;
	public static JTable tabelainfimoveis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfImovel frame = new InfImovel();
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
	public InfImovel() {
		setTitle(" INFORMA\u00C7\u00D5ES IM\u00D3VEL");
		setIconImage(Toolkit.getDefaultToolkit().getImage(InfImovel.class.getResource("/br/com/controle/imobiliario/imagem/Logo CI.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1067, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); // tela sempre no centro
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 10));
		scrollPane.setBounds(10, 11, 1041, 523);
		contentPane.add(scrollPane);
		
		tabelainfimoveis = new JTable();
		tabelainfimoveis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Acoes frame = new Acoes();
				frame.setVisible(true);
//				AbrirTelaEstatisticaImoveis atei = new AbrirTelaEstatisticaImoveis();
//				atei.AbrirTelaEstatisticaImoveis();
			}
		});
		tabelainfimoveis.setFont(new Font("Tahoma", Font.BOLD, 10));
		tabelainfimoveis.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00D3DIGO", "EMPREENDIMENTO / IM\u00D3VEL", "UNIDADE", "CIDADE", "ESTADO"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelainfimoveis.getColumnModel().getColumn(0).setResizable(false);
		tabelainfimoveis.getColumnModel().getColumn(0).setPreferredWidth(37);
		tabelainfimoveis.getColumnModel().getColumn(1).setPreferredWidth(310);
		tabelainfimoveis.getColumnModel().getColumn(2).setPreferredWidth(141);
		tabelainfimoveis.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(tabelainfimoveis);
		
		tabelainfimoveis.getTableHeader().setReorderingAllowed(false);// manter menu da tabela fixo
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InfImovel.class.getResource("/br/com/controle/imobiliario/imagem/download.jpg")));
		lblNewLabel.setBounds(0, 0, 1438, 545);
		contentPane.add(lblNewLabel);		
		
		ListaEstatisticaImoveisDao leid = new ListaEstatisticaImoveisDao();
		leid.listar();
	}
}
