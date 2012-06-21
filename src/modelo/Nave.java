package modelo;

import static modelo.Estado.COLIDIU;
import static modelo.Estado.*;

import java.awt.Dimension;
import java.awt.Point;

import modelo.geometria.Retangulo;

public class Nave extends RetanguloMovel implements TipoAtirador {

	private final int PASSO = 15;

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

	@Override
	public void atirar() {

		new Tiro(espaco, new Retangulo(new Point(retangulo.x + 30,
				retangulo.y + 15), new Dimension(5, 2)));
	}

}
