package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Conexao {
	
	static Connection conn;
	public static Connection getConnection(){
	try {

	
		Class.forName("org.gjt.mm.mysql.Driver");
	    conn = DriverManager.getConnection("jdbc:mysql://localhost/livraria", "root", "");

	
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
			
		}
	catch(SQLException ex) {
		System.err.println("ERRO!!! Ao conectar com a base de dados.");
	}
	return conn;
	   }

	public static void main(String[] args) {

		
		
	}

}
