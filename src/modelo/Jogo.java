package modelo;

import java.awt.Dimension;

import modelo.geometria.Retangulo;
import modelo.util.Observavel;

public class Jogo extends Observavel {

	private static final int TAXA_DE_ATUALIZACAO_DE_TIROS = 3;
	private int ultimaAtualizacaoDeTiro = 0;
	private PontosDimensoes pd = new PontosDimensoes();

	private Asteroide asteroide;
	private Alien alien;
	private Nave nave;

	public Jogo() {

		Espaco espaco = new Espaco(new Retangulo(new Dimension(500, 500)));
		this.asteroide = new Asteroide(espaco, pd.obterRetanguloPadrao('m'));
		this.alien = new Alien(espaco, pd.obterRetanguloPadrao('a'));
		this.nave = new Nave(espaco, pd.obterRetanguloPadrao('n'));

	}

	public Alien alien() {
		return alien;
	}

	public Nave nave() {
		return nave;
	}

	public Asteroide asteroide() {
		return asteroide;
	}

	public void receberTick() {

		boolean alienAndou = alien.andarNaHorizontal();
		boolean asteroideAndou = asteroide.andarNaVertical();

		if (alienAndou == false) {
			alien.resetarPosicaoY();
		}

		if (asteroideAndou == false) {
			asteroide.resetarPosicaoX();
		}

		if (nave.intersecciona(alien.retangulo())
				|| nave.intersecciona(asteroide.retangulo())) {
			nave.explodir();
		}

	}

}
