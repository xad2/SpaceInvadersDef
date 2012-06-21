package modelo;

import static modelo.Estado.COLIDIU;
import static modelo.Estado.*;


import modelo.geometria.Retangulo;

public class Nave extends RetanguloMovel {

	private final int PASSO = 25;

	private Estado estado = VIVO;

	public Nave(Espaco espaco, Retangulo retangulo) {
		this.espaco = espaco;
		this.retangulo = retangulo;
	}

	public boolean intersecciona(Retangulo r) {
		return retangulo.intersecciona(r);
	}

	public void andarNaHorizontal(int d) {

		int passoDirecionado = d * PASSO;
		moverX(passoDirecionado);
		notificarObservadores(toString());

	}

	public void andarNaVertical(int d) {

		int passoDirecionado = d * PASSO;
		moverY(passoDirecionado);
		notificarObservadores(toString());
	}

	public String toString() {

		return new String(retangulo.x + "/" + retangulo.y + "/"
				+ estado.toString());

	}

	public void explodir() {
		estado = COLIDIU;

		notificarObservadores(toString());
	}


}
