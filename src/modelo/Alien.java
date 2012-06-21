package modelo;

import modelo.geometria.Retangulo;
import modelo.util.Observavel;
import modelo.util.TratadorDeInteiros;
import static modelo.Posicoes.*;

public class Alien extends Observavel {

	private final int PASSO = 1;

	private RetanguloMovel retangulo;

	public Alien(RetanguloMovel retangulo) {

		this.retangulo = retangulo;

	}

	public Retangulo retangulo() {
		return retangulo;

	}

	public void resetarPosicaoY() {

		retangulo.setLocation(POSICAOX_INICIAL_ALIEN.valor(),
				POSICAOY_INICIAL_ALIEN.aleatoria(465));

		notificarObservadores(toString());

	}

	public boolean andarNaHorizontal() {

		boolean b = retangulo.moverX(-PASSO);
		notificarObservadores(toString());
		return b;
	}

	public String toString() {

		return new String(retangulo.x + "/" + retangulo.y);

	}

}
