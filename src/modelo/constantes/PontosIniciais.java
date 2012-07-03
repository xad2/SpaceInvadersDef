package modelo.constantes;

import java.awt.Point;
import static modelo.constantes.Medidas.*;
import static modelo.constantes.Dimensoes.*;

public enum PontosIniciais {
	
	PONTO_INICIAL_NAVE(new Point(POSICAOX_INICIAL_NAVE.valor(), POSICAOY_INICIAL_NAVE.valor())),
	PONTO_INICIAL_ALIEN(new Point(POSICAOX_INICIAL_ALIEN.valor(), POSICAOY_INICIAL_ALIEN.aleatoria(465))),
	PONTO_INICIAL_ASTEROIDE(new Point(POSICAOX_INICIAL_ASTEROIDE.aleatoria(465), POSICAOY_INICIAL_ASTEROIDE.valor())){
		
	};
	
	

	private PontosIniciais(Point p) {
		this.p = p;
	}
	private Point p;
	
	public Point valor(){
		return p;
	}
	
	
	
}
