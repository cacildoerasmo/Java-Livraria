package Model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;


public class LivrariaDAO {
	
	public ArrayList<LivrariaModel> listar() {
	 Conexao conn = new Conexao();
	 Connection con;
	 PreparedStatement pst;
	 ResultSet rs;
	 LivrariaModel livra;
	 
	 ArrayList<LivrariaModel> livraria = new ArrayList<>();
	 String sql = "select * from livro order by id_livro";
	 
	 try {
		 con = conn.getConnection();
		 pst = con.prepareStatement(sql);
		 rs = pst.executeQuery();
		 
		 while(rs.next()) {
	
			 LivrariaModel p = new LivrariaModel();
			 p.setId(rs.getInt(1));
			 p.setAutor(rs.getString(2));
			 p.setEditora(rs.getString(3));
			 p.setAssunto(rs.getString(4));
			 p.setValor(rs.getDouble(5));
			 livraria.add(p);
			 
		 }
		 
	 }catch(Exception e) {
		 
	 }
	return livraria;
	 
	
	 
	 
	}
	
	public boolean salvar(LivrariaModel l) {
		
		Connection conn = Conexao.getConnection();
		PreparedStatement pst = null;
		
		try {
			pst = conn.prepareStatement("insert into livro(autor,editora,assunto,valor) values(?,?,?,?)");
			pst.setString(1, l.getAutor());
			pst.setString(2, l.getEditora());
			pst.setString(3, l.getAssunto());
			pst.setDouble(4, l.getValor());
			
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean alterar(LivrariaModel l){
		
		Connection conn = Conexao.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		
		try {
	
			String sql = "update livro set autor=?,editora=?,assunto=?,valor=? where id_livro=?";
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, l.getAutor());
			pst.setString(2, l.getEditora());
			pst.setString(3, l.getAssunto());
			pst.setDouble(4, l.getValor());
			pst.setInt(5, l.getId());
			pst.execute();
			
		
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
				return false;
		}
	
		
		
	}
	
        public boolean apagar(LivrariaModel l){
		
		Connection conn = Conexao.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		
		try {
		
			String sql = "delete from livro where id_livro=?";
			
			pst = conn.prepareStatement(sql);
			pst.setInt(1, l.getId());
			pst.executeUpdate();

			
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		
		
		
	}
        public boolean pesquisar(LivrariaModel l){
    		
    		Connection conn = Conexao.getConnection();
    		PreparedStatement pst = null;
    		ResultSet rs = null;
    		
    		
    		
    		try {
    			pst = conn.prepareStatement("select * from livro where id_livro=?");
    			
    			DefaultTableModel m = new DefaultTableModel();
    			pst.setInt(1, l.getId());
    			rs = pst.executeQuery();

    			if(rs.next()) {
    				
    				l.setAutor(rs.getString("autor"));
    				l.setEditora(rs.getString("editora"));
    				l.setAssunto(rs.getString("assunto"));
    				l.setValor(Double.parseDouble(rs.getString("valor")));
  
    				return true;
    				
    				
    			}
    			
    			return false;
    			
    			
    			
    		} catch (SQLException e) {
    			
    			e.printStackTrace();
    		}
    		return true;
    		
        }
	
	
	
	

	public static void main(String[] args) {
		
		

	}

}
