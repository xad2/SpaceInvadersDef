package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.geometria.Retangulo;

public class ListaDeTiros {

	private static ArrayList<Tiro> lista = new ArrayList<Tiro>();
	private static int tamanhoAnterior; 
	public void adicionarTiro(Tiro t) {
		tamanhoAnterior = lista.size();
		lista.add(t);
		
	}

	public void moverTiros() {
		for (Tiro t : lista) {
			if(t.estaVisivel())
			t.andar();
		}
	}

	public boolean checarColisao(Retangulo r) {
		for (Tiro t : lista) {
			if (t.checarColisaoCom(r))
				return true;
		}
		return false;
	}
	
	public static List<Tiro> obterLista() {
		return lista;
	}
	
	public static int obterTamanhoAnterior(){
		return tamanhoAnterior;
	}
	
	

}
