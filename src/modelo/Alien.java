package modelo;

import modelo.geometria.Retangulo;
import static modelo.constantes.Valores.*;

public class Alien extends RetanguloMovel {

	private final int PASSO = 1;

	public Alien(Espaco espaco, Retangulo retangulo) {

		this.espaco = espaco;
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

		boolean b = moverX(-PASSO);
		notificarObservadores(toString());
		return b;
	}

	public String toString() {

		return new String(retangulo.x + "/" + retangulo.y);

	}

}
