package modelo;

import static modelo.constantes.PontosIniciais.PONTO_INICIAL_ASTEROIDE;
import static modelo.constantes.Estado.*;
import static modelo.constantes.Medidas.*;

import java.awt.Point;

import modelo.constantes.Estado;
import modelo.util.Observavel;

public class Asteroide extends ObjetoMovel implements TipoQueExplode {

	private final int PASSO = 5;

	public Asteroide(Espaco espaco, Retangulo retangulo) {
		this.espaco = espaco;
		this.corpo = retangulo;
		this.observavel = new Observavel();
		estado = VIVO;
	}

	public boolean andarNaVertical() {
		return moverY(PASSO);
	}

	public void resetarPosicao() {
		Point p = new Point(POSICAOX_INICIAL_ASTEROIDE.aleatoria(465),
				POSICAOY_INICIAL_ASTEROIDE.valor());

		super.resetarPosicao(p);

	}

	@Override
	public void explodir() {
		estado = COLIDIU;
		observavel.notificarObservadores(toString());

	}

}
