package modelo;

import modelo.geometria.Retangulo;

public class Tiro extends RetanguloMovel {

	private final int passo = 1;
	private ListaDeTiros tiros = new ListaDeTiros();

	public Tiro(Espaco espaco, Retangulo r) {
		this.espaco = espaco;
		this.retangulo = r;
		tiros.adicionarTiro(this);

	}

	public void andar() {
		moverX(1);
	}
	
	public boolean checarColisao(Retangulo r){
		
		if(!espaco.contem(this.retangulo)){
			return false;
		}
		if(!r.contem(this.retangulo)){
			return false;
		}
		return true;
	}
}
