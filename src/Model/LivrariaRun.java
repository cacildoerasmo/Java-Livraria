package Model;

import javax.swing.JFrame;


import Controller.LivrariaController;
import View.LivrariaView;
import View.LivrariaViews;

public class LivrariaRun {

	public static void main(String[] args) {
	
		LivrariaModel livraria = new LivrariaModel();
		LivrariaDAO ldao = new LivrariaDAO();
		LivrariaView lviews = new LivrariaView();
		
		LivrariaController lcontroller = new LivrariaController(livraria, ldao, lviews);
		lcontroller.iniciar();
		lviews.frame.setVisible(true);
	
		
	}

}
