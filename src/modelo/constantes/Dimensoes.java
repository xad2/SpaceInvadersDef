package modelo.constantes;

import static modelo.constantes.Medidas.ALTURA_ALIEN;
import static modelo.constantes.Medidas.ALTURA_ASTEROIDE;
import static modelo.constantes.Medidas.ALTURA_NAVE;
import static modelo.constantes.Medidas.LARGURA_ALIEN;
import static modelo.constantes.Medidas.LARGURA_ASTEROIDE;
import static modelo.constantes.Medidas.LARGURA_NAVE;

import java.awt.Dimension;

public enum Dimensoes {
	NAVE_DIMENSAO(new Dimension(LARGURA_NAVE.valor(),
			ALTURA_NAVE.valor())),
	ALIEN_DIMENSAO(new Dimension(LARGURA_ALIEN.valor(),
			ALTURA_ALIEN.valor())),
	ASTEROIDE_DIMENSAO( new Dimension(LARGURA_ASTEROIDE.valor(),
			ALTURA_ASTEROIDE.valor()));
	
	private Dimension d;

	private Dimensoes(Dimension d) {
		this.d = d;	}
	
	public Dimension valor(){
		return d;
	}
}
