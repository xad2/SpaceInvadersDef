package modelo;

import modelo.util.TratadorDeInteiros;

public enum Posicoes {
	
	POSICAOX_INICIAL_NAVE(0){
		@Override
		public int valor() {
			
			return super.valor();
		}
	},
	
	POSICAOY_INICIAL_NAVE(250){
		@Override
		public int valor() {
			
			return super.valor();
		}
	},
	
	POSICAOX_INICIAL_ALIEN(465){
		@Override
		public int valor() {
			
			return super.valor();
		}
	},
	
	POSICAOY_INICIAL_ALIEN(0){
		
		@Override
		public int aleatoria(int v) {
			
			return super.aleatoria(v);
		}
		
	},
	
	POSICAOX_INICIAL_ASTEROIDE(250){
		
		@Override
		public int aleatoria(int v) {
			
			return super.aleatoria(v);
		}
	},
	
	POSICAOY_INICIAL_ASTEROIDE(465){
		@Override
		public int valor() {
			
			return super.valor();
		}
	},
	
	ALTURA_NAVE(30){
		
		@Override
		public int valor() {
			
			return super.valor();
		}
		
	},
	
	LARGURA_NAVE(30){
		
		@Override
		public int valor() {
			
			return super.valor();
		}
	},
	
	ALTURA_ALIEN(35){
		@Override
		public int valor() {
			
			return super.valor();
		}
	},
	
	LARGURA_ALIEN(35){
		@Override
		public int valor() {
			
			return super.valor();
		}
	},
	
	ALTURA_ASTEROIDE(15){
		@Override
		public int valor() {
			
			return super.valor();
		}
	},
	LARGURA_ASTEROIDE(15){
		@Override
		public int valor() {
			
			return super.valor();
		}
	};
	
	
	private int valor;


	private Posicoes(int valor) {
		this.valor = valor;
	}
	
	public int valor(){
		return valor;
	}
	public int aleatoria(int v){
		return TratadorDeInteiros.retornarNmrAleatorio(v);
	}
	
	

}
