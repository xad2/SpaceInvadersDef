package apliques;

import static modelo.constantes.PontosIniciais.PONTO_INICIAL_ALIEN;
import static modelo.constantes.PontosIniciais.PONTO_INICIAL_ASTEROIDE;
import static modelo.constantes.PontosIniciais.PONTO_INICIAL_NAVE;
import static modelo.constantes.RetangulosIniciais.RETANGULO_ALIEN;
import static modelo.constantes.RetangulosIniciais.RETANGULO_ASTEROIDE;
import static modelo.constantes.RetangulosIniciais.RETANGULO_NAVE;

import java.awt.Dimension;
import java.util.Calendar;

import javax.swing.JOptionPane;

import visao.ImagemFundo;
import visao.ImagemObjetoMovel;

import modelo.Alien;
import modelo.Asteroide;
import modelo.Espaco;
import modelo.Fachada;
import modelo.Jogo;
import modelo.Nave;
import modelo.Retangulo;
import controle.ControladorDoJogo;
import controle.TratadorDoTeclado;
import edugraf.jadix.Aplique;

public class UmAplique extends Aplique {

	@Override
	public void iniciar() {

		Espaco espaco = new Espaco(new Retangulo(new Dimension(500, 500)));
		Asteroide asteroide = new Asteroide(espaco, RETANGULO_ASTEROIDE.valor());
		Alien alien = new Alien(espaco, RETANGULO_ALIEN.valor());
		Nave nave = new Nave(espaco, RETANGULO_NAVE.valor());

		new ImagemFundo(obterPaginaDix(), "recursos/square.jpg");

		ImagemObjetoMovel iNave = new ImagemObjetoMovel(obterPaginaDix(),
				PONTO_INICIAL_NAVE.valor(), "recursos/sm_square.gif");
		nave.adicionarObservador(iNave);
		ImagemObjetoMovel iAsteroide = new ImagemObjetoMovel(obterPaginaDix(),
				PONTO_INICIAL_ASTEROIDE.valor(), "recursos/squareAlien.jpg");
		asteroide.adicionarObservador(iAsteroide);
		ImagemObjetoMovel iAlien = new ImagemObjetoMovel(obterPaginaDix(),
				PONTO_INICIAL_ALIEN.valor(), "recursos/alien.gif");
		alien.adicionarObservador(iAlien);

		Jogo jogo = new Jogo(asteroide, alien, nave); 
		Fachada fachada = new Fachada(nave);
		TratadorDoTeclado t = new TratadorDoTeclado(obterPaginaDix(), fachada);
		ControladorDoJogo controladorJogo = new ControladorDoJogo(jogo, t);
		boolean jogoEmAndamento = true;

		while (jogoEmAndamento) {

			jogoEmAndamento = controladorJogo.enviarTick();
			
		}
	
	
	}
}