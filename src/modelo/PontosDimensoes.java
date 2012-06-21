package modelo;

import static modelo.constantes.Valores.ALTURA_ALIEN;
import static modelo.constantes.Valores.ALTURA_ASTEROIDE;
import static modelo.constantes.Valores.ALTURA_NAVE;
import static modelo.constantes.Valores.LARGURA_ALIEN;
import static modelo.constantes.Valores.LARGURA_ASTEROIDE;
import static modelo.constantes.Valores.LARGURA_NAVE;
import static modelo.constantes.Valores.POSICAOX_INICIAL_ALIEN;
import static modelo.constantes.Valores.POSICAOX_INICIAL_ASTEROIDE;
import static modelo.constantes.Valores.POSICAOX_INICIAL_NAVE;
import static modelo.constantes.Valores.POSICAOY_INICIAL_ALIEN;
import static modelo.constantes.Valores.POSICAOY_INICIAL_ASTEROIDE;
import static modelo.constantes.Valores.POSICAOY_INICIAL_NAVE;

import java.awt.Dimension;
import java.awt.Point;

import modelo.geometria.Retangulo;

import br.ufsc.edugraf.telis.maquina.palavras.Ponto;

public class PontosDimensoes {
	
	private Point pNave = new Point(POSICAOX_INICIAL_NAVE.valor(),
			POSICAOY_INICIAL_NAVE.valor());
	private Point pAlien = new Point(POSICAOX_INICIAL_ALIEN.valor(),
			POSICAOY_INICIAL_ALIEN.aleatoria(465));
	private Point pAsteroide = new Point(POSICAOX_INICIAL_ASTEROIDE.aleatoria(465),
			POSICAOY_INICIAL_ASTEROIDE.valor());
	private Dimension dNave = new Dimension(LARGURA_NAVE.valor(),
			ALTURA_NAVE.valor());
	private Dimension dAlien = new Dimension(LARGURA_ALIEN.valor(),
			ALTURA_ALIEN.valor());
	private Dimension dAsteroide = new Dimension(LARGURA_ASTEROIDE.valor(),
			ALTURA_ASTEROIDE.valor());
	
	public Point getpNave() {
		return pNave;
	}
	public Point getpAlien() {
		return pAlien;
	}
	public Point getpAsteroide() {
		return pAsteroide;
	}
	public Dimension getdNave() {
		return dNave;
	}
	public Dimension getdAlien() {
		return dAlien;
	}
	public Dimension getdAsteroide() {
		return dAsteroide;
	}
	
	
	public Retangulo obterRetanguloPadrao(char c){
		
		
		switch (c){
		
		case 'a' : return new Retangulo(pAlien, dAlien);
		case 'n' : return new Retangulo(pNave, dNave);
		case 'm' : return new Retangulo(pAsteroide, dAsteroide);
		
		}
		
		return null;
		
		
	}
	

}
