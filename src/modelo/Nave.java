package modelo;

import static modelo.constantes.Estado.COLIDIU;
import static modelo.constantes.Estado.VIVO;
import modelo.constantes.Estado;
import modelo.util.Observavel;

public class Nave extends ObjetoMovel implements TipoQueExplode {

	private final int PASSO = 20;

	public Nave(Espaco espaco, Retangulo retangulo) {
		this.espaco = espaco;
		this.corpo = retangulo;
		this.observavel = new Observavel();
		estado = VIVO;
	}

	public boolean intersecciona(Retangulo r) {
		return corpo.intersecciona(r);
	}

	public void andarNaHorizontal(int d) {

		int passoDirecionado = d * PASSO;
		moverX(passoDirecionado);

	}

	public void andarNaVertical(int d) {

		int passoDirecionado = d * PASSO;
		moverY(passoDirecionado);
	}

	public void explodir() {
		estado = COLIDIU;
		observavel.notificarObservadores(toString());
	}

}
