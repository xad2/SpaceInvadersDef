package modelo;

import modelo.geometria.Retangulo;
import static modelo.Estado.*;

public class Tiro extends RetanguloMovel {

	private final int passo = 100;
	private ListaDeTiros tiros = new ListaDeTiros();
	private Estado estado;

	public Tiro(Espaco espaco, Retangulo r) {
		this.espaco = espaco;
		this.retangulo = r;
		tiros.adicionarTiro(this);

	}

	public void andar() {
		moverX(passo);
		estado = VISIVEL;
		notificarObservadores(toString());
	}
	
	public boolean estaVisivel(){
			
		return estado.equals(VISIVEL) ? true : false;
	}
	
	public boolean checarColisaoCom(Retangulo r){
		
		Retangulo clone = (Retangulo) this.retangulo.clone();
		
		if(!espaco.contem(clone)){
			estado = INVISIVEL;
			return false;
		}
		if(!r.contem(clone)){
			estado = INVISIVEL;
			return false;
		}
		return true;
	}
	
	public String toString(){
		return retangulo.x + "/" + retangulo.y + "/" + estado.toString();
	}
	
}
