package br.com.controle.imobiliario.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.controle.imobiliario.DAO.RelatorioGeralDespesaDao;
import br.com.controle.imobiliario.DAO.RelatorioGeralReceitaDao;
import br.com.controle.imobiliario.DAO.RelatorioImoveisDao;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;


public class Entrar extends JFrame {

	private JPanel contentPane;
	public static JMenu menucadastro;
	public static JMenu menuinformacoes;
	public static JMenu menuutilidade;
	public static JMenu menuRelatorios;
	public static JMenu menuAcessar;
	public static JLabel lblentrarlogado;
	public static JLabel lblentrardata;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrar frame = new Entrar();
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
	public Entrar() {
		setTitle(" CONTROLE DE IM\u00D3VEIS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Entrar.class.getResource("/br/com/controle/imobiliario/imagem/Logo_CI_menor.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 381);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 311, 549, 21);
		contentPane.add(panel_1);
		
		Date d = new Date();

		Locale local = new Locale("pt", "BR"); // Para internacionalizar a data,
												// colocar o codigo de cada país
												// e o mesmo assume o formato.

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", local);	
		lblentrardata = new JLabel("");
		lblentrardata.setForeground(new Color(51, 102, 153));
		lblentrardata.setBounds(62, 3, 92, 14);
		panel_1.add(lblentrardata);
		lblentrardata.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblentrardata.setText(sdf.format(d));
		
		JLabel lblLogadoComo = new JLabel("Logado :");
		lblLogadoComo.setBounds(4, 3, 59, 14);
		panel_1.add(lblLogadoComo);
		lblLogadoComo.setForeground(new Color(0, 153, 0));
		lblLogadoComo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblentrarlogado = new JLabel("");
		lblentrarlogado.setBounds(180, 3, 92, 14);
		panel_1.add(lblentrarlogado);
		lblentrarlogado.setForeground(new Color(51, 102, 153));
		lblentrarlogado.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblPor = new JLabel("por :");
		lblPor.setForeground(new Color(0, 153, 0));
		lblPor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPor.setBounds(146, 3, 36, 14);
		panel_1.add(lblPor);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 332, 549, 21);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDesenvolvidoPorJorge = new JLabel("Desenvolvido Por Jorge Alberto");
		lblDesenvolvidoPorJorge.setBounds(382, 3, 164, 14);
		panel.add(lblDesenvolvidoPorJorge);
		lblDesenvolvidoPorJorge.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDesenvolvidoPorJorge.setForeground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Entrar.class.getResource("/br/com/controle/imobiliario/imagem/frentee.png")));
		lblNewLabel.setBounds(0, 22, 549, 334);
		contentPane.add(lblNewLabel);	
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 636, 21);
		contentPane.add(menuBar);
		
		menuAcessar = new JMenu("ACESSAR");
		menuAcessar.setFont(new Font("Tahoma", Font.BOLD, 10));
		menuBar.add(menuAcessar);
		
		JMenuItem mntmAcessarControleDe = new JMenuItem("ACESSAR CONTROLE DE IM\u00D3VEIS");
		mntmAcessarControleDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login lg = new Login();
				lg.setVisible(true);
				Login.tfsenha.requestFocus();				
			}
		});
		mntmAcessarControleDe.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuAcessar.add(mntmAcessarControleDe);
		
		menucadastro = new JMenu("CADASTROS ");
		menucadastro.setFont(new Font("Tahoma", Font.BOLD, 10));
		menuBar.add(menucadastro);
		
		JMenuItem mntmNovaDespesa = new JMenuItem("NOVO IM\u00D3VEL");
		mntmNovaDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				principal pri = new principal();
				pri.setVisible(true);
			}
		});
		mntmNovaDespesa.setFont(new Font("Tahoma", Font.BOLD, 12));
		menucadastro.add(mntmNovaDespesa);
		
		JMenuItem mntmNovoTipoDe = new JMenuItem("NOVO TIPO DE DESPESA");
		mntmNovoTipoDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				IncluirNovaDespesa id = new IncluirNovaDespesa();
				id.setVisible(true);
			}
		});
		
		JMenuItem mntmNovoTipoDe_1 = new JMenuItem("NOVO TIPO DE RECEITA");
		mntmNovoTipoDe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				IncluirNovaReceita inr = new IncluirNovaReceita();
				inr.setVisible(true);
			}
		});
		mntmNovoTipoDe_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		menucadastro.add(mntmNovoTipoDe_1);
		mntmNovoTipoDe.setFont(new Font("Tahoma", Font.BOLD, 12));
		menucadastro.add(mntmNovoTipoDe);
		
		menuinformacoes = new JMenu("MOVIMENTA\u00C7\u00D5ES");
		menuinformacoes.setFont(new Font("Tahoma", Font.BOLD, 10));
		menuBar.add(menuinformacoes);
		
		JMenuItem mntmInformaes = new JMenuItem("LISTA GERAL DE IM\u00D3VEIS");
		mntmInformaes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InfImovel ii = new 	InfImovel();
				ii.setVisible(true);
			}
		});
		
		JMenuItem mntmInformeNovaReceita = new JMenuItem("INFORME NOVA RECEITA");
		mntmInformeNovaReceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CadastrarReceita cr = new CadastrarReceita();
				cr.setVisible(true);
			}
		});
		mntmInformeNovaReceita.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuinformacoes.add(mntmInformeNovaReceita);
		
		JMenuItem mntmInformeNodaDespesa = new JMenuItem("INFORME NOVA DESPESA");
		mntmInformeNodaDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastrarDespesa cd = new CadastrarDespesa();
				cd.setVisible(true);
			}
		});
		mntmInformeNodaDespesa.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuinformacoes.add(mntmInformeNodaDespesa);
		mntmInformaes.setFont(new Font("Tahoma", Font.BOLD, 12));
		mntmInformaes.setForeground(Color.BLACK);
		menuinformacoes.add(mntmInformaes);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("LISTA GERAL DE SALDO POR PER\u00CDODO");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InfAnualSaldo ima = new InfAnualSaldo();
				ima.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("LISTA GERAL DE RECEITA POR IM\u00D3VEL");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InfImoveisReceitaGeralImovel iira = new InfImoveisReceitaGeralImovel();
				iira.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuinformacoes.add(mntmNewMenuItem_1);
		
		JMenuItem mntmListaDespesaPor = new JMenuItem("LISTA GERAL DE DESPESA POR IM\u00D3VEL");
		mntmListaDespesaPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InfImoveisDespesaGeralImovel iida = new InfImoveisDespesaGeralImovel();
				iida.setVisible(true);
			}
		});
		mntmListaDespesaPor.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuinformacoes.add(mntmListaDespesaPor);
		mntmNewMenuItem.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuinformacoes.add(mntmNewMenuItem);
		
		menuRelatorios = new JMenu("RELAT\u00D3RIOS");
		menuRelatorios.setEnabled(false);
		menuRelatorios.setFont(new Font("Tahoma", Font.BOLD, 10));
		menuBar.add(menuRelatorios);
		
		JMenuItem mntmImveisCadastrados = new JMenuItem("IM\u00D3VEIS CADASTRADOS");
		mntmImveisCadastrados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RelatorioImoveisDao rm = new RelatorioImoveisDao();
				rm.relatorioimoveiscadastrados();
			}
		});
		mntmImveisCadastrados.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuRelatorios.add(mntmImveisCadastrados);
		
		JMenuItem mntmRelatrioDespesaPor = new JMenuItem("RELAT\u00D3RIO DESPESA POR EMPREENDIMENTO");
		mntmRelatrioDespesaPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RelatorioDespesaporEmpreendimento rdpe = new RelatorioDespesaporEmpreendimento();
				rdpe.setVisible(true);
			}
		});
		mntmRelatrioDespesaPor.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuRelatorios.add(mntmRelatrioDespesaPor);
		
		JMenuItem mntmRelatrioReceitaPor = new JMenuItem("RELAT\u00D3RIO RECEITA POR EMPREENDIMENTO");
		mntmRelatrioReceitaPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RelatorioReceitaporEmpreendimento rrpe = new RelatorioReceitaporEmpreendimento();
				rrpe.setVisible(true);
			}
		});
		mntmRelatrioReceitaPor.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuRelatorios.add(mntmRelatrioReceitaPor);
		
		JMenuItem mntmRelatrioGeralDe = new JMenuItem("RELAT\u00D3RIO GERAL DE DESPESA");
		mntmRelatrioGeralDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RelatorioGeralDespesaDao rgd = new RelatorioGeralDespesaDao();
				rgd.relatoriogeraldespesa();
			}
		});
		mntmRelatrioGeralDe.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuRelatorios.add(mntmRelatrioGeralDe);
		
		JMenuItem mntmRelatrioGeralDe_1 = new JMenuItem("RELAT\u00D3RIO GERAL DE RECEITA");
		mntmRelatrioGeralDe_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RelatorioGeralReceitaDao rgr = new RelatorioGeralReceitaDao();
				rgr.relatoriogeralreceita();
			}
		});
		mntmRelatrioGeralDe_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuRelatorios.add(mntmRelatrioGeralDe_1);
		
		menuutilidade = new JMenu("UTILIDADE");
		menuutilidade.setEnabled(false);
		menuutilidade.setFont(new Font("Tahoma", Font.BOLD, 10));
		menuBar.add(menuutilidade);
		
		JMenuItem mntmValorDoDolar = new JMenuItem("VALOR DO DOLAR HOJE");
		mntmValorDoDolar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Runtime.getRuntime().exec("cmd.exe /C start chrome.exe https://www.melhorcambio.com/dolar-hoje");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mntmValorDoDolar.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuutilidade.add(mntmValorDoDolar);
		
		JMenuItem mntmCustoDeVida = new JMenuItem("CUSTO DE VIDA");
		mntmCustoDeVida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Runtime.getRuntime().exec("cmd.exe /C start chrome.exe http://www.custodevida.com.br/pe/recife/#bar");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmCustoDeVida.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuutilidade.add(mntmCustoDeVida);
		
		JMenuItem mntmCuidadosAoAlugar = new JMenuItem("CUIDADOS AO ALUGAR");
		mntmCuidadosAoAlugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Runtime.getRuntime().exec("cmd.exe /C start chrome.exe https://bernardocesarcoura.jusbrasil.com.br/noticias/148145220/tudo-o-que-voce-precisa-saber-sobre-locacao-de-imovel");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmCuidadosAoAlugar.setFont(new Font("Tahoma", Font.BOLD, 12));
		menuutilidade.add(mntmCuidadosAoAlugar);
		
		Entrar.menucadastro.setEnabled(false);
		Entrar.menuinformacoes.setEnabled(false);
		Entrar.menuutilidade.setEnabled(false);
		Entrar.menuRelatorios.setEnabled(false);
	}
}
