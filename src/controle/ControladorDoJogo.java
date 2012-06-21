package controle;

import static modelo.constantes.Valores.*;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import modelo.Alien;
import modelo.Asteroide;
import modelo.Espaco;
import modelo.Fachada;
import modelo.Nave;
import modelo.RetanguloMovel;
import modelo.geometria.Retangulo;
import modelo.util.TratadorDeInteiros;
import visao.ImagemFundo;
import visao.ImagemRetangularMovel;
import edugraf.jadix.fachada.PaginaDix;
import edugraf.jadix.tiposPrimitivos.Coordenadas;

public class ControladorDoJogo {

	private Nave nave;
	private Alien alien;
	private Asteroide asteroide;
	

	public ControladorDoJogo(PaginaDix pagina) {

		
		Retangulo rEspaco = new Retangulo(new Dimension(500, 500));
		Espaco espaco = new Espaco(rEspaco);


		Point pNave = new Point(POSICAOX_INICIAL_NAVE.valor(),
				POSICAOY_INICIAL_NAVE.valor());
		Point pAlien = new Point(POSICAOX_INICIAL_ALIEN.valor(),
				POSICAOY_INICIAL_ALIEN.aleatoria(465));
		Point pAsteroide = new Point(POSICAOX_INICIAL_ASTEROIDE.aleatoria(465),
				POSICAOY_INICIAL_ASTEROIDE.valor());
		Dimension dNave = new Dimension(LARGURA_NAVE.valor(),
				ALTURA_NAVE.valor());
		Dimension dAlien = new Dimension(LARGURA_ALIEN.valor(),
				ALTURA_ALIEN.valor());
		Dimension dAsteroide = new Dimension(LARGURA_ASTEROIDE.valor(),
				ALTURA_ASTEROIDE.valor());

		RetanguloMovel retNave = new RetanguloMovel(espaco, pNave, dNave);
		RetanguloMovel retAlien = new RetanguloMovel(espaco, pAlien, dAlien);
		RetanguloMovel retAsteroide = new RetanguloMovel(espaco, pAsteroide,
				dAsteroide);

		this.asteroide = new Asteroide(retAsteroide);
		this.alien = new Alien(retAlien);
		this.nave = new Nave(retNave);

		new ImagemFundo(pagina, "recursos/square.jpg");

		ImagemRetangularMovel iAsteroide = new ImagemRetangularMovel(pagina,
				pAsteroide, "recursos/squareAlien.jpg");
		asteroide.adicionarObservador(iAsteroide);

		ImagemRetangularMovel iNave = new ImagemRetangularMovel(pagina, pNave,
				"recursos/sm_square.gif");
		nave.adicionarObservador(iNave);
		new ControladorDaNave(nave, iNave);

		ImagemRetangularMovel iAlien = new ImagemRetangularMovel(pagina,
				pAlien, "recursos/alien.gif");
		alien.adicionarObservador(iAlien);

		Fachada fachada = new Fachada(nave);
		new TratadorDoTeclado(pagina, fachada);
	}

	public int receberTick(int tick) {

		boolean alienAndou = alien.andarNaHorizontal();
		boolean asteroideAndou = asteroide.andarNaVertical();

		if (alienAndou == false) {
			alien.resetarPosicaoY();
		}

		if (asteroideAndou == false) {
			asteroide.resetarPosicaoX();
		}

		if (nave.intersecciona(alien.retangulo())
				|| nave.intersecciona(asteroide.retangulo())) {
			nave.explodir();
			return -1;
		}

		tick++;
		return tick;
	}

}
