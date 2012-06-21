package modelo;

import static modelo.Estado.*;
import modelo.geometria.Retangulo;
import modelo.util.Observavel;

public class Nave extends Observavel {

	private final int PASSO = 15;

	private RetanguloMovel retangulo;
	private Estado estado = VIVO;

	public Nave(RetanguloMovel retangulo) {

		this.retangulo = retangulo;
	}

	public boolean intersecciona(Retangulo r) {
		return retangulo.intersecciona(r);
	}

	public void andarNaHorizontal(int d) {

		int passoDirecionado = d * PASSO;
		retangulo.moverX(passoDirecionado);
		notificarObservadores(toString());

	}

	public void andarNaVertical(int d) {

		int passoDirecionado = d * PASSO;
		retangulo.moverY(passoDirecionado);
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
