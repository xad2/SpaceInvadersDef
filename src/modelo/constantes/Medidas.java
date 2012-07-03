package modelo.constantes;

import modelo.util.TratadorDeInteiros;

public enum Medidas {
	
	POSICAOX_INICIAL_NAVE(0),
	
	POSICAOY_INICIAL_NAVE(250),
	
	POSICAOX_INICIAL_ALIEN(465),
	
	POSICAOY_INICIAL_ALIEN(0),
	
	POSICAOX_INICIAL_ASTEROIDE(0),
	
	POSICAOY_INICIAL_ASTEROIDE(0),
	
	ALTURA_NAVE(30),
	
	LARGURA_NAVE(30),
	
	ALTURA_ALIEN(35),
	
	LARGURA_ALIEN(35),
	
	ALTURA_ASTEROIDE(15),
	LARGURA_ASTEROIDE(15);
	
	
	private int valor;


	private Medidas(int valor) {
		this.valor = valor;
	}
	
	public int valor(){
		return valor;
	}
	public int aleatoria(int v){
		valor = TratadorDeInteiros.retornarNmrAleatorio(v);
		return valor;
	}
	
	

}
