package modelo;

import modelo.geometria.Retangulo;
import modelo.util.TratadorDeInteiros;

public class Asteroide extends RetanguloMovel {

	private final int PASSO = 1;

	public Asteroide(Espaco espaco, Retangulo retangulo) {
		this.espaco = espaco;
		this.retangulo = retangulo;
	}

	public Retangulo retangulo() {
		return retangulo;

	}

	public void resetarPosicaoX() {

		int r2 = TratadorDeInteiros.retornarNmrAleatorio(465);
		retangulo.setLocation(r2, 0);

		notificarObservadores(toString());

	}

	public boolean andarNaVertical() {

		boolean b = moverY( PASSO);
		notificarObservadores(toString());
		return b;
	}

	public String toString() {

		return new String(retangulo.x + "/" + retangulo.y);

	}

}
