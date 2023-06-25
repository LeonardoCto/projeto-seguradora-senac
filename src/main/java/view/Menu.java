package view;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.privatejgoodies.forms.layout.ColumnSpec;
import com.privatejgoodies.forms.layout.FormLayout;
import com.privatejgoodies.forms.layout.RowSpec;

public class Menu {

	private JFrame frmMenu;
	protected PainelCadastroSeguro painelCadastroCliente;
	protected PainelConsultaSeguro PainelConsultaCliente;
	private PainelConsultaSeguro painelConsultaSeguroAlterado;
	private PainelCadastroSeguro painelCadastroSeguro;
	private PainelConsultaSinistro painelConsultaSinistro;
	private PainelCadastroSinistro painelCadastroSinistro;
	protected PainelConsultaSeguro painelConsultaSeguro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.getContentPane().setBackground(new Color(26, 156, 238));
		frmMenu.setIconImage(

				Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/icones/icons8-card\u00E1pio-64.png")));
		// Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/icones/icons8-cardápio-64.png")));
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 631, 569);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenu.setExtendedState(JFrame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setBackground(new Color(26, 158, 230));
		frmMenu.setJMenuBar(menuBar);

		JMenu mnItemCliente = new JMenu("Cliente");
		mnItemCliente.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-cliente-64 (3).png")));
		menuBar.add(mnItemCliente);

		// PARTE DE CLIENTE DO MENU//////////////////////////////////////////////////////////////////////////////////////////////
		JMenuItem mnItemCadastroCliente = new JMenuItem("Cadastro");
		mnItemCadastroCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelCadastroCliente painelCadastroCliente = new PainelCadastroCliente();
				frmMenu.setContentPane(painelCadastroCliente);
				frmMenu.revalidate();
			}
		});

		JMenuItem mnItemConsultaCliente = new JMenuItem("Consultar");
		mnItemConsultaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelConsultaCliente painelConsultaCliente = new PainelConsultaCliente();
				frmMenu.setContentPane(painelConsultaCliente);
				frmMenu.revalidate();
			}
		});

		mnItemCadastroCliente.setIcon(
				new ImageIcon(Menu.class.getResource("/icones/icons8-adicionar-usu\u00E1rio-masculino-64.png")));
		mnItemCliente.add(mnItemCadastroCliente);
		mnItemConsultaCliente.setIcon(
				new ImageIcon(Menu.class.getResource("/icones/icons8-an\u00E1lise-de-crescimento-financeiro-64.png")));
		mnItemCliente.add(mnItemConsultaCliente);

		// PARTE DE SEGURO DO MENU//////////////////////////////////////////////////////////////////////////////////////////////
		JMenu mnSeguros = new JMenu("Seguros");
		mnSeguros.setBackground(new Color(26, 158, 230));
		mnSeguros.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-alerta-64 (1).png")));
		menuBar.add(mnSeguros);

		JMenuItem mnItemConsultaSeguro = new JMenuItem("Consulta");
		mnItemConsultaSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelConsultaSeguro = new PainelConsultaSeguro();
				painelConsultaSeguro.setVisible(true);
				registrarCliqueBotaoEditarDoPainelConsultaSeguro();
				painelConsultaSeguro.getBtnEditar().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PainelCadastroSeguro telaEdicaoSeguro = new PainelCadastroSeguro(
								painelConsultaSeguro.getSeguroSelecionado());
					}
				});
				frmMenu.setContentPane(painelConsultaSeguro);
				frmMenu.revalidate();
			}

		});
		mnItemConsultaSeguro.setIcon(
				new ImageIcon(Menu.class.getResource("/icones/icons8-an\u00E1lise-de-crescimento-financeiro-64.png")));
		mnSeguros.add(mnItemConsultaSeguro);

		JMenuItem mnItemCadastroSeguro = new JMenuItem("Cadastro");
		mnItemCadastroSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroSeguro = new PainelCadastroSeguro(null);
				painelCadastroSeguro.setVisible(true);
				registrarCliqueBotaoVoltarDoPainelCadastroSeguro();
				// Atualiza a tela principal
				frmMenu.setContentPane(painelCadastroSeguro);
				frmMenu.revalidate();
			}

		});

		mnItemCadastroSeguro.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-carro-64 (1).png")));
		mnSeguros.add(mnItemCadastroSeguro);

		// PARTE DE SINISTRO DO MENU////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		JMenu mnSinistro = new JMenu("Sinistro");
		mnSinistro.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-servi\u00E7o-de-carro-64.png")));
		menuBar.add(mnSinistro);

		JMenuItem mnItemCadastroSinistro = new JMenuItem("Cadastrar");
		mnItemCadastroSinistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelCadastroSinistro painelCadastroSinistro = new PainelCadastroSinistro(null);
				frmMenu.setContentPane(painelCadastroSinistro);
				painelCadastroSinistro.setVisible(true);
				frmMenu.revalidate();

				painelCadastroSinistro.getBtnVoltar().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						PainelConsultaSinistro painelConsultaSinistro = new PainelConsultaSinistro();
						frmMenu.setContentPane(painelConsultaSinistro);
						frmMenu.revalidate();
						painelConsultaSinistro.setVisible(true);
						frmMenu.revalidate();
					}
				});

			}
		});
		mnItemCadastroSinistro.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-adicionar-64.png")));
		mnSinistro.add(mnItemCadastroSinistro);

		JMenuItem mnItemConsultarSinistro = new JMenuItem("Consultar");
		mnItemConsultarSinistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelConsultaSinistro paneConsultaSinistro = new PainelConsultaSinistro();
				frmMenu.setContentPane(paneConsultaSinistro);
				paneConsultaSinistro.setVisible(true);
				frmMenu.revalidate();

				paneConsultaSinistro.getBtnEditar().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						PainelCadastroSinistro painelCadastroSinistroParaEditar = new PainelCadastroSinistro(null);
						frmMenu.setContentPane(painelCadastroSinistroParaEditar);
						painelCadastroSinistroParaEditar.setVisible(true);
						frmMenu.revalidate();
					}

				});
			}
		});

		mnItemConsultarSinistro.setIcon(
				new ImageIcon(Menu.class.getResource("/icones/icons8-análise-de-crescimento-financeiro-64.png")));

			new ImageIcon(Menu.class.getResource("/icones/icons8-análise-de-crescimento-financeiro-64.png"));
		mnSinistro.add(mnItemConsultarSinistro);

		JMenu mnRelatorios = new JMenu("Relatórios");
		mnRelatorios.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-partilhar-2-64 (1).png")));
		menuBar.add(mnRelatorios);

		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				JOptionPane.showMessageDialog(null, "LDF Corretora de Seguros");
			}
		});
		mnSobre.setIcon(new ImageIcon(Menu.class.getResource("/icones/icons8-sobre-64.png")));
		menuBar.add(mnSobre);
		frmMenu.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {}, new RowSpec[] {}));
	}

//////////////////////////////////METODOS DO PAINEL SEGURO///////////////////////////////////////////////////////////////////////////
	protected void registrarCliqueBotaoVoltarDoPainelCadastroSeguro() {
		if (painelCadastroSeguro == null) {
			painelCadastroSeguro = new PainelCadastroSeguro(null);
		}
		painelCadastroSeguro.getbtnVoltar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Lógica do clique no botão Voltar
				// Mostra o painel de listagem de clientes
				painelConsultaSeguroAlterado = new PainelConsultaSeguro();
				painelConsultaSeguroAlterado.setVisible(true);
				registrarCliqueBotaoEditarDoPainelConsultaSeguro();
				frmMenu.setContentPane(painelConsultaSeguroAlterado);

			}
		});
	}

	protected void registrarCliqueBotaoEditarDoPainelConsultaSeguro() {
		painelConsultaSeguro.getBtnEditar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				painelCadastroSeguro = new PainelCadastroSeguro(painelConsultaSeguro.getSeguroSelecionado());
				painelCadastroSeguro.setVisible(true);
				registrarCliqueBotaoVoltarDoPainelCadastroSeguro();
				//Atualiza a tela principal
				frmMenu.setContentPane(painelCadastroSeguro);
				frmMenu.revalidate();
			}
		});
	}

}
