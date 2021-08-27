package View;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Model.Conexao;
import Model.LivrariaModel;
import Model.LivrariaDAO;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LivrariaView {

	public JFrame frame;
    public JTextField textbAutor;
    public JTextField textbEditora;
	public JTextField textbAssunto;
	public JTextField textbValor;
    public JTextField textbLivro;
	public JButton btnSalvar;
    public JButton btnSair;
    public JButton btnLimpar;
    public JButton btnAlterar;
    public JButton btnApagar;
    public JButton btnPesquisar;
    public JButton btnPesquisar1;
    public JButton btnListar;
    public JTable table;
    public JScrollPane scrollPane;
    DefaultTableModel model;
    

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LivrariaView window = new LivrariaView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LivrariaView() {
		initialize();
		
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.getContentPane().setForeground(new Color(169, 169, 169));
		frame.setBounds(100, 100, 750, 441);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE LIVRO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(257, 11, 298, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBorder(new TitledBorder(null, "Registar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 65, 314, 194);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Autor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 25, 70, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Editora");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 71, 70, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Assunto");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(10, 106, 70, 28);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Valor");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_2.setBounds(10, 145, 70, 28);
		panel.add(lblNewLabel_2_2);
		
		textbAutor = new JTextField();
		textbAutor.setBounds(90, 27, 201, 28);
		panel.add(textbAutor);
		textbAutor.setColumns(10);
		
		textbEditora = new JTextField();
		textbEditora.setColumns(10);
		textbEditora.setBounds(90, 69, 201, 28);
		panel.add(textbEditora);
		
		textbAssunto = new JTextField();
		textbAssunto.setColumns(10);
		textbAssunto.setBounds(90, 108, 201, 28);
		panel.add(textbAssunto);
		
		textbValor = new JTextField();
		textbValor.setColumns(10);
		textbValor.setBounds(90, 147, 201, 28);
		panel.add(textbValor);
		
		JLabel lblNewLabel_1_1 = new JLabel("Autor");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 25, 70, 28);
		panel.add(lblNewLabel_1_1);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(169, 169, 169));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnSalvar.setBounds(10, 270, 89, 40);
		frame.getContentPane().add(btnSalvar);
		
		 btnSair = new JButton("Sair");
		btnSair.setBackground(new Color(169, 169, 169));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair.setBounds(122, 270, 89, 40);
		frame.getContentPane().add(btnSair);
		
		 btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(new Color(169, 169, 169));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnLimpar.setBounds(235, 270, 89, 40);
		frame.getContentPane().add(btnLimpar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Pesquisa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 321, 314, 50);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("IDLivro");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(10, 11, 70, 28);
		panel_1.add(lblNewLabel_1_2);
		
		textbLivro = new JTextField();
		textbLivro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
		});
		textbLivro.setColumns(10);
		textbLivro.setBounds(90, 11, 194, 28);
		panel_1.add(textbLivro);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBackground(new Color(169, 169, 169));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
			}
		}); 
		btnAlterar.setBounds(542, 331, 89, 40);
		frame.getContentPane().add(btnAlterar);
		
		btnApagar = new JButton("Apagar");
		btnApagar.setBackground(new Color(169, 169, 169));
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnApagar.setBounds(443, 331, 89, 40);
		frame.getContentPane().add(btnApagar);
		
		btnPesquisar1 = new JButton("Pesquisar");
		btnPesquisar1.setBackground(new Color(169, 169, 169));
		btnPesquisar1.setBounds(334, 331, 101, 40);
		frame.getContentPane().add(btnPesquisar1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(345, 73, 387, 237);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] coluna = {"IDLivro","Autor","Editora","Assunto","Valor"};
		Object[] linhas = new Object[0];
		model.setColumnIdentifiers(coluna);
		table.setModel(model);
	
		
		scrollPane.setViewportView(table);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnListar.setBackground(new Color(169, 169, 169));
		btnListar.setBounds(641, 331, 91, 40);
		frame.getContentPane().add(btnListar);
	}
}
