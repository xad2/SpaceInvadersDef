package modelo;

import java.awt.Dimension;
import java.awt.Point;

import modelo.geometria.Retangulo;

public class RetanguloMovel extends Retangulo implements
		TipoMovimentavel {

	private Espaco espaco;

	public RetanguloMovel(Espaco espaco, Point p, Dimension d) {
		super(p, d);
		this.espaco = espaco;
	}

	@Override
	public boolean moverX(int passo) {

		RetanguloMovel r = (RetanguloMovel) this.clone();
		
		r.x += passo;
		if(espaco.contem(r)){
			this.x += passo;
			return true;
		}
		return false;
		

	}

	public boolean moverY(int passo) {

		RetanguloMovel r = (RetanguloMovel) this.clone();
		
		r.y += passo;
		if(espaco.contem(r)){
			this.y += passo;
			return true;
		}
		return false;
	}

}
