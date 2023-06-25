package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import com.github.lgooddatepicker.components.DatePicker;
import javax.swing.JFormattedTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.PessoaController;
import model.exception.CampoInvalidoException;
import model.exception.PessoaInvalidaException;
import model.seletor.PessoaSeletor;
import model.vo.Pessoa;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class PainelConsultaCliente extends JPanel {
	
	private JTextField txtNome;
	private final JTable tblListagemPessoas = new JTable();
	private ArrayList<Pessoa> pessoas;
	private String[] nomesColunas = { "Id", "Nome", "CPF", "dataNascimento", "seguros", "telefone", "endereco" };
	private JLabel lblCpfList;
	private JLabel lblDataNascimentoDe;
	private JLabel lblAte;
	private JFormattedTextField txtCPF;
	private MaskFormatter mascaraCpf;
	
	private JButton btnBuscarTodos;
	private JButton btnGerarPlanilha;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JLabel lblTitulo;
	private DatePicker dpDataNascimento;
	private DatePicker dpDataNascimento_1;
	private JLabel lblNomeList;

	private PessoaController pessoaController = new PessoaController();
	private Pessoa pessoaSelecionada;
//	private PainelConsultaCliente painelConsultaCliente;
	private PessoaSeletor seletor = new PessoaSeletor();
	
	
	private void limparTabela() {
		tblListagemPessoas.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}

	private void atualizarTabelaPessoas() {
		this.limparTabela();
		
		DefaultTableModel model = (DefaultTableModel) tblListagemPessoas.getModel();

		for (Pessoa p : pessoas) {
			Object[] novaLinhaDaTabela = new Object[7];
			novaLinhaDaTabela[0] = p.getNome();
			novaLinhaDaTabela[1] = p.getCpf();
			novaLinhaDaTabela[2] = p.getDataNascimento();
			novaLinhaDaTabela[3] = p.getSeguros().size();			
			novaLinhaDaTabela[4] = p.getTelefone();
			novaLinhaDaTabela[5] = p.getEndereco();
			novaLinhaDaTabela[6] = p.getTipoPessoa();
			model.addRow(novaLinhaDaTabela);
		}
	}	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelConsultaCliente window = new PainelConsultaCliente();
					window.tblListagemPessoas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	/**
	 * Create the panel.
	 */
	public PainelConsultaCliente() {
		setBackground(new Color(26, 158, 230));
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("1px"),
				ColumnSpec.decode("262px"),
				ColumnSpec.decode("right:46px"),
				ColumnSpec.decode("120px"),
				ColumnSpec.decode("134px"),
				ColumnSpec.decode("29px"),
				ColumnSpec.decode("32px"),
				ColumnSpec.decode("39px"),
				ColumnSpec.decode("380px"),},
			new RowSpec[] {
				RowSpec.decode("1px"),
				RowSpec.decode("21px"),
				RowSpec.decode("44px"),
				RowSpec.decode("36px"),
				RowSpec.decode("32px"),
				RowSpec.decode("26px"),
				RowSpec.decode("20px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("44px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("246px"),
				RowSpec.decode("25px"),
				RowSpec.decode("42px"),}));

		txtNome = new JTextField();
		add(txtNome, "4, 5, 2, 1, fill, center");
		txtNome.setColumns(10);

		lblNomeList = new JLabel("Nome:");
		lblNomeList.setForeground(new Color(255, 255, 255));
		lblNomeList.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblNomeList, "3, 5, center, center");
		add(tblListagemPessoas, "3, 13, 7, 1, fill, fill");
		tblListagemPessoas.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nome", "Cpf", "Endere\u00E7o", "Telefone", "DataNascimento"},
			},
			new String[] {
				"Nome", "Cpf", "Endere\u00E7o", "Telefone", "DataNascimento"
			}
		));
		tblListagemPessoas.getColumnModel().getColumn(4).setPreferredWidth(93);
		
		lblCpfList = new JLabel("Cpf:");
		lblCpfList.setForeground(Color.WHITE);
		lblCpfList.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblCpfList, "6, 5, 2, 1, center, center");
		
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setValueContainsLiteralCharacters(false);
		} catch (ParseException erro) {
			//silent
		}

		txtCPF = new JFormattedTextField(mascaraCpf);
		add(txtCPF, "8, 5, 2, 1, default, center");
		
		
		lblDataNascimentoDe = new JLabel("Data de nascimento. De:");
		lblDataNascimentoDe.setForeground(Color.WHITE);
		lblDataNascimentoDe.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblDataNascimentoDe, "3, 7, 2, 1, center, top");
		
		lblAte = new JLabel("At\u00E9:");
		lblAte.setForeground(Color.WHITE);
		lblAte.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		add(lblAte, "4, 9, center, top");
		
		btnBuscarTodos = new JButton("BuscarTodos");
		btnBuscarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPessoasComFiltros();
				atualizarTabelaPessoas();
			}
		});
		btnBuscarTodos.setIcon(new ImageIcon(PainelConsultaCliente.class.getResource("/icones/icons8-lupa-50.png")));
		btnBuscarTodos.setBackground(new Color(231, 200, 24));
		add(btnBuscarTodos, "5, 11, 2, 1, left, fill");
		
//		tblListagemPessoas = new JTable();
//		this.limparTabelaPessoas();
		
		btnGerarPlanilha = new JButton("GerarPlanilha");
		btnGerarPlanilha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser janelaSelecaoDestinoArquivo = new JFileChooser();
				janelaSelecaoDestinoArquivo.setDialogTitle("Selecione um destino para a planilha...");

				int opcaoSelecionada = janelaSelecaoDestinoArquivo.showSaveDialog(null);
				if (opcaoSelecionada == JFileChooser.APPROVE_OPTION) {
					String caminhoEscolhido = janelaSelecaoDestinoArquivo.getSelectedFile().getAbsolutePath();
					String resultado;
					try {
						resultado = pessoaController.gerarPlanilha(pessoas, caminhoEscolhido);
						JOptionPane.showMessageDialog(null, resultado);
					} catch (CampoInvalidoException e1) {
						JOptionPane.showConfirmDialog(null, e1.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
					}
				}				
			}
		});
		btnGerarPlanilha.setIcon(new ImageIcon(PainelConsultaCliente.class.getResource("/icones/icons8-planilha-50.png")));
		btnGerarPlanilha.setBackground(new Color(231, 200, 24));
		add(btnGerarPlanilha, "9, 11, fill, fill");
		
		btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(PainelConsultaCliente.class.getResource("/icones/icons8-editar-48.png")));
		btnEditar.setBackground(new Color(231, 200, 24));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelCadastroCliente edicaoPessoa = new PainelCadastroCliente();
			}
		});
		add(btnEditar, "5, 15, fill, fill");
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(PainelConsultaCliente.class.getResource("/icones/icons8-excluir-48.png")));
		btnExcluir.setBackground(new Color(231, 200, 24));
		btnExcluir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int opcaoSelecionada = JOptionPane.showConfirmDialog(null, "Confirma a exclusão?");
				if (opcaoSelecionada == JOptionPane.YES_OPTION) {
					pessoaController.excluir(pessoaSelecionada.getId());
					JOptionPane.showMessageDialog(null, "Excluído com sucesso");
					pessoas = (ArrayList<Pessoa>) pessoaController.consultarTodos();
					atualizarTabelaPessoas();
				}
			}
		});
		add(btnExcluir, "9, 15, center, fill");
//		btnEditar.setEnabled(true);
//		btnExcluir.setEnabled(true);
		
		lblTitulo = new JLabel("Consultar Cliente");
		lblTitulo.setIcon(new ImageIcon(PainelConsultaCliente.class.getResource("/icones/icons8-lupa-48.png")));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		add(lblTitulo, "4, 3, 6, 1, center, center");
		
		dpDataNascimento = new DatePicker();
		add(dpDataNascimento, "5, 7, 5, 1, fill, top");
		
		dpDataNascimento_1 = new DatePicker();
		add(dpDataNascimento_1, "5, 9, 5, 1, fill, top");	
		
		
//		tblListagemPessoas.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent erro) {
//				int indiceSelecionado = tblListagemPessoas.getSelectedRow();
//				
//				if (indiceSelecionado > 0) {
//					pessoaSelecionada = pessoas.get(indiceSelecionado - 1); 
//					btnEditar.setEnabled(true);
//					btnExcluir.setEnabled(true);
//				} else {
//					btnEditar.setEnabled(false);
//					btnExcluir.setEnabled(false);
//				}
//			}
//		});
}

	private void buscarPessoasComFiltros() {
		seletor = new PessoaSeletor();
		seletor.setNome(txtNome.getText());
		
		String cpfSemMascara;			
			if(txtCPF.getText() != null) {
				cpfSemMascara = txtCPF.getText().replace(".", "").replace("-", "");
				seletor.setCpf(cpfSemMascara);				
			}
		
		seletor.setNome(txtNome.getText());
		seletor.setDataNascimentoDe(dpDataNascimento.getDate());
		seletor.setDataNascimentoAte(dpDataNascimento_1.getDate());
		pessoas = (ArrayList<Pessoa>) pessoaController.consultarComFiltros(seletor);
		atualizarTabelaPessoas();
	}
	
	public JButton getBtnEditar() {
		return this.btnEditar;
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}
}