package modelo;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;


public class Retangulo extends Rectangle {

	public Retangulo(Dimension d) {

		super(d);

	}

	public Retangulo(Point p, Dimension d) {
		super(p, d);

	}

	public boolean contem(Rectangle r) {
		return contains(r);
	}

	public boolean intersecciona(Rectangle r) {
		return intersects(r);
	}
	
	@Override
	public String toString() {
		
		return this.x + "/" + this.y;
	}
	

}
