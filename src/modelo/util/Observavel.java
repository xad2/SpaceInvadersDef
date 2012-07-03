package modelo.util;

import javax.swing.JOptionPane;

public class Observavel implements TipoObservavel {

	private ListaDeObservadores observadores = new ListaDeObservadores();

	public void adicionarObservador(Observador o) {
		observadores.adicionar(o);

	}

	public void notificarObservadores(String argumento) {
		for (Observador obs : observadores.obterLista()) {
			obs.atualizar(argumento);
		}
	}
}
