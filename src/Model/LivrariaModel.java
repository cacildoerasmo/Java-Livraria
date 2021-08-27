package Model;

public class LivrariaModel {
	
	
	
	private int id;
	private String autor;
	private String editora;
	private String assunto;
	private double valor;
	
	
	public int getId() { 
		return id;
	}
	public String getAutor() {
	return autor;
      }
	public String getAssunto() {
		return assunto;
	}
	public String getEditora() {
		return editora;
	}
	public double getValor() {
		return valor;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return "ID: " + this.id + ", " + "Autor: " + this.autor + ", " + "Assunto: " + this.assunto + ", " + "Ano: " + this.editora + ", " + "Valor: " + this.valor;
	}

	public static void main(String[] args) {
		

	}

}
