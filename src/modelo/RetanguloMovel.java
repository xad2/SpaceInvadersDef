package modelo;

import modelo.geometria.Retangulo;
import modelo.util.Observavel;

public abstract class RetanguloMovel extends Observavel implements TipoMovimentavel {

	protected Retangulo retangulo;
	protected Espaco espaco;


	@Override
	public boolean moverX(int passo) {

		Retangulo r = (Retangulo) retangulo.clone();

		r.x += passo;
		if (espaco.contem(r)) {
			retangulo.x += passo;
			return true;
		}
		return false;

	}

	public boolean moverY(int passo) {

		Retangulo r = (Retangulo) retangulo.clone();

		r.y += passo;
		if (espaco.contem(r)) {
			retangulo.y += passo;
			return true;
		}
		return false;
	}

}
