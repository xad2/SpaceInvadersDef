package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.geometria.Retangulo;

public class ListaDeTiros {

	private static List<Tiro> lista = new ArrayList<Tiro>();

	public void adicionarTiro(Tiro t) {
		lista.add(t);

	}

	public void moverTiros() {
		for (Tiro t : lista) {
			t.andar();
		}
	}

	public boolean checarColisao(Retangulo r) {
		for (Tiro t : lista) {
			if (t.checarColisao(r) == true)
				return true;
		}
		return false;
	}

}
