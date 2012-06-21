package modelo;

import java.awt.Dimension;
import modelo.geometria.Retangulo;

public class Espaco {

	
	private final Retangulo formato;
	
	public Espaco(Retangulo r) {
		this.formato = r;
	}
	
	public boolean contem(Retangulo r){
		return formato.contem(r);
	}
	
	

	
}
