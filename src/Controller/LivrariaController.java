package Controller;

import java.awt.event.ActionEvent;



import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.LivrariaDAO;
import Model.LivrariaModel;
import View.LivrariaView;
import View.LivrariaViews;

public class LivrariaController implements ActionListener {
	
	private LivrariaModel livraria;
	private LivrariaDAO ldao;
	private LivrariaView lview;
	
     
   public LivrariaController(LivrariaModel livraria, LivrariaDAO ldao, LivrariaView lview) {
	   
	   this.livraria = livraria;
	   this.ldao = ldao;
	   this.lview = lview;
	   this.lview.btnAlterar.addActionListener(this);
	   this.lview.btnApagar.addActionListener(this);
	   this.lview.btnListar.addActionListener(this);
	   this.lview.btnLimpar.addActionListener(this);
	   this.lview.btnSair.addActionListener(this);
	   this.lview.btnPesquisar1.addActionListener(this);
	   this.lview.btnSalvar.addActionListener(this);
   }
   public void iniciar() {
	   
	   lview.frame.setLocationRelativeTo(null);
	   
   }
   
   public void actionPerformed(ActionEvent e) {
	   
	   if(e.getSource() == lview.btnSalvar) {
		   livraria.setAutor(lview.textbAutor.getText());
		   livraria.setEditora(lview.textbEditora.getText());
		   livraria.setAssunto(lview.textbAssunto.getText());
		   livraria.setValor(Double.parseDouble(lview.textbValor.getText()));
		   
		   if(ldao.salvar(livraria)) {
			   JOptionPane.showMessageDialog(null, "Livro Cadastrado!!!!");
			   limpar();
		   }else {
			   
			  System.err.println("ERRO!!! Ao inserir os dados.");
			  limpar();
		   }
	   }
	   
	   if(e.getSource() == lview.btnAlterar) {
		   livraria.setId(Integer.parseInt(lview.textbLivro.getText()));
		   livraria.setAutor(lview.textbAutor.getText());
		   livraria.setEditora(lview.textbEditora.getText());
		   livraria.setAssunto(lview.textbAssunto.getText());
		   livraria.setValor(Double.parseDouble(lview.textbValor.getText()));
		   
		   if(ldao.alterar(livraria)) {
			   JOptionPane.showMessageDialog(null, "Livro alterado com Sucesso!!!!");
			   limpar();
		   }else {
			   
			  System.err.println("ERRO!!! Ao alterar os dados do Livro.");
			  limpar();
		   }
	   }
	   if(e.getSource() == lview.btnApagar) {
		   livraria.setId(Integer.parseInt(lview.textbLivro.getText()));
		
		   
		   if(ldao.apagar(livraria)) {
			   JOptionPane.showMessageDialog(null, "Livro eliminado com Sucesso!!!!");
			   limpar();
		   }else {
			   
			  System.err.println("ERRO!!! Ao eliminar os dados do Livro.");
			  limpar();
		   }
	   }
	   if(e.getSource() == lview.btnPesquisar1) {
		   livraria.setId(Integer.parseInt(lview.textbLivro.getText()));
		
		   
		   if(ldao.pesquisar(livraria)) {
			   lview.textbLivro.setText(String.valueOf(livraria.getId()));
			   lview.textbAutor.setText((livraria.getAutor()));
			   lview.textbEditora.setText((livraria.getEditora()));
			   lview.textbAssunto.setText((livraria.getAssunto()));
			   lview.textbValor.setText(String.valueOf(livraria.getValor()));

		   }else {
			   
			  System.err.println("Dados do livro nao encontrado!!!");
			  limpar();
		   }
	   }
	   if(e.getSource() == lview.btnLimpar) {
		   
		   limpar();
	   }
	   
	   
	   
   
   if(e.getSource() == lview.btnSair) {
	   
	   System.exit(0);
	   
	   
       }

    if(e.getSource() == lview.btnListar) {
	   
     listar(lview.table);
     }
   }
   
   public void listar(JTable tabela) {
	   DefaultTableModel modelo = new DefaultTableModel();
			  tabela.setModel(modelo);
	   
			  modelo.addColumn("IDLivro");
			  modelo.addColumn("Autor");
			  modelo.addColumn("Editora");
			  modelo.addColumn("Assunto");
			  modelo.addColumn("Valor");
			  
			  Object[] coluna = new Object[5];
			  int r = ldao.listar().size();
			  
			  for(int i = 0; i < r; i++) {
				  coluna[0] = ldao.listar().get(i).getId();
				  coluna[1] = ldao.listar().get(i).getAutor();
				  coluna[2] = ldao.listar().get(i).getEditora();
				  coluna[3] = ldao.listar().get(i).getAssunto();
				  coluna[4] = ldao.listar().get(i).getValor();
				  modelo.addRow(coluna);
			  }
			  

   }
   
   
   
   public void limpar() {
	   
	   lview.textbAutor.setText(null);
	   lview.textbEditora.setText(null);
	   lview.textbAssunto.setText(null);
	   lview.textbValor.setText(null);
	   
   }
   
   

	public static void main(String[] args) {
	
		
   
	}

}
