package modelo;

import java.awt.Rectangle;

public abstract class Objeto {

	protected Retangulo corpo;
	protected Espaco espaco;

	
	public boolean contem(Rectangle r) {
		return corpo.contem(r);
	}

	public boolean intersecciona(Rectangle r) {
		return corpo.intersecciona(r);
	}
	
	@Override
	public String toString() {
		
		return corpo.x + "/" + corpo.y;
	}

}
