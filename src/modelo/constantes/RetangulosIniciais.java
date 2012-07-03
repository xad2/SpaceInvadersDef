package modelo.constantes;

import static modelo.constantes.Dimensoes.*;
import static modelo.constantes.PontosIniciais.*;
import modelo.Retangulo;

public enum RetangulosIniciais {
	
	RETANGULO_ALIEN(new Retangulo(PONTO_INICIAL_ALIEN.valor(), ALIEN_DIMENSAO.valor() ) ),
	RETANGULO_NAVE(new Retangulo(PONTO_INICIAL_NAVE.valor(), NAVE_DIMENSAO.valor())),
	RETANGULO_ASTEROIDE(new Retangulo(PONTO_INICIAL_ASTEROIDE.valor(), ASTEROIDE_DIMENSAO.valor()));
	
	
	private Retangulo r;
	private RetangulosIniciais(Retangulo r) {
		this.r= r;
	}
	
	public Retangulo valor(){
		return r;
	}

}
