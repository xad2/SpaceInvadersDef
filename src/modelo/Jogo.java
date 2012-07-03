package modelo;

import static modelo.constantes.RetangulosIniciais.*;

import static modelo.constantes.PontosIniciais.*;
import static modelo.constantes.Medidas.*;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JOptionPane;

import modelo.util.Observavel;

public class Jogo {

	private Asteroide asteroide;
	private Alien alien;
	private Nave nave;

	public Jogo(Asteroide asteroide, Alien alien, Nave nave) {

		this.alien = alien;
		this.asteroide = asteroide;
		this.nave = nave;

	}

	public boolean receberTick() {

		boolean alienAndou = alien.andarNaHorizontal();
		boolean asteroideAndou = asteroide.andarNaVertical();

		if (!alienAndou) {
			alien.resetarPosicao();
		}

		if (!asteroideAndou) {
			asteroide.resetarPosicao();
		}

		if (nave.intersecciona(alien)) {
			nave.explodir();
			alien.explodir();
			return false;

		}

		if (nave.intersecciona(asteroide)) {
			nave.explodir();
			asteroide.explodir();
			return false;
		}

		return true;
	}

}
