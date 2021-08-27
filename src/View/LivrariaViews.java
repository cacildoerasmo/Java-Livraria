package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class LivrariaViews {

	public JFrame frame;
    public JTextField textbAutor;
    public JTextField textbEditora;
	public JTextField textbAssunto;
	public JTextField textbValor;
	public JTable table;
	public JTextField textbLivro;
	public JButton btnSalvar;
    public JButton btnSair;
    public JButton btnLimpar;
    public JButton btnAlterar;
    public JButton btnApagar;
    public JButton btnListar;
    public JButton btnPesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LivrariaViews window = new LivrariaViews();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LivrariaViews() {
		initialize();
		connection();
	}
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	


	public void connection() {
		
		
		try {
	
		
			Class.forName("org.gjt.mm.mysql.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://localhost/livraria", "root", "");

		
			}catch(ClassNotFoundException ex) {
				ex.printStackTrace();
				
			}
		catch(SQLException ex) {
			System.err.println("ERRO!!! Ao conectar com a base de dados.");
		}


	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 742, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE LIVRO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(245, 11, 289, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 58, 297, 207);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Autor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 30, 58, 27);
		panel.add(lblNewLabel_1);
		
		textbAutor = new JTextField();
		textbAutor.setBounds(78, 32, 202, 27);
		panel.add(textbAutor);
		textbAutor.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Editora");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 72, 70, 27);
		panel.add(lblNewLabel_1_1);
		
		textbEditora = new JTextField();
		textbEditora.setColumns(10);
		textbEditora.setBounds(78, 77, 202, 27);
		panel.add(textbEditora);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Assunto");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(10, 115, 70, 27);
		panel.add(lblNewLabel_1_1_1);
		
		textbAssunto = new JTextField();
		textbAssunto.setColumns(10);
		textbAssunto.setBounds(78, 120, 202, 27);
		panel.add(textbAssunto);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Valor");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(10, 158, 70, 27);
		panel.add(lblNewLabel_1_1_1_1);
		
		textbValor = new JTextField();
		textbValor.setColumns(10);
		textbValor.setBounds(78, 158, 202, 27);
		panel.add(textbValor);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 276, 89, 38);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(109, 276, 89, 38);
		frame.getContentPane().add(btnSair);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(208, 276, 89, 38);
		frame.getContentPane().add(btnLimpar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Pesquisar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 325, 293, 57);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("IDLivro");
		lblNewLabel_1_2.setBounds(10, 15, 61, 20);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_1_2);
		
		textbLivro = new JTextField();
		textbLivro.setColumns(10);
		textbLivro.setBounds(81, 14, 202, 27);
		panel_1.add(textbLivro);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(324, 58, 400, 256);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(323, 321, 89, 38);
		frame.getContentPane().add(btnPesquisar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(421, 321, 89, 38);
		frame.getContentPane().add(btnAlterar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.setBounds(520, 321, 89, 38);
		frame.getContentPane().add(btnApagar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(620, 321, 89, 38);
		frame.getContentPane().add(btnListar);
	}
}
