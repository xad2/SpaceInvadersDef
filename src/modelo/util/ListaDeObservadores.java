package modelo.util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ListaDeObservadores {

	private List<Observador> lista = new ArrayList<Observador>();
	
	public void adicionar(Observador o){
		lista.add(o);	
	}
	
	public List<Observador> obterLista(){
		return lista;
		
	}
	
}
