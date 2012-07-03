package modelo;

import java.awt.Point;

public interface TipoMovimentavel {
	
	boolean moverX(int x);
	boolean moverY(int y);
	void resetarPosicao(Point novaPosicao);

}
