package modelo.constantes;

import java.awt.Dimension;
import java.awt.Point;

import modelo.util.TratadorDeInteiros;

public enum Constantes {

	PONTO_INICIAL_NAVE(new Point(0, 250)),

	PONTO_INICIAL_ALIEN(new Point(465,
			TratadorDeInteiros.retornarNmrAleatorio(465))),

	PONTO_INICIAL_ASTEROIDE(new Point(
			TratadorDeInteiros.retornarNmrAleatorio(465), 0));

	private Point p;

	private Constantes(Point p) {
		this.p = p;
	}

}
