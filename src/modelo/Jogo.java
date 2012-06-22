package modelo;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.constantes.PontosDimensoes;
import modelo.geometria.Retangulo;
import modelo.util.Observavel;

public class Jogo extends Observavel {

	
	private PontosDimensoes pd = new PontosDimensoes();

	private Asteroide asteroide;
	private Alien alien;
	private Nave nave;
	private ArrayList<Tiro> tiros;
	private ListaDeTiros listaDeTiros = new ListaDeTiros();

	public Jogo() {

		Espaco espaco = new Espaco(new Retangulo(new Dimension(500, 500)));
		this.asteroide = new Asteroide(espaco, pd.obterRetanguloPadrao('m'));
		this.alien = new Alien(espaco, pd.obterRetanguloPadrao('a'));
		this.nave = new Nave(espaco, pd.obterRetanguloPadrao('n'));
		this.tiros =  (ArrayList<Tiro>) ListaDeTiros.obterLista();
		
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
	public ArrayList<Tiro> getTiros() {
		return tiros;
	}

	public void receberTick() {

		boolean alienAndou = alien.andarNaHorizontal();
		boolean asteroideAndou = asteroide.andarNaVertical();

		listaDeTiros.moverTiros();

		if (!alienAndou) {
			alien.resetarPosicaoY();
		}

		if (!asteroideAndou) {
			asteroide.resetarPosicaoX();
		}

		if (nave.intersecciona(alien.retangulo())
				|| nave.intersecciona(asteroide.retangulo())) {
			nave.explodir();
		}

	}

}
