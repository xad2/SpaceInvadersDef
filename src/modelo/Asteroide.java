package modelo;

import static modelo.constantes.Valores.POSICAOX_INICIAL_ALIEN;
import modelo.geometria.Retangulo;
import modelo.util.Observavel;
import modelo.util.TratadorDeInteiros;

public class Asteroide extends Observavel {

	private final int PASSO = 1;

	private RetanguloMovel retangulo;

	public Asteroide(RetanguloMovel retangulo) {
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

		boolean b = retangulo.moverY(PASSO);
		notificarObservadores(toString());
		return b;
	}

	public String toString() {

		return new String(retangulo.x + "/" + retangulo.y);

	}

}
