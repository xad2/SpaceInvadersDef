package modelo;

import java.awt.Point;
import java.awt.Rectangle;

import modelo.constantes.Estado;
import modelo.util.Observador;
import modelo.util.Observavel;
import modelo.util.TipoObservavel;

public abstract class ObjetoMovel extends Objeto implements
		TipoMovimentavel, TipoObservavel {

	protected Observavel observavel;
	protected Estado estado;

	@Override
	public boolean moverX(int passo) {

		Retangulo r = (Retangulo) corpo.clone();

		r.x += passo;
		if (espaco.contem(r)) {
			corpo.x += passo;
			observavel.notificarObservadores(toString());
			return true;
		}
		return false;

	}

	public boolean moverY(int passo) {

		Retangulo r = (Retangulo) corpo.clone();

		r.y += passo;
		if (espaco.contem(r)) {
			corpo.y += passo;
			observavel.notificarObservadores(toString());
			return true;
		}
		return false;
	}

	public void resetarPosicao(Point p) {
		corpo.setLocation(p);
		observavel.notificarObservadores(toString());
	}
	
	
	public boolean intersecciona(ObjetoMovel o) {
		
		return super.intersecciona(o.corpo);
	}

	@Override
	public void adicionarObservador(Observador observador) {
		observavel.adicionarObservador(observador);
	}

	public String toString() {
		return corpo.toString() + "/" + estado.toString();

	}

}
