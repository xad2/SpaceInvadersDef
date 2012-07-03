package modelo;

import java.awt.Dimension;

public class Espaco {

	private final Retangulo formato;

	public Espaco(Retangulo r) {
		this.formato = r;
	}

	public boolean contem(Retangulo r) {
		return formato.contem(r);
	}

}
