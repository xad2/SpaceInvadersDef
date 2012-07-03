package modelo;

import java.awt.Point;

import modelo.util.Observavel;
import modelo.util.TratadorDeInteiros;
import static modelo.constantes.Medidas.*;
import static modelo.constantes.Estado.*;

public class Alien extends ObjetoMovel implements TipoQueExplode {

	private final int PASSO = 5;

	public Alien(Espaco espaco, Retangulo retangulo) {

		this.espaco = espaco;
		this.corpo = retangulo;
		this.observavel = new Observavel();
		estado = VIVO;
	}

	public boolean andarNaHorizontal() {
		return moverX(-PASSO);
	}

	public void resetarPosicao() {
		Point p = new Point(POSICAOX_INICIAL_ALIEN.valor(),
				TratadorDeInteiros.retornarNmrAleatorio(465));
		super.resetarPosicao(p);
	}

	@Override
	public void explodir() {
		estado = COLIDIU;
		observavel.notificarObservadores(toString());
	}

}
